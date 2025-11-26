package com.dgsw.project2.service.impl;

import com.dgsw.project2.domain.ItemEntity;
import com.dgsw.project2.dto.request.CreateItemRequest;
import com.dgsw.project2.dto.response.ItemResponse;
import com.dgsw.project2.repository.ItemRepository;
import com.dgsw.project2.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public ItemResponse create(CreateItemRequest request) {
        return ItemResponse.of(itemRepository.save(CreateItemRequest.toEntity(request)));
    }

    @Override
    public ItemResponse findById(Long id) {
        return ItemResponse.of(itemRepository.findById(id).orElseThrow(() -> new RuntimeException("(ID:" + id + ")상품 조회 실패 (ItemServiceImpl.findById)")));
    }

    @Override
    public List<ItemResponse> findAll() {
        return itemRepository.findAll().stream().map(ItemResponse::of).toList();
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemResponse update(Long id, CreateItemRequest request) {
        ItemEntity item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("(ID:" + id + ")상품 조회 실패 (ItemServiceImpl.update)"));
        Optional.ofNullable(request.title()).ifPresent(item::setTitle);
        Optional.ofNullable(request.sellerId()).ifPresent(item::setSellerId);
        Optional.ofNullable(request.price()).ifPresent(item::setPrice);
        Optional.ofNullable(request.description()).ifPresent(item::setDescription);
        return ItemResponse.of(itemRepository.save(item));
    }
}
