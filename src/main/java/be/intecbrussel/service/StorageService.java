package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.StorageRepository;

public class StorageService implements IStorageService{
    ProductService productService = new ProductService();
    StorageRepository repo = new StorageRepository();
    @Override
    public void addStorage(Storage storage) {
        for (Product product : storage.getStorageContent()) {
            if(product.getId() == 0){
                productService.addProduct(product);
            } else{
                productService.updateProduct(product);
            }
        }

        repo.createStorage(storage);
    }

    @Override
    public Storage getStorage(Long id) {
        return repo.readStorage(id);
    }

    @Override
    public void deleteStorage(Storage storage) {
        repo.deleteStorage(storage);
    }

    @Override
    public void updateStorage(Storage storage) {
        repo.updateStorage(storage);
    }
}
