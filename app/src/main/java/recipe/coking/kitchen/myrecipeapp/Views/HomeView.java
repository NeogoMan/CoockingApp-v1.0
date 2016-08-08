package recipe.coking.kitchen.myrecipeapp.Views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import recipe.coking.kitchen.myrecipeapp.Models.Menu;
import recipe.coking.kitchen.myrecipeapp.R;


public class HomeView extends FrameLayout implements View.OnClickListener {




    private ImageView mMenuImage;
    private Button    mMenuTitle;
    private CardView  mCardView;


    private Menu menu;

    private OnclickCategorieListener onOnclickCategorieListener;

    public interface OnclickCategorieListener{
      public void onclickCategorie(String catgname);
    }

    public HomeView(Context context) {
        this(context, null);

    }

    public HomeView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);

    }

    public HomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
        alleyListener();
    }

    private void initializeView() {
        inflate(getContext(), R.layout.view_home, this);
        mMenuImage = (ImageView) findViewById(R.id.menu_image);
        mMenuTitle = (Button)  findViewById(R.id.menu_title);
        mCardView  = (CardView)  findViewById(R.id.c_root_view);
    }


    private void alleyListener(){
        mCardView.setOnClickListener(this);
    }



    public void setMenuData(Menu menu){
      this.menu = menu;
        fillData();
    }

    private void fillData() {
        mMenuImage.setImageDrawable(menu.getImage());
        mMenuTitle.setText(menu.getName());
    }


    public void setOnOnclickCategorieListener(OnclickCategorieListener onOnclickCategorieListener) {
        this.onOnclickCategorieListener = onOnclickCategorieListener;
    }

    @Override
    public void onClick(View v) {
       if (onOnclickCategorieListener!= null){
           onOnclickCategorieListener.onclickCategorie(mMenuTitle.getText().toString());
       }
    }
}
