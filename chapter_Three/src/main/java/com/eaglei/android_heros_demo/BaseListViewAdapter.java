package com.eaglei.android_heros_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eagle on 2016/6/16.
 */
public class BaseListViewAdapter extends BaseAdapter{

    private List<String> mList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public BaseListViewAdapter(List<String> mList, Context context) {
        this.mList = mList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null){
            mHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_baselistview,parent,false);
            mHolder.findView(convertView);
            convertView.setTag(mHolder);
        }else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mHolder.textView.setText(mList.get(position));
        return convertView;
    }
    class ViewHolder{
        private TextView textView;
        void findView(View view){
            textView = (TextView) view.findViewById(R.id.title_baselistview);
        }
    }
}
