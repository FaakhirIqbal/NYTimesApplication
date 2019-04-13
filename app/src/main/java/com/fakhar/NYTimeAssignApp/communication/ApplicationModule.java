package com.fakhar.NYTimeAssignApp.communication;

import android.app.Application;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    /**
     *  Provides method in ApplicationModule, allowing Dagger to know this is the instance dagger wanted to inject.
     *  ApplicationModule is a class that contributes to the object graph(means it will provides Application Type).
     * */


    Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

}

