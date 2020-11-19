package com.example.zomatosearch.ui.main;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.zomatosearch.R;
import com.example.zomatosearch.data.network.models.Restaurant;
import com.example.zomatosearch.ui.webView.WebViewActivity;
import com.example.zomatosearch.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainMvpPresenter<MainMvpView> mPresenter;
    private EditText mSearchEditText;
    private RelativeLayout mEmptyLayout;
    private RelativeLayout mErrorLayout;
    private RelativeLayout mStartSearchLayout;
    private ExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableListAdapter;
    private List<String> mExpandableListTitle;
    private RelativeLayout mLoadingLayout;
    private ImageView mCloseImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter=new MainPresenter<>();
        mPresenter.onAttach(this); //Attaches the presenter to the view
        setUp(); //Used to setup the view on creation.
    }


    @Override
    protected void setUp() {

        mSearchEditText=findViewById(R.id.search_editText);
        mStartSearchLayout=findViewById(R.id.start_search_layout);
        mEmptyLayout=findViewById(R.id.no_result_layout);
        mErrorLayout=findViewById(R.id.error_layout);
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        mLoadingLayout=findViewById(R.id.loading_layout);
        mCloseImageView=findViewById(R.id.close_imageview);

        //
        showStartSearch();

        //Used to get real time updates of changing text in the search text edittext field.
        mSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mPresenter.searchRestaurants(charSequence.toString().trim()); //We search for the keyword once the used has made changes.
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mCloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeSearch();
            }
        }); //Clicking on the close icon clears the search edittext.
    }

    /*
    Called when the presenter has wants to updated the data on the view with new search results. The view relays the data to the ListAdapter.
     */
    @Override
    public void onSearchResult(final HashMap<String, ArrayList<Restaurant>> mExpandableListDetail) {

        mExpandableListView.setVisibility(View.VISIBLE);
        hideStartSearch();
        hideNoResult();
        hideErrorOccured();

        mExpandableListTitle = new ArrayList<String>(mExpandableListDetail.keySet());
        mExpandableListAdapter = new CustomExpandableListAdapter(this, mExpandableListTitle, mExpandableListDetail);
        mExpandableListView.setAdapter(mExpandableListAdapter);

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Intent intent=new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", mExpandableListDetail.get(
                        mExpandableListTitle.get(groupPosition)).get(
                        childPosition).getMenu_url());
                startActivity(intent);
                return false;
            }
        });

    }

    /*
    We have four layouts
    1. No Result Found Layout, which is shown when no result returned after a successful search.
    2. Search Layout, which is shown when a search returns valid data.
    3. Loading Layout, which is shown when a network call is in progress.
    4. Error Layout, which is show when some error like network happens during the api call.

    Atmost one of all these layouts is shown at a time, depending on the result of the api call.
    This is handled by the presenter.
     */


    /*
    Shows the no result found layout when no data is found for the search term and hides all other layouts.
     */
    @Override
    public void showNoResultFound() {
        hideErrorOccured();
        hideSearchResult();
        hideStartSearch();
        hideLoading();
        mEmptyLayout.setVisibility(View.VISIBLE);
    }


    /*
    Shows the start search layout when nothing is being searched to asks user to start searching.
     */
    @Override
    public void showStartSearch() {
        hideErrorOccured();
        hideSearchResult();
        hideNoResult();
        hideLoading();
        mStartSearchLayout.setVisibility(View.VISIBLE);
    }

    /*
    Shows the error layout when some error occurs.
    */
    @Override
    public void showErrorOccured() {
        hideStartSearch();
        hideSearchResult();
        hideNoResult();
        hideLoading();
        mErrorLayout.setVisibility(View.VISIBLE);
    }

    /*
    Hides the No Result Layout
     */
    @Override
    public void hideNoResult() {
        mEmptyLayout.setVisibility(View.GONE);
    }

    /*
    Hides the Error Occured Layout
     */
    @Override
    public void hideErrorOccured() {
        mErrorLayout.setVisibility(View.GONE);
    }

    /*
    Hides the Search Result Layout
     */
    @Override
    public void hideSearchResult() {
        mExpandableListView.setVisibility(View.GONE);
    }

    /*
    Hides the Start Search Layout
     */
    @Override
    public void hideStartSearch() {
        mStartSearchLayout.setVisibility(View.GONE);
    }

    /*
    Shows indeterminate loading progress bar when the network call is in progress and hides everything else.
     */
    @Override
    public void showLoading() {
        hideStartSearch();
        hideSearchResult();
        hideNoResult();
        hideErrorOccured();
        mLoadingLayout.setVisibility(View.VISIBLE);
    }

    /*
    Hides loading progress.
     */
    @Override
    public void hideLoading() {

        mLoadingLayout.setVisibility(View.GONE);
    }

    /*
    Clears the search field.
     */
    @Override
    public void closeSearch() {
        mSearchEditText.setText("");
    }
}
