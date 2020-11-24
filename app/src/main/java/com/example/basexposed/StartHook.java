package com.example.basexposed;

import android.annotation.SuppressLint;
import android.util.Log;


import de.robv.android.xqoseb.IXposedHookLoadPackage;
import de.robv.android.xqoseb.XSharedPreferences;
import de.robv.android.xqoseb.callbacks.XC_LoadPackage;


public class StartHook implements IXposedHookLoadPackage {
    @SuppressLint("NewApi")
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XSharedPreferences xSharedPreferences = new XSharedPreferences(BuildConfig.APPLICATION_ID, "app_info");
        xSharedPreferences.makeWorldReadable();
        String packName = xSharedPreferences.getString("pack_name", null);
        if (packName != null){
            Log.d("Xposed", "PackName is "+ packName);
            if (loadPackageParam.packageName.contains(packName)){

            }
        }else Log.e("Xposed", "PackName is NULL");
    }
}
