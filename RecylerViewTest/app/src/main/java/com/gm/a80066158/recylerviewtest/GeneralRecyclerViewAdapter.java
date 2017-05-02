package com.gm.a80066158.recylerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 80066158 on 2017-05-02.
 */

public class GeneralRecyclerViewAdapter extends RecyclerView.Adapter<GeneralRecyclerViewAdapter.ItemViewHold> {

    private Context context = null;
    private LayoutInflater layoutInflater = null;
    private List<GeneralRecyclerViewItemData> dataList = null;
    private View.OnClickListener onClickListener = null;

    public GeneralRecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = new ArrayList<>();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setDataList(List<GeneralRecyclerViewItemData> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.general_recycler_view_item_layout, parent, false);
        return new ItemViewHold(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHold holder, int position) {
        GeneralRecyclerViewItemData itemData = dataList.get(position);
        holder.icon.setImageResource(itemData.getDefaultIconId());
        onSetIcon(holder.icon, position);
        holder.title.setText(itemData.getTitle());
        holder.subTitle.setText(itemData.getSubTitle());

        holder.view.setTag(position);
        holder.view.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        if (null == dataList) {
            return 0;
        }
        return dataList.size();
    }

    protected void onSetIcon(ImageView icon, int position) {

    }

    public static class ItemViewHold extends RecyclerView.ViewHolder {
        private View view = null;
        private ImageView icon = null;
        private TextView title = null;
        private TextView subTitle = null;

        public ItemViewHold(View itemView) {
            super(itemView);
            view = itemView;
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
            subTitle = (TextView) itemView.findViewById(R.id.subtitle);
        }
    }
}
