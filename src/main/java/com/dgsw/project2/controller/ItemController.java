package com.dgsw.project2.controller;

import com.dgsw.project2.dto.request.CreateItemRequest;
import com.dgsw.project2.dto.response.ItemResponse;
import com.dgsw.project2.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> create(CreateItemRequest request) {
        return ResponseEntity.ok().body(itemService.create(request));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse> find(@PathVariable("itemId") Long itemId) {
        return ResponseEntity.ok().body(itemService.findById(itemId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemResponse>> getAll() {
        return ResponseEntity.ok().body(itemService.findAll());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestParam Long itemId
    ) {
        itemService.delete(itemId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemResponse> update(
            @PathVariable("itemId") Long itemId,
            @RequestBody CreateItemRequest request
    ) {
      return ResponseEntity.ok().body(itemService.update(itemId, request));
    }

    @GetMapping("/title/like")
    public ResponseEntity<List<ItemResponse>> findByTitleLike(String keyword) {
        return ResponseEntity.ok().body(itemService.findByTitleLike(keyword));
    }

    @GetMapping("/price/greater-than")
    public ResponseEntity<List<ItemResponse>> findByPriceGreaterThan(Long price) {
        return ResponseEntity.ok().body(itemService.findByPriceGreaterThan(price));
    }
}