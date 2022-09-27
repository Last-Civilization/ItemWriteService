package com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto;

import liquibase.pro.packaged.V;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public record ItemDto (
        @Min(1)
        long id,
        @NotEmpty
        String name,
        @Valid
        DetailsDto details,
        @Pattern(regexp = "USE|SHIELD|HELMET|PANTS|SHOES|WEAPON")
        String type
) { }
