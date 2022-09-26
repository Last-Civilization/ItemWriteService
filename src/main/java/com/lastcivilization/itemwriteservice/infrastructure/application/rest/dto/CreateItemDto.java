package com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto;

public record CreateItemDto (
        String name,
        int resistance,
        int damage,
        int strength,
        int dexterity,
        int defense,
        int health,
        int time,
        int lvl,
        String type
) { }
