package com.example.zomatosearch.ui.main;


import com.example.zomatosearch.data.network.models.Restaurant;
import com.example.zomatosearch.ui.base.MvpView;

import java.util.ArrayList;
import java.util.HashMap;

public interface MainMvpView extends MvpView {
    public void onSearchResult(HashMap<String, ArrayList<Restaurant>> list);
    public void showNoResultFound();
    public void showStartSearch();
    public void showErrorOccured();
    public void hideNoResult();
    public void hideErrorOccured();
    public void hideStartSearch();
    public void hideSearchResult();
    public void closeSearch();
    public void hideLoading();
    public void showLoading();
}
