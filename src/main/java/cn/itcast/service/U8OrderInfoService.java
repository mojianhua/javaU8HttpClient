package cn.itcast.service;

import cn.itcast.pojo.U8OrdersInfo;

import java.util.List;

public interface U8OrderInfoService {

    //保存产品
    public void save(U8OrdersInfo u8OrdersInfo);

    //根据条件查询产品
    public List<U8OrdersInfo> findAll(U8OrdersInfo u8OrdersInfo);
}
