package com.batch.avcpersistence.mapper;

import com.batch.avcpersistence.entities.Sample2Entity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Sample2EntityMapper {

    List<Sample2Entity> getSample2DTOList();
}
