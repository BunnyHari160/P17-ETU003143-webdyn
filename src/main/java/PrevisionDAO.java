import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrevisionDAO {
    
    private static final String URL = "jdbc:mysql://localhost:3306/db_S2_ETU003143";
    private static final String USER = "ETU003143";
    private static final String PASSWORD = "pjHi9Ul4";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insert_prevision(Prevision prevision) throws SQLException {
        String sql = " INSERT INTO previsions (libelle, montant) VALUES (?,?) ";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, prevision.getLibelle());
                stmt.setString(2, prevision.getMontant_prev());
                stmt.executeUpdate();
            }
    }

    public static List<Prevision> list_previsions() throws SQLException {

        List<Prevision> list_prev = new ArrayList<>();

        String sql = " SELECT * FROM previsions ";

        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    list_prev.add(new Prevision(rs.getString("libelle"), rs.getInt("montant")));
                }
            }

        return list_prev;
        
    }
}
