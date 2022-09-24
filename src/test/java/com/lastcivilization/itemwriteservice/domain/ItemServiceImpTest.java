package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.domain.dto.DetailsDto;
import com.lastcivilization.itemwriteservice.domain.dto.ItemDto;
import com.lastcivilization.itemwriteservice.domain.exception.ItemNotFoundException;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceImpTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImp underTest;

    @Test
    void shouldCreateItem() {
        //given
        CreateItemDto createItemDto = buildCreateItemDto();
        ItemDto expectedItemDto = buildItemDto(null, null);
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(itemRepository).save(any(Item.class));
        //when
        ItemDto itemDto = underTest.createItem(createItemDto);
        //then
        assertThat(itemDto).isEqualTo(expectedItemDto);
    }

    private ItemDto buildItemDto(Long itemId, Long detailsId) {
        return new ItemDto(
                itemId,
                "test",
                new DetailsDto(
                        detailsId,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1
                ),
                "USE"
        );
    }

    @NotNull
    private static CreateItemDto buildCreateItemDto() {
        return new CreateItemDto(
                "test",
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
    void shouldUpdateItem() {
        //given
        ItemDto updateItemDto = buildItemDto(1L, 1L);
        when(itemRepository.existsById(anyLong())).thenReturn(true);
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(itemRepository).save(any(Item.class));
        //when
        ItemDto itemDto = underTest.updateItem(updateItemDto);
        //then
        assertThat(itemDto).isEqualTo(updateItemDto);
    }

    @Test
    void shouldThrowItemNotFoundExceptionWhileUpdatingItem() {
        //given
        ItemDto updateItemDto = buildItemDto(1L, 1L);
        when(itemRepository.existsById(anyLong())).thenReturn(false);
        //when
        Executable updateExecutable = () -> underTest.updateItem(updateItemDto);
        //then
        assertThrows(ItemNotFoundException.class, updateExecutable);
    }
}