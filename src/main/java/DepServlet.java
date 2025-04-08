import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DepServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String libelle = request.getParameter("libelle");
        String montant = request.getParameter("montant");
        String date = request.getParameter("date");

        if(libelle!=null && !libelle.trim().isEmpty() && montant!=null && !montant.trim().isEmpty() && date!=null && !date.trim().isEmpty()) {
            try {
                DepenseDAO.insert_depense(new Depense(libelle, montant, date));
            } catch (SQLException e) {
                throw new ServletException("erreur ajout Depense", e);
            }
        } else {
            throw new ServletException("erreur : libelle ou montant vide");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
}
