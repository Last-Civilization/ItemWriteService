package com.lastcivilization.itemwriteservice.domain.dto;

public record CreateItemDto(
        String name,
        int resistance,
        int damage,
        int strength,
        int dexterity,
        int defense,
        int health,
        int time,
        String type
) { }
