package com.aaa.af.service;

import com.aaa.af.dao.CompanyInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 11:19
 */
@Service
public class CompanyInfoServiceImpl implements CompanyInfoService{
    //依赖注入
    @Autowired
    private CompanyInfoDao companyInfoDao;


    @Override
    public String checkCompany(Map map, Model model) {
        int i = companyInfoDao.getPersonAccount(map);
        System.out.println(i);
        if (i==0){
            model.addAttribute("msg","用户名不存在");
            return "companyLogin";
        }else if(i>0) {
            List<Map> map1= companyInfoDao.getPersonPassword(map);
            Object grmm = map1.get(0).get("ULEGALCARD");
            Object password = map.get("password");
            System.out.println(grmm);
            System.out.println(password);
            if(password.equals(grmm)){
                model.addAttribute("username",map.get("username"));
                return "yingyeting/company";
            }else{
                model.addAttribute("msg","密码输入错误");
                return "companyLogin";
            }
        }else{
            return "";
        }
    }

}
