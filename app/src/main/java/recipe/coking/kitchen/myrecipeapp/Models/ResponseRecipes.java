package recipe.coking.kitchen.myrecipeapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mac on 10/04/16.
 */
public class ResponseRecipes {

    @SerializedName("count")
    private int mCount;
    @SerializedName("recipes")
    private List<Recipes> mRecipeList;


    public int getmCount() {
        return mCount;
    }

    public List<Recipes> getmRecipeList() {
        return mRecipeList;
    }
}
