package com.rajanks.digitaldiary.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rajanks.digitaldiary.R;

import java.util.Map;

/**
 *Created by rajan ks on 21-01-2016.
 */

@SuppressLint("InflateParams")
@SuppressWarnings("unused")
public class Util {

    //Properties
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static AlertDialog progressDialog;

    //<editor-fold desc="SharedPreferences - Generic">
    public static void saveValueWithKey(Activity context,String key,String value)
    {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveValueWithKey(Activity context,String key,int value)
    {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void saveValueWithKey(Activity context,String key,boolean value)
    {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public static void saveValueWithKey(Activity context,String key,Float value)
    {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static void clearCacheForPref(Activity context)
    {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static int getIntValueForKey(Activity context,String key,int defaultValue) {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,defaultValue);
    }

    public static String getStringValueForKey(Activity context,String key,String defaultValue) {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    public static boolean getBoolValueForKey(Activity context,String key,boolean defaultValue) {
        sharedPreferences = context.getSharedPreferences(AppConstants.ApplicationTag,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }
    //</editor-fold>

    //<editor-fold desc="Toast - Long and Short Durations">
    public static void showLongToast(Activity context,String message){
        LayoutInflater inflater = context.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) context.findViewById(R.id.custom_toast));

        TextView text = (TextView) layout.findViewById(R.id.toast_message);
        text.setText(message);

        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public static void showShortToast(Activity context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    //</editor-fold>

	//<editor-fold desc="Progress Dialog with Message">
	public static void showProgressDialog(Activity context,String message) {
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(context);
        LayoutInflater inflater=context.getLayoutInflater();
        View view= inflater.inflate(R.layout.progress_dailog,null);
        TextView messageTV=(TextView)view.findViewById(R.id.messageTV);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        progressBar.getIndeterminateDrawable().setColorFilter(0xFF555555, android.graphics.PorterDuff.Mode.MULTIPLY);
        messageTV.setTypeface(Util.getFontWithName(context,"elite"));
        messageTV.setText(message);
        builderDialog.setView(view);
        builderDialog.setCancelable(false);
        progressDialog = builderDialog.create();
        progressDialog.getWindow().setLayout(600,250);
        if(!progressDialog.isShowing())
        {
            progressDialog.show();
        }
	}

	public static void hideProgressBar() {
		if(progressDialog.isShowing()) {
		  progressDialog.dismiss();
		}
	}

	//</editor-fold>
	
    //<editor-fold desc="Internet Availability Check - Need Manifest Permissions">
    //Manifest Permissions to be added
    // <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    // <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    //</editor-fold>

    //<editor-fold desc="Fonts - Typeface">
    public static Typeface getFontWithName(Context context, String fontName)
    {
	   String assetPath = AppConstants.FontsRootPath + fontName+".ttf";
       return Typeface.createFromAsset(context.getAssets(), assetPath);
    }
    //</editor-fold>..

    //<editor-fold desc="Error Popups">
    public static void PopError(Activity activity, final Throwable t, final String title) {
        PopError(activity, t.getMessage(), title);
    }

    public static void PopError(Activity activity, final Exception exception, final String title) {
        Throwable ex = exception;
        if (exception.getCause() != null) {
            ex = exception.getCause();
        }
        PopError(activity, ex.getMessage(), title);
    }

    private static void PopError(Activity activity, final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.create().show();
    }
    //</editor-fold>

    public static void showAlert(final Activity activity, final String message){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
        String actualMessage = message.replace("\"", "");
        builder.setMessage(actualMessage);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
    }

    @SuppressWarnings("deprecation")
    public static void ClearCookies(Context context)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else
        {
            CookieSyncManager cookieSyncManager= CookieSyncManager.createInstance(context);
            cookieSyncManager.startSync();
            CookieManager cookieManager= CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncManager.stopSync();
            cookieSyncManager.sync();
        }
    }

    public static void Log(String message){
        message = message != null ? message : "error";
        Log.d(AppConstants.ApplicationTag,message);
    }

    public static String urlEncodeUTF8(String Url,Map<String,String> map) {
        String encodedUrl = Url;
        StringBuilder sb = new StringBuilder();
        if(map.size() > 0) {
            encodedUrl+="?";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(String.format("%s=%s",
                        entry.getKey(),
                        entry.getValue()
                ));
            }
        }
        return encodedUrl+sb.toString();
    }

}
