package com.dgsw.project2.controller;

import com.dgsw.project2.dto.request.CreateItemRequest;
import com.dgsw.project2.dto.response.ItemResponse;
import com.dgsw.project2.service.ItemService;

    mockMvc.perform(post("/items")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.title").value("상품1"));
    }

    @Test
    @DisplayName("전체 아이템 조회 테스트")
    void getAllItemsTest() throws Exception {
    ItemResponse item1 = new ItemResponse(1L, "상품1", "설명1", 1000L, 1L);
    ItemResponse item2 = new ItemResponse(2L, "상품2", "설명2", 2000L, 2L);
    given(itemService.findAll()).willReturn(List.of(item1, item2));

    mockMvc.perform(get("/items/all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("단일 아이템 조회 테스트")
    void getItemByIdTest() throws Exception {
    ItemResponse response = new ItemResponse(1L, "상품1", "설명1", 1000L, 1L);
    given(itemService.findById(1L)).willReturn(response);

    mockMvc.perform(get("/items/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.title").value("상품1"));
    }

    @Test
    @DisplayName("아이템 수정 테스트")
    void updateItemTest() throws Exception {
    String json = "{\"title\":\"상품1-수정\",\"description\":\"설명1-수정\",\"price\":1500,\"sellerId\":1}";

    ItemResponse response = new ItemResponse(1L, "상품1-수정", "설명1-수정", 1500L, 1L);
    given(itemService.update(1L, new CreateItemRequest("상품1-수정","설명1-수정",1500L,1L)))
        .willReturn(response);

    mockMvc.perform(put("/items/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("상품1-수정"))
        .andExpect(jsonPath("$.price").value(1500));
    }

    @Test
    @DisplayName("아이템 삭제 테스트")
    void deleteItemTest() throws Exception {
    willDoNothing().given(itemService).delete(1L);

    mockMvc.perform(delete("/items")
        .param("itemId", "1"))
        .andExpect(status().isOk());
    }
}
                    @Test
                    @DisplayName("아이템 수정 테스트")
                    void updateItemTest() throws Exception {
                        String json = "{\"title\":\"상품1-수정\",\"description\":\"설명1-수정\",\"price\":1500,\"sellerId\":1}";

                        ItemResponse response = new ItemResponse(1L, "상품1-수정", "설명1-수정", 1500L, 1L);
                        given(itemService.update(1L, new CreateItemRequest("상품1-수정","설명1-수정",1500L,1L)))
                                .willReturn(response);

                        mockMvc.perform(put("/items/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value("상품1-수정"))
                                .andExpect(jsonPath("$.price").value(1500));
                    }

                    @Test
                    @DisplayName("아이템 삭제 테스트")
                    void deleteItemTest() throws Exception {
                        willDoNothing().given(itemService).delete(1L);

                        mockMvc.perform(delete("/items")
                                .param("itemId", "1"))
                                .andExpect(status().isOk());
                    }
                }
