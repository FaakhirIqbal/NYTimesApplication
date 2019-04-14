package com.fakhar.NYTimeAssignApp;



import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.test.mock.MockContext;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.fakhar.NYTimeAssignApp.adapter.NewsAdapter;
import com.fakhar.NYTimeAssignApp.controller.NewsArticleFragment;
import com.fakhar.NYTimeAssignApp.model.ServiceResponse;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest({LayoutInflater.class, NewsAdapter.class})
public class RecycleViewLoadTest {

    private static final String ARTICLE_TITLE_TEST = "This is News Article Title";
    //Example of Test Case comparing String values one in strings.xml
    // wanted to access Context in our JUnit test classes
    @Mock
    Context mMockContext;
    @Mock
    LayoutInflater mockInflater;
    @Mock
    View mockView;
    @Mock
    ViewGroup mockParent;
    @Mock
    private int dummyTestId;
    @Mock
    private NewsAdapter adapter;
    @Mock
    private ServiceResponse mockResponse;
    @Mock
    private FragmentManager mockFragmentManager;
    @Mock
    private MainActivity mockMainActivity;



    @Before
    public void setUp() throws Exception {

         /** mock the static LayoutInflater in "LayoutInflater.from()"
         so that we can ask it to return a mockInflater that we moked above
          */
          mockStatic(LayoutInflater.class);
          adapter = new NewsAdapter(mockResponse, mockMainActivity, mockFragmentManager);
    }



    @Test
    public void readFromNewsAdapter() throws Exception{
        //Returns the ARTICLE_TITLE_TEST when getString(R.string.rv_test_text) is called
        when(mMockContext.getString(R.string.rv_test_text)).thenReturn(ARTICLE_TITLE_TEST);
        //Creates an object of the NewsAdapter with the mock context
        NewsAdapter objectUnderTest = new NewsAdapter(mMockContext);
        //Stores the return value of getNewsArticleTitle() in result
        String result = objectUnderTest.getNewsArticleTitle();
        assertThat(result, is(ARTICLE_TITLE_TEST));

    }

    @Test
    public void onCreateViewHolderReturnValidViewHolder() throws Exception {

        //creating an mockContext
        mMockContext = new MockContext();
        // mock the context that comes from parent ViewGroup
        when(mockParent.getContext()).thenReturn(mMockContext);
        // mock the inflater that is returned by LayoutInflater.from()
        when(LayoutInflater.from(mMockContext)).thenReturn(mockInflater);
        //  anyInt() as a resource id to care of R.layout.news_article_row in onCreateViewHolder()
        when(mockInflater.inflate(anyInt(), eq(mockParent), eq(false))).thenReturn(mockView);
        // call onCreateViewHolder() to
        NewsAdapter.ViewHolder viewHolder = adapter.onCreateViewHolder(mockParent, dummyTestId);
        assertNotNull(viewHolder);

    }




//
//    @Mock
//    public RecyclerView mRecyclerView;
//    @Mock
//    public LinearLayoutManager mLayoutManager;
//    @Mock
//    public View.OnTouchListener mOnTouchListener;
//    @Mock
//    public AdapterView.OnItemClickListener mOnItemClickListener;
//    @Mock
//    public AdapterView.OnItemLongClickListener mOnItemLongClickListener;
//    @Mock
//    public View mChildView;
//    @Mock
//    public Object mItem;
//
//    private Activity mActivity;
//
//    private NewsArticleFragment mRecyclerViewFragment;
//
//
//    @Before
//    public void setup() throws Exception{
//
//        /*spy method is used to wrap the real object*/
//
//        MockitoAnnotations.initMocks(this);
//        mActivity =  spy(new NewsArticleFragment().getActivity());
//
//        Mockito.when(mRecyclerView.getLayoutManager()).thenReturn(mLayoutManager);
//       // Mockito.when(mRecyclerView.getLayoutManager()).thenReturn(mLayoutManager);
//        Mockito.when(mRecyclerView.getContext()).thenReturn(mActivity);
//      //  Mockito.mRecyclerViewProxy = new RecyclerViewProxy(mRecyclerView);
//    }
//
//    @Test
//    public void testGetView() {
//        assertThat(mRecyclerViewFragment.getView()).isEqualTo(mRecyclerView);
//    }
//
//    @Test
//    public void testAddScrollListener() {
//        RecyclerView.OnScrollListener onScrollListener = mock(RecyclerView.OnScrollListener.class);
//        mRecyclerViewProxy.setOnScrollListener(onScrollListener);
//
//        verify(mRecyclerView).addOnScrollListener(mOnScrollListenerCaptor.capture());
//        mOnScrollListenerCaptor.getValue().onScrolled(mRecyclerView, 0, 20);
//        verify(onScrollListener)
//                .onScroll(same(mRecyclerViewProxy), anyInt(), anyInt(), anyInt());
//    }


}
