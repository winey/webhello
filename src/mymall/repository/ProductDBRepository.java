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
    private final DBhandle dbHandle = new DBhandle();

    public static ProductDBRepository getInstance() {
        return instance;
    }

    private ProductDBRepository () {}


    @Override
    public List<Product> getProduct() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select product_id, name, price, amount from products order by product_id desc";
        List<Product> products = new ArrayList<Product>();

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("rs = " + rs);
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setAmount(rs.getInt("amount"));

               // System.out.println("product = " + product.getName());

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

            System.out.println("cnt = " + cnt);

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

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update products set name=?, price=?, amount=? where product_id=?";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getAmount());
            pstmt.setInt(4, product.getProductId());

            int cnt= pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(pstmt, conn);
        }
    }

    @Override
    public void updateProduct(Connection conn, Product product) throws SQLException, Exception {

        PreparedStatement pstmt = null;
        String sql = "update products set amount=? where product_id=?";
        System.out.println("sql = " + sql);

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, product.getAmount());
            pstmt.setInt(2, product.getProductId());

            int cnt= pstmt.executeUpdate();
            System.out.println("cnt = " + cnt);

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            //dbDisconnect(pstmt, conn);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from products where product_id = ?";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
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
    public Product getProductById(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select product_id, name, price, amount from products where product_id=?";

        Product product = new Product();

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setAmount(rs.getInt("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(rs, pstmt, conn);
        }

        return product;

    }

    public Connection dbConnect() {

        return dbHandle.dbConnect();
    }

    public void dbDisconnect (ResultSet rs, PreparedStatement pstmt, Connection conn) {

        dbHandle.dbDisconnect(rs, pstmt, conn);
    }

    public void dbDisconnect (PreparedStatement pstmt, Connection conn) {

        dbHandle.dbDisconnect(pstmt, conn);
    }
}
