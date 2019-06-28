package cn.edu.gdpt.iterpretsdreams;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cn.edu.gdpt.iterpretsdreams.databinding.ActivitySearchListBinding;

public class Activity_Searchlist extends AppCompatActivity implements View.OnClickListener {
    MyResultBean resultBean;
    ActivitySearchListBinding binding;
    private Button btnext;
    private int position = 0;
    private List<MyResultBean.ResultBean> result;
    private Button btlast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        resultBean = (MyResultBean) intent.getSerializableExtra("bean");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_list);
        result = resultBean.getResult();

        binding.setBean(result.get(position));
        initView();
    }

    private void initView() {
        btnext = (Button) findViewById(R.id.btnext);

        btnext.setOnClickListener(this);
        btlast = (Button) findViewById(R.id.btlast);
        btlast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnext:

                if (result.size() - 1 >= (position + 1)) {
                    position += 1;
                    binding.setBean(result.get(position));
                    binding.notifyChange();
                } else {
                    Toast.makeText(this, "没有下一条", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btlast:


                if (position!=0) {
                    position -= 1;
                    binding.setBean(result.get(position));
                    binding.notifyChange();
                } else {
                    Toast.makeText(this, "没有上一条", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
