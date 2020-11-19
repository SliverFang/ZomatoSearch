
package com.example.zomatosearch.ui.main;

import android.util.Log;

import com.example.zomatosearch.R;
import com.example.zomatosearch.data.network.models.Restaurant;
import com.example.zomatosearch.data.network.models.RestaurantSearchResponse;
import com.example.zomatosearch.data.network.models.RestaurantWrapper;
import com.example.zomatosearch.ui.base.BasePresenter;
import com.example.zomatosearch.ui.base.MvpView;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter<V extends MvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";
    private static String lastQuery;

    /*
    Receives the search query from the view.
     */
    @Override
    public void searchRestaurants(String query) {

        lastQuery=query;
        if(query.length()==0)//when search query is empty show the start search layout
        {
            ((MainActivity)getMvpView()).showStartSearch();
            return;
        }
        //when the search query is not empty perform an api call and show loading layout
        if (isViewAttached()) {
            ((MainActivity)getMvpView()).showLoading();
        } else {
            return;
        }
        doSearchQuery(query);
    }

    /*
       Performs the search query.
     */
    @Override
    public void doSearchQuery(String query)
    {
        //We define a retrofit callback object to get our data from the network call.
        Callback<RestaurantSearchResponse> callback = new Callback<RestaurantSearchResponse>() {
            @Override
            public void onResponse(Call<RestaurantSearchResponse> call, Response<RestaurantSearchResponse> response) {
                RestaurantSearchResponse  res=(RestaurantSearchResponse)response.body();
                if(lastQuery.length()!=0)
                    handleSearchResult(res);
            }

            @Override
            public void onFailure(Call<RestaurantSearchResponse> call, Throwable t) {

                //In case of any error we show the error layout
                if(!isViewAttached()||call.isCanceled()||lastQuery.length()==0)
                {
                    return;
                }
                ((MainActivity)getMvpView()).showErrorOccured();
            }
        };

        //Do a retrofit call for the search query using the zomato api.
        getDataManager().searchZomato(callback,query);
    }

    /*Deals with the serialised search data. Extracts the list of cuisine from each restaurant data and maps the restaurant to all those cuisine.
      The Map is then passed on to the view for display.
    */
    @Override
    public void handleSearchResult(RestaurantSearchResponse  res)
    {
        if(res!=null)
        {
            ArrayList<Restaurant> restaurantsList=new ArrayList<Restaurant>();
            for(RestaurantWrapper restaurantWrapper:res.getRestaurants())
            {
                restaurantsList.add(restaurantWrapper.getRestaurant());
            }
            if(restaurantsList.size()>0)
            {
                //Map from cuisine name to list of restaurants which servers the particular cuisine.
                HashMap<String, ArrayList<Restaurant>> expandableListDetail =new HashMap<>();
                //Traverse through the list of restaurants
                for(Restaurant restaurant:restaurantsList)
                {
                    //Get the comma separated list of cuisines served in the restaurant and convert into an array.
                    String[] cuisineArr=restaurant.getCuisines().split(",");
                    // Traverse the cuisine list and for each cuisine add the restaurant in the particular list.
                    for(String cuisine:cuisineArr)
                    {
                        cuisine=cuisine.trim();
                        ArrayList<Restaurant> previousList=new ArrayList<>();
                        if(expandableListDetail.containsKey(cuisine))
                        {
                            previousList= expandableListDetail.get(cuisine);
                        }
                        previousList.add(restaurant);
                        expandableListDetail.put(cuisine,previousList);
                    }
                }
                //Pass the map to the View.
                if(isViewAttached())
                {
                    ((MainActivity)getMvpView()).onSearchResult(expandableListDetail);
                }
            }
            else
            {
                if (isViewAttached()) {
                    ((MainActivity)getMvpView()).showNoResultFound();
                }
            }
        }
        else
        {
            //Shows NoResultFound if the returned data is null
            ((MainActivity)getMvpView()).showNoResultFound();
        }
    }



}
