package com.dgsw.project2.dto.request;

public record SearchItemRequest(
        String title,
        Long minPrice,
        Long maxPrice,
        String sortBy
) {}