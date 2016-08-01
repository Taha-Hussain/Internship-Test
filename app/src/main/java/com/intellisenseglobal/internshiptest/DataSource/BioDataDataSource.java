package com.intellisenseglobal.internshiptest.DataSource;

import com.intellisenseglobal.internshiptest.JsonParser.BioDataJsonParser;
import com.intellisenseglobal.internshiptest.Model.BioData;

import java.util.ArrayList;

/**
 * Created by Taha on 30/07/2016.
 */
public class BioDataDataSource {
    BioDataJsonParser bioDataJsonParser;
    ArrayList<BioData> arrayList;

    public BioDataDataSource()

    {
        bioDataJsonParser = new BioDataJsonParser();
        arrayList = new ArrayList<>();
    }

    public ArrayList<BioData> getArrayList()
    {
        try {
            arrayList = bioDataJsonParser.getParsedBioData();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return arrayList;
    }
}
