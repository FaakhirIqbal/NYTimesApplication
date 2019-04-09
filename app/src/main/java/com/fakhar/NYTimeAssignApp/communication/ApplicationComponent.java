package com.fakhar.NYTimeAssignApp.communication;

import com.fakhar.NYTimeAssignApp.MainActivity;
import com.fakhar.NYTimeAssignApp.controller.NewsArticleFragment;

import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules = {NetWorkModule.class, ApplicationModule.class})

public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(NewsArticleFragment newsArticlesFragment);
}
