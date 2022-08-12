package com.db.temaShop.controller;

import com.db.temaShop.models.Product;
import com.db.temaShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PostMapping("increment/{id}")
    public Product increment(@PathVariable Integer id) {
        return productService.incrementStock(id);
    }

    @PostMapping("decrement/{id}")
    public Product decrement(@PathVariable Integer id) {
        return productService.decrementStock(id);
    }
}
