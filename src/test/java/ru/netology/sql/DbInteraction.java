package ru.netology.sql;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
        val transactions= "DELETE FROM card_transactions";
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
        } catch (SQLException exception ) {
            exception .printStackTrace();
        }
    }

}
