package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Storage;
import jakarta.persistence.EntityManager;

public class StorageRepository implements IStorageRepository {

    @Override
    public void createStorage(Storage storage) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(storage);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Storage readStorage(Long id) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();

        Storage storagedb = em.find(Storage.class, id);

        em.getTransaction().commit();

        em.close();

        return storagedb;
    }

    @Override
    public void updateStorage(Storage storage) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();

        if (storage.getId() != 0){
            em.merge(storage);
        }

        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void deleteStorage(Storage storage) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Storage.class, storage.getId()));
        em.getTransaction().commit();
        em.close();

    }
}
