package com.practice.product_service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Category {

    Long id;
    String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    ArrayList<Product> products=new ArrayList<>();


}
