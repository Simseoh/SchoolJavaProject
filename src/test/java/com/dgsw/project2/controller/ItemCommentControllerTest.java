package com.dgsw.project2.controller;

import com.dgsw.project2.dto.request.CreateItemCommentRequest;
import com.dgsw.project2.dto.request.UpdateItemCommentRequest;
import com.dgsw.project2.dto.response.ItemCommentResponse;
import com.dgsw.project2.service.ItemCommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemCommentController.class)
public class ItemCommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemCommentService itemCommentService;

    @Test
    @DisplayName("댓글 생성 테스트")
    void createCommentTest() throws Exception {
        String json = "{\"itemId\":1,\"authorId\":1,\"content\":\"댓글 내용\"}";

        ItemCommentResponse response = new ItemCommentResponse(1L, 1L, 1L, "댓글 내용");
        given(itemCommentService.create(new CreateItemCommentRequest(1L,1L,"댓글 내용"))).willReturn(response);

        mockMvc.perform(post("/item-comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("댓글 내용"));
    }

    @Test
    @DisplayName("댓글 전체 조회 테스트")
    void getAllCommentsTest() throws Exception {
        ItemCommentResponse comment1 = new ItemCommentResponse(1L,1L,1L,"댓글1");
        ItemCommentResponse comment2 = new ItemCommentResponse(2L,1L,2L,"댓글2");
        given(itemCommentService.findAll(1L)).willReturn(List.of(comment1, comment2));

        mockMvc.perform(get("/item-comments")
                .param("itemId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("단일 댓글 조회 테스트")
    void getCommentByIdTest() throws Exception {
        ItemCommentResponse response = new ItemCommentResponse(1L,1L,1L,"댓글1");
        given(itemCommentService.findById(1L)).willReturn(response);

        mockMvc.perform(get("/item-comments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("댓글1"));
    }

    @Test
    @DisplayName("댓글 수정 테스트")
    void updateCommentTest() throws Exception {
        String json = "{\"content\":\"댓글1-수정\"}";

        ItemCommentResponse response = new ItemCommentResponse(1L,1L,1L,"댓글1-수정");
        given(itemCommentService.update(1L, new UpdateItemCommentRequest("댓글1-수정")))
                .willReturn(response);

        mockMvc.perform(put("/item-comments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("댓글1-수정"));
    }

    @Test
    @DisplayName("댓글 삭제 테스트")
    void deleteCommentTest() throws Exception {
        willDoNothing().given(itemCommentService).delete(1L);

        mockMvc.perform(delete("/item-comments/1"))
                .andExpect(status().isOk());
    }
}


            @Test
            @DisplayName("단일 댓글 조회 테스트")
            void getCommentByIdTest() throws Exception {
                ItemCommentResponse response = new ItemCommentResponse(1L,1L,1L,"댓글1");
                given(itemCommentService.findById(1L)).willReturn(response);

                mockMvc.perform(get("/item-comments/1"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.id").value(1))
                        .andExpect(jsonPath("$.content").value("댓글1"));
            }

            @Test
            @DisplayName("댓글 수정 테스트")
            void updateCommentTest() throws Exception {
                String json = """
                    {
                        "content": "댓글1-수정"
                    }
                """;

                ItemCommentResponse response = new ItemCommentResponse(1L,1L,1L,"댓글1-수정");
                given(itemCommentService.update(1L, new UpdateItemCommentRequest("댓글1-수정")))
                        .willReturn(response);

                mockMvc.perform(put("/item-comments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.content").value("댓글1-수정"));
            }

            @Test
            @DisplayName("댓글 삭제 테스트")
            void deleteCommentTest() throws Exception {
                willDoNothing().given(itemCommentService).delete(1L);

                mockMvc.perform(delete("/item-comments/1"))
                        .andExpect(status().isOk());
            }
        }
