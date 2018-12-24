package com.aaa.af.service;

import com.aaa.af.dao.SearchInfoDao;
import com.fasterxml.jackson.core.util.InternCache;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(loan_id>0){
            return searchInfoDao.checkPassFinally(map);
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
        List<Map> unique = searchInfoDao.unique();
        if(unique!=null&&unique.size()>0){
            for (Map map : unique) {
               /* System.out.println(value+"*****************");
                System.out.println(map.get("GRZH")+""+"&&&&&&&&&&&&&&&&&");*/
                if((map.get("GRZH")+"").equals(value)){
                    return 1;
                }
            }
        }
        return 0;
    }
}
