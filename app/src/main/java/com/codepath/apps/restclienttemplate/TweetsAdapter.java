package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

import javax.annotation.Nonnull;

    public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

        Context context;
        List<Tweet> tweets;

        //pass in the context and list of tweets
        public TweetsAdapter(Context context, List<Tweet> tweets) {
            this.context = context;
            this.tweets = tweets;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // get data at position
            Tweet tweet = tweets.get(position);
            // bind the tweet with the view holder
            holder.bind(tweet);
        }

        @Override
        public int getItemCount() {
            return tweets.size();
        }
        // pass in the context and list tweets

    // for ech row, inflate the layout

    // bind values based on the positions of the element

    // define a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;

        public ViewHolder(@Nonnull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);

        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
           Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
        }
    }
}
