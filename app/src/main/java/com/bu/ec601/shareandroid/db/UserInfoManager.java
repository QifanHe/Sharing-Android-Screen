package com.bu.ec601.shareandroid.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bu.ec601.shareandroid.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/7/28.
 * Add, delete, change, check
 */
public class UserInfoManager {
    public DBManager manager;
    //add
    public UserInfoManager(Context context){
        manager = new DBManager(context);
    }
    public void add(String username, String pwd, String phone, String email){
        SQLiteDatabase db = manager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("pwd", pwd);
        values.put("phone", phone);
        values.put("email", email);
        db.insert("UserInfo", null, values);
    }
    //query
    public List<UserInfo> queryById(String userName) {
        List<UserInfo> list = new ArrayList<UserInfo>();
        SQLiteDatabase db = manager.getReadableDatabase();
        String sql = "select * from UserInfo where username='" + userName+"'";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor
                    .getColumnIndex("username"));
            String pwd = cursor.getString(cursor
                    .getColumnIndex("pwd"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String email = cursor.getString(cursor
                    .getColumnIndex("email"));
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(username);
            userInfo.setPwd(pwd);
            userInfo.setPhone(phone);
            userInfo.setEmial(email);
            list.add(userInfo);
        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     *
     * @return
     * queryall
     */
    public List<UserInfo> queryById() {
        List<UserInfo> list = new ArrayList<UserInfo>();
        SQLiteDatabase db = manager.getReadableDatabase();
        String sql = "select * from UserInfo";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor
                    .getColumnIndex("username"));
            String pwd = cursor.getString(cursor
                    .getColumnIndex("pwd"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String email = cursor.getString(cursor
                    .getColumnIndex("email"));
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(username);
            userInfo.setPwd(pwd);
            userInfo.setPhone(phone);
            userInfo.setEmial(email);
            list.add(userInfo);
        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     *
     * @param userName
     * @param pwd
     * @return
     * According to the user name, password query
     */
    public List<UserInfo> queryById(String userName, String pwd) {
        List<UserInfo> list = new ArrayList<UserInfo>();
        SQLiteDatabase db = manager.getReadableDatabase();
        String sql = "select * from UserInfo where username='"+userName+"' and pwd ='"+pwd+"'";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor
                    .getColumnIndex("username"));
            String pwd1 = cursor.getString(cursor
                    .getColumnIndex("pwd"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String email = cursor.getString(cursor
                    .getColumnIndex("email"));
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(username);
            userInfo.setPwd(pwd1);
            userInfo.setPhone(phone);
            userInfo.setEmial(email);
            list.add(userInfo);
        }
        cursor.close();
        db.close();
        return list;
    }

    //delect
    public void delectById(String username) {
        SQLiteDatabase db = manager.getWritableDatabase();
        String sql = "delete from UserInfo where username = '" + username+"'";
        db.execSQL(sql, new String[] {});
        db.close();
    }
}
