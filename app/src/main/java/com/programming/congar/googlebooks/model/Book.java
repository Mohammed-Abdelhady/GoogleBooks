package com.programming.congar.googlebooks.model;

public class Book {
    private String mTitle;
    private String mAuthors;
    private String mPublishedDate;
    private String mDescription;
    private String mCategories;
    private String mThumbnail;
    private String mrRetailPrice;
    private String mBuy;
    private String mPreview;
    private String mPrice;
    private int pageCount;
    private String mUrl;
    public Book(String mTitle, String mAuthors, String mPublishedDate, String mDescription, String mCategories, String mThumbnail,
                 String mBuy, String mPerview , String price,int pageCount , String mUrl) {
        this.mTitle = mTitle;
        this.mAuthors = mAuthors;
        this.mPublishedDate = mPublishedDate;
        this.mDescription = mDescription;
        this.mCategories = mCategories;
        this.mThumbnail = mThumbnail;
        this.mBuy = mBuy;
        this.mPreview = mPerview;
        this.mPrice = price;
        this.pageCount = pageCount;
        this.mUrl = mUrl;
    }


    public String getmUrl() {
        return mUrl;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthors() {
        return mAuthors;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getCategories() {
        return mCategories;
    }

    public String getThumbnail() {
        return mThumbnail;
    }


    public String getBuy() {
        return mBuy;
    }

    public String getPerview() {
        return mPreview;
    }

    public String getPrice() {
        return mPrice;
    }




}
