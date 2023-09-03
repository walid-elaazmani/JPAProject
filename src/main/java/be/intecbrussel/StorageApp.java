package be.intecbrussel;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.IProductSevice;
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

        StorageService storageService = new StorageService();

        s1.add(p1, p2, p4,p3);

        storageService.addStorage(s1);

        long a = 1;

        s1.setName("updated storage");

        storageService.updateStorage(s1);

        Product p5 = new Product("ore", 12000, 20);

        productService.addProduct(p5);

        s1.add(p5);

        storageService.updateStorage(s1);


        // --------- DELETE STORAGE 1 -------------
        storageService.deleteStorage(s1); // - OK + All Orphans removed !


        // ---------- CREATE STORAGE 2 IN DATABASE ----------
        // 1. create storage 2
        Storage s2 = new Storage("hello");

        // 2. create new product
        Product p6 = new Product("jijih",2,6);

        // 3. add product to database (optional)
        productService.addProduct(p6); // adding p1 - p5 won't work, probably because they have already an id > 0
        System.out.println("see ? : " + p1);

        // 4. add product to storage
        s2.add(p6);

        // 5. add storage to database
        storageService.addStorage(s2);


        //--------- REMOVE PRODUCT FROM STORAGE -------------
        // 1. remove from storage
        s2.remove(p6); // removes p6 from list -> link in table is broken

        // 2. update storage
        storageService.updateStorage(s2); // merging storage, p6 still exists in db, but has no link to storage

        // 3. delete product
        productService.deleteProduct(p6); // delete p6 from database





    }
}
