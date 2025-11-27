package com.dgsw.project2.controller;

import com.dgsw.project2.dto.request.CreateItemCommentRequest;
import com.dgsw.project2.dto.request.UpdateItemCommentRequest;
import com.dgsw.project2.dto.response.ItemCommentResponse;
import com.dgsw.project2.service.ItemCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item-comments")
public class ItemCommentController {
    private final ItemCommentService itemCommentService;
    @PostMapping
    public ItemCommentResponse create(@RequestBody CreateItemCommentRequest request) {
        return itemCommentService.create(request);
    }

    @GetMapping
    public List<ItemCommentResponse> findAll(@RequestParam Long itemId) {
        return itemCommentService.findAll(itemId);
    }

    @GetMapping("/{id}")
    public ItemCommentResponse findById(@PathVariable Long id) {
        return itemCommentService.findById(id);
    }

    @PutMapping("/{id}")
    public ItemCommentResponse update(@PathVariable Long id, @RequestBody UpdateItemCommentRequest request) {
        return itemCommentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemCommentService.delete(id);
    }
}
