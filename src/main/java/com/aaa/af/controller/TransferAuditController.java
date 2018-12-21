package com.aaa.af.controller;

import com.aaa.af.service.TransferAuditService;
import com.aaa.af.service.UserTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransfer
 * discription:人员转移审核
 * author:wqy
 * createTime:2018-12-11 14:23
 */
@Controller
@RequestMapping("/transferAudit")
public class TransferAuditController {

    @Autowired
    private TransferAuditService transferAuditService;
    /**
     * 跳转列表页面
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "person/personnel_audit_transfer";
    }
    /**
     * 分页------待转移人员
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/page")
    public Object list(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("pageData",transferAuditService.getPageByParam(map));
        map1.put("total",transferAuditService.getPageCount(map));
        return map1;
    }

    /**
     * ----驳回---删除待审核表中的信息，并加入到审核记录表中
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/reject")
    public Object reject(@RequestBody Map map){
        if(map!=null&&map.size()>0){
            transferAuditService.add(map);
        }
        int i1 = transferAuditService.delete(Integer.valueOf(map.get("TRANSFER_ID")+""));
        return i1;
    }
    /**
     * ----通过--删除待审核表中的信息，并加入到审核记录表中，更改相关信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/pass")
    public Object pass(@RequestBody Map map){
        if(map!=null&&map.size()>0){
            transferAuditService.add(map);
        }
        //uaid	公司账户grzh  个人账号
        //更新个人所在公司的id
        int updateid = transferAuditService.updateId(Integer.valueOf(map.get("TRANSFER_INTO_UNIT")+""),Integer.valueOf(map.get("PERSON_ACCOUNT")+""));
        if(updateid==1){
            //删除待转移人员
            transferAuditService.delete(Integer.valueOf(map.get("TRANSFER_ID")+""));
            //更新转入公司公司的缴存人数
            transferAuditService.unitsUpdatea(map.get("UNAME")+"");
            //更新转出公司公司的缴存人数
            transferAuditService.unitsUpdatea(map.get("TRANSFER_OUT_UNIT")+"");
            //更新转入公司的总缴存金额
            transferAuditService.unitsUpdateMoneya(map.get("UNAME")+"");
            //更新转出公司的总缴存金额
            transferAuditService.unitsUpdateMoneya(map.get("TRANSFER_OUT_UNIT")+"");
        }

        return true;
    }
}
