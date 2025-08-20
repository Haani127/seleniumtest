package JDBC;

import java.sql.*;
import java.util.Scanner;

public class JDBCOperations {
    private static final String url = "jdbc:mysql://localhost/ri_db";
    private static final String user = "test";
    private static final String password = "test123";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    insertCutomers(sc);
                    System.out.println("Customer record inserted successfully.");
                    displayCutomers(sc);
                    break;
                case 2:
                    updateCutomers(sc);
                    System.out.println("Customer record updated successfully.");
                    displayCutomers(sc);
                    break;
                case 3:
                    displayCutomers(sc);
                    break;
                case 4:
                    deleteCutomers(sc);
                    System.out.println("Customer record deleted successfully.");
                    displayCutomers(sc);
                    break;
                default:
                    System.out.println("Invalid operation number. Please try again.");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertCutomers(Scanner sc) throws SQLException {
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String contact = sc.nextLine();
        String Plan = sc.nextLine();
        sc.nextLine();
        String payment = sc.next();

        String sql = "INSERT INTO customer(customer_id, name, contact_information, subscription_plan, payment_history) VALUES(?, ? , ? , ? , ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, contact);
            pstmt.setString(4, Plan);
            pstmt.setString(5, payment);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateCutomers(Scanner sc) throws SQLException {
        int id = sc.nextInt();
        String name = sc.next();
        String contact = sc.next();
        String Plan = sc.nextLine();
        String payment = sc.next();

        String query = "UPDATE customer SET name = ?, contact_information = ?, subscription_plan = ?, payment_history = ? WHERE customer_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, contact);
            stmt.setString(3, Plan);
            stmt.setString(4, payment);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void deleteCutomers(Scanner sc) throws SQLException {
        int id = sc.nextInt();
        String query = "DELETE FROM customer WHERE customer_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void displayCutomers(Scanner sc) throws SQLException {
        String sql = "Select * from customer";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Contact Information: %s, Subscription Plan: %s, Payment History: %s%n",
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("contact_information"),
                        rs.getString("subscription_plan"),
                        rs.getString("payment_history"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}