package ninja.b1t.JEEBackendAPI.JDBC;

import java.sql.*;
import java.util.Scanner;


public class SqlStatements extends JeeJDBC {

    public void selectAllEntries() {

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "Ny64gZwNL2gkb3bE"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM journalentry");

            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("content: " + resultSet.getString("content"));
                System.out.println("created on: " + resultSet.getString("created"));
                System.out.println("mood: " + resultSet.getString("mood"));
                System.out.println("\n");
            }

            System.out.println("\nAlle Entries erfolgreich ausgegeben!\n");
        }
        catch(SQLException e){
            System.out.println("\nCouldn't load all Entries!\n" + e.getMessage());
        }
    }

    public void selectEntryById(int id) {

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "Ny64gZwNL2gkb3bE"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM journalentry WHERE id = " + id);

            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("content: " + resultSet.getString("content"));
                System.out.println("created on: " + resultSet.getString("created"));
                System.out.println("mood: " + resultSet.getString("mood"));
            }
            System.out.println("\nEntry mit id " + id + "erfolgreich ausgegeben!\n");
        }
        catch(SQLException e){
            System.out.println("\nCouldn't load this Entry!\n" + e.getMessage());
        }
    }

    public void addEntry(String content, String created, String mood) {

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "Ny64gZwNL2gkb3bE"
            );

            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("INSERT INTO journalentry \n" + "(`content`,\n" + "`created`,\n" + "`mood`)\n" + "VALUES\n"
                                                        + "(\"" + content + "\"," + "\n" + "\"" + created + "\"," + "\n" + "\"" + mood + "\");");

            System.out.println("\nEntry erfolgreich hinzugefügt!\n");
        }
        catch(SQLException e){
            System.out.println("\nCouldn't create this Entry!\n" + e.getMessage());
        }
    }

    public void updateEntry(int id, String content, String created, String mood) {

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "Ny64gZwNL2gkb3bE"
            );

            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("UPDATE journalentry SET\n" + "`content` = " + "\"" + content + "\",\n" + "`created` = "
                                                        + "\"" + created + "\",\n" + "`mood` = " + "\"" + mood + "\"\n" + "WHERE `id` = " + id + ";");

            System.out.println("\nEntry erfolgreich angepasst!\n");
        }
        catch(SQLException e){
            System.out.println("\nCouldn't create this Entry!\n" + e.getMessage());
        }
    }

    public void deleteEntry(int id) {

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "Ny64gZwNL2gkb3bE"
            );

            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate( "DELETE FROM journalentry WHERE id = " + id + ";");

            System.out.println("\nEntry erfolgreich gelöscht!\n");
        }
        catch(SQLException e){
            System.out.println("\nCouldn't delete this Entry!\n" + e.getMessage());
        }
    }



    public void nochWasTun() {
        JeeJDBC jee = new JeeJDBC();
        Scanner sc = new Scanner(System.in);

        System.out.println("Willst du noch etwas tun?\nFalls nicht " + "\"" + "stop" + "\"" + " eingeben!\n");
        String eingabe = sc.next();

        switch (eingabe) {
            case "stop": {
                System.out.println("Bye Bye!\n");
                break;
            }
            default:
                jee.main(null);
        }
    }
}
