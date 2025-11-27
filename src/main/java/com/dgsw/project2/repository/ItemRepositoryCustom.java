package com.dgsw.project2.repository;

import com.dgsw.project2.domain.ItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryCustom {
    List<ItemEntity> search(String title, Long minPrice, Long maxPrice, String sortBy);
}

