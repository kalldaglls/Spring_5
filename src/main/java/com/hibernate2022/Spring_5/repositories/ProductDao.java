package com.hibernate2022.Spring_5.repositories;

import com.hibernate2022.Spring_5.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
}
