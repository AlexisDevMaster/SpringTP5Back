package fst.spring.tp5.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class InitBD implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Création et initialisation de la base de données");

        String sqlStatements[] = {
                //"DROP TABLE products_sellers IF EXISTS",
                //"DROP TABLE product IF EXISTS",
                //"DROP TABLE seller IF EXISTS",

                //"CREATE TABLE products(is serial, name VARCHAR(255))",
                "INSERT INTO product(name) VALUES ('Bottle');",
                "INSERT INTO product(name) VALUES ('Computer');",
                "INSERT INTO product(name) VALUES ('Lamp');",
                "INSERT INTO product(name) VALUES ('Television');",

                //"CREATE TABLE seller(is serial, name VARCHAR(255))",
                "INSERT INTO seller(name) VALUES ('Amazon');",
                "INSERT INTO seller(name) VALUES ('CDiscount');",
                "INSERT INTO seller(name) VALUES ('Wish');",

                //"CREATE TABLE products_sellers(is serial, price DOUBLE, id_product INTEGER, id_seller INTEGER)",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (8.60, 1, 1);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (10.0, 2, 2);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (5.60, 1, 3);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (100.99, 2, 1);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (110.20, 2, 2);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (2.20, 3 , 1);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (5.70, 3 , 2);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (1.60, 3 , 3);",
                "INSERT INTO products_sellers (price, id_product, id_seller) VALUES (3.80, 3 , 2);"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql->{
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println("Affichage de tous les vendeurs -------------------------------");
        jdbcTemplate.query("SELECT * FROM seller",
                new RowMapper<Object>() {
                    @Override
                    public Object mapRow(ResultSet seller, int id) throws SQLException{
                        System.out.println("id: " + seller.getString("id") +
                                " nomVendeur : " + seller.getString("name"));
                        return null;
                    }
        });


        System.out.println("Affichage de tous les produits -------------------------------");
        jdbcTemplate.query("SELECT * FROM product",
                new RowMapper<Object>() {
                    @Override
                    public Object mapRow(ResultSet product, int id) throws SQLException{
                        System.out.println("id: " + product.getString("id") +
                                " nomProduit : " + product.getString("name"));
                        return null;
                    }
                });
    }
}
