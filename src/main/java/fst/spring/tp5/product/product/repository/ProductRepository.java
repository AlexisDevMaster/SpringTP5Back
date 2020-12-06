package fst.spring.tp5.product.product.repository;

import fst.spring.tp5.product.product.modele.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByName(String productName);

    Product findById(int id);

    void deleteById(int id);

}
