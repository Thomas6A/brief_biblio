package bibliothèque;

public class Livre {
	//Attributs
	private String Titre, Auteur, Genre;
	private int nb_page, nb_exemplaires;
	
	//Constructeurs
	public Livre(final String Titre, final String Auteur, final String Genre, final int nb_page, final int nb_exemplaires) {
		this.Titre = Titre;
		this.Auteur = Auteur;
		this.Genre = Genre;
		this.nb_page = nb_page;
		this.nb_exemplaires = nb_exemplaires;
	}
	
	
	
	
	
	//Getters Setters

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getAuteur() {
		return Auteur;
	}

	public void setAuteur(String auteur) {
		Auteur = auteur;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public int getNb_page() {
		return nb_page;
	}

	public void setNb_page(int nb_page) {
		this.nb_page = nb_page;
	}

	public int getNb_exemplaires() {
		return nb_exemplaires;
	}

	public void setNb_exemplaires(int nb_exemplaires) {
		this.nb_exemplaires = nb_exemplaires;
	}
	
	
}
