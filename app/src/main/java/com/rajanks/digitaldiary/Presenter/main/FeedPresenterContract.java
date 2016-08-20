package com.rajanks.digitaldiary.Presenter.main;

import com.rajanks.digitaldiary.DataModel.Feed;

import java.util.ArrayList;

/**
 * Created by rajan.kali on 16/08/16.
 */
public interface FeedPresenterContract {
    void onData(ArrayList<Feed> feeds);
}
