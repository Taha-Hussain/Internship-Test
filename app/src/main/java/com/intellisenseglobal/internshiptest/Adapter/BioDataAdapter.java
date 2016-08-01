package com.intellisenseglobal.internshiptest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.intellisenseglobal.internshiptest.Model.BioData;
import com.intellisenseglobal.internshiptest.R;

import java.util.ArrayList;

/**
 * Created by Taha on 31/07/2016.
 */
public class BioDataAdapter extends ArrayAdapter<BioData> {
    Context context;
    public BioDataAdapter(Context context, int resource, ArrayList<BioData> objects)
    {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BioData bioData = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_biodata_listview,parent,false);

        TextView name = (TextView) rowView.findViewById(R.id.row_name_textview);
        TextView email = (TextView) rowView.findViewById(R.id.row_email_textview);
        TextView address = (TextView) rowView.findViewById(R.id.row_address_textview);
        TextView gender = (TextView) rowView.findViewById(R.id.row_gender_textview);
        TextView mobile_number = (TextView) rowView.findViewById(R.id.row_mobile_number_textview);
        TextView home_number = (TextView) rowView.findViewById(R.id.row_home_number_textview);
        TextView office_number = (TextView) rowView.findViewById(R.id.row_office_number_textview);
        ImageView gender_image = (ImageView) rowView.findViewById(R.id.row_gender_image_view);


        name.setText(bioData.getName());
        email.setText(bioData.getEmail());
        address.setText(bioData.getAddress());
        gender.setText(bioData.getGender());
        String genderString =  bioData.getGender();
        if(genderString.equals("female"))
        {
            gender_image.setImageResource(context.getResources().getIdentifier("drawable/female", null, context.getPackageName()));
        }
        else
        {
            gender_image.setImageResource(context.getResources().getIdentifier("drawable/male", null, context.getPackageName()));
        }

        mobile_number.setText(bioData.getMobile());
        home_number.setText(bioData.getHome());
        office_number.setText(bioData.getOffice());

        return rowView;
    }
}
