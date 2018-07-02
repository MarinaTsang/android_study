package com.zmy.broadcasttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.uname)
    TextView uname;
    @BindView(R.id.upwd)
    TextView upwd;
    @BindView(R.id.uname_input)
    EditText unameInput;
    @BindView(R.id.upwd_input)
    EditText upwdInput;
    @BindView(R.id.loginBtn)
    Button loginBtn;

    private LoginActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mActivity = this;

        final String userName = unameInput.getText().toString();
        final String pwd = upwdInput.getText().toString();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟登录成功
                //1.判空处理
                //2.登录操作
                if ("hello".equals(userName) && "123456".equals(pwd)){
                    Utils.showToast(mActivity,"登录成功");
                    MainActivity.actionStartMainAc(mActivity);
                }else {
                    Utils.showToast(mActivity,"用户名或密码错误");
                }
            }
        });


    }

    public static void actionStartLoginAc(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }
}
