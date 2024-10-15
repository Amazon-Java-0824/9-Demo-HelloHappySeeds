package com.scorsaro.hellowebagain.dto;

import jakarta.validation.constraints.Min;

public record ModifyQuantityRequest(

        @Min(5) Long quantity,
        QuantityOperationType operation
) {
}
