package com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public record CreateItemDto (
        @NotEmpty
        String name,
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
        int lvl,
        @Pattern(regexp = "USE|SHIELD|HELMET|PANTS|SHOES|WEAPON")
        String type
) { }
