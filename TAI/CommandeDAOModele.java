import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CommandeDAOModele(){
    
	public ArrayList<CommandeBeanModele> lireListe() {

		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		ArrayList<CommandeBeanModele> commandeListe = new ArrayList<CommandeBeanModele>();

		try {
			String requete = new String("SELECT id, fournisseur_article, choix_produit, nombre, prix, commentaire  FROM commande;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while (rs.next()) {
				CommandeBeanModele produit = new CommandeBeanModele();
				commande.setId(rs.getInt("id"));
				commande.setFournisseur_article(rs.getString("fournisseur_article"));
				commande.setChoix_produit(rs.getString("choix_produit"));
				commande.setNombre(rs.getInt("nombre"));
				commande.setPrix(rs.getInt("prix"));
				commande.setCommentaire(rs.getString("commentaire"));

				commandeListe.add(commande);
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
		return commandeListe;
	}

	public int creer(CommandeBeanModele commande) {
		
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		
		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO commande (fournisseur_article, choix_produit, nombre, prix, commentaire) VALUES (?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, commande.getFournisseur_article());
			statement.setString(2, commande.getChoix_produit());
			statement.setInt(3, commande.getNombre());
			statement.setInt(4, commande.getPrix());
			statement.setInt(5, commande.getCommentaire());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				commande.setId(resultat);
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