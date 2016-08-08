package recipe.coking.kitchen.myrecipeapp.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import recipe.coking.kitchen.myrecipeapp.R;

/**
 * Created by mac on 20/04/16.
 */
public class HomeActionBar extends FrameLayout{

    public HomeActionBar(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public HomeActionBar(Context context) {
        this(context,null);
    }

    public HomeActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    private void initializeView() {
        inflate(getContext(), R.layout.home_actionbar,this);
    }

}
