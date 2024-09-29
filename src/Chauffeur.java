public class Chauffeur 
{
	private String matricule;
	private String nom_prenom;
	private String ville_travail;
	private boolean marie;
	private String type_permis;
	private double salaire;
	private double salaire_divers=0;
	public Chauffeur() {
		super();
	}
	public Chauffeur(String matricule, String nom_prenom, String ville_travail, boolean marie, String type_permis,
			double salaire) {
		super();
		this.matricule = matricule;
		this.nom_prenom = nom_prenom;
		this.ville_travail = ville_travail;
		this.marie = marie;
		this.type_permis = type_permis;
		this.salaire = salaire;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom_prenom() {
		return nom_prenom;
	}
	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}
	public String getVille_travail() {
		return ville_travail;
	}
	public void setVille_travail(String ville_travail) {
		this.ville_travail = ville_travail;
	}
	public boolean isMarie() {
		return marie;
	}
	public void setMarie(boolean marie) {
		this.marie = marie;
	}
	public String getType_permis() {
		return type_permis;
	}
	public void setType_permis(String type_permis) {
		this.type_permis = type_permis;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public double getSalaire_divers() {
		return salaire_divers;
	}
	public void setSalaire_divers(double salaire_divers) {
		this.salaire_divers = salaire_divers;
	}
	
	
}
