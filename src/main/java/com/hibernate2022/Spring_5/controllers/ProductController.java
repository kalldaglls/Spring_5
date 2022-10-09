package com.hibernate2022.Spring_5.controllers;



import com.hibernate2022.Spring_5.entities.Product;
import com.hibernate2022.Spring_5.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping
    public ResponseEntity saveOrUpdate(@RequestBody Product product) {
        try {
            productDao.save(product);
            return ResponseEntity.ok("Продукт успешно сохранен");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Не получилось сохранить продукт");
        }
    }

    @RequestMapping("/start")
    public ResponseEntity hello() {
        try {
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер не запускается");
        }
    }

    @GetMapping
    public Product findById(@RequestParam long id) {
        try {
            return productDao.findById(id).get();
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping("/showProducts")
    public List<Product> findAll() {
        try {
            return (List<Product>) productDao.findAll();
        } catch (Exception e){
            return null;
        }
    }

    @DeleteMapping
    public void deleteById(@RequestParam long id) {
        try {
            productDao.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("SWW");
        }
    }
}

