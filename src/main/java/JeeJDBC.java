import java.sql.*;

public class JeeJDBC {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "Ny64gZwNL2gkb3bE"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM journalentry");

            while(resultSet.next()){
                System.out.println(resultSet.getString("content"));
                System.out.println(resultSet.getString("created"));
                System.out.println(resultSet.getString("mood"));
            }
        }
        catch(SQLException e){
            System.out.println("That didn't work!" + e.getMessage());
        }

    }
}
