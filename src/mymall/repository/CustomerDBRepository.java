package mymall.repository;

import mymall.entity.Customer;

import java.sql.*;


/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 4
 * Time: 오후 6:04
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDBRepository implements CustomerRepository {

    private static CustomerDBRepository instance = new CustomerDBRepository();
    private final mymall.repository.DBHandle DBHandle = new mymall.repository.DBHandle();

    public static CustomerDBRepository getInstance() {
        return instance;
    }

    private CustomerDBRepository () {}


    @Override
    public void addCustomer(Customer customer) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Customer getCustomerById(String customerId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id, name, pw, balance from customer where id=?";

        Customer customer = new Customer();
        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customerId);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPw(rs.getString("pw"));
                customer.setBalance(rs.getInt("balance"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(rs, pstmt, conn);
        }

        return customer;
    }

    public Connection dbConnect() {

        return DBHandle.dbConnect();
    }

    public void dbDisconnect (ResultSet rs, PreparedStatement pstmt, Connection conn) {

        DBHandle.dbDisconnect(rs, pstmt, conn);
    }

    public void dbDisconnect (PreparedStatement pstmt, Connection conn) {

        DBHandle.dbDisconnect(pstmt, conn);
    }
}
