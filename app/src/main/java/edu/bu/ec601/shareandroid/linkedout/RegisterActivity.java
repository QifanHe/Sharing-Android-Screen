package edu.bu.ec601.shareandroid.linkedout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bu.ec601.shareandroid.bean.UserInfo;
import com.bu.ec601.shareandroid.db.UserInfoManager;
import com.bu.ec601.shareandroid.utils.utils;

import java.util.List;


/**
 * Created by Administrator on 2016/11/20.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btn_reg;
    public ImageView btn_exit;
    public EditText et_phone,et_pwd,et_qr_pwd,et_username,et_mail;
    public String userName,phone,pwd,email,qr_pwd;
    public UserInfoManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.register);
        InitView();
        manager = new UserInfoManager(RegisterActivity.this);
    }


    private void InitView() {
        et_username = (EditText) findViewById(R.id.et_username);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(this);
        btn_exit = (ImageView) findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(this);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_qr_pwd = (EditText) findViewById(R.id.et_qr_pwd);
        et_mail = (EditText) findViewById(R.id.et_mail);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_reg:
                userName = et_username.getText().toString().trim();
                pwd = et_pwd.getText().toString().trim();
                phone = et_phone.getText().toString().trim();
                email = et_mail.getText().toString().trim();
                qr_pwd = et_qr_pwd.getText().toString().trim();
                if (userName.length()>0&&!userName.equals("")){
                   if(pwd.length()>0&&!pwd.equals("")){
                        if(phone.length()>0&&!phone.equals("")){
                          if (email.length()>0&&!email.equals("")){
                              if (pwd.equals(qr_pwd)){
                                  if(utils.isPhoneNumberValid(phone)){
                                      if (utils.emailFormat(email)){
                                          List<UserInfo> userInfos = manager.queryById(userName);
                                          if(userInfos.size()<=0) {
                                              manager.add(userName, pwd, phone, email);
                                              Toast.makeText(RegisterActivity.this,"login was successful!",Toast.LENGTH_LONG).show();
                                              RegisterActivity.this.finish();
                                          }else{
                                              Toast.makeText(RegisterActivity.this,"The user is registered!",Toast.LENGTH_LONG).show();
                                          }

                                      }else{
                                          Toast.makeText(RegisterActivity.this,"Mailbox format error!",Toast.LENGTH_LONG).show();
                                      }
                                  }else{
                                      Toast.makeText(RegisterActivity.this,
                                              "Cell phone number format error!",Toast.LENGTH_LONG).show();
                                  }
                              }else {
                                  Toast.makeText(RegisterActivity.this,"Two input passwords are not consistent!",Toast.LENGTH_LONG).show();
                              }
                          }else {
                              Toast.makeText(RegisterActivity.this,"Mailbox cannot be empty!",Toast.LENGTH_LONG).show();
                          }
                        }else {
                            Toast.makeText(RegisterActivity.this,"Phone number can not be empty!",Toast.LENGTH_LONG).show();
                        }
                   }else{
                       Toast.makeText(RegisterActivity.this,"Password can not be empty!",Toast.LENGTH_LONG).show();
                   }
                }else{
                    Toast.makeText(RegisterActivity.this,"User name cannot be empty!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_exit:
                RegisterActivity.this.finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RegisterActivity.this.finish();
    }
}
