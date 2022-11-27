package com.visioture.dao.interfaces;

import java.util.List;

import com.visioture.model.dto.Actor;

public interface ActorInterface {
	
	List<Actor> getAllActors();

	// Dato il titolo di un film, restituisce nome e cognome di tutti gli attori
	// che hanno recitato in quel film
	List<Actor> getActorsInFilm(String title);

	// Restituisce nome e cognome dei primi tre attori che hanno recitato in più film
	// (primo secondo e terzo)
	List<Actor> getThreeMostPopularActors();

	// Dato un nome e un cognome, restituisce una lista di attori
	// che hanno quel nome o quel cognome
	List<Actor> getActorsByFirstNameOrLastName(String firstName, String lastName);
	
	// Data una stringa, restituisce tutti gli attori il cui nome
	// inizia con data stringa
	List<Actor> getAllActorsWhereNameStartsWith(String prefix);
}
