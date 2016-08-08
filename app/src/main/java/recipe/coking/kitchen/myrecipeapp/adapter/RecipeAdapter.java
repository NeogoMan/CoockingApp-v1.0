package recipe.coking.kitchen.myrecipeapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.LinkedList;
import java.util.List;

import recipe.coking.kitchen.myrecipeapp.Models.Recipes;
import recipe.coking.kitchen.myrecipeapp.R;
import recipe.coking.kitchen.myrecipeapp.Views.RecipeView;

/**
 * Created by mac on 11/04/16.
 */
public class RecipeAdapter extends UltimateViewAdapter<RecipeAdapter.ViewHolder>{

    private List<Recipes> mRecipeList     = new LinkedList<Recipes>();

    private int lastPosition = -1;
    private Context context;



    public RecipeAdapter(List<Recipes> mRecipeList,Context context) {
        this.mRecipeList = mRecipeList;
        this.context     = context;
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        RecipeView recipeView = new RecipeView(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(recipeView);
        return viewHolder;
    }


    @Override
    public int getAdapterItemCount() {
        return mRecipeList.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position<mRecipeList.size()) {
            Recipes recipes = mRecipeList.get(position);
            holder.mRecipesView.setRecipe(recipes);
            setAnimation(holder.mRecipesView, position);
        }

    }

    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            animation.setDuration(500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    class ViewHolder extends UltimateRecyclerviewViewHolder {

        RecipeView mRecipesView;
        public ViewHolder(View itemView) {
            super(itemView);
            mRecipesView = (RecipeView) itemView;
        }

    }




}
