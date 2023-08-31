package be.intecbrussel.repository;

import be.intecbrussel.model.Storage;

public interface IStorageRepository {
    // CREATE
    void createStorage(Storage storage);
    //READ
    Storage readStorage(Long id);
    //UPDATE
    void updateStorage(Storage storage);
    //DELETE
    void deleteStorage(Storage storage);
}
