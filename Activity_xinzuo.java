package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.IOException;

import cn.edu.gdpt.iterpretsdreams.databinding.XinzhuoItemBinding;

public class Activity_xinzuo extends AppCompatActivity {
    XinzhuoItemBinding binding;
    private String name;
    private String[] data;
    private int positions = 0;
    private Spinner mysp;
    private int imgs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.xinzhuo_item);
        Intent intent = getIntent();
        //today,tomorrow,week,month,year
        data = new String[]{"today", "tomorrow", "week", "month", "year"};
        name = intent.getStringExtra("name");
        imgs = intent.getIntExtra("img",R.drawable.byz);
        ShowData();
        ShowData2();
        initView();

    }

    public void ShowData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    XinzhuoBean bean = Okhttpuntil.synGetRequesr("http://web.juhe.cn:8080/constellation/getAll?key=d310c3587bdf255589ea373fe782bfaf&consName=" + name + "&type=" + data[positions], XinzhuoBean.class);
                    if (bean != null) {
                        Log.i("MMMM", Okhttpuntil.converterToFirstSpell(name));
                      //  int drawable = getResources().getIdentifier(Okhttpuntil.converterToFirstSpell(name), "drawable", getPackageName());
                        //bean.setDrawimg(drawable);
                        bean.setDrawimg(imgs);
                        binding.setXinzuo(bean);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView() {
        mysp = (Spinner) findViewById(R.id.mysp);
        mysp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positions=position;
                ShowData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void ShowData2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Xinzhuoweek bean = Okhttpuntil.synGetRequesr("http://web.juhe.cn:8080/constellation/getAll?key=d310c3587bdf255589ea373fe782bfaf&consName=" + name + "&type=week", Xinzhuoweek.class);
                    if (bean != null) {
                        Log.i("MMMM", Okhttpuntil.converterToFirstSpell(name));
                        //  int drawable = getResources().getIdentifier(Okhttpuntil.converterToFirstSpell(name), "drawable", getPackageName());
                        //bean.setDrawimg(drawable);

                        binding.setWeek(bean);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
