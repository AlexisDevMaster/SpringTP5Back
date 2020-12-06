package fst.spring.tp5.product.product.controller;

import fst.spring.tp5.product.product.modele.Product;
import fst.spring.tp5.product.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productDAO;

    @GetMapping(value = "/products")
    public Iterable<Product> getAllProducts(){
        return productDAO.findAll();
    }

    @GetMapping(value = "/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productDAO.findById(id);
    }

    @PostMapping(value = "/products")
    public void addProduct(@RequestBody Product p){
        productDAO.save(p);
    }

}
