public class FournisseurBeanModele(){
    private int id;
    private String nom;
    private String produit;
    private String adresse;
    private int telephone;
    private String mail;

    public FournisseurBeanModele(){

    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProduit() {
		return this.produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



}