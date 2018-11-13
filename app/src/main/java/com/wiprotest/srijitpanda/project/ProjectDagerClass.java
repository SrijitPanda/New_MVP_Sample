package com.wiprotest.srijitpanda.project;

import com.wiprotest.srijitpanda.project.Dagger.ActivityScoped;
import com.wiprotest.srijitpanda.project.Presenter.Contract;
import com.wiprotest.srijitpanda.project.Presenter.Presenter;
import com.wiprotest.srijitpanda.project.View.ViewActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ProjectDagerClass {
  @Binds
  @ActivityScoped
  abstract Contract.PresenterContract provideBookingPresenter(Presenter presenter);

  @Binds
  @ActivityScoped
  abstract Contract.ViewContract  provideBookingView(ViewActivity viewActivity);
 }

