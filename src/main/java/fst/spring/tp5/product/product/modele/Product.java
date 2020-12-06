package fst.spring.tp5.product.product.modele;

import fst.spring.tp5.product.product_seller.modele.ProductSeller;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    protected Product() { }

    /**
     * Build a painting with no fixed id
     */
    public Product(String name) {
        this.name = name;
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String name, ProductSeller... productSellers) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
