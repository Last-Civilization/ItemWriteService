package com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto;

import javax.validation.constraints.Min;

public record DetailsDto(
        @Min(1)
        long id,
        @Min(0)
        int resistance,
        @Min(0)
        int damage,
        @Min(0)
        int strength,
        @Min(0)
        int dexterity,
        @Min(0)
        int defense,
        @Min(0)
        int health,
        @Min(0)
        int time,
        @Min(0)
        int lvl
) { }
