package com.hp.kafka_product.service;

import com.hp.kafka_product.model.Product;
import com.hp.kafka_product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    KafkaProducerService kafkaProducerService;

    public Product createProduct(Product product) {
        Product savedproduct = productRepo.save(product);
        kafkaProducerService.sendMessage("Product Details : " + savedproduct);
        return savedproduct;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public List<Product> getProduct() {
        return productRepo.findAll();
    }


    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepo.findById(id).map(existing -> {
            existing.setName(updatedProduct.getName());
            existing.setPrice(updatedProduct.getPrice());
            Product saved = productRepo.save(existing);
            kafkaProducerService.sendMessage("Updated Product: " + saved);
            return saved;
        });
    }

    public boolean deleteProduct(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            kafkaProducerService.sendMessage("Deleted Product with ID: " + id);
            return true;
        }
        return false;
    }
}
