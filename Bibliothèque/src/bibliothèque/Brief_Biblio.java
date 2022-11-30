package bibliothèque;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Brief_Biblio {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		ArrayList<Livre> Livres = new ArrayList<Livre>();
		import_CSV(Livres);
		Bibliothèque biblio = new Bibliothèque(Livres);
		do {
			int selection = Choix_util(input);
			if(selection == 1) {
				Choix1(Livres, input);
			    biblio = new Bibliothèque(Livres);
			    continue;
			}else if(selection == 2) {
				Choix2(Livres, input);
				biblio = new Bibliothèque(Livres);
				continue;
			}else if(selection == 3) {
				System.out.println(biblio.Liste_livres());
				continue;
			}else if(selection == 4) {
				Livre livre = biblio.detail_livre(input);
				System.out.println("L'auteur de "+ livre.getTitre() +" est : "+livre.getAuteur()+", son genre est : "+livre.getGenre()
				+", son nombre de page est : "+livre.getNb_page()+" et son nombre d'exemplaire est :"+livre.getNb_exemplaires());
				continue;
			}else if(selection == 5) {
				biblio.export_fichier();
				break;
			}else {
				System.out.println("Veuillez rentrez un des choix disponibles.");
				continue;
			}
			
		}while(true);
		
	}
	
	public static int Choix_util(Scanner input) {
		System.out.println("Choisissez votre utilisation:");
		System.out.println("1 - Saisir un nouveau livre");
		System.out.println("2 - Modifier un livre");
		System.out.println("3 - Afficher la liste des livres");
		System.out.println("4 - Rechercher un livre et afficher son détail");
		System.out.println("5 - Fermer programme");
		System.out.println("Saisissez votre choix:");
		return input.nextInt();
	
	}
	
	public static void Choix1(ArrayList<Livre> Livres, Scanner input) {	
		System.out.println("Entrez le titre du livre");
		input.nextLine();
		String titre = input.nextLine();
		System.out.println("Entrez l'auteur du livre");
		String auteur = input.nextLine();
		System.out.println("Entrez le genre du livre");
		String genre = input.nextLine();
		System.out.println("Entrez le nombre de page du livre");
		int nb_page = input.nextInt();
		System.out.println("Entrez le nombre d'exemplaire du livre");
		int nb_exemplaire = input.nextInt();
		Livre livre = new Livre(titre, auteur, genre, nb_page, nb_exemplaire);
		Livres.add(livre);
	}
	
	public static void Choix2(ArrayList<Livre> Livres, Scanner input) {
		System.out.println("Entrez le titre du livre que vous voulez modifiez");
		input.nextLine();
		String titre = input.nextLine();
		for(int i = 0; i < Livres.size(); i++) {
			if(titre.contains(Livres.get(i).getTitre())){
				System.out.println("Entrez l'auteur du livre");
				Livres.get(i).setAuteur(input.nextLine());
				System.out.println("Entrez le genre du livre");
				Livres.get(i).setGenre(input.nextLine());
				System.out.println("Entrez le nombre de page du livre");
				Livres.get(i).setNb_page(input.nextInt());
				System.out.println("Entrez le nombre d'exemplaire du livre");
				Livres.get(i).setNb_exemplaires(input.nextInt());
				break;
			}
		}
		
	}
	public static void import_CSV(ArrayList<Livre> Livres) {
		String line = "";
		String splitBy = ",";
			try {
				BufferedReader br = new BufferedReader(new FileReader("biblio.csv"));
				while((line = br.readLine()) != null) {
					String[] in = line.split(splitBy);
					String titre = in[0];
					String auteur = in[1];
					String genre = in[2];
					String page = in[3];
					String exemplaire = in[4];
					int nb_page = Integer.valueOf(page);
					int nb_exemplaire = Integer.valueOf(exemplaire);
					Livre livre = new Livre(titre, auteur, genre, nb_page, nb_exemplaire);
					Livres.add(livre);
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
		

}
