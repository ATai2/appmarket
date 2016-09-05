package com.atai.ormlite;

import com.litesuits.orm.LiteOrm;

import org.junit.Test;

/**
 * 文 件 名: MainActivityTest
 * 创 建 人: Administrator
 * 创建日期: 2016/9/5 10:02
 * 文件描述：
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */
public class MainActivityTest {

    private LiteOrm liteOrm;

    @Test
    public void addStudents(){
        if (liteOrm ==null){
//            liteOrm=LiteOrm.newCascadeInstance(MainActivity.this)
        }
        Students std=new Students(1,"tom","c1");
        Students std2=new Students(2,"t2om","c1");
        Students std3=new Students(3,"to3m","c1");
        Students std4=new Students(4,"tom4","c1");
        Students std5=new Students(5,"tom5","c1");

    }
}