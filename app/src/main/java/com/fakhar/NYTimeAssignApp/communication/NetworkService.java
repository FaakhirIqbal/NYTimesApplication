package com.fakhar.NYTimeAssignApp.communication;

import com.fakhar.NYTimeAssignApp.model.ServiceResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=sybDZly7rUqL8GuOtTFGBKNmcihhCQEX")
    Observable<ServiceResponse> getNYTimesDataSet();

}
