package com.wiprotest.srijitpanda.project.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wiprotest.srijitpanda.project.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_header)
    TextView tvHeader;
    @BindView(R.id.tv_desc)
    TextView tvDescription;
    @BindView(R.id.iv_images)
    ImageView ivProfile;

    /**
     * <h2>FeedViewHolder</h2>
     * <p>provide view items inside recyclerview items for the list of data</p>
     * @param itemView  is the parent view of the items views of recyclerview.
     */
    public FeedViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
