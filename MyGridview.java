package cn.edu.gdpt.iterpretsdreams;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridview extends GridView {
    public MyGridview(Context context) {
        super(context);
    }

    public MyGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(99999,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

