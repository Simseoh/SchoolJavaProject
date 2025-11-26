package com.dgsw.project2.controller;

import com.dgsw.project2.service.ItemCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemCommentController {
    private final ItemCommentService itemCommentService;
}
