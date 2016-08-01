package com.intellisenseglobal.internshiptest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.intellisenseglobal.internshiptest.DataSource.BioDataDataSource;
import com.intellisenseglobal.internshiptest.Helper.DataWrapper;
import com.intellisenseglobal.internshiptest.Model.BioData;

import java.util.ArrayList;

public class splash_screen extends AppCompatActivity {

    ArrayList<BioData> arrayList;
    BioDataDataSource bioDataDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new splashScreen_AsynchTask().execute();
        YoYo.with(Techniques.FadeIn).duration(700).playOn(findViewById(R.id.splash_screen_linearLayout));
    }

    private class splashScreen_AsynchTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            arrayList = new ArrayList<>();
            bioDataDataSource = new BioDataDataSource();

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            if(isNetworkConnected()) {
                arrayList = bioDataDataSource.getArrayList();

            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent();
            intent.setClass(splash_screen.this,MainActivity.class);
            intent.putExtra("data", new DataWrapper(arrayList));
            startActivity(intent);
            finish();
            super.onPostExecute(aVoid);
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
