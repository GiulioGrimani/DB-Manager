package com.visioture.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.visioture.dao.dbutil.DBTools;
import com.visioture.dao.interfaces.ActorInterface;
import com.visioture.model.dto.Actor;

public class ActorDao implements ActorInterface {

	@Override
	public List<Actor> getAllActors() {

		Connection connection = DBTools.getConnection();

		List<Actor> actors = new ArrayList<Actor>();

		String query = "SELECT * FROM actor";

		try {

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				actors.add(getFullActorFromResultSet(rs));
			}

			DBTools.closeConnection(connection);
			return actors;

		} catch (SQLException e) {
			System.err.println("QUERY DOESN'T WORK!");
			System.out.println(e.getMessage());
			DBTools.closeConnection(connection);
			return null;
		}
	}

	@Override
	public List<Actor> getActorsInFilm(String title) {

		Connection connection = DBTools.getConnection();

		List<Actor> actors = new ArrayList<Actor>();

		String query = "SELECT actor.first_name, actor.last_name FROM film_actor INNER JOIN film ON film_actor.film_id = film.film_id INNER JOIN actor ON film_actor.actor_id = actor.actor_id WHERE film.title = ?;";

		try {

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, title);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(getActorByFirstNameAndLastNameFromResultSet(rs));
			}

			DBTools.closeConnection(connection);
			return actors;

		} catch (SQLException e) {
			System.err.println("QUERY DOESN'T WORK!");
			System.out.println(e.getMessage());
			DBTools.closeConnection(connection);
			return null;
		}

	}

	@Override
	public List<Actor> getThreeMostPopularActors() {

		Connection connection = DBTools.getConnection();
		
		List<Actor> actors = new ArrayList<Actor>();

		String query = "SELECT actor.first_name, actor.last_name, COUNT(film.film_id) AS numFilm FROM film_actor INNER JOIN film ON film_actor.film_id = film.film_id INNER JOIN actor ON film_actor.actor_id = actor.actor_id GROUP BY actor.actor_id ORDER BY numFilm DESC LIMIT 3;";

		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				actors.add(getActorByFirstNameAndLastNameFromResultSet(rs));
			}

			DBTools.closeConnection(connection);
			return actors;

		} catch (SQLException e) {
			System.err.println("QUERY DOESN'T WORK!");
			System.out.println(e.getMessage());
			DBTools.closeConnection(connection);
			return null;
		}
	}

	@Override
	public List<Actor> getActorsByFirstNameOrLastName(String firstName, String lastName) {

		Connection connection = DBTools.getConnection();
		
		List<Actor> actors = new ArrayList<Actor>();

		String query = "Select * from actor where first_name = ? || last_name = ?;";

		try {
			
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, firstName);
			ps.setString(2, lastName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(getFullActorFromResultSet(rs));
			}

			DBTools.closeConnection(connection);
			return actors;

		} catch (SQLException e) {
			System.err.println("QUERY DOESN'T WORK!");
			System.out.println(e.getMessage());
			DBTools.closeConnection(connection);
			return null;
		}
	}

	@Override
	public List<Actor> getAllActorsWhereNameStartsWith(String prefix) {

		Connection connection = DBTools.getConnection();
		
		List<Actor> actors = new ArrayList<Actor>();

		String query = "SELECT * FROM actor WHERE first_name LIKE ?;";

		try {
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, prefix + "%");
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(getFullActorFromResultSet(rs));
			}
			
			DBTools.closeConnection(connection);
			return actors;

		} catch (SQLException e) {
			System.err.println("QUERY DOESN'T WORK!");
			System.out.println(e.getMessage());
			DBTools.closeConnection(connection);
			return null;
		}
	}

	private Actor getFullActorFromResultSet(ResultSet rs) throws SQLException {

		Actor actor = new Actor();
		
		actor.setId(rs.getInt("actor_id"));
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		actor.setLastUpdate(rs.getTimestamp("last_update"));

		return actor;
	}

	private Actor getActorByFirstNameAndLastNameFromResultSet(ResultSet rs) throws SQLException {

		Actor actor = new Actor();
		
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));

		return actor;
	}
}
