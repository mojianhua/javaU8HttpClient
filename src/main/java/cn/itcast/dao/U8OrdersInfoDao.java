package cn.itcast.dao;

import cn.itcast.pojo.U8OrdersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<pojo,主键长度>
public interface U8OrdersInfoDao extends JpaRepository<U8OrdersInfo,Integer> {
}
