package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import bean.Studente;
import dao.StudenteDAO;

public class StudenteService {

	public StudenteService() {
	}

	public void studentiNatiDopo90() {
		StudenteDAO studentiDAO = new StudenteDAO();
		ArrayList<Studente> listaStudentiSopra90 = new ArrayList<Studente>();

		try {
			listaStudentiSopra90 = studentiDAO.studentiNatiDopo90();
			Iterator<Studente> iter = listaStudentiSopra90.iterator();
			while (iter.hasNext()) {
				Studente studente = iter.next();
				System.out.println(studente.toString());
			}
		} catch (ClassNotFoundException e1) {
			System.out.println("Errore Driver\n");
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("Errore SQL\n");
			e1.printStackTrace();
		}
	}
}
