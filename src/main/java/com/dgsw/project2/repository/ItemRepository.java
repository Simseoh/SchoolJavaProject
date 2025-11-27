package com.dgsw.project2.repository;

import com.dgsw.project2.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    // JPQL
    @Query("SELECT i FROM ItemEntity i WHERE i.title LIKE %:keyword%")
    List<ItemEntity> findByTitleLike(@Param("keyword") String keyword);

    // Query Method
    List<ItemEntity> findByPriceGreaterThan(Long price);
}
