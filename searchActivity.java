package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class searchActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logo;
    private ImageView imageView;
    private EditText editText;
    private Button button;
    private String qqqq;
    String id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
         id = intent.getStringExtra("id");
        qqqq = intent.getStringExtra("qqqq");
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        logo = (ImageView) findViewById(R.id.logo);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        if(id==null){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        MyResultBean resultBean = Okhttpuntil.synGetRequesr("http://v.juhe.cn/dream/query?q="+qqqq+"&full=1&key=c45a4c712fa4f5aac2571df29fe8f47f", MyResultBean.class);
                        if(resultBean!=null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(resultBean.getResult()==null){
                                        Toast.makeText(searchActivity.this, "周公解不了这个梦", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                    Intent intent=new Intent(searchActivity.this,Activity_Searchlist.class);
                                    intent.putExtra("bean",resultBean);
                                    startActivity(intent);
                                finish();
                                }
                            });

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(submit()!=null){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                MyResultBean resultBean = Okhttpuntil.synGetRequesr("http://v.juhe.cn/dream/query?q="+submit()+"&cid="+id+"&full=1&key=c45a4c712fa4f5aac2571df29fe8f47f", MyResultBean.class);
                                if(resultBean!=null){
                                   runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                         if(resultBean.getResult()==null){
                                             Toast.makeText(searchActivity.this, "周公解不了这个梦", Toast.LENGTH_SHORT).show();
                                             return;
                                         }
                                           Intent intent=new Intent(searchActivity.this,Activity_Searchlist.class);
                                           intent.putExtra("bean",resultBean);
                                           startActivity(intent);

                                       }
                                   });

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
                break;
        }
    }

    private String submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "请输入搜索内容", Toast.LENGTH_SHORT).show();
            return null;
        }

        // TODO validate success, do something
return editTextString;

    }
}
