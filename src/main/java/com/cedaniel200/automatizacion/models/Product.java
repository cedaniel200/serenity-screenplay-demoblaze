package com.cedaniel200.automatizacion.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private String category;
    private String name;
}
