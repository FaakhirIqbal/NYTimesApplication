package com.fakhar.NYTimeAssignApp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//region sample data service Response Object
  /*
        "status": "OK",
        "copyright": "Copyright (c) 2019 The New York Times Company.  All Rights Reserved.",
        "num_results": 1694,
        "results": []
   */

//endregion

public class ServiceResponse implements Serializable {

    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("num_results")
    private String numResults;
    @SerializedName("results")
    private List<Result> newsArticleResults = null;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getNumResults() {
        return numResults;
    }

    public List<Result> getNewsArticleResults() {
        return newsArticleResults;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setNumResults(String numResults) {
        this.numResults = numResults;
    }

    public void setNewsArticleResults(List<Result> newsArticleResults) {
        this.newsArticleResults = newsArticleResults;
    }
}
