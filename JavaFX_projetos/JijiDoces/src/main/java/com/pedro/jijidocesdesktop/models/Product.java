package com.pedro.jijidocesdesktop.models;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String flavour;
    private Double weight;
    private BigDecimal price;
    private String productType;
    private String productStyle;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getFlavour() {
        return flavour;
    }

    public Double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductStyle() {
        return productStyle;
    }
}