package com.example.android.newsapp;


public class News {

    /**
     * Section of the article
     */
    private String mSection;

    /**
     * Publication date
     */
    private String mPublishedDate;

    /**
     * Title of the article
     */
    private String mTitle;

    /**
     * Author of the article
     */
    private String mAuthor;

    /**
     * Website URL of the article
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param section is the section of the article
     * @param publishedDate is the published date of the article
     * @param title is the title of the article
     * @param author is the author of the article
     * @param url external link to the article
     */
    public News(String section, String publishedDate, String title, String author, String url) {
        mSection = section;
        mPublishedDate = publishedDate;
        mTitle = title;
        mAuthor = author;
        mUrl = url;
    }

    /**
     * Returns the section of the article
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the published date of the article.
     */
    public String getPublishedDate() {
        return mPublishedDate;
    }

    /**
     * Returns the Title of the article
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the Author of the article
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the website URL of the article.
     */
    public String getUrl() {
        return mUrl;
    }

}
