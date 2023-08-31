package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IStorageService{
    // CREATE
    void addStorage(Storage storage);
    // READ
    Storage getStorage(Long id);
    // UPDATE
    void deleteStorage(Storage storage);
    // DELETE
    void updateStorage(Storage storage);


}
