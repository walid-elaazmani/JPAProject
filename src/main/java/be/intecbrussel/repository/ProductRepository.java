package be.intecbrussel.repository;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Product;
import jakarta.persistence.EntityManager;

public class ProductRepository implements IProductRepository{
    @Override
    public void createProduct(Product product) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public Product readProduct(long id) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();

        return product;
    }

    @Override
    public void updateProduct(Product product) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void deleteProduct(Product product) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, product.getId()));
        em.getTransaction().commit();
        em.close();

    }
}
