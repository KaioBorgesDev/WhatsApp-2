package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDB {


    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String SENHA = "270275";
    private final String DB = "Whatsapp";
    private final String URL_BANCO = "jdbc:mysql://localhost:3306/Whatsapp";

    private Connection conexao;


    public Connection startConnection(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL_BANCO, USER,SENHA);
            System.out.println("Conexao feita!");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }

    public void closeConnection(){
        try {
            conexao.close();
            System.out.println("Conexao Fechada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
