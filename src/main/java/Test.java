import com.maxkavun.http.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.get()) {
            System.out.println("Connection established successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}