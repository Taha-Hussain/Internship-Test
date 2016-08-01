package com.intellisenseglobal.internshiptest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.intellisenseglobal.internshiptest.Adapter.BioDataAdapter;
import com.intellisenseglobal.internshiptest.Helper.DataWrapper;
import com.intellisenseglobal.internshiptest.Model.BioData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    BioDataAdapter bioDataAdapter;
    ListView listViewBioData;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("data");
        ArrayList<BioData> bioDataArrayList = dw.getBioData();

        listViewBioData = (ListView) findViewById(R.id.BioData_ListView);
        if(isNetworkConnected()) {
            bioDataAdapter = new BioDataAdapter(context, R.layout.row_biodata_listview, bioDataArrayList);
            listViewBioData.setAdapter(bioDataAdapter);
        }
        else
        {
            Toast.makeText(MainActivity.this, "Please Check Your Internet Connection!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
