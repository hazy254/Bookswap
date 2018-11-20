package projects.juma.bookswap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by TOSHIBA on 8/8/2016.
 */
public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE=0;
    private static final String PREF_NAME ="loginPref";
    private static final String IS_LOG_IN ="IsLoggedIn";
    private static final String KEY_NAME ="name";
    private static final String KEY_EMAIL="email";

    public SessionManager(Context context){
        this.context=context;
        pref=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }
    public void createLoginSession(String name, String email){
        editor.putBoolean(IS_LOG_IN,true);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_NAME,name);
        editor.apply();

    }
    public void checkLogin(){
        if (!this.isLoggedIn()){
            Intent i = new Intent(context,LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }
    public HashMap<String,String> getUserDetails(){
        HashMap<String,String> user = new HashMap<String, String>();
        user.put(KEY_EMAIL,pref.getString(KEY_EMAIL,null));
        user.put(KEY_NAME,pref.getString(KEY_NAME,null));

        return user;

    }
    public void logoutUser(){
        editor.clear();
        editor.apply();
        Intent i = new Intent(context,LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOG_IN,false);
    }



}
