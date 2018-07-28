package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * String with split position of Date
     **/
    private static final String DATE_SEPARATOR = "T";



    public NewsAdapter(Context context, List<News> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        TextView articleSection = listItemView.findViewById(R.id.article_section);
        TextView articleText = listItemView.findViewById(R.id.article_title);
        TextView articleAuthor = listItemView.findViewById(R.id.article_author);
        TextView articleDate = listItemView.findViewById(R.id.article_date);

        News currentArticle = getItem(position);

        articleSection.setText(currentArticle.getSection());
        articleText.setText(currentArticle.getTitle());
        articleAuthor.setText(currentArticle.getAuthor());
        articleDate.setText(currentArticle.getPublishedDate());


        // Converting data using SimpleDateFormat
        String originalDate = currentArticle.getPublishedDate();
        String date = null;

        // Fix split Date
        if (originalDate.contains(DATE_SEPARATOR)) {
            String[] parts = originalDate.split(DATE_SEPARATOR);
            date = parts[0];
        }

        // Converts to format "MM-dd-yyyy"
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date newDate = null;
        try {
            newDate = spf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        spf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        date = spf.format(newDate);

        // Sets text of the date articleDate
        articleDate.setText(date);


        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }


}
