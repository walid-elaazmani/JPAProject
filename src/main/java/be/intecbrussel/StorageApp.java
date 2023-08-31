package be.intecbrussel;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.repository.IStorageRepository;
import be.intecbrussel.repository.StorageRepository;
import be.intecbrussel.service.IProductSevice;
import be.intecbrussel.service.IStorageService;
import be.intecbrussel.service.ProductService;
import be.intecbrussel.service.StorageService;

public class StorageApp {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", 1.5, 2.75);
        Product p2 = new Product("Potato", 2.0, 3.0);
        Product p3 = new Product("Banana", 4.0, 2.0);
        Product p4 = new Product("Train", 50000.0, 60000.0);

        Storage s1 = new Storage("Fruits and Trains");

        System.out.println(s1);

        IProductSevice productService = new ProductService();

        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        productService.addProduct(p4);

        System.out.println(productService.getProduct(1)); // return product with id 1, added product "p1" - OK!
        System.out.println(productService.getProduct(2)); // null, bestaat niet - OK!

        p1.setName("updated apple");
        productService.updateProduct(p1); // apple -> updated  apple in DB - OK!

        productService.updateProduct(p2);

//        productService.deleteProduct(p1); // apple deleted from DB - OK!

//        productService.deleteProduct(p2); // NOT DELETED, WHY ?


        StorageService storageService = new StorageService();

        s1.add(p1, p2, p4,p3);

        storageService.addStorage(s1);

        long a = 1;

        Storage storage = storageService.getStorage(a);

//        System.out.println("storage: " + storage);

        s1.setName("updated storage");

        storageService.updateStorage(s1);

        Product p5 = new Product("ore", 12000, 20);

        productService.addProduct(p5);

        s1.add(p5);

        storageService.updateStorage(s1);

        storageService.deleteStorage(s1);

        Storage s2 = new Storage("hello");

        Product p6 = new Product("jijih",2,6);

        s2.add(p6);

        storageService.addStorage(s2);

        storageService.updateStorage(s2);

//        productService.deleteProduct(p6); // foreign key constraint




    }
}
