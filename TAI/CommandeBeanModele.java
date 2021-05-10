public class CommandeBeanModele(){

    private int id;
    private String fournisseur_article;
    private String choix_produit;
    private int nombre;
    private int prix;
    private String commentaire;

    public CommandeBeanModele() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFournisseur_article() {
		return this.fournisseur_article;
	}

	public void setFournisseur_article(String fournisseur_article) {
		this.fournisseur_article = fournisseur_article;
	}

	public String getChoix_produit() {
		return this.choix_produit;
	}

	public void setChoix_produit(String choix_produit) {
		this.choix_produit = choix_produit;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


    
    

}