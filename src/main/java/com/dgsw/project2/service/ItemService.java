package com.dgsw.project2.service;

import com.dgsw.project2.dto.request.CreateItemRequest;
import com.dgsw.project2.dto.request.SearchItemRequest;
import com.dgsw.project2.dto.response.ItemResponse;

import java.util.List;

public interface ItemService {
    ItemResponse create(CreateItemRequest request);
    ItemResponse findById(Long id);
    List<ItemResponse> findAll();
    void delete(Long id);
    ItemResponse update(Long id, CreateItemRequest request);
    List<ItemResponse> findByTitleLike(String keyword);
    List<ItemResponse> findByPriceGreaterThan(Long price);
    List<ItemResponse> search(SearchItemRequest request);
}
