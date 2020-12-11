package com.dgw.orden.mapper;
import com.dgw.orden.entity.Repertory;
import org.apache.ibatis.annotations.Param;

public interface RepertoryMapper {

    //查询库存
    Repertory selectNum(@Param("repertoryId") Integer repertoryId);
}
