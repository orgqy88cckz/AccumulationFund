package com.aaa.af.service;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransferService
 * discription:查看审批
 * author:wqy
 * createTime:2018-12-11 14:25
 */
public interface ApprovalService {
    /**
     * 带参分页查询--查看审批
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
     * 带参分页查询--人员转移审核
     * @param map
     * @return
     */
    List<Map> getPageByParamR(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCountR(Map map);
    /**
     * 带参分页查询
     * @param map
     * @return
     */
    List<Map> getPageByParamF(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCountF(Map map);
    /**
     * 带参分页查询
     * @param map
     * @return
     */
    List<Map> getPageByParamG(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCountG(Map map);
    /**
     * 带参分页查询
     * @param map
     * @return
     */
    List<Map> getPageByParamGJ(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCountGJ(Map map);

//    /**
//     * 封启销户
//     * @param map
//     * @return
//     */
//    List<Map> listF(Map map);

    /**
     * 查询到个人贷款tb_loan_check
     * 记录表 当前信息条数
     * @return
     */
    int accraditationCount();
    /**
     * 查询到个人转移tb_transfer_audit_jl
     * 记录表 当前信息条数
     * @return
     */

    int accraditationCountb();

    /**
     * 查询到公积金提取
     * 部分销户tb_bftake_check
     * 约定提取tb_appoint_check
     * 记录表 当前信息条数
     * @return
     */

    int accraditationCountt();

    /**
     * 封存、启封、销户审批tb_unseal_audit
     * 记录表 当前信息条数
     * @return
     */

    int accraditationCounts();

    /**
     * 更新查看审批表的相关信息
     * 工作流量
     * @return
     */

    int addAccraditationCount( int accraditation_flux,String accraditation_name);


}
