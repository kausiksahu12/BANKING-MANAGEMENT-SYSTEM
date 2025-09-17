package bank.management.system;

import java.sql.*;

public class Con {
    Connection connection;
    Statement statement;

    public Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "rashmitasahu@#12345"
            );

            statement = connection.createStatement();
            System.out.println("✅ Database connected successfully!"); // <--- Debug message

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Database connection failed!"); // <--- Debug message
        }
    }
}
