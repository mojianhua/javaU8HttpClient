package cn.itcast.service.impl;

import cn.itcast.dao.U8OrdersListDao;
import cn.itcast.pojo.U8OrdersList;
import cn.itcast.service.U8OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class U8OrdersListServiceImpl implements U8OrderListService {

    //获取dao层
    @Autowired
    private U8OrdersListDao u8OrdersListDao;

    @Override
    @Transactional
    public void save(U8OrdersList u8OrdersList){
       this.u8OrdersListDao.save(u8OrdersList);
    }

    @Override
    public List<U8OrdersList> findAll(U8OrdersList u8OrdersList){
        //声明查询条件
        Example<U8OrdersList> example = Example.of(u8OrdersList);
        //根据查询条件进行查询数据
        List<U8OrdersList> list = this.u8OrdersListDao.findAll(example);
        return list;
    }
}
