package com.aaa.af.service;
import com.aaa.af.dao.RepayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * className:DeptTest
 * discription:
 * author:changdu
 * createTime:2018/12/11 15:48
 */
@Service
public class RepayServiceImpl implements RepayService {
    //依赖注入
    @Autowired
    private RepayDao repayDao;

    /**
     * 获取还款列表
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> getList(Map map) {
        return repayDao.getList(map);
    }

    @Override
    public List<Map> getListById(int id) {
        return repayDao.getListById(id);
    }

    /**
     * 分期还款
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        return repayDao.update(map);
    }

    /**
     * 添加个人还款记录
     * @param map
     * @return
     */
    @Override
    public int addInfo(Map map) {
        return repayDao.addInfo(map);
    }

    /**
     * 获取还款信息
     * @param map
     * @return
     */
    public List<Map> getRecord(Map map){
        return repayDao.getRecord(map);
    }

    /**
     * 更新还款状态
     * @param map
     * @return
     */
    @Override
    public int updateState(Map map) {
        return repayDao.updateState(map);
    }

    @Override
    public int updState(Map map) {
        return repayDao.updState(map);
    }

}