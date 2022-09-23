package com.lastcivilization.itemwriteservice.domain.dto;

public record DetailsDto(
        Long id,
        int resistance,
        int damage,
        int strength,
        int dexterity,
        int defense,
        int health,
        int time
) { }
