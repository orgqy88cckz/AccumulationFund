package com.aaa.af.service;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransferService
 * discription:人员转移
 * author:wqy
 * createTime:2018-12-11 14:25
 */
public interface UserTransferService {
    /**
     * 带参分页
     * @param map
     * @return
     */
    List<Map> getPageByParam(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 根据name查询全体人员
     * @param tb_pname
     * @return
     */
    Map selectByName( String tb_pname);
    /**
     * 公司列表查询
     *  状态为正常的
     *  显示到提交审核处
     * @return
     */
    List<Map> getUnit();
    /**
     *下拉框选中公司 获取ID  查询公司的受托银行
     * 显示到提交审核处
     * @return
     */
    Map getUintById(Integer id);

    /**
     * 添加到待转移人员
     * @param map
     * @return
     */
    int add(Map map);
    /**
     * 带参分页查询-----待转移人员
     * @param map
     * @return
     */
    List<Map> getPageByParam2(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount2(Map map);
    /**
     * 提交验证，不能提交两次申请
     * @param
     * @return
     */
    Map submitVerify(String idnumber);
}
