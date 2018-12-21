package com.aaa.af.service;
import java.util.List;
import java.util.Map;

/**
 * className:UserTransferService
 * discription:人员转移
 * author:wqy
 * createTime:2018-12-11 14:25
 */
public interface TransferAuditService {
    /**
     * 带参分页查询-----待转移人员
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
     * 删除待转移人员审核表中的数据----驳回，通过
     * @param transfer_id
     * @return
     */
    int delete(int transfer_id);

    /**
     * 添加到人员审核记录表中----驳回，通过
     * @param map
     * @return
     */
    int add(Map map);
    /**
     * 根据获取的个人账号查询到自己公司id 在修改为要转入的公司id
     * @param grzh  个人账号
     * @param uaid	公司账户
     * @return
     */
    int updateId(int uaid,int grzh);
    /**
     * 公司缴存人数  查询到当前公司账户状态为正常的个数  把公司账户信息表 应缴纳人数修改了
     * 为了修改公司缴存人数
     * 转出公司的缴存人数
     * @param uname
     * @return
     */
    int unitsUpdatea(String uname);
    /**
     * 审核表中  点击通过审核  获取前台信息 进行修改 个人信息状态后    然后修改 公司缴存人数  查询到当前公司账户状态为正常的个数  把公司账户信息表 应缴纳人数修改了
     * 在修改公司 总缴存金额
     *
     * 获取转出公司 进行修改总缴存金额 方法
     * @param uname
     * @return
     */
    int unitsUpdateMoneya(String uname);
}
