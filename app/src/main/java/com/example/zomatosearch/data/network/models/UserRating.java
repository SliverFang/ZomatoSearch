package com.example.zomatosearch.data.network.models;

/*
 This class is modelled on the zomato user rating json class that is provided as a response to their search api.
 */

public class UserRating {
    private String aggregate_rating;
    private String rating_text;
    private String rating_color;
    private int votes;

    public UserRating() {
    }

    public UserRating(String aggregate_rating, String rating_text, String rating_color, int votes) {
        this.aggregate_rating = aggregate_rating;
        this.rating_text = rating_text;
        this.rating_color = rating_color;
        this.votes = votes;
    }

    public String getAggregate_rating() {
        return aggregate_rating;
    }

    public void setAggregate_rating(String aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
