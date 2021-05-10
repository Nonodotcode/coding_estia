import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class FournisseurDAOModele(){

	public ArrayList<FournisseurDAOModele> lireListe() {

		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		ArrayList<FournisseurDAOModele> fournisseurListe = new ArrayList<FournisseurDAOModele>();

		try {
			String requete = new String("SELECT id, nom, produit, adresse, telephone, mail FROM fournisseur;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while (rs.next()) {
				FournisseurDAOModele fournisseur = new FournisseurDAOModele();
				fournisseur.setId(rs.getInt("id"));
				fournisseur.setNom(rs.getString("nom"));
				fournisseur.setProduit(rs.getString("produit"));
				fournisseur.setAdresse(rs.getString("adresse"));
				fournisseur.setTelephone(rs.getInt("telephone"));
				fournisseur.setMail(rs.getString("mail"));

				fournisseurListe.add(fournisseur);
			}

		} catch (SQLException ex3){
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
		return fournisseurListe;
	}

	public int creer(FournisseurDAOModele fournisseur) {
		
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		
		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO fournisseur (nom, produit, adresse, telephone, mail) VALUES (?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, fournisseur.getNom());
			statement.setString(2, fournisseur.getProduit());
			statement.setString(3, fournisseur.getAdresse());
			statement.setInt(4, fournisseur.getTelephone());
			statement.setString(5, fournisseur.getMail());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				produit.setId(resultat);
			}
			else 
				resultat = -1;

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
		
		return resultat;
	}

}