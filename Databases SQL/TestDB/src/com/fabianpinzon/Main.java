package com.fabianpinzon;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String  CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\FabianCreadorApps\\googleDrive\\Projects\\Java\\Databases SQL\\TestDB\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String  COLUMN_PHONE = "phone";
    public static final String  COLUMN_EMAIL = "email";

    public static void main(String[] args) {
       //The commented out code below closes statement and conn automatically
     /*   try (Connection conn = DriverManager.getConnection
                ("jdbc:sqlite:C:\\Users\\FabianCreadorApps\\googleDrive\\Projects\\Java\\Databases SQL\\TestDB\\testjava.db");
        Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE contacts(name TEXT, phone INTEGER, email TEXT)");
        }*/

	    try {
            Connection conn = DriverManager.getConnection
                            (CONNECTION_STRING);
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                "(" + COLUMN_NAME + " text, " +
                                      COLUMN_PHONE + " integer, " +
                                      COLUMN_EMAIL + " text)");
            insertContact(statement,"Fabian", 123, "fabian@test.com");
            insertContact(statement, "Zoila", 456, "zoila@test.com");
            insertContact(statement, "Diana", 1010, "diana@test.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "=2323 " + " WHERE " + COLUMN_NAME + "='Fabian'");
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='Diana'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while(results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " " +
                                   results.getInt(COLUMN_PHONE) + " " +
                                   results.getString(COLUMN_EMAIL));
            }

            results.close();

            statement.close();
            conn.close();

        }catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL +
                ") VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
