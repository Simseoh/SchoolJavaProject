package com.dgsw.project2.service;

import com.dgsw.project2.dto.request.CreateItemCommentRequest;
import com.dgsw.project2.dto.request.UpdateItemCommentRequest;
import com.dgsw.project2.dto.response.ItemCommentResponse;

import java.util.List;

public interface ItemCommentService {
    ItemCommentResponse create(CreateItemCommentRequest request);
    ItemCommentResponse findById(Long id);
    List<ItemCommentResponse> findAll(Long itemId);
    void delete(Long id);
    ItemCommentResponse update(Long id, UpdateItemCommentRequest request);
}
