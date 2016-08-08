package recipe.coking.kitchen.myrecipeapp.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import recipe.coking.kitchen.myrecipeapp.R;

/**
 * Created by mac on 19/04/16.
 */
public class ActionBarView extends FrameLayout implements View.OnClickListener{


    private TextView mText;
    private ImageView mBtnBack;


    private onClickBackListener mListener;

    public interface onClickBackListener{
        public void onClickBak();
    }


    public ActionBarView(Context context) {
        this(context,null);
    }

    public ActionBarView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ActionBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews();
    }

    private void initializeViews() {
        inflate(getContext(), R.layout.view_actionbar,this);
        mText = (TextView) findViewById(R.id.c_name);
        mBtnBack = (ImageView) findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(this);
    }

    public void setText(String text){
      mText.setText(text);
    }

    public void setmListener(onClickBackListener mListener) {
        this.mListener = mListener;
    }


    @Override
    public void onClick(View v) {
        if (mListener!= null){
            mListener.onClickBak();
        }
    }
}
