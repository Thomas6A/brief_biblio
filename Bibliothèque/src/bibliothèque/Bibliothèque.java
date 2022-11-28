package bibliothèque;

import java.util.ArrayList;

public class Bibliothèque {
	//Attributs
	private ArrayList<Livre> Livres;
	private ArrayList<String> Liste = new ArrayList<String>();
	
	//Constructeurs
	public Bibliothèque(final ArrayList<Livre> Livres) {
		this.Livres = Livres;
	}
	
	//Méthodes
	public ArrayList<String> Liste_livres(){
		
		for (int i = 0; i < Livres.size();i++) {
			Liste.add(this.Livres.get(i).getTitre());
		}
		return Liste;
	}
	
	
	
	//Setters Getters

	public ArrayList<Livre> getLivres() {
		return Livres;
	}

	public void setLivres(ArrayList<Livre> livres) {
		Livres = livres;
	}

}
