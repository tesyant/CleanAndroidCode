package com.lab.tesyant.androidcleancode.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lab.tesyant.androidcleancode.R;
import com.lab.tesyant.androidcleancode.models.CityListData;

import java.util.List;

/**
 * Created by tesyant on 11/14/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private final OnItemClickListener listener;
    private List<CityListData> datas;
    private Context context;

    public HomeAdapter(Context context, List<CityListData> datas, OnItemClickListener listener) {
        this.datas = datas;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.click(datas.get(position), listener);
        holder.tvCity.setText(datas.get(position).getName());
        holder.tvDesc.setText(datas.get(position).getDescription());

        String images = datas.get(position).getBackground();

        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.background);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity, tvDesc;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = (TextView) itemView.findViewById(R.id.city);
            tvDesc = (TextView) itemView.findViewById(R.id.hotel);
            background = (ImageView) itemView.findViewById(R.id.image);
        }

        public void click (final CityListData cityListData, final OnItemClickListener listener) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(cityListData);
                    }
                });
        }
    }

    public interface OnItemClickListener {
        void onClick(CityListData Item);
    }
}
