package fst.spring.tp5.product.seller.web.controller;

import fst.spring.tp5.product.seller.modele.Seller;
import fst.spring.tp5.product.seller.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {

    @Value("${me}")
    private String me;

    @Autowired
    private SellerRepository sellerDAO;

    @GetMapping(value = "/sellers")
    public Iterable<Seller> getAllSellers(){return sellerDAO.findAll();}

    @GetMapping(value = "/seller/{id}")
    public Seller getSellerById(@PathVariable int id){
        return sellerDAO.findById(id);
    }

    @PostMapping(value = "/sellers")
    public void addSeller(@RequestBody Seller p){
        sellerDAO.save(p);
    }

    @GetMapping(value = "/Cestqui")
    public String getName(){
        return me;
    }

}
