package recipe.coking.kitchen.myrecipeapp.Models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by mac on 14/04/16.
 */
public class Menu {


    private Drawable mImage;
    private String   mName;



    public Menu(Drawable mImage, String mName) {
        this.mImage = mImage;
        this.mName  = mName;
    }




    public String getName() {
        return mName;
    }


    public Drawable getImage() {
        return mImage;
    }
}
