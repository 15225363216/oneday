package com.example.app21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class drawerActivity extends AppCompatActivity {
    private TextView mV4Text;
    private FrameLayout mV4DrawerlayoutFrame;
    private ListView mV4Listview;
    private DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initView();
    }
    private void initView(){
        mV4Text=(TextView)findViewById(R.id.v4_text);
        mV4DrawerlayoutFrame = (FrameLayout) findViewById(R.id.v4_drawerlayout_frame);
        mV4Listview = (ListView) findViewById(R.id.v4_listview);
        drawerlayout = findViewById(R.id.drawerlayout);

        setDate();
    }
    List<String> datas=new ArrayList<>();
    private void setDate(){
        datas.add("条目1");
        datas.add("条目2");
        datas.add("条目3");
        datas.add("条目4");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datas);
        mV4Listview.setAdapter(adapter);

        mV4Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = datas.get(position);
                mV4Text.setText(result);

                hideOrShow();
            }
        });
    }
    private void hideOrShow() {
        //判断当前 侧滑是不是 在左侧已打开
        if(drawerlayout.isDrawerOpen(Gravity.LEFT)){
            drawerlayout.closeDrawer(Gravity.LEFT);
        }else{
            drawerlayout.openDrawer(Gravity.LEFT);
        }
    }
}
