package com.shoptask.faker;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

@Service
public class TestData {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "admin";

    public static void main(String[] argv) {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection;
        Statement statement;


        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

//            shopTestData(50, statement);
//            goodsTestData(50,statement);
            /*buyerTestData(50,statement);*/

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void buyerTestData(int count, Statement statement) throws SQLException {
        final String insertBuyer = "INSERT INTO store.buyer (email, fio) " +
                "VALUES ('%s', '%s')";
        Faker faker = new Faker(new Locale("ru"));

        while (count != 0) {
            --count;
            statement.executeUpdate(String.format(insertBuyer, faker.internet().emailAddress(),
                    faker.name().nameWithMiddle()));
        }
    }

    private static void goodsTestData(int count, Statement statement) throws SQLException {
        final String insertGoods = "INSERT INTO store.goods (goods_name, price_per_one, quantity, code, id_shop) " +
                "VALUES ('%s', %s, %s, '%s', %s)";
        Faker faker = new Faker(new Locale("ru"));

        while (count != 0) {
            --count;

            long generatedLong = 2166 + (long) (Math.random() * (2215 - 2166));

            String code = String.valueOf(faker.commerce().promotionCode());
            while (code.length() >= 16) {
                code = faker.commerce().promotionCode();
            }
            statement.executeUpdate(String.format(insertGoods,
                    faker.commerce().material(),
                    faker.commerce().price().replace(',', '.'),
                    faker.number().randomNumber(),
                    code,
                    generatedLong));
        }
    }

    private static void shopTestData(int count, Statement statement) throws SQLException {
        final String insertShop = "INSERT INTO store.shop (shop_name, address) VALUES ('%s','%s')";
        Faker faker = new Faker(new Locale("ru"));
        while (count != 0) {
            --count;

            String shopName = faker.commerce().department();
            while (shopName.length() >= 16) {
                shopName = faker.commerce().department();
            }

            statement.executeUpdate(String.format(insertShop,
                    shopName, faker.address().fullAddress()));
        }
    }
}
