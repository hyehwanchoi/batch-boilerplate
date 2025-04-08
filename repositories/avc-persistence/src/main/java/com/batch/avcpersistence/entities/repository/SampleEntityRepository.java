package com.batch.avcpersistence.entities.repository;

import com.batch.avcpersistence.entities.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long> {
}
