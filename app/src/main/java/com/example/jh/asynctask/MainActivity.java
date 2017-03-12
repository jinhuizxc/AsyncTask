package com.example.jh.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 本demo测试AsyncTask
 */
public class MainActivity extends AppCompatActivity {

    private ImageView mImage ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = (ImageView)findViewById(R.id.imageView);
        //新建一个异步任务，开始加载网络图片
        new ImageAsynTask(mImage , "http://p4.so.qhimg.com/t01aade72dccf26cffe.jpg").execute();
    }
}
