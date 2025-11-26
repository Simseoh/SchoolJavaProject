package com.dgsw.project2.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateItemCommentRequest(
        @NotNull
        String content
) {
}
