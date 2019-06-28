package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {
EditText btn_regist_usedname,btn_regist_usedpassword,btn_regist_second_usedpassword;
Button sure_regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    private void initView() {
        btn_regist_usedname=findViewById(R.id.btn_regist_usedname);
        btn_regist_usedpassword=findViewById(R.id.btn_regist_usedpassword);
        btn_regist_second_usedpassword=findViewById(R.id.btn_regist_second_usedpassword);
        sure_regist=findViewById(R.id.sure_regist);
        sure_regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sure_regist:
                submit();
                break;
        }
    }

    private void submit() {
        String usedname=btn_regist_usedname.getText().toString().trim();
        String psw1=btn_regist_usedpassword.getText().toString().trim();
        String psw2=btn_regist_second_usedpassword.getText().toString().trim();
        if (TextUtils.isEmpty(usedname)){
            Toast.makeText(this, "请输入要注册的用户名", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(psw1)){
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(psw2)){
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }else if (!psw1.equals(psw2)){
            Toast.makeText(this,"输入两次的密码不一样",Toast.LENGTH_SHORT).show();
            return;
        }else if (isExitUsedName(usedname)){
            Toast.makeText(this, "此用户名已存在！", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            saveRegisterInfo(usedname,psw1);
            Intent data=new Intent();
            data.putExtra("userName",usedname);
            setResult(RESULT_OK,data);
            RegistActivity.this.finish();
        }
    }

    private void saveRegisterInfo(String usedname, String psw1) {
        String md5Psw=MD5Utils.md5(psw1);
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(usedname,md5Psw);
        editor.commit();
    }

    private boolean isExitUsedName(String usedname) {
        boolean has_userName=false;
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPsw=sp.getString(usedname,"");
        if (!TextUtils.isEmpty(spPsw)){
            has_userName=true;
        }
        return has_userName;
    }
}
