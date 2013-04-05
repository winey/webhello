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
    private final DBhandle dbhandle = new DBhandle();

    public static CustomerDBRepository getInstance() {
        return instance;
    }

    private CustomerDBRepository () {}


    @Override
    public void addCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into customer (name, pw) values (?, ?)";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPw());
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
    public Customer getCustomerByName(String customerName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id, name, pw, balance from customer where name=?";

        Customer customer = new Customer();
        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customerName);
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

    @Override
    public void updateCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update customer set balance=? where customer_id=?";

        try {
            conn = dbConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customer.getBalance());
            pstmt.setInt(2, customer.getId());

            int cnt= pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbDisconnect(pstmt, conn);
        }
    }

    public void updateCustomer(Connection conn, Customer customer) throws SQLException, Exception {

        PreparedStatement pstmt = null;
        String sql = "update customer set balance=? where id=?";
        System.out.println("sql = " + sql);

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customer.getBalance());
            pstmt.setInt(2, customer.getId());

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


    public Connection dbConnect() {

        return dbhandle.dbConnect();
    }

    public void dbDisconnect (ResultSet rs, PreparedStatement pstmt, Connection conn) {

        dbhandle.dbDisconnect(rs, pstmt, conn);
    }

    public void dbDisconnect (PreparedStatement pstmt, Connection conn) {

        dbhandle.dbDisconnect(pstmt, conn);
    }
}
