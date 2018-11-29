package com.aaa.af.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * className:PageUtil
 * discription:
 * author:Cheng Fangying
 * createTime:2018-11-19 11:46
 */
public class PageUtil {
    //分页的要素
    private int pageNo;//页码（第几页）
    private int pageSize;//每页显示数量
    private int totalSize;//总条数
    //临时变量
    private String url;//请求的url
    private String pageString;//拼接后的分页字符串

    /**
     * 构造
     * @param pageNo
     * @param pageSize
     * @param totalSize
     * @param request  可以用来获取当前请求的地址和所有的请求参数
     */
    public PageUtil(int pageNo, int pageSize, int totalSize, HttpServletRequest request){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        //获取本次请求的url（从项目名称开始）
        url = request.getRequestURI()+"?";  //  /web20180918/jsp/page/page3.jsp?pageNo=2&dname=内&id=&aa=11&bb=22
        //getParameterNames获取所有请求中带的参数的名称  pageNo=2&dname=内&id=   getParameterNames获取到结果为：
        Enumeration<String> parameterNames = request.getParameterNames();//获取参数名称集合  [pageNo,dname,id]
        while(parameterNames.hasMoreElements()){//判断有没有下一个元素
            String parameterName = parameterNames.nextElement();//第一次取到的pageNo
            //!"pageNo".equals(parameterName)  每次请求，pageNo都在变化，所以下面拼接pageString一直会带上
            if(!"pageNo".equals(parameterName)){
                //charAt 得到字符串某个位置的上的字符
                if(url.charAt(url.length()-1)=='?'){//判断请求的最后位置是否是？
                    url+=parameterName+"="+request.getParameter(parameterName);// /web20180918/jsp/page/page3.jsp?dname=内
                }else{
                    url+="&"+parameterName+"="+request.getParameter(parameterName);///web20180918/jsp/page/page3.jsp?dname=内&id=&&aa=11&
                }
            }
        }
        //为了下面拼接简单
        if(url.charAt(url.length()-1)!='?'){
            url+="&";
        }
    }
    // url =/web20180918/jsp/page/page3.jsp?dname=内&id=&&aa=11&
    /**
     * 拼装分页字符串
     * @return
     */
    public String getPageString(){
        //计算总页数
        int pageCount = totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        StringBuffer stringBuffer = new StringBuffer();
        //上一页不能小于1
        if(pageNo<1){
            pageNo = 1;
        }
        if(pageNo>1){//不是第一页
            stringBuffer.append("<a href='"+url+"pageNo=1'>首页</a>&nbsp;<a href='"+url+"pageNo="+(pageNo-1)+"'>上一页</a>");
        }else{
            stringBuffer.append("首页&nbsp;上一页");
        }
        stringBuffer.append("&nbsp;");
        //不能大于最大页
        if(pageNo>pageCount){
            pageNo=pageCount;
        }
        if(pageNo<pageCount){//不是最大页（尾页）
            stringBuffer.append("<a href='"+url+"pageNo="+(pageNo+1)+"'>下一页</a>&nbsp;<a href='"+url+"pageNo="+pageCount+"'>尾页</a>");
        }else{
            stringBuffer.append("下一页&nbsp;尾页");
        }
        stringBuffer.append("&nbsp;");
        //拼装下拉第几页                                                                                                                                                                                //this.value  select元素选中值
        stringBuffer.append("第<select onchange=\"javascript:window.location.href='"+url+"pageNo='+this.value\">"); //为select添加onchange事件，能选择自定义页数
        for(int i=1;i<=pageCount;i++){
            if(pageNo==i){//如果当前页码（第几页）和i相等，让option被选中 selected='selected'
                stringBuffer.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
            }else{
                stringBuffer.append("<option value='"+i+"'>"+i+"</option>");
            }
        }
        stringBuffer.append("</select>页&nbsp;共"+totalSize+"条&nbsp;"+pageCount+"页");
        return stringBuffer.toString();
    }

}
