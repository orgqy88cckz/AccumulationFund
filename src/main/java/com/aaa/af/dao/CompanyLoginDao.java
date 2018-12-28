package com.aaa.af.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/25 9:41
 */
public interface CompanyLoginDao {
    /**
     * 获取单位信息
     * @param map
     * @return
     */
    @Select("select u.id,u.ulegalcard,u.dwxz,u.gslx,u.ulegalperson,u.uoperator,uopiphone,p.uaremain,to_char(khrq,'yyyy-mm-dd')as p.khrq" +
            "from tb_unit u left join tb_unitaccount p on u.id=p.id where dwxz = #{DWXZ}")
    List<Map>  getList(Map map);
}
