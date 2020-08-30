package cn.itcast.service;

import cn.itcast.pojo.U8OrdersList;

import java.util.List;

public interface U8OrderListService {

    //保存产品
    public void save(U8OrdersList u8OrdersList);

    //根据条件查询产品
    public List<U8OrdersList> findAll(U8OrdersList u8OrdersList);
}
