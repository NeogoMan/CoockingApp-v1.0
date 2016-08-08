package recipe.coking.kitchen.myrecipeapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Recipes {


    @SerializedName("publisher")
    private String Publisher;
    @SerializedName("f2f_url")
    private String Site;
    @SerializedName("title")
    private String Title;
    @SerializedName("source_url")
    private String SourceUrl;
    @SerializedName("recipe_id")
    private String RecipeId;
    @SerializedName("image_url")
    private String ImageUrl;
    @SerializedName("social_rank")
    private float  SocialRank;
    @SerializedName("publisher_url")
    private String PublisherUrl;


    public String getPublisher() {
        return Publisher;
    }

    public String getSite() {
        return Site;
    }

    public String getTitle() {
        return Title;
    }

    public String getSourceUrl() {
        return SourceUrl;
    }

    public String getRecipeId() {
        return RecipeId;
    }

    public float getSocialRank() {
        return SocialRank;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getPublisherUrl() {
        return PublisherUrl;
    }
}
