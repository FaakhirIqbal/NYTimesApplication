package com.fakhar.NYTimeAssignApp;
//TODO need to add test cases using powermock or Espresso test recorder

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fakhar.NYTimeAssignApp.communication.ApplicationComponent;
import com.fakhar.NYTimeAssignApp.communication.NetworkService;
import com.fakhar.NYTimeAssignApp.communication.Service;
import com.fakhar.NYTimeAssignApp.controller.NewsArticleFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doReturn;

@RunWith(PowerMockRunner.class)
@PrepareForTest({NewsArticleFragment.class, MainActivity.class,
        Service.class, BaseApplication.class})

public class NewsArticleFragmentTest {


    @Mock
    private MainActivity ntyMainActivity;

    @Mock
    private BaseApplication nytBaseApplication;

    @Mock
    private NewsArticleFragment nytNewsArticleFragment;

    @Mock
    private Service nytService;

    @Mock
    private NetworkService nytNetworkService;

    @Mock
    private ViewGroup nytViewGroup;

    @Mock
    private Bundle mockBundle;

    @Mock
    private View nytInflatedView;

    @Mock
    private ApplicationComponent applicationComponent;

    @Mock
    private LayoutInflater nytLayoutInflater;


    @Before
    public void setUp() throws Exception{

        MockitoAnnotations.initMocks(this);
        ntyMainActivity = spy(new MainActivity());
        nytNewsArticleFragment = spy(new NewsArticleFragment());
        nytService = new Service(nytNetworkService);

        doReturn(ntyMainActivity).when(nytNewsArticleFragment).getActivity();
        doReturn(nytBaseApplication).when(ntyMainActivity).getApplication();
        doReturn(applicationComponent).when(nytBaseApplication).getAppComponent();


    }

    @Test
    public void testOnCreateView() throws Exception {
        nytNewsArticleFragment.onCreateView(nytLayoutInflater, nytViewGroup, mockBundle);
        verify(nytLayoutInflater, times(1)).inflate(R.layout.news_article_recycler_view, nytViewGroup, false);
    }

    @Test
    public void testOnCreate() throws Exception {
        Whitebox.setInternalState(nytNewsArticleFragment, "BaseApplication", nytBaseApplication);
        nytNewsArticleFragment.onCreate(mockBundle);
    }

}
