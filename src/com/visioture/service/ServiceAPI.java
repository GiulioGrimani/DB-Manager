package com.visioture.service;

import java.util.List;

import com.visioture.dao.factory.DaoFactory;
import com.visioture.dao.interfaces.ActorInterface;
import com.visioture.dao.interfaces.FilmInterface;
import com.visioture.model.dto.Actor;
import com.visioture.model.dto.Film;

public class ServiceAPI {

	private static ActorInterface actorService = DaoFactory.getActorDao();
	private static FilmInterface filmService = DaoFactory.getFilmDao();

	public List<Actor> getAllActors() {
		return actorService.getAllActors();
	}

	public List<Actor> getActorsInFilm(String title) {
		return actorService.getActorsInFilm(title);
	}

	public List<Actor> getThreeMostPopularActors() {
		return actorService.getThreeMostPopularActors();
	}

	public List<Actor> getActorsByFirstNameOrLastName(String firstName, String lastName) {
		return actorService.getActorsByFirstNameOrLastName(firstName, lastName);
	}

	public List<Actor> getAllActorsWhereNameStartsWith(String prefix) {
		return actorService.getAllActorsWhereNameStartsWith(prefix);
	}

	public List<Film> getAllFilms() {
		return filmService.getAllFilms();
	}

	public List<Film> getFilmByActorAndReleaseYear(String firstName, String lastName, int year) {
		return filmService.getFilmByActorAndReleaseYear(firstName, lastName, year);
	}

}
