package com.db.temaShop.service;

import com.db.temaShop.models.Product;
import com.db.temaShop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product incrementStock(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Integer stock = productOptional.get().getStock() + 1;
        productOptional.get().setStock(stock);
        return productOptional.get();
    }

    public Product decrementStock(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Integer stock = productOptional.get().getStock() - 1;
        productOptional.get().setStock(stock);
        return productOptional.get();
    }
}
