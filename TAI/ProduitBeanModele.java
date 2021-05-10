public class ProduitBeanModele(){
    private int id;
    private String nom_article;
    private String fournisseur_article;
    private int quantite;
    private int remise;
    private int prix_unitaire;

    public ProduitBeanModele(){

    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_article() {
		return this.nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getFournisseur_article() {
		return this.fournisseur_article;
	}

	public void setFournisseur_article(String fournisseur_article) {
		this.fournisseur_article = fournisseur_article;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getRemise() {
		return this.remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getPrix_unitaire() {
		return this.prix_unitaire;
	}

	public void setPrix_unitaire(int prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

}