import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountService {

    public Account GetAccountDetails(Connection connection, String number) {
        String sql = "SELECT * FROM accounts WHERE account_number = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, number);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve the account details
                String name = rs.getString("name");
                double deposit = rs.getDouble("deposit");

                // Return an Account object
                return new Account(name, number, deposit);
            } else {
                // No account found
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

