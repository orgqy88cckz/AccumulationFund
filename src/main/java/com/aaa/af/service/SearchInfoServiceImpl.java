package com.aaa.af.service;

import com.aaa.af.dao.SearchInfoDao;
import com.fasterxml.jackson.core.util.InternCache;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:SearchInfoServiceImpl
 * discription:
 * author:Cheng Fangying
 * createTime:2018-12-12 21:08
 */
@SuppressWarnings("all")
@Service
public class SearchInfoServiceImpl implements SearchInfoService{

    @Autowired
    private SearchInfoDao searchInfoDao;

    @Override
    public int getPageCount(Map map) {
        return searchInfoDao.getPageCount(map);
    }

    @Override
    public int checkReject(Map map) {
        //驳回添加到TB_LOAN_CHECK表中
        int i = searchInfoDao.checkReject(map);
        if(i>0){
            //驳回更新TB_LOAN表中
            return searchInfoDao.checkRejectUpdate(Integer.valueOf(map.get("LOAN_ID")+""));
        }
        return 0;
    }

    @Override
    public int checkPass(Map map) {
        int loan_id = searchInfoDao.checkPassUpdate(Integer.valueOf(map.get("LOAN_ID") + ""));
        if(loan_id>0){
            return searchInfoDao.checkPass(map);
        }
        return 0;
    }

    @Override
    public Map selectForm(String loan_id) {
        return searchInfoDao.selectForm(loan_id);
    }

    @Override
    public List<Map> loanCheckSelect(Map map) {
        return searchInfoDao.loanCheckSelect(map);
    }

    @Override
    public int addInfo(List<Map> map) {
        int i=0;
        Map map2=new HashMap();
        for (Map map1 : map) {
            map2.putAll(map1);
        }
        System.out.println(map2+"*************************************");
        i = searchInfoDao.addInfo(map2);
        return i;
    }

    @Override
    public Map getPersonInfo(String account) {
        return searchInfoDao.getPersonInfo(account);
    }

    @Override
    public List<Map> loanCheckSelectFinally(Map map) {
        return searchInfoDao.loanCheckSelectFinally(map);
    }

    @Override
    public int getPageCountFinally(Map map) {
        return searchInfoDao.getPageCountFinally(map);
    }

    @Override
    public int checkPassFinally(Map map) {
        int loan_id = searchInfoDao.checkFinallyUpdate(Integer.valueOf(map.get("LOAN_ID") + ""));
        String loan_repay = map.get("LOAN_REPAY") + "";
        if(loan_id>0){
            if(loan_repay.equals("等额本金")){
                Double loan_money = Double.valueOf(map.get("LOAN_MONEY") + "");//贷款本金
                Double loan_rate = Double.valueOf(map.get("LOAN_RATE") + "");//贷款利率
                Double loan_periods = Double.valueOf(map.get("LOAN_PERIODS") + "");//贷款期数
                Double repayed_month_money1=loan_money/loan_periods;//每月还款本金
                Double repayed_month_interest1=(loan_money-0)*(loan_rate/loan_periods/100);//每月还款利息
                Double month_return1=repayed_month_money1+repayed_month_interest1;//月还金额
//                等额本金总利息=（还款月数+1）×贷款总额×月利率÷2
                Double repay_interests1=(loan_periods+1)*loan_money*(loan_rate/loan_periods/100)/2;//总共还的利息
                DecimalFormat df = new DecimalFormat("#.00");
                Double month_return2 = Double.valueOf(df.format(month_return1));
                Double repayed_month_money2 = Double.valueOf(df.format(repayed_month_money1));
                Double repayed_month_interest2 = Double.valueOf(df.format(repayed_month_interest1));
                Double repay_interests2 =Double.valueOf( df.format(repay_interests1));
                map.put("repayed_month_money1",repayed_month_money2);
                map.put("repayed_month_interest1",repayed_month_interest2);
                map.put("month_return1",month_return2);
                map.put("repay_interests1",repay_interests2);
                System.out.println(month_return2+"********"+repayed_month_money2+"**********"+repayed_month_interest2+"*****"+repay_interests2);
                return searchInfoDao.checkPassFinally(map);
            }else {
                Double loan_money = Double.valueOf(map.get("LOAN_MONEY") + "");//贷款本金
                Double loan_rate = Double.valueOf(map.get("LOAN_RATE") + "");//贷款利率
                Double loan_periods = Double.valueOf(map.get("LOAN_PERIODS") + "");//贷款期数
                double month_return1 = (loan_money * (loan_rate / 12 / 100) * Math.pow(1 + (loan_rate / 12 / 100), loan_periods)) / (Math.pow((1 + (loan_rate / 12 / 100)), loan_periods) - 1);//每月还款金额
                Double repayed_month_interest1= loan_money*((loan_rate / 12 / 100));//月还款利息
                Double repayed_month_money1=month_return1-repayed_month_interest1;//月还款本金
                double repay_interests1 =month_return1*loan_periods-loan_money;//总共要还的利息
                DecimalFormat df = new DecimalFormat("#.00");
                //System.out.println(df.format(f));
                Double month_return2 = Double.valueOf(df.format(month_return1));
                Double repayed_month_money2 = Double.valueOf(df.format(repayed_month_money1));
                Double repayed_month_interest2 = Double.valueOf(df.format(repayed_month_interest1));
                Double repay_interests2 =Double.valueOf( df.format(repay_interests1));
                System.out.println(month_return2+"********"+repayed_month_money2+"**********"+repayed_month_interest2+"*****"+repay_interests2);
                map.put("repayed_month_money1",repayed_month_money2);
                map.put("repayed_month_interest1",repayed_month_interest2);
                map.put("month_return1",month_return2);
                map.put("repay_interests1",repay_interests2);
                return searchInfoDao.dengebenxi(map);
            }
        }
        return 0;
    }

    @Override
    public int checkRejectFinally(Map map) {
        return searchInfoDao.checkRejectFinally(Integer.valueOf(map.get("LOAN_ID")+""));
    }

    /**
     * 个人账号验证
     * @param value
     * @return
     */
    @Override
    public int unique(String value) {
        return searchInfoDao.unique(value);
    }

    @Override
    public Map yanzheng(String GRZH) {
        return searchInfoDao.yanzheng(GRZH);
    }
}
