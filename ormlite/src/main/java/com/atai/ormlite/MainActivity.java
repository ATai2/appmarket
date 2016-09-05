package com.atai.ormlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.litesuits.orm.LiteOrm;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LiteOrm liteOrm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (liteOrm ==null){
//            liteOrm= LiteOrm.newCascadeInstance(MainActivity.this,"stu.db");
//        }
//        Students std=new Students(1,"tom","c1");
//        Students std2=new Students(2,"t2om","c1");
//        Students std3=new Students(3,"to3m","c1");
//        Students std4=new Students(4,"tom4","c1");
//        Students std5=new Students(5,"tom5","c1");
//
//        liteOrm.save(std);

        List<AppUtils.AppInfo> allAppsInfo = AppUtils.getAllAppsInfo(this);
        AppUtils.openAppByPackageName(this,allAppsInfo.get(1).getPackageName());

    }
}
