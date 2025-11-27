package com.dgsw.project2.controller;

import com.dgsw.project2.dto.request.CreateItemCommentRequest;
import com.dgsw.project2.dto.request.CreateItemRequest;
import com.dgsw.project2.dto.request.UpdateItemCommentRequest;
import com.dgsw.project2.dto.response.ItemCommentResponse;
import com.dgsw.project2.service.ItemCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemCommentController {
    private final ItemCommentService itemCommentService;

    @PostMapping
    public ResponseEntity<ItemCommentResponse> create(CreateItemCommentRequest request) {
        return ResponseEntity.ok().body(itemCommentService.create(request));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<ItemCommentResponse> find(@PathVariable("commentId") Long commentId) {
        return ResponseEntity.ok().body(itemCommentService.findById(commentId));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<List<ItemCommentResponse>> getAll(
            @PathVariable("itemId") Long itemId
    ) {
        return ResponseEntity.ok().body(itemCommentService.findAll(itemId));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestParam Long commentId
    ) {
        itemCommentService.delete(commentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemCommentResponse> update(
            @PathVariable("itemId") Long commentId,
            @RequestBody UpdateItemCommentRequest request
    ) {
        return ResponseEntity.ok().body(itemCommentService.update(commentId, request));
    }
}
