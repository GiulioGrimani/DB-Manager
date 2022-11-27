package com.visioture.serviceUser;

import java.util.List;
import com.visioture.service.ServiceAPI;

public class Main {

	public static void main(String[] args) {

		ServiceAPI service = new ServiceAPI();
		
//		print(service.getThreeMostPopularActors());
		
//		print(service.getFilmByActorAndReleaseYear("ed", "chase", 2006));
		
//		print(service.getAllActors());
		
//		print(service.getActorsByFirstNameOrLastName("Penelope", "Guiness"));
		
//		print(service.getAllFilms());

	}

	
	private static void print(List<?> myList) {
		for(Object o : myList) {
			System.out.println(o);
			System.out.println();
		}
		System.out.println();
	}
}
