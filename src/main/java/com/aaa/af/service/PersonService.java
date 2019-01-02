package com.aaa.af.service;



import java.util.Map;

/**
 * discription:
 *
 * @Version 1.0
 * @Author: ZhangZhaohan
 * @Date: 2018/12/16 17:06
 */
public interface PersonService {

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Map getById(String id);

    /**
     * 添加
     * @param map
     * @return
     */
    Map add(Map map);

    /**
     * 查询公司账号
     * @param acc
     * @return
     */
    int look(String acc);

    /**
     * 银行账号唯一性验证
     * @param accou
     * @return
     */
    int bankAccount(String accou);

    /**
     * 邮箱验证
     * @param ema
     * @return
     */
    int emailAccount(String ema);

    /**
     * 验证手机号
     * @param pnum
     * @return
     */
    int phoneNumber(String pnum);

    /**
     * 身份证验证
     * @param card
     * @return
     */
    int idCard2(String card);
}
