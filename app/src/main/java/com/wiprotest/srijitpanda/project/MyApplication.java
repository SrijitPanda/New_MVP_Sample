package com.wiprotest.srijitpanda.project;



import com.wiprotest.srijitpanda.project.Dagger.AppComponent;


import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyApplication extends DaggerApplication {

    /**
     * <h2>AndroidInjector</h2>
     * <p>Here the dagger injection method is build and intialised</p>
     * @return it returns appcomponent class
     */
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
