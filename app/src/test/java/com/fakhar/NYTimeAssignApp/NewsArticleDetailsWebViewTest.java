package com.fakhar.NYTimeAssignApp;

import android.webkit.WebView;
import com.fakhar.NYTimeAssignApp.communication.NetworkService;
import com.fakhar.NYTimeAssignApp.controller.NewsArticleDetailFragment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BaseApplication.class, NewsArticleDetailFragment.class})
public class NewsArticleDetailsWebViewTest {

    
    @Mock
    private WebView mockWebView;
    @Mock
    private BaseApplication mockBaseApplication;
    @Mock
    private NetworkService mockNetworkService;

    @Before
    public void setUp() throws Exception {
        mockWebView = new WebView(mockBaseApplication.getApplicationContext());
    }


    @Test
    public void loadedUrlTest() {
        mockWebView.loadUrl("https://www.nytimes.com/2019/04/06/health/drug-resistant-candida-auris.html");
    }
    
    
}


