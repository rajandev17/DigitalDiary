package com.rajanks.digitaldiary.Presenter.main;

import com.rajanks.digitaldiary.DataModel.Feed;
import com.rajanks.digitaldiary.Model.Main.FeedInteractor;
import com.rajanks.digitaldiary.Model.Main.FeedInteractorContract;
import com.rajanks.digitaldiary.UI.Fragments.Feed.FeedContract;

import java.util.ArrayList;

/**
 * Created by rajan.kali on 16/08/16.
 */
public class FeedPresenter implements FeedPresenterContract {

    private FeedInteractorContract feedInteractor;
    private FeedContract feedContract;

    public FeedPresenter(FeedContract feedContract){
        this.feedContract = feedContract;
        feedInteractor = new FeedInteractor(this);
    }

    public void setFeed(){
        feedInteractor.loadFeed();
    }

    @Override
    public void onData(ArrayList<Feed> feeds) {
        feedContract.displayFeed(feeds);
    }
}
