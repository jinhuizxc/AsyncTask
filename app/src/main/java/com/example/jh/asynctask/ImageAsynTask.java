package com.example.jh.asynctask;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 作者：jinhui on 2017/3/12
 * 邮箱：1004260403@qq.com
 *
 * 自定义ImageAsynTask类，继承自异步任务类
 */

public class ImageAsynTask extends AsyncTask<Void ,Void ,Drawable> {
    private ImageView iv ;       //用来显示图片
    private String imageUrl ;   //记录网络图片地址

    //根据imageView对象和网络图片网址的，构造函数
    public ImageAsynTask(ImageView i , String url){
        iv  = i ;
        imageUrl = url ;
    }
    //后台执行耗时的操作
    @Override
    protected Drawable doInBackground(Void... voids) {
        return loadImages(imageUrl);    //自定义加载图片的方法
    }

    //执行后台操作完毕后自动回调此方法
    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        if(drawable != null){       //判断图片加载是否成功
            iv.setImageDrawable(drawable);
        }else {
            iv.setImageResource(R.drawable.fail);
        }
    }
    //执行后台操作前的回调函数
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //根据网址加载图片
    private Drawable loadImages(String url) {
        try{
            //生成URL对象
            URL mUrl = new URL(url);
            //得到inputStream
            InputStream inputStream = (InputStream)mUrl.openStream();
            return Drawable.createFromStream(inputStream , "test"); //生成并返回图片

        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
