package be.intecbrussel;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.Storage;
import be.intecbrussel.service.IProductSevice;
import be.intecbrussel.service.ProductService;

public class StorageApp {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", 1.5, 2.75);
        Product p2 = new Product("Potato", 2.0, 3.0);
        Product p3 = new Product("Banana", 4.0, 2.0);
        Product p4 = new Product("Train", 50000.0, 60000.0);

        Storage s1 = new Storage("Fruits and Trains");

        s1.add(p1,p2,p3,p4);

        System.out.println(s1);

        IProductSevice productSevice = new ProductService();


        productSevice.addProduct(p1);

        System.out.println(productSevice.getProduct(1)); // return product with id 1, added product "p1" - OK!
        System.out.println(productSevice.getProduct(2)); // null, bestaat niet - OK!

        p1.setName("updated Apple");
        System.out.println(p1);
        productSevice.updateProduct(p1); // apple -> updated  apple in DB - OK!

        productSevice.deleteProduct(p1); // apple deleted from DB - OK!
    }
}
