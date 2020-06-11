package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Studente;

public class StudenteDAO {

	public StudenteDAO() {
	}

	public ArrayList<Studente> studentiNatiDopo90() throws ClassNotFoundException, SQLException {


		// PASSO 1: recupero la connessione
		Connection connector = DBConnectionSingleton.getIstance().getConnection();
		// PASSO 2: creo lo statement

		ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
		String readStudenti = "select idStudente,nomeStudente,cognomeStudente,annoDiNascita from studente where annoDiNascita > 1990";
		PreparedStatement state = connector.prepareStatement(readStudenti);

		ResultSet tabella = state.executeQuery();

		while (tabella.next()) {
			Studente studenteDopo90 = new Studente();
			studenteDopo90.setIdStudente(tabella.getInt("idStudente"));
			studenteDopo90.setNomeStudente(tabella.getString("nomeStudente"));
			studenteDopo90.setCognomeStudente(tabella.getString("cognomeStudente"));
			studenteDopo90.setAnnoDiNascita(tabella.getInt("annoDiNascita"));

			listaStudenti.add(studenteDopo90);
		}

		System.out.println("Query terminata con successo\n");
		return listaStudenti;
	}
}
