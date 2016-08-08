package recipe.coking.kitchen.myrecipeapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mac on 24/05/16.
 */
public class Recipe {

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("f2f_url")
    private String f2f_url;

    @SerializedName("ingredients")
    private String [] ingredients;

    @SerializedName("source_url")
    private String source_url;


    @SerializedName("recipe_id")
    private String recipe_id;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("source_rank")
    private String source_rank;

    @SerializedName("publisher_url")
    private String publisher_url;

    @SerializedName("title")
    private String title;


    public String getPublisher() {
        return publisher;
    }

    public String getF2f_url() {
        return f2f_url;
    }

    public String [] getIngredients() {
        return ingredients;
    }

    public String getSource_url() {
        return source_url;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSource_rank() {
        return source_rank;
    }

    public String getPublisher_url() {
        return publisher_url;
    }

    public String getTitle() {
        return title;
    }
}
