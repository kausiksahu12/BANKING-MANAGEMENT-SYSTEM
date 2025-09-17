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
                    // "attach your local host name of data base",
                    // "attach your database password here"
            );

            statement = connection.createStatement();
            System.out.println("✅ Database connected successfully!"); // <--- Debug message

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Database connection failed!"); // <--- Debug message
        }
    }
}

