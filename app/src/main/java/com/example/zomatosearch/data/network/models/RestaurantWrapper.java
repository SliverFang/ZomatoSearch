package com.example.zomatosearch.data.network.models;
/*
 This class is modelled on the zomato restaurant json class that is provided as a response to their search api.
 */
public class RestaurantWrapper {
    private Restaurant restaurant;

    public RestaurantWrapper(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public RestaurantWrapper() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "RestaurantWrapper{" +
                "restaurant=" + restaurant.toString() +
                '}';
    }
}
