package com.visioture.dao.factory;

import com.visioture.dao.implementations.ActorDao;
import com.visioture.dao.implementations.FilmDao;
import com.visioture.dao.interfaces.ActorInterface;
import com.visioture.dao.interfaces.FilmInterface;

public class DaoFactory {

	public static ActorInterface getActorDao() {
		return new ActorDao();
	}

	public static FilmInterface getFilmDao() {
		return new FilmDao();
	}

}
