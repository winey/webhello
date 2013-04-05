package mymall.repository;

import mymall.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:30
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository {

    List<Product> getProduct();
    void addProduct(Product product);
    void updateProduct(Product product);
    void updateProduct(Connection conn, Product product) throws SQLException, Exception;
    void deleteProduct(int productId);
    Product getProductById(int productId);
}
