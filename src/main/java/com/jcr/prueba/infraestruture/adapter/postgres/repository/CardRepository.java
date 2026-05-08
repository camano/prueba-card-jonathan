package com.jcr.prueba.infraestruture.adapter.postgres.repository;

import com.jcr.prueba.infraestruture.adapter.postgres.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Long> {
}
