package com.fakhar.NYTimeAssignApp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

    //region sample data set for key Media array
      /*
        "type": "image",
        "subtype": "photo",
        "caption": "A projection of the Candida auris fungus on a microscope slide.",
        "copyright": "Melissa Golden for The New York Times",
        "approved_for_syndication": 1,
        "media-metadata": []
        */

//endregion


public class Media implements Serializable {
    @SerializedName("type")
    private String type;
    @SerializedName("subtype")
    private String subtype;
    @SerializedName("caption")
    private String caption;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("approved_for_syndication")
    private Integer approvedSyndication;
    @SerializedName("media-metadata")
    private List<MediaMetaData> mediaMetaData = null;


    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getCaption() {
        return caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public Integer getApprovedSyndication() {
        return approvedSyndication;
    }

    public List<MediaMetaData> getMediaMetaData() {
        return mediaMetaData;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setApprovedSyndication(Integer approvedSyndication) {
        this.approvedSyndication = approvedSyndication;
    }

    public void setMediaMetaData(List<MediaMetaData> mediaMetaData) {
        this.mediaMetaData = mediaMetaData;
    }
}
