package cn.edu.gdpt.iterpretsdreams;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class DatabingUntil {
    @BindingAdapter("imgname")
    public static void SetImg(ImageView imageView,int draw){
        imageView.setImageResource(draw);

    }
}
