package bean;

import java.util.Scanner;

import service.CorsoService;
import service.StudenteService;

public class Main {

	public static void main(String[] args) {

		System.out.println("Benvenuto nel menu per i Corsi degli Studenti \n");
		System.out.println("Scegli cosa fare \n");

		boolean quit = false;

		do {
			System.out.println(""
					+ "1)Inserisci nuovo Corso\n"
					+ "2)Cancella Corso\n"
					+ "3)Inserisci Studente(NAN)\n"
					+ "4)Cancella Studente(NAN)\n"
					+ "5)Inserisci Laurea(NAN)\n"
					+ "6)Cancella Laurea(NAN)\n"
					+ "7)Modifica(Solo Corso)\n"
					+ "8)Descrizione Corsi di Formazione\n"
					+ "9)Studenti nati dopo il 1990 \n"
					+ "10)Numero di corsi presenti nel sistema\n"
					+ "0)esci"
					);

			Scanner scanScelta = new Scanner(System.in);
			int scelta = scanScelta.nextInt();

			switch (scelta) {
			// inserimento CORSO
			case 1:
				System.out.println("Nome del nuovo corso\n");
				Scanner scanNomeCorso = new Scanner(System.in);
				String nomeCorso = scanNomeCorso.nextLine();

				System.out.println("Materia del nuovo corso\n");
				Scanner scanMateriaCorso = new Scanner(System.in);
				String materiaCorso = scanMateriaCorso.nextLine();

				System.out.println("Sede del nuovo corso\n");
				Scanner scanSedeCorso = new Scanner(System.in);
				String sedeCorso = scanSedeCorso.nextLine();

				System.out.println("Numero di crediti\n");
				Scanner scanNCreditiCorso = new Scanner(System.in);
				int nCreditiCorso = scanNCreditiCorso.nextInt();

				// Corso Service Call
				Corso corsoDaInserire = new Corso(nomeCorso, materiaCorso, sedeCorso, nCreditiCorso);
				CorsoService corsoIns = new CorsoService();
				corsoIns.inserisciCorsoInDb(corsoDaInserire);


				break;

			case 2:
				System.out.println("Nome del corso da cancellare\n");
				Scanner scanEliminaCorso = new Scanner(System.in);
				String nomeCorsoDaEliminare = scanEliminaCorso.nextLine();

				// CorsoService Call
				CorsoService corsoDaCancellareService = new CorsoService();
				corsoDaCancellareService.cancellaCorsoDaDb(nomeCorsoDaEliminare);

				break;
			case 3:

				System.out.println("In Lavorazione");
				break;
			case 4:
				System.out.println("In Lavorazione");
				break;
			case 5:
				System.out.println("In Lavorazione");
				break;
			case 6:
				System.out.println("In Lavorazione");
				break;
			case 7:
				System.out.println("Nome del corso da modificare\n");
				Scanner scanCorsoDaModificare = new Scanner(System.in);
				String nomeCorsoDaModificare = scanCorsoDaModificare.nextLine();

				System.out.println("Nuovo nome\n");
				Scanner scanNuovoNome = new Scanner(System.in);
				String nuovoNomeCorso = scanNuovoNome.nextLine();


				CorsoService corsoDaModificare = new CorsoService();
				corsoDaModificare.modificaCorsoInDb(nuovoNomeCorso, nomeCorsoDaModificare);

				System.out.println("In Lavorazione");
				break;
			// descrizione corsi
			case 8:
				System.out.println("Cosa vuoi modificare ?\n1)Corso\n2)Studente\n2)Laurea\n");
				Scanner scanSceltaModifica = new Scanner(System.in);
				int sceltaModifica = scanSceltaModifica.nextInt();

				switch (sceltaModifica) {

				// modifica Corso
				case 1:
					CorsoService corsoDaDescrivere = new CorsoService();
					corsoDaDescrivere.descrizioneCorsi();
					break;

				// modifica Studente
				case 2:
					break;

				// modifica Laurea
				case 3:
					break;

				}
				break;

			// studenti > 1990
			case 9:
				StudenteService studentiDopo90 = new StudenteService();
				studentiDopo90.studentiNatiDopo90();
				break;


			// numero di corsi
			case 10:
				CorsoService contaCorsiAttivi = new CorsoService();
				contaCorsiAttivi.numeroDiCorsiAttivi();
				break;


			// esci
			case 0:
				quit = true;
				break;

			}

		} while (!quit);

		System.out.println("Arrivederci");
	}

}
