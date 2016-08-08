package recipe.coking.kitchen.myrecipeapp.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import recipe.coking.kitchen.myrecipeapp.Models.Recipes;
import recipe.coking.kitchen.myrecipeapp.R;

public class RecipeView extends FrameLayout {

    private ImageView mRecipeImage;
    private TextView  mTvTitle;

    private Recipes   mRecipe;

    public RecipeView(Context context) {
        this(context, null);
    }

    public RecipeView(Context context, AttributeSet attrs) {
        this(context, attrs, -1,null);
    }

    public RecipeView(Context context, AttributeSet attrs, int defStyleAttr,Recipes recipes) {
        super(context, attrs, defStyleAttr);
        this.mRecipe = recipes;
        initializeViews();
    }

    private void initializeViews() {
        inflate(getContext(), R.layout.view_recipe,this);
        mRecipeImage = (ImageView) findViewById(R.id.image);
        mTvTitle      = (TextView)    findViewById(R.id.tv_title);
    }

    public void setRecipe(Recipes recipes){
        this.mRecipe = recipes;
        fillData();
    }

    private void fillData() {
      if (mRecipe != null){
          Picasso.with(getContext()).load(mRecipe.getImageUrl()).into(mRecipeImage);
          mTvTitle.setText(mRecipe.getTitle());
      }
    }
}
