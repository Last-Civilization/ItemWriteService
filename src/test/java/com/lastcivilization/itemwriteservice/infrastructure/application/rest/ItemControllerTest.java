package com.lastcivilization.itemwriteservice.infrastructure.application.rest;

import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.DetailsDto;
import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.ItemDto;
import com.lastcivilization.itemwriteservice.utils.IntegrationBaseClass;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ItemControllerTest extends IntegrationBaseClass {

    @Test
    void shouldCreateItem() throws Exception {
        //given
        CreateItemDto createItemDto = buildCreateItemDto();
        //when
        ResultActions createResult = mockMvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createItemDto)));
        //then
        createResult.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("created"))
                .andExpect(jsonPath("$.type").value("USE"))
                .andExpect(jsonPath("$.details.id").exists())
                .andExpect(jsonPath("$.details.resistance").value(1))
                .andExpect(jsonPath("$.details.damage").value(1))
                .andExpect(jsonPath("$.details.strength").value(1))
                .andExpect(jsonPath("$.details.dexterity").value(1))
                .andExpect(jsonPath("$.details.defense").value(1))
                .andExpect(jsonPath("$.details.health").value(1))
                .andExpect(jsonPath("$.details.time").value(1))
                .andExpect(jsonPath("$.details.lvl").value(1));
    }

    private ItemDto buildItemDto(Long itemId, Long detailsId) {
        return new ItemDto(
                itemId,
                "test",
                new DetailsDto(
                        detailsId,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2,
                        2
                ),
                "USE"
        );
    }

    @NotNull
    private static CreateItemDto buildCreateItemDto() {
        return new CreateItemDto(
                "created",
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                "USE"
        );
    }

    @Test
    void shouldUpdateItem() throws Exception {
        //given
        ItemDto itemDto = buildItemDto(1L, 1L);
        //when
        ResultActions updateResult = mockMvc.perform(put("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto)));
        //then
        updateResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.type").value("USE"))
                .andExpect(jsonPath("$.details.id").value(1))
                .andExpect(jsonPath("$.details.resistance").value(2))
                .andExpect(jsonPath("$.details.damage").value(2))
                .andExpect(jsonPath("$.details.strength").value(2))
                .andExpect(jsonPath("$.details.dexterity").value(2))
                .andExpect(jsonPath("$.details.defense").value(2))
                .andExpect(jsonPath("$.details.health").value(2))
                .andExpect(jsonPath("$.details.time").value(2))
                .andExpect(jsonPath("$.details.lvl").value(2));
    }

    @Test
    void shouldReturnItemNotFoundStatusWhileUpdatingItem() throws Exception {
        //given
        ItemDto itemDto = buildItemDto(2L, 2L);
        //when
        ResultActions updateResult = mockMvc.perform(put("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto)));
        //then
        updateResult.andExpect(status().isNotFound());
    }
}