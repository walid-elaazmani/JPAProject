package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.repository.IProductRepository;
import be.intecbrussel.repository.ProductRepository;

public class ProductService implements IProductSevice {

    private IProductRepository repo = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        repo.createProduct(product);
    }

    @Override
    public Product getProduct(long id) {
        return repo.readProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        repo.updateProduct(product);

    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public void deleteProduct(Product product) {
        repo.deleteProduct(product);
    }
}
