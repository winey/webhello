package mymall.repository;

import mymall.entity.Order;
import mymall.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:37
 * To change this template use File | Settings | File Templates.
 */
public class OrderDBRepository implements OrderRepository {

    private static OrderDBRepository instance = new OrderDBRepository();
    private final DBhandle dbHandle = new DBhandle();

    public static OrderDBRepository getInstance() {
        return instance;
    }

    private OrderDBRepository() {}


    @Override
    public List<Order> getOrder() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select order_id, product_id, customer_id, memo, orderdate, ordertime from orders order by order_id desc";
        List<Order> orders = new ArrayList<Order>();

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("rs = " + rs);
            while(rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setProductId(rs.getInt("product_id"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setMemo(rs.getString("memo"));
                order.setOrderDate(rs.getString("orderdate"));
                order.setOrderTime(rs.getString("ordertime"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(rs, pstmt, conn);
        }

        return orders;
    }


    @Override
    public List<Order> getOrder(int customerId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select order_id, product_id, customer_id, memo, orderdate, ordertime from orders where customer_id = ? order by order_id desc";
        List<Order> orders = new ArrayList<Order>();

        System.out.println("sql = " + sql);

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setProductId(rs.getInt("product_id"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setMemo(rs.getString("memo"));
                order.setOrderDate(rs.getString("orderdate"));
                order.setOrderTime(rs.getString("ordertime"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(rs, pstmt, conn);
        }

        return orders;
    }

    @Override
    public void addOrder(Order order) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into orders (product_id, customer_id, memo) values (?, ?, ?)";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, order.getProductId());
            pstmt.setInt(2, order.getCustomerId());
            pstmt.setString(3, order.getMemo());
            int cnt= pstmt.executeUpdate();

        } catch ( SQLException e ) {
           e.printStackTrace();
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            dbDisconnect(pstmt, conn);
        }

    }

    public void addOrder(Connection conn, Order order) throws SQLException,Exception {
        PreparedStatement pstmt = null;
        String sql = "insert into orders (product_id, customer_id, memo) values (?, ?, ?)";
        System.out.println("sql = " + sql);
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, order.getProductId());
            pstmt.setInt(2, order.getCustomerId());
            pstmt.setString(3, order.getMemo());
            int cnt= pstmt.executeUpdate();
            System.out.println("cnt = " + cnt);

        } catch ( SQLException e ) {
            throw e;
        } catch ( Exception e ) {
            throw e;
        } finally {
            //dbDisconnect(pstmt, conn);
        }

    }

    @Override
    public void updateOrder(Order order) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update orders set memo=? where order_id=?";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, order.getMemo());
            pstmt.setInt(2, order.getOrderId());

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
    public void deleteOrder(int orderId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from orders where order_id = ?";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
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
    public Order getOrderById(int orderId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select order_id, product_id, customer_id, memo from orders where order_id=?";

        Order order = new Order();

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                order.setOrderId(rs.getInt("order_id"));
                order.setProductId(rs.getInt("product_id"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setMemo(rs.getString("memo"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(rs, pstmt, conn);
        }

        return order;

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
