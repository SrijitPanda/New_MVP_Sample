package com.wiprotest.srijitpanda.project.View;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wiprotest.srijitpanda.project.Model.RowDataModel;
import com.wiprotest.srijitpanda.project.Presenter.Contract;
import com.wiprotest.srijitpanda.project.R;
import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

import dagger.android.DaggerActivity;


public class ViewActivity extends DaggerActivity implements Contract.ViewContract {
    private FeedAdapterList rvFeedAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Inject
    Contract.PresenterContract presenter;
    private ArrayList<RowDataModel> listOfItems;
    @BindView(R.id.rv_list_feed_items) RecyclerView rvFeedView;
    @BindView(R.id.sw_refresh) SwipeRefreshLayout swRefreshLayout;


    /**
     * <h2>onCreate</h2>
     * <p>The oncreate() lifecycle of ViewActivity is called</p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);
        intialiseData();
        presenter.makeServiceCall();
    }


    /**
     * <h2>intialiseData</h2>
     * <p>All the variables are intialised in this method</p>
     * <p>in this method layout manager is set for recyclerview</p>
     * <p>the size of recyclerview is fixed size and orientation is bydefault vertical</p>
     */
    private void intialiseData(){

        listOfItems= new ArrayList<RowDataModel>();
        rvFeedView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvFeedView.setLayoutManager(mLayoutManager);
        rvFeedAdapter = new FeedAdapterList(listOfItems);
        rvFeedView.setAdapter(rvFeedAdapter);

        swRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        presenter.makeServiceCall();
                    }
                }
        );
    }

    /**
     * <h2>updateUI</h2>
     * <p>This method is used to update the view of list that we get from response on api call</p>
     * <p>and notify the adapter</p>
     * @param ListDataItems it contains the array's of RowDataModel objects data.
     */
    @Override
    public void updateUI(ArrayList<RowDataModel> ListDataItems) {
        listOfItems.clear();
        listOfItems.addAll(ListDataItems);
        rvFeedAdapter.notifyDataSetChanged();
    }


    /**
     * <h2>errorMessage</h2>
     * <p>If the api call fails it throws error here
     * error is handled and an toast message is shown</p>
     */
    @Override
    public void errorMessage() {
        Toast.makeText(this,getResources().getString(R.string.error),Toast.LENGTH_LONG).show();
    }

}
