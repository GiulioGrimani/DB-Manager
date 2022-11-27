package com.visioture.dao.interfaces;

import java.util.List;

import com.visioture.model.dto.Film;

public interface FilmInterface {

	List<Film> getAllFilms();

	// Dato il nome e cognome di un attore e un anno di uscita dei film,
	// restituisce i titoli dei film in cui quel determinato attore
	// ha recitato in quel determinato anno
	List<Film> getFilmByActorAndReleaseYear(String firstName, String lastName, int year);
}
