import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepenseDAO {
    
    private static final String URL = "jdbc:mysql://localhost:3306/db_S2_ETU003143 ";
    private static final String USER = "ETU003143";
    private static final String PASSWORD = "pjHi9Ul4";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static void insert_depense(Depense depense) throws SQLException {
        String sql = "INSERT INTO depenses (libelle, montant, date_insert) VALUES (?,?,?)";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, depense.getLibelle());
                stmt.setString(2, depense.getMontant_dep());
                stmt.setString(3, depense.getDate());
                stmt.executeUpdate();
            }
    }

    public static List<Depense> list_depenses() throws SQLException {

        List<Depense> list_dep = new ArrayList<>();

        String sql = " SELECT * FROM depenses ";

        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    list_dep.add(new Depense(rs.getString("libelle"), rs.getString("montant"), rs.getString("date_insert")));
                }
            }

        return list_dep;
        
    }
}
