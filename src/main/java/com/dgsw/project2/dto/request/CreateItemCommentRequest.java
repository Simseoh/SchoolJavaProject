package com.dgsw.project2.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateItemCommentRequest(
        @NotNull
        Long itemId,

        @NotNull
        Long authorId,

        @NotNull
        String content
) {
}