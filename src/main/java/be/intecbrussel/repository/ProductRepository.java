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
        em.getTransaction().begin();// niet verplicht bij read
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();// niet verplicht bij read
        em.close();

        return product;
    }

    @Override
    public void updateProduct(Product product) {

        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
//        Product mergedProduct = em.merge(product);
//
//        if(!mergedProduct.equals(product)){
//            em.getTransaction().rollback();
//        } else {
//            em.getTransaction().commit();
//        }

        if(product.getId() != 0){
            em.merge(product);
        }

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
