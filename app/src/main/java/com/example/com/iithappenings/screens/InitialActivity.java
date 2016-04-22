package com.example.com.iithappenings.screens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

import com.example.com.iithappenings.R;

/**
 * Created by snehaupadhyay on 4/21/16.
 * This class does the connectivity part. If a connection cannot be established to the server, user is displayed with
 * a message
 */
public class InitialActivity extends Activity {

    private SharedPreferences preference;

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        // setting content view to splash screen
        setContentView(R.layout.splash);

        // get connectivity service context

        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        // check if connection exists or if connected

        if(cm.getActiveNetworkInfo()==null || !cm.getActiveNetworkInfo().isConnected()||!cm.getActiveNetworkInfo().isAvailable())
        {

            // display popup

            AlertDialog.Builder b = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AppTheme_PopupOverlay));

            b.setMessage("Unable to connect to IIT server. \n Please check connectivity.").setTitle("Error Connecting")
                    .setCancelable(false).setPositiveButton("Exit",new DialogInterface.OnClickListener(){
                @Override

                public void onClick(DialogInterface dialog, int id){
                    finish();
                }

            });

            AlertDialog alert = b.create();

            alert.show();
        } else{
            startActivity(new Intent(this, HomeActivity.class));
        }


    }



}
