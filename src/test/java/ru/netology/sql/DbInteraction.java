package ru.netology.sql;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInteraction {

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");
        return connection;
    }

    public static void clean() {
        val auth = "DELETE FROM auth_codes";
        val transactions = "DELETE FROM card_transactions";
        val card = "DELETE FROM cards";
        val user = "DELETE FROM users";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            runner.update(conn, auth);
            runner.update(conn, transactions);
            runner.update(conn, card);
            runner.update(conn, user);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static String getCode() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/app";
        String user = "app";
        String password = "pass";
        val verificationCode = "SELECT code FROM auth_codes ";
        try (val conn = DriverManager.getConnection(url, user, password);
             val countStmt = conn.createStatement();) {
            if (verificationCode != null) {
                String sql = "SELECT code FROM auth_codes ";
                val resultSet = countStmt.executeQuery(sql);
                if (resultSet.next()) {
                    //in this case enter when at least one result comes it means user is valid
                } else {
                    //in this case enter when  result size is zero  it means user is invalid
                }
            }

            // You can also validate user by result size if its comes zero user is invalid else user is valid

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;
    }
}
