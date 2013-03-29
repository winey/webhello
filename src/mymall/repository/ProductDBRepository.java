package mymall.repository;

import mymall.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:37
 * To change this template use File | Settings | File Templates.
 */
public class ProductDBRepository implements ProductRepository {

    private static ProductDBRepository instance = new ProductDBRepository();

    public static ProductDBRepository getInstance() {
        return instance;
    }

    private ProductDBRepository () {}


    @Override
    public List<Product> getProduct() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select product_id, name, price, amount from products";
        List<Product> products = new ArrayList<Product>();

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setAmount(rs.getInt("amount"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(rs, pstmt, conn);
        }

        return products;
    }

    @Override
    public void addProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into products (name, price, amount) values (?, ?, ?)";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getAmount());
            int cnt= pstmt.executeUpdate();

        } catch ( SQLException e ) {
           e.printStackTrace();
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            dbDisconnect(pstmt, conn);
        }

    }

    @Override
    public void updateProduct(Product product) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteProduct(int productId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Product getProductById(int productId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public Connection dbConnect() {
        String url = "jdbc:postgresql://localhost:5432/mymall";
        String usr = "test";
        String pwd = "1004";

        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void dbDisconnect (ResultSet rs, PreparedStatement pstmt, Connection conn) {

        try {

            if(rs != null) { rs.close(); }
            if(pstmt != null) { pstmt.close(); }
            if(conn != null) { conn.close(); }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbDisconnect (PreparedStatement pstmt, Connection conn) {

        try {

            if(pstmt != null) { pstmt.close(); }
            if(conn != null) { conn.close(); }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
