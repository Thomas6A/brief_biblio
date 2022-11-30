package bibliothèque;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bibliothèque {
	//Attributs
	private ArrayList<Livre> Livres;
	private ArrayList<String> Liste = new ArrayList<String>();
	private Livre livre;
	
	//Constructeurs
	public Bibliothèque(final ArrayList<Livre> Livres) {
		this.Livres = Livres;
	}
	
	//Méthodes
	public ArrayList<String> Liste_livres(){
		
		for (int i = 0; i < this.Livres.size();i++) {
			Liste.add(this.Livres.get(i).getTitre());
		}
		return Liste;
	}
	
	public Livre detail_livre(Scanner input) {
		System.out.println("Entrez le titre du livre dont vous voulez le détail");
		String titre = input.nextLine();
		for (int i = 0; i < this.Livres.size(); i++) {
			if(titre.contains(this.Livres.get(i).getTitre())) {
				livre = this.Livres.get(i);
			}
		}
		return livre;
	}
	
	public void export_fichier() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("biblio.csv"));
			for(Livre livre:Livres) {
				writer.write(livre.getTitre()+","+livre.getAuteur()+","+livre.getGenre()+","+livre.getNb_page()+","+livre.getNb_exemplaires()+"\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Setters Getters

	public ArrayList<String> getListe() {
		return Liste;
	}

	public void setListe(ArrayList<String> liste) {
		Liste = liste;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public ArrayList<Livre> getLivres() {
		return Livres;
	}

	public void setLivres(ArrayList<Livre> livres) {
		Livres = livres;
	}

}
