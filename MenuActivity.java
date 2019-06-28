package cn.edu.gdpt.iterpretsdreams.menu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gdpt.iterpretsdreams.R;
import cn.edu.gdpt.iterpretsdreams.login.loginActivity;
import cn.edu.gdpt.iterpretsdreams.product;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private GridView mGV;
    private List<product> list;
    private AutoCompleteTextView actv_seach;
    ImageView iv_user;
    Button btn_history;
    private ImageButton iv_search;//Button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();



        iv_user = findViewById(R.id.iv_user);
        btn_history = findViewById(R.id.btn_history);
        initform();
        Search();
        touser();
        toHistory();
    }

    private void toHistory() {
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void touser() {
        iv_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, loginActivity.class);
                startActivity(intent);

            }
        });
    }

    private void Search() {
        actv_seach = findViewById(R.id.actv_seach);
        String name[] = getResources().getStringArray(R.array.name);
        //适配器
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, name);
        //给控件设置适配器
        actv_seach.setAdapter(arrayAdapter);
    }

    private void initform() {
        list = new ArrayList<product>();
        list.add(new product(R.drawable.baiyang, "白羊座"));
        list.add(new product(R.drawable.jinniu, "金牛座"));
        list.add(new product(R.drawable.shuangzi, "双子座"));
        list.add(new product(R.drawable.juxie, "巨蟹座"));
        list.add(new product(R.drawable.shizi, "狮子座"));
        list.add(new product(R.drawable.chunv, "处女座"));
        list.add(new product(R.drawable.tianping, "天秤座"));
        list.add(new product(R.drawable.tianxie, "天蝎座"));
        list.add(new product(R.drawable.sheshou, "射手座"));
        list.add(new product(R.drawable.mojie, "摩羯座"));
        list.add(new product(R.drawable.shuiping, "水瓶座"));
        list.add(new product(R.drawable.shuangyu, "双鱼座"));
        MyAdapter myAdapter = new MyAdapter();
        GridView gridView = (GridView) findViewById(R.id.mGV);
        gridView.setAdapter(myAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MenuActivity.this, "点击了第" + position + "项", Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                startActivity(new Intent(this, searchActivity.class));
                break;

        }
    }

    private void initView() {
        iv_search = (ImageButton) findViewById(R.id.iv_search);

        iv_search.setOnClickListener(this);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, null);
            ImageView imglogo = (ImageView) view.findViewById(R.id.img_logo);
            imglogo.setImageResource(list.get(position).getIdlogo());
            TextView tvname = (TextView) view.findViewById(R.id.tv_name);
            tvname.setText(list.get(position).getName());
            return view;
        }
    }
}
