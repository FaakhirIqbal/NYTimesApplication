package com.fakhar.NYTimeAssignApp.communication;

import com.fakhar.NYTimeAssignApp.MainActivity;
import com.fakhar.NYTimeAssignApp.controller.NewsArticleFragment;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Using dagger2 in project as design pattern
 * ApplicationComponent is most important piece of dagger
 * a way of telling Dagger what dependencies should be bundled together and made available
 * to a given instance so they can be used.
 * They provide a way for a class to request dependencies being injected through their @Inject annotation.
 * */

@Singleton
@Component(modules = {NetWorkModule.class, ApplicationModule.class})

//Dagger will put NetWorkModule and ApplicationModule in ApplicationComponent in buildTime

public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(NewsArticleFragment newsArticlesFragment);
}
