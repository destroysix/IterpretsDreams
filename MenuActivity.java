package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gdpt.iterpretsdreams.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_search;
    private GridView mGV;
    private List<product> list;
    private AutoCompleteTextView actv_seach;
    ImageView iv_user;
    Button btn_history;
    ActivityMenuBinding binding;
    private MyGridview mygv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        iv_search = findViewById(R.id.iv_search);
        iv_search.setOnClickListener(this);
        iv_user = findViewById(R.id.iv_user);
        btn_history = findViewById(R.id.btn_history);
        mygv = (MyGridview) findViewById(R.id.ggggvvvv);
        initform();
        Search();
        touser();
        toHistory();
        GetInfo();


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

    ArrayAdapter arrayAdapter ;
    private void Search() {
        actv_seach = findViewById(R.id.actv_seach);

        //适配器
        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, Okhttpuntil.dates);
        //给控件设置适配器
        actv_seach.setAdapter(arrayAdapter);


        actv_seach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this, searchActivity.class);
                intent.putExtra("qqqq",Okhttpuntil.dates.get(position));
                startActivity(intent);
            }
        });
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
                Intent intent=new Intent(MenuActivity.this,Activity_xinzuo.class);
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("img",list.get(position).getIdlogo());
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                    Okhttpuntil.dates.add(actv_seach.getText() + "");

                    Intent intent = new Intent(this, searchActivity.class);
                    intent.putExtra("qqqq",actv_seach.getText()+"");
                    startActivity(intent);

                break;
        }
    }

    @Override
    protected void onResume() {
       try{
           //适配器
           arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, Okhttpuntil.dates);
           //给控件设置适配器
           actv_seach.setAdapter(arrayAdapter);
       }catch (Exception e){

       }
        super.onResume();
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

    /*网络请求获取列表*/
    public void GetInfo() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MenListBean menListBean = Okhttpuntil.synGetRequesr("http://v.juhe.cn/dream/category?key=c45a4c712fa4f5aac2571df29fe8f47f", MenListBean.class);
                    if (menListBean != null) {
                        List<MenListBean.ResultBean> result = menListBean.getResult();
                        ActivityMainItemAdapter<MenListBean.ResultBean> adapter = new ActivityMainItemAdapter(result, MenuActivity.this, R.layout.grid_item1, BR.men);
                        binding.setAdapters1(adapter);

                    adapter.setSuccessClick(new SuccessClick<MenListBean.ResultBean>() {
                        @Override
                        public void ResultBean(MenListBean.ResultBean resultBean) {
                            Intent intent=new Intent(MenuActivity.this,searchActivity.class);
                            intent.putExtra("id",resultBean.getFid());
                            startActivity(intent);
                        }
                    });

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
