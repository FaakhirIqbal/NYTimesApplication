package com.fakhar.NYTimeAssignApp.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//region sample data Result Array
/*
            "url": "https://www.nytimes.com/2019/04/06/health/drug-resistant-candida-auris.html",
            "adx_keywords": "Drug Resistance (Microbial);Candida Auris (Fungus);Infections;Fungi;Antibiotics;Hospitals;Nursing Homes;Centers for Disease Control and Prevention;Royal Brompton Hospital (London, England);Mount Sinai Medical Center;New York City;Chicago (Ill);Illinois;New Jersey;London (England);Pesticides;your-feed-science",
            "column": "Deadly germs, Lost cures",
            "section": "Health",
            "byline": "By MATT RICHTEL and ANDREW JACOBS",
            "type": "Article",
            "title": "A Mysterious Infection, Spanning the Globe in a Climate of Secrecy",
            "abstract": "The rise of Candida auris embodies a serious and growing public health threat: drug-resistant germs.",
            "published_date": "2019-04-06",
            "source": "The New York Times",
            "id": 100000006447778,
            "asset_id": 100000006447778,
            "views": 1,
            "des_facet": [],
            "org_facet": [],
            "per_facet": "",
            "geo_facet": [],
            "media": []

*/
//endregion
public class Result implements Serializable {

    @SerializedName("url")
    private String url;
    @SerializedName("adx_keywords")
    private String adxKeywords;
    @SerializedName("column")
    private Object column;
    @SerializedName("section")
    private String section;
    @SerializedName("byline")
    private String byline;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String abstractStr;
    @SerializedName("published_date")
    private String published_date;
    @SerializedName("source")
    private String source;
    @SerializedName("id")
    private Long id;
    @SerializedName("asset_id")
    private Long asset_id;
    @SerializedName("views")
    private int views;
    //as per design we need to expose keys "des_facet": "org_facet": "geo_facet":
    @SerializedName("media")
    private List<Media> media = null;
//setters and getters
    public String getUrl() {
        return url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public String getSection() {
        return section;
    }

    public String getByline() {
        return byline;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractStr() {
        return abstractStr;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getSource() {
        return source;
    }

    public Long getId() {
        return id;
    }

    public Long getAsset_id() {
        return asset_id;
    }

    public int getViews() {
        return views;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbstractStr(String abstractStr) {
        this.abstractStr = abstractStr;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsset_id(Long asset_id) {
        this.asset_id = asset_id;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
