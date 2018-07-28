package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {


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

        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }


}
