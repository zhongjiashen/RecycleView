package com.recycleview;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by 1363655717 on 2017-07-20.
 */

public class MyAdapter extends RecyclerView.Adapter{
    Activity activity;
    private final int HEAD = 0;
    private final int WORD = 1;
    public MyAdapter(Activity activity) {
        this.activity=activity;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0||position==5||position==10)
            return HEAD;
        else
            return WORD;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        RecyclerView.ViewHolder holder;
        if (viewType == HEAD) {
            v = LayoutInflater.from(activity).inflate(R.layout.item_head, parent, false);
            holder = new HeadViewHolder(v);
        } else {
            v = LayoutInflater.from(activity).inflate(R.layout.item_context, parent, false);
            holder = new ViewHolder(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
    static class HeadViewHolder extends RecyclerView.ViewHolder {

        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    int i=0;
                    switch (type){
                        case HEAD:
                            i=4;
                            break;
                        case WORD:
                            i=1;
                            break;
                    }
                    return i;
                }
            });
        }
    }
}
