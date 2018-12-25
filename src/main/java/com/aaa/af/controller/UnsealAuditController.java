package com.aaa.af.controller;

import com.aaa.af.service.UnsealAuditService;
import com.aaa.af.service.UserTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransfer
 * discription:启封 封存审核
 * author:wqy
 * createTime:2018-12-11 14:23
 */
@Controller
@RequestMapping("/sealed")
public class UnsealAuditController {

    @Autowired
    private UnsealAuditService unsealAuditService;
    /**
     * 跳转列表页面
     * 封启审核
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "person/unsealAudit";
    }
    /**
     * 跳转列表页面
     * 销户审核
     * @return
     */
    @RequestMapping("/toList2")
    public String toList2(){
        return "person/accountCancleAudit";
    }
    /**
     * 分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page2")
    public Object list2(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",unsealAuditService.getPageByParam2(map));
        map1.put("total",unsealAuditService.getPageCount2(map));
        return map1;
    }
    /**
     * 分页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object list(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",unsealAuditService.getPageByParam(map));
        map1.put("total",unsealAuditService.getPageCount(map));
        return map1;
    }
    /**
     * 审核通过 启封 封存 销户
     * 1.修改个人信息状态
     * 2.修改 公司缴存人数
     * 3.修改公司总缴存金额   减去当前人员的缴存金额
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/pass")
    public Object pass(@RequestBody Map map){
        int i = unsealAuditService.archive(map.get("AUDIT_STATE") + "",
                map.get("REASON") + "",map.get("UNSEAL_ACCOUNT") + "");//修改个人账户状态等 封存--正常--销户
        if(i==1){
            unsealAuditService.unsealAuditUpdate(map.get("AUDIT_NAME")+"",
                    map.get("BOHUI")+"",map.get("UNSEAL_ACCOUNT")+"");//修改审核表的状态及相关信息AUDIT_NAME--驳回，通过
            unsealAuditService.unitsUpdate(map.get("UNSEAL_UNIT")+"");//为了修改公司缴存人数UNSEAL_UNIT--公司名称
            String state=map.get("STATE")+"";//?????----------------------应该对应哪一个？
            if(state.equals("封存申请") || state.equals("销户申请")){
                unsealAuditService.unitsUpdateMoney(map.get("UNSEAL_ACCOUNT")+"");//修改公司缴存总额UNSEAL_ACCOUNT
            }
            if(state.equals("启封申请")){
                unsealAuditService.unitsMoney(map.get("UNSEAL_ACCOUNT")+"");//启封时
            }
        }

        return i;
    }

    /**
     * ----驳回---删除待审核表中的信息，并加入到审核记录表中
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/reject")
    public Object reject(@RequestBody Map map){
        int i = unsealAuditService.unsealAuditUpdate(map.get("AUDIT_NAME") + "",
                map.get("BOHUI") + "", map.get("UNSEAL_ACCOUNT") + "");//修改审核表的状态及相关信息AUDIT_NAME--驳回，通过
        return i;
    }
}
