package com.example.testest.repository;

import com.example.testest.entity.TownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<TownEntity, Integer> {

    TownEntity findByTownName(String townName);
}
