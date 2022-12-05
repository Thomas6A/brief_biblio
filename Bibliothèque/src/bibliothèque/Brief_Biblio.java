package bibliothèque;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Brief_Biblio {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Livre> Livres = new ArrayList<Livre>();
		import_CSV(Livres);
		Bibliothèque biblio = new Bibliothèque(Livres);
		do {
			try {
				int selection = Choix_util(input);
				if (selection == 1) {
					Choix1(Livres, input);
					biblio = new Bibliothèque(Livres);
				} else if (selection == 2) {
					Choix2(Livres, input);
					biblio = new Bibliothèque(Livres);
				} else if (selection == 3) {
					// Détail du livre
					System.out.println(biblio.Liste_livres());
				} else if (selection == 4) {
					System.out.println("Entrez le titre du livre dont vous voulez le détail");
					Livre detail_livre = biblio.detail_livre();
					System.out.println("L'auteur de " + detail_livre.getTitre() + " est : " + detail_livre.getAuteur()
							+ ", son genre est : " + detail_livre.getGenre() + ", son nombre de page est : "
							+ detail_livre.getNb_page() + " et son nombre d'exemplaire est :"
							+ detail_livre.getNb_exemplaires());
				} else if (selection == 7) {
					// Fin du programme et export en CSV
					biblio.export_fichier();
					break;
				} else if (selection == 5) {
					// Emprunt d'un livre
					System.out.println("Entrez le livre que vous voulez emporter");
					Livre emprunt_livre = biblio.detail_livre();
					if (emprunt_livre.isEmprunt()) {
						System.out.println("Le livre est déjà emprunté");
					} else {
						emprunt_livre.setEmprunt(true);
						Calendar calendar = Calendar.getInstance();
						emprunt_livre.setDate_emprunt(calendar.get(Calendar.DAY_OF_YEAR));
						System.out.println("Votre livre est emprunté, veuillez le rendre sous 30 jours");
					}
				} else if (selection == 6) {
					// Rendu d'un livre
					System.out.println("Entrez le livre que voulez rendre");
					Livre livre = biblio.detail_livre();
					if (livre.isEmprunt()) {
						livre.setEmprunt(false);
						Calendar calendar = Calendar.getInstance();
						int aujourdhui = calendar.get(Calendar.DAY_OF_YEAR);
						if ((aujourdhui - livre.getDate_emprunt()) < 30) {
							livre.setDate_emprunt(0);
							System.out.println("Votre livre a bien été rendue");
						} else {
							livre.setDate_emprunt(0);
							System.out.println("Vous avez rendue votre livre en retard");
						}
					} else {
						System.out.println("Ce livre a déjà été rendue");
					}
				} else {
					System.out.println("Veuillez rentrez un des choix disponibles.");
				}
			} catch (Exception e) {
				System.out.println("Veuillez entrez un des choix");
				input.next();
			}

		} while (true);

	}

//liste des choix
	public static int Choix_util(Scanner input) {
		System.out.println("Choisissez votre utilisation:");
		System.out.println("1 - Saisir un nouveau livre");
		System.out.println("2 - Modifier un livre");
		System.out.println("3 - Afficher la liste des livres");
		System.out.println("4 - Rechercher un livre et afficher son détail");
		System.out.println("5 - Empruntez un livre");
		System.out.println("6 - Rendre un livre");
		System.out.println("7 - Fermer programme");
		System.out.println("Saisissez votre choix:");
		return input.nextInt();

	}

	// Création de livre
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

	// Modification de livre
	public static void Choix2(ArrayList<Livre> Livres, Scanner input) {
		System.out.println("Entrez le titre du livre que vous voulez modifiez");
		input.nextLine();
		String titre = input.nextLine();
		for (int i = 0; i < Livres.size(); i++) {
			if (titre.contains(Livres.get(i).getTitre())) {
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

	// Lire fichier CSV
	public static void import_CSV(ArrayList<Livre> Livres) {
		String line = "";
		String splitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader("biblio.csv"));
			while ((line = br.readLine()) != null) {
				String[] in = line.split(splitBy);
				String titre = in[0];
				String auteur = in[1];
				String genre = in[2];
				String page = in[3];
				String exemplaire = in[4];
				String emprunt = in[5];
				String date = in[6];
				int nb_page = Integer.valueOf(page);
				int nb_exemplaire = Integer.valueOf(exemplaire);
				int date_emprunt = Integer.valueOf(date);
				boolean emp = Boolean.parseBoolean(emprunt);
				Livre livre = new Livre(titre, auteur, genre, nb_page, nb_exemplaire, emp, date_emprunt);
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
