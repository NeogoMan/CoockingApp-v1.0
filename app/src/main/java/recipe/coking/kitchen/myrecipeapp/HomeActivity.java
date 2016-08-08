package recipe.coking.kitchen.myrecipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.LinkedList;
import java.util.List;

import recipe.coking.kitchen.myrecipeapp.Models.Menu;
import recipe.coking.kitchen.myrecipeapp.Utils.CheckConnectivity;
import recipe.coking.kitchen.myrecipeapp.Views.HomeActionBar;
import recipe.coking.kitchen.myrecipeapp.Views.HomeView;
import recipe.coking.kitchen.myrecipeapp.adapter.MenuAdapter;

public class HomeActivity extends AppCompatActivity implements UltimateRecyclerView.OnLoadMoreListener, HomeView.OnclickCategorieListener{


    private UltimateRecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private MenuAdapter         menuAdapter;
    private HomeActionBar       homeActionBar;

    private List<Menu> listMenu = new LinkedList<>();


    Menu chicken   ;
    Menu fruits    ;
    Menu greens    ;
    Menu meat      ;
    Menu sandwich  ;
    Menu milk  ;
    Menu fish  ;
    Menu pizza  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeViews();
    }



    private void initializeViews() {
        homeActionBar= (HomeActionBar) findViewById(R.id.home_action_bar);
        recyclerView = (UltimateRecyclerView) findViewById(R.id.rec_menu);

        recyclerView.showLoadMoreItemNum = 1;
        recyclerView.setHasFixedSize(false);
        recyclerView.setOnLoadMoreListener(this);
        linearLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(linearLayoutManager);


        chicken  = new Menu(getResources().getDrawable(R.drawable.chicken),"Chicken");
        sandwich = new Menu(getResources().getDrawable(R.drawable.sandwich),"sandwich");
        fruits   = new Menu(getResources().getDrawable(R.drawable.fruits),"fruits");
        greens   = new Menu(getResources().getDrawable(R.drawable.greens),"greens");
        meat     = new Menu(getResources().getDrawable(R.drawable.cakes),"Cakes");
        milk     = new Menu(getResources().getDrawable(R.drawable.milk),"Milk");
        fish     = new Menu(getResources().getDrawable(R.drawable.fish),"Fish");
        pizza    = new Menu(getResources().getDrawable(R.drawable.pizza),"Pizza");

        listMenu.add(chicken);
        listMenu.add(sandwich);
        listMenu.add(fruits);
        listMenu.add(greens);
        listMenu.add(meat);
        listMenu.add(milk);
        listMenu.add(fish);
        listMenu.add(pizza);

        menuAdapter  = new MenuAdapter(listMenu);

        recyclerView.setAdapter(menuAdapter);

        menuAdapter.setOnclickCategorieListener(this);


    }

    @Override
    public void loadMore(int itemsCount, int maxLastVisiblePosition) {

    }



    @Override
    public void onclickCategorie(String catgname) {
        Intent intent = new Intent(HomeActivity.this,RecipesActivity.class);
        intent.putExtra("catname",catgname);
        startActivity(intent);
    }

}
