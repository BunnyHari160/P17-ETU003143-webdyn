import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrevServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String libelle = request.getParameter("libelle");
        String montant = request.getParameter("montant");

        if(libelle!=null && !libelle.trim().isEmpty() && montant!=null && !montant.trim().isEmpty()) {
            try {
                PrevisionDAO.insert_prevision(new Prevision(libelle, montant));
            } catch (SQLException e) {
                throw new ServletException("erreur ajout prevision", e);
            }
        } else {
            throw new ServletException("erreur : libelle ou montant vide");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
}
