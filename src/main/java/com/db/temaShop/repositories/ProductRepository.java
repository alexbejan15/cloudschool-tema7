package com.db.temaShop.repositories;

import com.db.temaShop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.deleted = true WHERE p.id = :id")
    void delete(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = p.stock + 1 WHERE p.id = :id")
    void incrementStock(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = p.stock - 1 WHERE p.id = :id")
    void decrementStock(Integer id);
}
