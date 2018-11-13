package com.wiprotest.srijitpanda.project.Dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
interface AppModule {

    //expose Application as an injectable context
    @Binds
    @Singleton
    Context bindContext(Application application);
}
