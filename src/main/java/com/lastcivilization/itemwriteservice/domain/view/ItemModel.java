package com.lastcivilization.itemwriteservice.domain.view;

public record ItemModel(
        Long id,
        String name,
        DetailsModel details,
        String type
) { }
