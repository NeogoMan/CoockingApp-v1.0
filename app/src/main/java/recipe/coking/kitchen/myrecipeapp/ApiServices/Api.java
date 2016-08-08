package recipe.coking.kitchen.myrecipeapp.ApiServices;

import java.util.List;

import recipe.coking.kitchen.myrecipeapp.Models.Recipe;
import recipe.coking.kitchen.myrecipeapp.Models.Recipes;
import recipe.coking.kitchen.myrecipeapp.Models.ResponseRecipe;
import recipe.coking.kitchen.myrecipeapp.Models.ResponseRecipes;
import recipe.coking.kitchen.myrecipeapp.Utils.AppConstant;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by mac on 10/04/16.
 */
public interface Api {

    //Cakes , Chicken , Greens , fruits ,
    @GET("search?key="+AppConstant.KEY)
    Call<ResponseRecipes> getRecipes(@Query("q") String catgName);

    @GET("get?key="+AppConstant.KEY)
    Call<ResponseRecipe> getRecipe(@Query("rId") String rId);
}
