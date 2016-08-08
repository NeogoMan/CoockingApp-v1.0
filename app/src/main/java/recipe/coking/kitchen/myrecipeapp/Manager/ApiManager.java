package recipe.coking.kitchen.myrecipeapp.Manager;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import recipe.coking.kitchen.myrecipeapp.ApiServices.Api;
import recipe.coking.kitchen.myrecipeapp.Models.Recipe;
import recipe.coking.kitchen.myrecipeapp.Models.Recipes;
import recipe.coking.kitchen.myrecipeapp.Models.ResponseRecipe;
import recipe.coking.kitchen.myrecipeapp.Models.ResponseRecipes;
import recipe.coking.kitchen.myrecipeapp.Utils.AppConstant;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by mac on 10/04/16.
 */
public class ApiManager {


    private static ApiManager instance;

    public static ApiManager getInstance() {
        return instance!=null ? instance : (instance = new ApiManager());
    }


    private OkHttpClient getHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request req = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();
                Response response = chain.proceed(req);
                Log.e("CALL WS", req.toString());
                Log.e("CALL WS", response.toString());
                return response;
            }
        });
        return client;
    }


    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();

    }

    private Api getAPIService() {
        return getRetrofit().create(Api.class);
    }

    public Call<ResponseRecipes> getRecipes(String catName,Callback<ResponseRecipes> callback) {
        Call<ResponseRecipes> call = getAPIService().getRecipes(catName);
        call.enqueue(callback);
        return call;
    }

    public Call<ResponseRecipe> getRecipe(String id, Callback<ResponseRecipe> callback) {
        Call<ResponseRecipe> call = getAPIService().getRecipe(id);
        call.enqueue(callback);
        return call;
    }
}
