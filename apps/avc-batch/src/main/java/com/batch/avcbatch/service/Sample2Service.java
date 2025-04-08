package com.batch.avcbatch.service;

import com.batch.avcpersistence.dto.Sample2DTO;
import com.batch.avcpersistence.entities.Sample2Entity;
import com.batch.avcpersistence.mapper.Sample2EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Sample2Service {

    private final Sample2EntityMapper sample2EntityMapper;

    public List<Sample2DTO> getSample2DTOList() {

        List<Sample2Entity> entities = sample2EntityMapper.getSample2DTOList();

        return Sample2DTO.fromEntities(entities);
    }
}
