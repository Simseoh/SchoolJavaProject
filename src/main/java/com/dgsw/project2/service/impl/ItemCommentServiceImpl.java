package com.dgsw.project2.service.impl;

import com.dgsw.project2.domain.ItemCommentEntity;
import com.dgsw.project2.dto.request.CreateItemCommentRequest;
import com.dgsw.project2.dto.request.UpdateItemCommentRequest;
import com.dgsw.project2.dto.response.ItemCommentResponse;
import com.dgsw.project2.repository.ItemCommentRepository;
import com.dgsw.project2.repository.ItemRepository;
import com.dgsw.project2.service.ItemCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemCommentServiceImpl implements ItemCommentService {
    private final ItemCommentRepository itemCommentRepository;
    private final ItemRepository itemRepository;

    @Override
    public ItemCommentResponse create(CreateItemCommentRequest request) {
        return ItemCommentResponse.of(itemCommentRepository.save(toEntity(request)));
    }

    @Override
    public ItemCommentResponse findById(Long id) {
        return ItemCommentResponse.of(itemCommentRepository.findById(id).orElseThrow(() -> new RuntimeException("(ID:" + id + ") 아이템 댓글 객체 조회 실패 (ItemCommentServiceImpl.findById)")));
    }

    @Override
    public List<ItemCommentResponse> findAll(Long itemId) {
        List<ItemCommentEntity> comments = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("(ID:" + itemId + ") 아이템 객체 조회 실패 (ItemCommentServiceImpl.findAll)" )).getComments();
        return comments.stream().map(ItemCommentResponse::of).toList();
    }

    @Override
    public void delete(Long id) {
        itemCommentRepository.deleteById(id);
    }

    @Override
    public ItemCommentResponse update(Long id, UpdateItemCommentRequest request) {
        ItemCommentEntity item = itemCommentRepository.findById(id).orElseThrow(() -> new RuntimeException("(ID:" + id + ")상품 조회 실패 (ItemServiceImpl.update)"));
        Optional.ofNullable(request.content()).ifPresent(item::setContent);
        return ItemCommentResponse.of(itemCommentRepository.save(item));
    }

    private ItemCommentEntity toEntity(CreateItemCommentRequest request) {
        return ItemCommentEntity.builder()
                .authorId(request.authorId())
                .content(request.content())
                .item(itemRepository.findById(request.itemId()).orElseThrow(() -> new RuntimeException("(ID:" + request.itemId() + ") 아이템 객체 조회 실패 (ItemCommentServiceImpl.toEntity)" )))
                .build();
    }
}
