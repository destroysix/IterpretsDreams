package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Timer timer=new Timer();
        final TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this,MenuActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        };
        timer.schedule(timerTask,2000);
    }
}
