package mymall.repository;

import mymall.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:31
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository {

    void addCustomer(Customer customer);
    Customer getCustomerByName(String customerName);
    void updateCustomer(Customer customer);
    void updateCustomer(Connection conn, Customer customer) throws SQLException, Exception;

}
