package com.fakhar.NYTimeAssignApp.communication;

import android.util.Log;

import com.fakhar.NYTimeAssignApp.model.ServiceResponse;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Service {
    private final NetworkService networkService;
    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getBaseURL(final ResponseCallback<ServiceResponse> responseCallback)
    {
        return networkService.getBaseURL()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ServiceResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.e("Subscription ","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(ServiceResponse response) {
                        responseCallback.onSuccess(response);
                    }
                });
    }


    //<editor-fold desc="GENERIC CALLBACK">
    public abstract interface ResponseCallback<T> {
        void onSuccess(T response);

        void onError(NetworkError networkError);
    }
    //</editor-fold>


}
