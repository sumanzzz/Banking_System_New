import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;


public class Main_File {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().CreateAndShowGUI(new Main_File());
            }
        });
    }

    // Method to handle account creation
    public void handleAccountCreation(String name, String number, String deposit, JFrame frame) {
        double depositAmount = 0.0;

        try {
            depositAmount = Double.parseDouble(deposit);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid deposit amount");
            return;
        }

        Connection connection = db_connectivity.Connect();

        if (connection != null) {
            boolean success = insertAccountDetails(connection, name, number, depositAmount);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Account created successfully");
            } else {
                JOptionPane.showMessageDialog(frame, "Account Creation Failed.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Database Connection Failed.");
        }
    }

    // Method to insert account details
    public boolean insertAccountDetails(Connection connection, String name, String number, double deposit) {
        String sql = "INSERT INTO accounts(name, account_number, initial_deposit) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.setDouble(3, deposit);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            db_connectivity.LOGGER.log(Level.SEVERE,"Failed  to insert Account details",e);
            JOptionPane.showMessageDialog(null,"an error occured when inserting account details.");

            e.printStackTrace();
            return false;
        }
    }
}