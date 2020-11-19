package com.example.zomatosearch.ui.base;

/*
Base class for all Presenters of the project to inherit from. Contains methods common to all presenters.
 */

import com.example.zomatosearch.data.AppDataManager;
import com.example.zomatosearch.data.DataManager;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{

    private static final String TAG = "BasePresenter";

    private DataManager mDataManager;

    private V mMvpView;

    public BasePresenter() {
        mDataManager=new AppDataManager();
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }


    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
