package com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto;

public record ItemDto (
        Long id,
        String name,
        DetailsDto details,
        String type
) { }
