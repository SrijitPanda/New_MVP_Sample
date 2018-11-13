package com.wiprotest.srijitpanda.project.Dagger;

import com.wiprotest.srijitpanda.project.ProjectDagerClass;
import com.wiprotest.srijitpanda.project.View.ViewActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * <h2>ActivityBindingModule</h2>
 * <p>This abstract class binds the ViewActivity class</p>
 */
@Module
abstract public class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {ProjectDagerClass.class})
    abstract ViewActivity viewActivity();
}
