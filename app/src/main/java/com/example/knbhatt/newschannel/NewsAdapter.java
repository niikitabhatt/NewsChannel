package com.example.knbhatt.newschannel;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by KN Bhatt on 8/28/2018.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    public NewsAdapter(Activity context, ArrayList<News> Newses) {
        super(context, 0, Newses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
    if(listItemView == null){
    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_layout,parent,false);
    }
        final News currentNews = getItem(position);
        Log.i(LOG_TAG, "Item position: " + position);


        // Find the TextView in the news_layout.xml (mapping)
        TextView titleNewsTextView = (TextView) listItemView.findViewById(R.id.news_title);
        TextView authorNewsTextView = (TextView) listItemView.findViewById(R.id.author_news);
        ImageView thumbnailImageView = (ImageView) listItemView.findViewById(R.id.thumbnail_image);
        TextView sectionNewsTextView = (TextView) listItemView.findViewById(R.id.section_type);
        TextView publicationDateTextView = (TextView) listItemView.findViewById(R.id.publicationDate);


        // Set proper value in each fields
        assert currentNews != null;
        titleNewsTextView.setText(currentNews.getTitle());
        authorNewsTextView.setText(currentNews.getAuthor());
        Picasso.with(getContext()).load(currentNews.getThumbUrl()).into(thumbnailImageView);
        sectionNewsTextView.setText(String.valueOf(currentNews.getSection()));
        publicationDateTextView.setText(String.valueOf(currentNews.getDate()));

        Log.i(LOG_TAG, "ListView has been returned");
        return listItemView;

    }
}
