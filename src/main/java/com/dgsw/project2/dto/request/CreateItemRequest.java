package com.dgsw.project2.dto.request;

import com.dgsw.project2.domain.ItemEntity;
import jakarta.validation.constraints.NotNull;

public record CreateItemRequest (
        @NotNull
        String title,

        @NotNull
        String description,

        @NotNull
        Long price,

        @NotNull
        Long sellerId
) {
    public static ItemEntity toEntity(CreateItemRequest request) {
        return new ItemEntity(request.title, request.description, request.price, request.sellerId);
    }
}