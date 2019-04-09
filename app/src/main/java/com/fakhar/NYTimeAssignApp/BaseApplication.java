package com.fakhar.NYTimeAssignApp;

import android.app.Application;

import com.fakhar.NYTimeAssignApp.communication.ApplicationComponent;
import com.fakhar.NYTimeAssignApp.communication.ApplicationModule;
import com.fakhar.NYTimeAssignApp.communication.DaggerApplicationComponent;
import com.fakhar.NYTimeAssignApp.communication.NetWorkModule;

public class BaseApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netWorkModule(new NetWorkModule())
                .build();
    }
    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }
}
