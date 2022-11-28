package bibliothèque;

import java.util.ArrayList;
import java.util.Scanner;

public class Brief_Biblio {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		ArrayList<Livre> Livres = new ArrayList<Livre>();
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
			if(titre == Livres.get(i).getTitre()) {
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

}
