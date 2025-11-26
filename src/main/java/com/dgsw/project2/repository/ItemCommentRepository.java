package com.dgsw.project2.repository;

import com.dgsw.project2.domain.ItemCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCommentRepository extends JpaRepository<ItemCommentEntity, Long> {
}
