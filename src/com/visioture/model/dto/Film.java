package com.visioture.model.dto;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Film {

	public enum Rating {
		G("G"), PG("PG"), PG_13("PG-13"), R("R"), NC_17("NC-17");

		private final String description;
		private static Map<String, Rating> ratingMap = createRatingMap();

		Rating(String description) {
			this.description = description;
		}

		private static Map<String, Rating> createRatingMap() {
			Map<String, Rating> ratingMap = new HashMap<>();
			for (Rating r : Rating.values()) {
				ratingMap.put(r.description, r);
			}
			return ratingMap;
		}

		public static Rating getRatingByDescription(String description) {
			return ratingMap.get(description);
		}

		public String toString() {
			return this.description;
		}

	};

	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int originalLanguageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private Rating rating;
	private Set<String> specialFeatures;
	private Timestamp lastUpdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(int originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Set<String> getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(Set<String> specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Film id: " + id + "\nTitle: " + title + "\nDescription: " + description + "\nRelease year: "
				+ releaseYear + "\nLanguage id: " + languageId + "\nOriginal language id: " + originalLanguageId
				+ "\nRental duration: " + rentalDuration + "\nRental rate: " + rentalRate + "\nLength: " + length
				+ "\nReplacement cost: " + replacementCost + "\nRating: " + rating + "\nSpecial features: "
				+ specialFeatures + "\nLast update: " + lastUpdate;
	}

}