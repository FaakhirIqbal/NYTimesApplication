package com.fakhar.NYTimeAssignApp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BaseApplication.class, NewsArticleFragment.class, MainActivity.class,
        Service.class, NetworkService.class})

public class NewsArticleFragmentTest {

    @Mock
    private LayoutInflater mockLayoutInflater;

    @Mock
    private LayoutInflater mockLayoutInflaterProdRate;

    @Mock
    private ViewGroup mockViewGroup;

    @Mock
    private View mockInflatedView;

    @Mock
    private View mockInflatedViewProdRate;

    @Mock
    private MainActivity spyMainActivity;

    @Mock
    private BaseApplication mockBaseApplication;

    @Mock
    private NewsArticleFragment spyNewsArticleFragment;

    @Mock
    private RecyclerView recyclerView;

    @Mock
    private Bundle mockBundle;

    @Mock
    private FragmentManager mockFragmentManager;

    @Mock
    private FragmentTransaction mockFragmentTransaction;

    @Mock
    private Service spyService;

    @Mock
    private NetworkService networkService;


    @Mock
    private ApplicationComponent applicationComponent;



    @Before
    public void setUp() throws Exception{

/*spy method is used to wrap the real object*/

        MockitoAnnotations.initMocks(this);
        spyMainActivity = spy(new MainActivity());
        spyNewsArticleFragment = spy(new NewsArticleFragment());
        spyService = new Service(networkService);
/* You have to use doReturn() for stubbing */
        Mockito.doReturn(spyMainActivity).when(spyNewsArticleFragment).getActivity();
        Mockito.doReturn(mockBaseApplication).when(spyMainActivity).getApplication();
        Mockito.doReturn(applicationComponent).when(mockBaseApplication).getAppComponent();
        Mockito.doReturn(mockLayoutInflaterProdRate).when(spyMainActivity).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Mockito.doReturn(mockInflatedView).when(mockLayoutInflater).inflate(anyInt(), any(ViewGroup.class), anyBoolean());
        Mockito.doReturn(mockInflatedViewProdRate).when(mockLayoutInflaterProdRate).inflate(anyInt(), any(ViewGroup.class));
        Mockito.doReturn(recyclerView).when(mockInflatedView).findViewById(R.id.recyclerView);
        Mockito.doReturn(mockFragmentManager).when(spyMainActivity).getFragmentManager();
        Mockito.doReturn(mockFragmentTransaction).when(mockFragmentManager).beginTransaction();
        Mockito.doReturn(mockFragmentTransaction).when(mockFragmentTransaction).add(anyInt(), any(Fragment.class), anyString());
        Mockito.doReturn(mockFragmentTransaction).when(mockFragmentTransaction).addToBackStack(anyString());
        Mockito.doReturn(0).when(mockFragmentTransaction).commit();
    }

    @Test
    public void testOnCreateView() throws Exception {
        spyNewsArticleFragment.onCreateView(mockLayoutInflater, mockViewGroup, mockBundle);
        verify(mockLayoutInflater, times(1)).inflate(R.layout.news_article_recycler_view, mockViewGroup, false);
    }

    @Test
    public void testOnCreate() throws Exception {
        Whitebox.setInternalState(spyNewsArticleFragment, "baseApplication", mockBaseApplication);
        spyNewsArticleFragment.onCreate(mockBundle);
    }

}
