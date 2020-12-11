package com.dgw.orden.mapper;
import com.dgw.orden.entity.Torder;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TorderMapper {
    //保存订单
    int insertOrder(@Param("torder") Torder torder);

    //查询订单
    List<Torder> selectTorder(long torderId);
}
