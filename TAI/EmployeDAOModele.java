import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class EmployeDAOModele(){

	public ArrayList<EmployeBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		ArrayList<EmployeBeanModele> listeEmploye = new ArrayList<EmployeBeanModele>();
		try
		{
			String requete = new String("SELECT id, nom, prenom, mail, mdp, statut FROM employe;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			while ( rs.next() )
			{
				EmployeBeanModele employe = new EmployeBeanModele();
				employe.setId(rs.getInt("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setMail(rs.getString("mail"));
				employe.setMdp(rs.getString("mdp"));
				employe.setStatut(rs.getString("statut"));
				listeEmploye.add(employe);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally
		{
			connexionBDDModele.fermerConnexion();
		}
		return listeEmploye;
	}

}
