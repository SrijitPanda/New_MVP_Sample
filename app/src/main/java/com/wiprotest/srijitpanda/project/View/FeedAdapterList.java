package com.wiprotest.srijitpanda.project.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.wiprotest.srijitpanda.project.Model.RowDataModel;
import com.wiprotest.srijitpanda.project.R;

import java.util.ArrayList;

public class FeedAdapterList extends RecyclerView.Adapter<FeedViewHolder> {
    private ArrayList<RowDataModel> listRowItems;

    /**
     * <h2>FeedAdapterList</h2>
     * <p>It is a constructor  recyclerview adapter class which is responsible for the list of views
     * displayed on the screen</p>
     * @param listRowItems it gets the array of datas from activity.
     */
    FeedAdapterList(ArrayList<RowDataModel> listRowItems){
        this.listRowItems=listRowItems;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        View viewList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_view_items, viewGroup, false);
        return new FeedViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder feedViewHolder, int i) {

        feedViewHolder.tvHeader.setText(listRowItems.get(i).getTitle());
        feedViewHolder.tvDescription.setText(listRowItems.get(i).getDescription());
        Picasso.get().resize(50,50).centerCrop().load(listRowItems.get(i).getImageHref()).into(feedViewHolder.ivProfile);
    }

    @Override
    public int getItemCount() {
        return listRowItems.size();
    }
}
