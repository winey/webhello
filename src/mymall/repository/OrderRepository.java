package mymall.repository;

import mymall.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:31
 * To change this template use File | Settings | File Templates.
 */
public interface OrderRepository {
    List<Order> getOrder();
    List<Order> getOrder(int customerId);
    void addOrder(Order order) throws SQLException;
    void addOrder(Connection conn, Order order) throws SQLException, Exception;
    void updateOrder(Order order);
    void deleteOrder(int orderId);
    Order getOrderById(int orderId);
}
