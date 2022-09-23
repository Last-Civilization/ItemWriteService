package com.lastcivilization.itemwriteservice.domain.dto;

public record ItemDto (
        Long id,
        String name,
        DetailsDto details,
        String type
) { }
