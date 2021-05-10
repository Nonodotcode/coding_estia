import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ProduitDAOModele(){

	public ArrayList<ProduitBeanModele> lireListe() {

		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		ArrayList<ProduitBeanModele> produitListe = new ArrayList<ProduitBeanModele>();

		try {
			String requete = new String("SELECT id, nom_article, fournisseur_article, quantite, remise, prix_unitaire FROM produit;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while (rs.next()) {
				ProduitBeanModele produit = new ProduitBeanModele();
				produit.setId(rs.getInt("id"));
				produit.setNom_article(rs.getString("nom_article"));
				produit.setFournisseur_article(rs.getString("fournisseur_article"));
				produit.setQuantite(rs.getInt("quantite"));
				produit.setRemise(rs.getInt("remise"));
				produit.setPrix_unitaire(rs.getInt("prix_unitaire"));

				produitListe.add(produit);
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
		return produitListe;
	}

	public int creer(ProduitBeanModele produit) {
		
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		
		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO produit (nom_article, fournisseur_article, quantite, remise, prix_unitaire) VALUES (?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, produit.getNom_article());
			statement.setString(2, produit.getFournisseur_article());
			statement.setInt(3, produit.getQuantite());
			statement.setInt(4, produit.getRemise());
			statement.setInt(5, produit.getPrix_unitaire());


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