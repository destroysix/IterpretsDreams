package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
EditText usedname,usedpassword;
Button btn_sure_login,btn_sure_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        usedname=findViewById(R.id.usedname);
        usedpassword=findViewById(R.id.usedpassword);
        btn_sure_login=findViewById(R.id.btn_sure_login);
        btn_sure_regist=findViewById(R.id.btn_sure_regist);
        btn_sure_login.setOnClickListener(this);
        btn_sure_regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sure_login:
                submit();
                break;
            case R.id.btn_sure_regist:
                startActivity(new Intent(this,RegistActivity.class));
                break;
        }
    }

    private void submit() {
        String name=usedname.getText().toString().trim();
        String psw=usedpassword.getText().toString().trim();
        String md5=MD5Utils.md5(psw);
        String spPsw=readPsw(name);
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"请输入账号/邮箱",Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(psw)){
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }else if (md5.equals(spPsw)){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            saveLoginStatus(true,name);
            startActivity(new Intent(loginActivity.this, MenuActivity.class));
            loginActivity.this.finish();
            return;
        }else if ((!TextUtils.isEmpty(spPsw)&& ! md5.equals(spPsw))){
            Toast.makeText(this, "输入的密码和用户名不一致！", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Toast.makeText(this, "此用户不存在！", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLoginStatus(boolean status, String name) {
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",status);
        editor.putString("loginUserNmae",name);
        editor.commit();
    }

    private String readPsw(String name) {
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        return sp.getString(name,"");
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data !=null){
            String name=data.getStringExtra("userName");
            if (!TextUtils.isEmpty(name)){
                usedname.setText(name);
                usedname.setSelection(name.length());
            }
        }
    }
}
