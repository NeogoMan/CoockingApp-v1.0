package recipe.coking.kitchen.myrecipeapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.LinkedList;
import java.util.List;

import recipe.coking.kitchen.myrecipeapp.Models.Menu;
import recipe.coking.kitchen.myrecipeapp.Views.HomeView;

/**
 * Created by mac on 14/04/16.
 */
public class MenuAdapter extends UltimateViewAdapter<MenuAdapter.ViewHolder> {


    private List<Menu> menuList = new LinkedList<>();
    private HomeView.OnclickCategorieListener onclickCategorieListener;


    public MenuAdapter(List<Menu> menuList){
        this.menuList = menuList;
    }


    @Override
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        HomeView   homeView   = new HomeView(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(homeView);
        return viewHolder;
    }

    @Override
    public int getAdapterItemCount() {
        return menuList.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position<menuList.size()) {
            Menu menu = menuList.get(position);
            holder.homeView.setMenuData(menu);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    public void setOnclickCategorieListener(HomeView.OnclickCategorieListener onclickCategorieListener) {
        this.onclickCategorieListener = onclickCategorieListener;
    }

    class ViewHolder extends UltimateRecyclerviewViewHolder {

        HomeView homeView;
        public ViewHolder(View itemView) {
            super(itemView);
            homeView = (HomeView) itemView;
            homeView.setOnOnclickCategorieListener(onclickCategorieListener);
        }

    }
}
