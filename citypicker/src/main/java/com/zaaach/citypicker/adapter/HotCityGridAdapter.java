package com.zaaach.citypicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zaaach.citypicker.R;
import com.zaaach.citypicker.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * author zaaach on 2016/1/26.
 */
public class HotCityGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<City> mCities;

    public HotCityGridAdapter(Context context) {
        this.mContext = context;
        mCities = new ArrayList<>();
        mCities.add(new City("北京市","北京","B"));
        mCities.add(new City("上海市","上海","S"));
        mCities.add(new City("广东省","广州","G"));
        mCities.add(new City("广东省","深圳","S"));
        mCities.add(new City("浙江省","杭州","H"));
        mCities.add(new City("江苏省","南京","N"));
        mCities.add(new City("天津","天津","T"));
        mCities.add(new City("湖北省","武汉","W"));
        mCities.add(new City("重庆","重庆","C"));
    }

    @Override
    public int getCount() {
        return mCities == null ? 0 : mCities.size();
    }

    @Override
    public City getItem(int position) {
        return mCities == null ? null : mCities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        HotCityViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.cp_item_hot_city_gridview, parent, false);
            holder = new HotCityViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tv_hot_city_name);
            view.setTag(holder);
        }else{
            holder = (HotCityViewHolder) view.getTag();
        }
        holder.name.setText(mCities.get(position).getName());
        return view;
    }

    public static class HotCityViewHolder{
        TextView name;
    }
}
