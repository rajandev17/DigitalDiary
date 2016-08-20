package com.rajanks.digitaldiary.Model.Main;

import com.rajanks.digitaldiary.DataModel.Feed;
import com.rajanks.digitaldiary.Presenter.main.FeedPresenterContract;

import java.util.ArrayList;

/**
 * Created by rajan.kali on 16/08/16.
 */
public class FeedInteractor implements FeedInteractorContract {

    FeedPresenterContract feedPresenter;

    public FeedInteractor(FeedPresenterContract presenter){
        feedPresenter = presenter;
    }

    @Override
    public void loadFeed() {
        ArrayList<Feed> feeds = new ArrayList<>();
        feeds.add(new  Feed("Holiday on 29th october" , "faucibus  orci  luctus  et  ultrices  posuere  cubilia  curae  duis  faucibus  accumsan  odio  curabitur  convallis  duis  consequat  dui  nec  nisi  volutpat  eleifend  donec  ut  dolor  morbi  vel  lectus  in  quam  fringilla  rhoncus  mauris  enim  leo  rhoncus  sed  vestibulum  sit  amet  cursus  id  turpis  integer  aliquet  massa  id  lobortis"));
        feeds.add(new  Feed("Quarterly Notification" , "donec  ut  mauris  eget  massa  tempor  convallis  nulla  neque  libero  convallis  eget  eleifend  luctus  ultricies  eu  nibh  quisque  id  justo  sit  amet"));
        feeds.add(new  Feed("PTA meeting on 16th october" , "maecenas  pulvinar  lobortis  est  phasellus  sit  amet  erat  nulla  tempus  vivamus  in  felis  eu  sapien  cursus  vestibulum  proin  eu  mi  nulla  ac  enim  in  tempor  turpis  nec  euismod  scelerisque  quam  turpis  adipiscing  lorem  vitae  mattis  nibh  ligula"));
        feeds.add(new  Feed("Holiday on 11-oct due to bandh" , "interdum  mauris  non  ligula  pellentesque  ultrices  phasellus  id  sapien  in  sapien  iaculis  congue  vivamus  metus  arcu  adipiscing  molestie  hendrerit  at  vulputate  vitae  nisl  aenean  lectus  pellentesque  eget  nunc  donec  quis  orci  eget  orci  vehicula"));
        feeds.add(new  Feed("Mid Term Schedule" , "pellentesque  volutpat  dui  maecenas  tristique  est  et  tempus  semper  est  quam  pharetra  magna  ac  consequat  metus  sapien  ut  nunc  vestibulum  ante  ipsum  primis"));
        feeds.add(new  Feed("Assignment Notice" , "vel  nulla  eget  eros  elementum  pellentesque  quisque  porta  volutpat  erat  quisque  erat  eros  viverra  eget  congue  eget  semper  rutrum  nulla  nunc  purus  phasellus  in  felis  donec  semper  sapien  a  libero  nam  dui  proin  leo  odio  porttitor  id  consequat  in  consequat  ut"));
        feeds.add(new  Feed("Results are out for First Unit test" , "vestibulum  proin  eu  mi  nulla  ac  enim  in  tempor  turpis  nec  euismod  scelerisque  quam  turpis  adipiscing  lorem  vitae  mattis  nibh  ligula  nec  sem  duis"));
        feeds.add(new  Feed("Unit Test Starts 14th Aug" , "non  pretium  quis  lectus  suspendisse  potenti  in  eleifend  quam  a  odio  in  hac  habitasse  platea  dictumst  maecenas  ut  massa  quis  augue  luctus  tincidunt  nulla  mollis  molestie  lorem  quisque  ut  erat  curabitur  gravida  nisi  at  nibh  in  hac  habitasse"));
        feeds.add(new  Feed("Books Required" , "sem  mauris  laoreet  ut  rhoncus  aliquet  pulvinar  sed  nisl  nunc  rhoncus  dui  vel  sem  sed  sagittis  nam  congue  risus  semper  porta  volutpat  quam  pede  lobortis  ligula  sit  amet"));
        feeds.add(new  Feed("Class V schedule" , "integer  aliquet  massa  id  lobortis  convallis  tortor  risus  dapibus  augue  vel  accumsan  tellus  nisi  eu  orci  mauris  lacinia  sapien  quis  libero  nullam  sit  amet  turpis  elementum  ligula  vehicula  consequat  morbi  a  ipsum  integer  a  nibh  in  quis  justo  maecenas  rhoncus  aliquam  lacus  morbi"));
        feedPresenter.onData(feeds);
    }
}
