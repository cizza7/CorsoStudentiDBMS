package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import bean.Corso;
import dao.CorsoDAO;

public class CorsoService {

	public CorsoService() {

	}

	// INSERISCE CORSO
	public void inserisciCorsoInDb(Corso corsoDaInserire) {
		// richiama corso DAO
		CorsoDAO corsoIns = new CorsoDAO();
		corsoIns.inserisciNuovoCorso(corsoDaInserire);
	}

	// CANCELLA CORSO
	public void cancellaCorsoDaDb(String nomeCorsoDaCancellare) {
		// richiama corso DAO
		CorsoDAO daCancellare = new CorsoDAO();
		daCancellare.cancellaCorso(nomeCorsoDaCancellare);
	}

	// MODIFICA CORSI
	public void modificaCorsoInDb(String nuovoNome, String vecchioNome) {
		CorsoDAO corsoModifica = new CorsoDAO();
		corsoModifica.modificaCorso(vecchioNome, nuovoNome);
	}

	// STAMPA I CORSI
	public void descrizioneCorsi() {
		CorsoDAO corsod = new CorsoDAO();
		ArrayList<Corso> listaCorsi = new ArrayList<Corso>();
		try {

			listaCorsi = corsod.descrizioneCorso();
			Iterator<Corso> iter = listaCorsi.iterator();
			while (iter.hasNext()) {
				Corso corso = iter.next(); //
				System.out.println(corso.toString());
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore Sql o Driver");
			e.printStackTrace();
		}
	}

	// CONTA I CORSI ATTIVI
	public void numeroDiCorsiAttivi() {
		CorsoDAO corsoDAO = new CorsoDAO();
		int result = 0;
		try {
			result = corsoDAO.numeroDiCorsi();

		} catch (ClassNotFoundException e) {
			System.out.println("Errore driver\n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore sql\n");
			e.printStackTrace();
		}
		System.out.println("Ci sono n°" + result + " studenti nati dopo gli anni 90\n");
	}
}
