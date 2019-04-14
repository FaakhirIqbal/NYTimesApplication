package com.fakhar.NYTimeAssignApp.controller;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fakhar.NYTimeAssignApp.BaseApplication;
import com.fakhar.NYTimeAssignApp.MainActivity;
import com.fakhar.NYTimeAssignApp.R;
import com.fakhar.NYTimeAssignApp.adapter.NewsAdapter;
import com.fakhar.NYTimeAssignApp.communication.NetworkError;
import com.fakhar.NYTimeAssignApp.communication.Service;
import com.fakhar.NYTimeAssignApp.customView.NYTimesDialog;
import com.fakhar.NYTimeAssignApp.model.ServiceResponse;
import javax.inject.Inject;


/**
 * First Screen Fragment that show the NewsArticle Listing
 * NewsArticleFragment is being injecting from ApplicationComponent.java class
 * */

public class NewsArticleFragment extends Fragment {

    @Inject
    Service service;
    private NYTimesDialog newYorkTimesProgressDialog;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private BaseApplication baseApplication;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* injecting dependency */
        baseApplication = (BaseApplication) getActivity().getApplication();
        (baseApplication).getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_article_recycler_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        newYorkTimesProgressDialog = new NYTimesDialog(getActivity());
        newYorkTimesProgressDialog.showDialog();

        service.getNYTimesDataSet(new Service.ResponseCallback<ServiceResponse>() {
            @Override
            public void onSuccess(ServiceResponse response) {
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                //recyclerView.setHasFixedSize(true);
                mAdapter = new NewsAdapter(response, (MainActivity) getActivity(), getFragmentManager());
                recyclerView.setAdapter(mAdapter);
                newYorkTimesProgressDialog.dismissDialog();
            }

            @Override
            public void onError(NetworkError networkError) {
                newYorkTimesProgressDialog.dismiss();
                Toast.makeText(getActivity(), "Network error has occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
