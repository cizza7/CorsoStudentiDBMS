package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import bean.Corso;

public class CorsoDAO {

	// constructor
	public CorsoDAO() {
	}

	
	
	// OTTENGO LE DESCRIZIONI DI OGNI CORSO
	public ArrayList<Corso> descrizioneCorso() throws ClassNotFoundException, SQLException {


		// PASSO 1: recupero la connessione
		Connection connector = DBConnectionSingleton.getIstance().getConnection();

		// PASSO 2: scrivo query e creo il PreparedStatement
		String readQuery = "select * from corso";
		PreparedStatement state = connector.prepareStatement(readQuery);

		ResultSet tabella = state.executeQuery(readQuery);
		ArrayList<Corso> listaCorsi = new ArrayList<Corso>();

		while (tabella.next()) {
			Corso corsoDi = new Corso();
			corsoDi.setIdCorso(tabella.getInt("idCorso"));
			corsoDi.setNomeCorso(tabella.getString("nomeCorso"));
			corsoDi.setMateriaCorso(tabella.getString("materiaCorso"));
			corsoDi.setSedeCorso(tabella.getString("sedeCorso"));
			corsoDi.setNumeroCrediti(tabella.getInt("nCrediti"));

			listaCorsi.add(corsoDi);

			// System.out.println(corsoDi.toString());
		}

		System.out.println("Query terminata con successo\n");
		return listaCorsi;
	}

	
	// NUOVO CORSO INSERIMENTO
	public void inserisciNuovoCorso(Corso corso) {

		try {
			Connection connector = DBConnectionSingleton.getIstance().getConnection();

			String query = "insert into corso(nomeCorso,materiaCorso,sedeCorso,nCrediti) values (?,?,?,?)";
			PreparedStatement prepstat = connector.prepareStatement(query);

			prepstat.setString(1, corso.getNomeCorso());
			prepstat.setString(2, corso.getMateriaCorso());
			prepstat.setString(3, corso.getSedeCorso());
			prepstat.setInt(4, corso.getNumeroCrediti());

			prepstat.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("Errore Driver \n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore SQL\n");
			e.printStackTrace();
		}

	}
	
	// CANCELLA CORSO
	public void cancellaCorso(String nomeCorsoDaCancellare) {
		try {
			Connection connector = DBConnectionSingleton.getIstance().getConnection();
			String query = "DELETE FROM corso WHERE idCorso=?;";

			int indexCorsoDaEliminare = cercaCorso(nomeCorsoDaCancellare);
			PreparedStatement prepstate = connector.prepareStatement(query);
			prepstate.setInt(1, indexCorsoDaEliminare);
			prepstate.executeUpdate();

			prepstate.close();

			System.out.println("Eliminato con successo");
		} catch (ClassNotFoundException e) {
			System.out.println("Errore driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore SQL");
			e.printStackTrace();
		}


	}

	// MODIFICA CORSO
	public void modificaCorso(String nomeCorsoDaModificare, String nuovoNomeCorso) {
		try {
			Connection connector = DBConnectionSingleton.getIstance().getConnection();
			String query = "UPDATE corso SET nomeCorso=? where idCorso=?;";

			int indexCorsoDaEliminare = cercaCorso(nomeCorsoDaModificare);
			PreparedStatement prepstate = connector.prepareStatement(query);
			prepstate.setString(1, nuovoNomeCorso);
			prepstate.setInt(2, indexCorsoDaEliminare);
			prepstate.executeUpdate();

			System.out.println("Modificato con successo");
		} catch (ClassNotFoundException e) {
			System.out.println("Errore driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore SQL");
			e.printStackTrace();
		}

	}

	// NUMERO DI CORSI PRESENTI
	public int numeroDiCorsi() throws ClassNotFoundException, SQLException {

		// PASSO 1: recupero la connessione
		Connection connector = DBConnectionSingleton.getIstance().getConnection();
		// PASSO 2: creo lo statement
		String countQuery = "select count(idCorso) numeroCorsi from corso";
		PreparedStatement state = connector.prepareStatement(countQuery);
		// ciclo il sirultato
		ResultSet tabella = state.executeQuery();

		int nCorsi = 0;

		if (tabella.next()) {
			nCorsi = tabella.getInt("numeroCorsi");
		} else {
			System.out.println("Nessun corso\n");
			nCorsi = -1;
		}

		System.out.println("Query terminata con successo\n");
		return nCorsi;
	}

	// CERCA CORSO PER NOME
	public int cercaCorso(String nome) {
		int res = -1;

		try {

			// PASSO 1: recupero la connessione
			Connection connector = DBConnectionSingleton.getIstance().getConnection();

			// PASSO 2: scrivo query e creo il PreparedStatement
			String readQuery = "select * from corso";
			PreparedStatement state = connector.prepareStatement(readQuery);

			ResultSet tabella = state.executeQuery(readQuery);
			ArrayList<Corso> listaCorsi = new ArrayList<Corso>();

			while (tabella.next()) {
				Corso corsoDi = new Corso();
				corsoDi.setIdCorso(tabella.getInt("idCorso"));
				corsoDi.setNomeCorso(tabella.getString("nomeCorso"));
				corsoDi.setMateriaCorso(tabella.getString("materiaCorso"));
				corsoDi.setSedeCorso(tabella.getString("sedeCorso"));
				corsoDi.setNumeroCrediti(tabella.getInt("nCrediti"));

				listaCorsi.add(corsoDi);
			}

			// ArrayList<Corso> listaCorsi = new ArrayList<Corso>();
			Iterator<Corso> iter = listaCorsi.iterator();
			while (iter.hasNext()) {
				Corso c = iter.next();
				if (c.getNomeCorso().equals(nome)) {
					res = c.getIdCorso();
					break;
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Errore driver \n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore sql");
			e.printStackTrace();
		}


		// System.out.println(res);
		return res;
	}

}
