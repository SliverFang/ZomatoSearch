package com.example.zomatosearch.data.network.models;

/*
 This class is modelled on the zomato json data that is provided as a response to their search api.
 */

import java.util.ArrayList;

public class RestaurantSearchResponse {
    private int results_found;
    private int results_start;
    private int results_shown;
    private ArrayList<RestaurantWrapper> restaurants;

    public RestaurantSearchResponse() {
    }

    public RestaurantSearchResponse(int results_found, int results_start, int results_shown, ArrayList<RestaurantWrapper> restaurants) {
        this.results_found = results_found;
        this.results_start = results_start;
        this.results_shown = results_shown;
        this.restaurants = restaurants;
    }

    public int getResults_found() {
        return results_found;
    }

    public void setResults_found(int results_found) {
        this.results_found = results_found;
    }

    public int getResults_start() {
        return results_start;
    }

    public void setResults_start(int results_start) {
        this.results_start = results_start;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public void setResults_shown(int results_shown) {
        this.results_shown = results_shown;
    }

    public ArrayList<RestaurantWrapper> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<RestaurantWrapper> restaurants) {
        this.restaurants = restaurants;
    }
}
