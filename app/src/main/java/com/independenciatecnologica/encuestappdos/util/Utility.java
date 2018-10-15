package com.independenciatecnologica.encuestappdos.util;

import android.util.Log;
import static com.independenciatecnologica.encuestappdos.util.Constanst.TAG;
public class Utility {
    public static boolean checking(String data){
        if(data == null)
            Log.e(TAG,"string is null");
        else
        if(!data.isEmpty()&& data!=""){
            Log.d(TAG,"its ok , is not empty or \"\" ");
            return true;}

        Log.d(TAG,"its not ok!! ");
        return false;
    }
}
