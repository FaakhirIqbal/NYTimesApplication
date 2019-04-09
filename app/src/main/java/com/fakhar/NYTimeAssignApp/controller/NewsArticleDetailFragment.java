package com.fakhar.NYTimeAssignApp.controller;

import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fakhar.NYTimeAssignApp.R;
import com.fakhar.NYTimeAssignApp.customView.NYTimesDialog;
import com.fakhar.NYTimeAssignApp.utility.Constant;


/*
    This Fragment only showing details of news in WebView
    services can used for fully native support in details
    e.g. Parallax effect can be added content of news under the main banner image
 */
public class NewsArticleDetailFragment extends Fragment {

    private View view;
    private WebView webView;
    private String newsUrl;
    private NYTimesDialog nytDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_article_detail_view, null);
        nytDialog = new NYTimesDialog(getActivity());
        newsUrl = getArguments().getString(Constant.SERVICE_RESPONSE_URL);
        initView(view);
        return view;
    }
    private void initView(View view) {
        webView = view.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewController());
        webView.loadUrl(newsUrl);
    }

    public class WebViewController extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            nytDialog.showDialog();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            nytDialog.dismissDialog();
            super.onPageFinished(view, url);

        }

    }
}