package recipe.coking.kitchen.myrecipeapp.Utils;

import android.content.Context;
import junit.framework.Assert;

/**
 * Created by mac on 14/04/16.
 */
public class Util {

    public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }

}
