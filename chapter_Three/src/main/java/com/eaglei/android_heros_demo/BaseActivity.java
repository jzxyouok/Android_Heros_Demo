package com.eaglei.android_heros_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    private List<String> mList = new ArrayList<>();
    ListView mListview;
    BaseListViewAdapter mAdapter;
    private String [] title = new String[]{"第三章","第四章","第五章","第六章","第七章","第八章","第九章","第十一章","第十二章","第十三章"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initData();
        initView();
    }

    private void initView() {
        mListview = (ListView) findViewById(R.id.listview);
        mAdapter = new BaseListViewAdapter(mList,BaseActivity.this);
        mListview.setAdapter(mAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toNextActivity(position);
            }
        });
    }

    private void toNextActivity(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(BaseActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(BaseActivity.this,SmoothListviewActi.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(BaseActivity.this,ScrollActi.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(BaseActivity.this , Primary_ColorActi.class);
                startActivity(intent);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;

        }
    }

    private void initData() {
        for (String a :title){
            mList.add(a);
        }

    }
}
