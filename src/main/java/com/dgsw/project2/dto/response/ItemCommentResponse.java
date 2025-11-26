package com.dgsw.project2.dto.response;

import com.dgsw.project2.domain.ItemCommentEntity;

public record ItemCommentResponse(
        Long id,
        Long itemId,
        Long authorId,
        String content
) {
    public static ItemCommentResponse of(ItemCommentEntity request) {
        return new ItemCommentResponse(request.getId(), request.getItem().getId(), request.getAuthorId(), request.getContent());
    }
}
