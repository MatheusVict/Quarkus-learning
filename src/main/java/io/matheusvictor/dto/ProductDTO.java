package io.matheusvictor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class ProductDTO {

    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;
}
