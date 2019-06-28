package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnlogin,btnregist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin=findViewById(R.id.login);
        btnregist=findViewById(R.id.regist);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,loginActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegistActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void dl(View view) {
        Intent i=new Intent(MainActivity.this,loginActivity.class);
        finish();

    }
}
