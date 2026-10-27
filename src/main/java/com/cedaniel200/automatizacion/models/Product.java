package com.cedaniel200.automatizacion.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private String category;
    private String name;
}
