package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IProductSevice {
    // CREATE
    void addProduct(Product product);
    // READ
    Product getProduct(long id);
    // UPDATE
    void updateProduct(Product product);
    // DELETE
    void deleteProduct(Long id);
    void deleteProduct(Product product);
}
