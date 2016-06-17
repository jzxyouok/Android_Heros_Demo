package com.eaglei.android_heros_demo;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import chapter_four.ChatItemListViewBean;
import chapter_four.ChatViewAdapter;

public class ChatItemListActTest extends AppCompatActivity {

    private List<ChatItemListViewBean> mData = new ArrayList<>();
    private ListView mListView;
    private ChatViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_item_list_act_test);
        initData();
        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.chat_listview);
        mAdapter = new ChatViewAdapter(mData , ChatItemListActTest.this);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {
        ChatItemListViewBean mBeanIn = new ChatItemListViewBean();
        mBeanIn.setType(0);
        mBeanIn.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.in_icon));
        mBeanIn.setText("How Are You ?");
        mData.add(mBeanIn);

        ChatItemListViewBean mBeanOut = new ChatItemListViewBean();
        mBeanOut.setType(1);
        mBeanOut.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        mBeanOut.setText("I am fine.");
        mData.add(mBeanOut);
    }
}
