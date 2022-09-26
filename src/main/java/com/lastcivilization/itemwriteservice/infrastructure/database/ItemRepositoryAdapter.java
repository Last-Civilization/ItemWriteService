package com.lastcivilization.itemwriteservice.infrastructure.database;

import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.lastcivilization.itemwriteservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class ItemRepositoryAdapter implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public ItemModel save(ItemModel item) {
        ItemEntity itemEntity = MAPPER.toEntity(item);
        ItemEntity savedItemEntity = itemJpaRepository.save(itemEntity);
        return MAPPER.toDomain(savedItemEntity);
    }

    @Override
    public boolean existsById(long id) {
        return itemJpaRepository.existsById(id);
    }
}
