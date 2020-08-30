package cn.itcast.dao;

import cn.itcast.pojo.U8OrdersList;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<pojo,主键长度>
public interface U8OrdersListDao extends JpaRepository<U8OrdersList,Integer> {
}
