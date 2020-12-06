package fst.spring.tp5.product.seller.repository;

import fst.spring.tp5.product.seller.modele.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

    Iterable<Seller> findByName(String seller);

    Seller findById(int id);

    void deleteById(int id);

}
