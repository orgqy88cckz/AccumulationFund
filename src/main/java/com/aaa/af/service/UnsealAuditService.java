package com.aaa.af.service;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransferService
 * discription:启封 封存审核
 * author:wqy
 * createTime:2018-12-11 14:25
 */
public interface UnsealAuditService {
    /**
     * 带参分页查询
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
     * 修改 个人账户状态 正常 销户 封存
     *      添加相关理由原因
     * @param grzh
     * @return
     */
    int archive(String peraccstate,String ypayamt,String grzh);
    /**
     * 更新审核表中 审核状态及通过或驳回理由
     * @param grzh
     * @return
     */

    int unsealAuditUpdate( String audit_name,String bohui,String grzh);
    /**
     * 封存 销户后
     * 修改公司缴存金额
     * @param grzh
     * @return
     */
    int unitsUpdateMoney(String grzh);

    /**
     * 启封后  修改总缴存金额
     * @param grzh
     * @return
     */
    int unitsMoney(String grzh);

    /**
     * 修改公司缴存人数
     * @param uname
     * @return
     */
    int unitsUpdate(String uname);
    /**
     * 带参分页查询
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
}
