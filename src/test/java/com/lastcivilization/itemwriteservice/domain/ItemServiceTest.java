package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.exception.ItemNotFoundException;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.view.CreateItemModel;
import com.lastcivilization.itemwriteservice.domain.view.DetailsModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService underTest;

    @Test
    void shouldCreateItem() {
        //given
        CreateItemModel createItemModel = buildCreateItemDto();
        ItemModel expectedItemModel = buildItemDto(null, null);
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(itemRepository).save(any(ItemModel.class));
        //when
        ItemModel itemModel = underTest.createItem(createItemModel);
        //then
        assertThat(itemModel).isEqualTo(expectedItemModel);
    }

    private ItemModel buildItemDto(Long itemId, Long detailsId) {
        return new ItemModel(
                itemId,
                "test",
                new DetailsModel(
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
    private static CreateItemModel buildCreateItemDto() {
        return new CreateItemModel(
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
        ItemModel updateItemModel = buildItemDto(1L, 1L);
        when(itemRepository.existsById(anyLong())).thenReturn(true);
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(itemRepository).save(any(ItemModel.class));
        //when
        ItemModel itemModel = underTest.updateItem(updateItemModel);
        //then
        assertThat(itemModel).isEqualTo(updateItemModel);
    }

    @Test
    void shouldThrowItemNotFoundExceptionWhileUpdatingItem() {
        //given
        ItemModel updateItemModel = buildItemDto(1L, 1L);
        when(itemRepository.existsById(anyLong())).thenReturn(false);
        //when
        Executable updateExecutable = () -> underTest.updateItem(updateItemModel);
        //then
        assertThrows(ItemNotFoundException.class, updateExecutable);
    }
}