package com.fakhar.NYTimeAssignApp.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//region service sample data of media-metadata Array
/*
        "url": "https://static01.nyt.com/images/2019/04/08/science/00CANDIDA-auris-hp-promofix/00CANDIDA-auris-hp-promofix-square320-v5.jpg",
        "format": "square320",
        "height": 320,
        "width": 320
*/
//endregion


public class MediaMetaData {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;


    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
