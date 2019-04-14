package com.fakhar.NYTimeAssignApp.adapter;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.fakhar.NYTimeAssignApp.MainActivity;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.fakhar.NYTimeAssignApp.R;
import com.fakhar.NYTimeAssignApp.controller.NewsArticleDetailFragment;
import com.fakhar.NYTimeAssignApp.model.ServiceResponse;
import com.fakhar.NYTimeAssignApp.utility.Constant;
import com.fakhar.NYTimeAssignApp.utility.FragmentHelper;


/**
 NewsAdapter adapter class to render the data in RecyclerView list
 The RecyclerView (NewsArticleFragment.java) adapter
 overrides methods like onCreateViewHolder() method which inflates news_article_row.xml
 & onBindViewHolder() method the appropriate ServiceResponse data (newsTitle, byLine, newsSource, newsPublishDate & newsImageIcon)
 set to each row.
 * */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ServiceResponse response;
    private FragmentManager fragmentManager;
    private MainActivity mainActivity;

    public NewsAdapter(ServiceResponse response,
                       MainActivity mainActivity,
                       FragmentManager fragmentManager) {
        this.response = response;
        this.fragmentManager = fragmentManager;
        this.mainActivity = mainActivity;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view =
                inflater.inflate(R.layout.news_article_row, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(view);

        mViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsArticleDetailFragment newsArticleDetailFrg = new NewsArticleDetailFragment();
                Bundle bundle = new Bundle();
                int position = mViewHolder.getAdapterPosition();
                bundle.putString(Constant.SERVICE_RESPONSE_URL, response.getNewsArticleResults().get(position).getUrl());
                newsArticleDetailFrg.setArguments(bundle);
                FragmentHelper.addAndInitFragmentWithBackStack(newsArticleDetailFrg, R.id.fragment_content_container, fragmentManager);
            }
        });

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        final String newsTitle = response.getNewsArticleResults().get(position).getTitle();
        final String byLine = response.getNewsArticleResults().get(position).getByline();
        String newsSource = response.getNewsArticleResults().get(position).getSource();
        String newsPublishDate = response.getNewsArticleResults().get(position).getPublished_date();
        viewHolder.newsTitle.setText(newsTitle);
        viewHolder.newsByLine.setText(byLine);
        viewHolder.newsSource.setText(newsSource);
        viewHolder.newsPublishDate.setText(newsPublishDate);
        //setting Image Icon in RV
        articleImageIcon(viewHolder, position);
    }

    private void articleImageIcon(final ViewHolder viewHolder, int position) {
        Glide.with(mainActivity).load(response.getNewsArticleResults().get(position)
                .getMedia().get(0).getMediaMetaData().get(0)
                .getUrl()).asBitmap().centerCrop()
                .into(new BitmapImageViewTarget(viewHolder.newsImageIcon) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        //used Glide library in gradle for Image cropping round
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mainActivity.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        viewHolder.newsImageIcon.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return response.getNewsArticleResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView newsTitle;
        public AppCompatTextView newsPublishDate;
        public AppCompatImageView newsImageIcon;
        public AppCompatTextView newsSource;
        public AppCompatTextView newsByLine;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            newsTitle = v.findViewById(R.id.title);
            newsImageIcon = v.findViewById(R.id.img_article_icon);
            newsPublishDate = v.findViewById(R.id.date);
            newsSource =  v.findViewById(R.id.source);
            newsByLine =  v.findViewById(R.id.byLine);
        }
    }

}
