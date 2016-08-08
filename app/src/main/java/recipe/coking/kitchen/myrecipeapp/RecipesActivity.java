package recipe.coking.kitchen.myrecipeapp;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.MobileAds;
import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.List;

import recipe.coking.kitchen.myrecipeapp.Models.Recipes;

import recipe.coking.kitchen.myrecipeapp.Manager.ApiManager;
import recipe.coking.kitchen.myrecipeapp.Models.ResponseRecipes;
import recipe.coking.kitchen.myrecipeapp.Views.ActionBarView;
import recipe.coking.kitchen.myrecipeapp.adapter.RecipeAdapter;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class RecipesActivity extends AppCompatActivity implements RecyclerItemClickListener.OnItemClickListener, Callback<ResponseRecipes>, UltimateRecyclerView.OnLoadMoreListener, ActionBarView.onClickBackListener {


    private RecipeAdapter recipeAdapter;
    private UltimateRecyclerView ultimateRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    private List<Recipes> recipeList;

    private String mCatgName;
    private ActionBarView actionBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        mCatgName = getIntent().getStringExtra("catname");
        ApiManager.getInstance().getRecipes(mCatgName, this);
        initializeViews();

        createNotification(1, R.drawable.common_google_signin_btn_icon_dark, "Test", "Hello every body");
    }

    private void initializeViews() {
        ultimateRecyclerView = (UltimateRecyclerView) findViewById(R.id.ultimate_recycler_view);

        ultimateRecyclerView.showLoadMoreItemNum = 1;
        ultimateRecyclerView.setHasFixedSize(false);
        ultimateRecyclerView.setOnLoadMoreListener(this);
        linearLayoutManager = new GridLayoutManager(this, 2);
        ultimateRecyclerView.setLayoutManager(linearLayoutManager);
        ultimateRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));



        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        actionBarView = (ActionBarView) findViewById(R.id.rec_actionbar);
        actionBarView.setText(mCatgName);
        actionBarView.setmListener(this);

    }


    @Override
    public void onResponse(Response<ResponseRecipes> response, Retrofit retrofit) {
        if (response.isSuccess()) {
            recipeList = response.body().getmRecipeList();
            recipeAdapter = new RecipeAdapter(recipeList, this);
            ultimateRecyclerView.setAdapter(recipeAdapter);
        } else {

        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e("onFailure", "" + t.getMessage());
    }

    @Override
    public void loadMore(int itemsCount, int maxLastVisiblePosition) {

    }


    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("Id", recipeList.get(position).getRecipeId());
        intent.putExtra("Url", recipeList.get(position).getSourceUrl());
        intent.putExtra("RecipeName", recipeList.get(position).getTitle());
        intent.putExtra("RecipeId", recipeList.get(position).getRecipeId());
        startActivity(intent);
    }

    @Override
    public void onClickBak() {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    private void createNotification(int nId, int iconRes, String title, String body) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setSmallIcon(iconRes)
                .setContentTitle(title)
                .setContentText(body);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(nId, mBuilder.build());
    }

}
