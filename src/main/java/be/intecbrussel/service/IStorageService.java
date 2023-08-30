package be.intecbrussel.service;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;

public interface IStorageService{
    // CREATE
    void addStorage(Storage storage);
    // READ
    Storage getStorage(String name);
    // UPDATE
    void deleteStorage(String name);
    // DELETE
    void updateStorage(Storage storage);


}
