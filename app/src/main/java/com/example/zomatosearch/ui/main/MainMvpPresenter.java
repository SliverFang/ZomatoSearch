
package com.example.zomatosearch.ui.main;

import com.example.zomatosearch.data.network.models.Restaurant;
import com.example.zomatosearch.data.network.models.RestaurantSearchResponse;
import com.example.zomatosearch.ui.base.MvpPresenter;
import com.example.zomatosearch.ui.base.MvpView;

import java.util.ArrayList;

public interface MainMvpPresenter<V extends MvpView> extends MvpPresenter<V> {

    public void searchRestaurants(String query);
    public void doSearchQuery(String query);
    public void handleSearchResult(RestaurantSearchResponse res);

}
