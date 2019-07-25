package com.dknoe.repository;

import org.springframework.data.repository.CrudRepository;

import com.dknoe.model.Product;

public interface ProductsRepository  extends CrudRepository<Product, Integer>{

}
