package recipe.coking.kitchen.myrecipeapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mac on 26/05/16.
 */
public class ResponseRecipe {

    @SerializedName("recipe")
    private Recipe recipe;


    public Recipe getRecipe() {
        return recipe;
    }
}
