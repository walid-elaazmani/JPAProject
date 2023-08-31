package be.intecbrussel.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
//    @OneToMany(targetEntity = Product.class) // To remove parent, but keep children in DB
    private List<Product> storageContent;


    protected Storage() {
        this.storageContent = new ArrayList<>();
    }

    public Storage(String name) {
        this.name = name;
        this.storageContent = new ArrayList<>();
    }

    public List<Product> getStorageContent() {
        return storageContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Product product){
        storageContent.add(product);
    }

    public void add(Product... products){
        for (Product product: products) {
            add(product);
        }
    }

    public void remove(Product product) {
        storageContent.remove(product);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", storageContent=" + storageContent +
                '}';
    }
}
