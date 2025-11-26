package com.dgsw.project2.dto.response;

import com.dgsw.project2.domain.ItemEntity;

public record ItemResponse(
        Long id,
        String title,
        String description,
        Long price,
        Long sellerId
) {
    public static ItemResponse of(ItemEntity entity) {
        return new ItemResponse(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getPrice(), entity.getSellerId());
    }
}
