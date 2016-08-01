package com.intellisenseglobal.internshiptest.JsonParser;

import com.intellisenseglobal.internshiptest.HttpService.HttpGetService;
import com.intellisenseglobal.internshiptest.Model.BioData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Taha on 30/07/2016.
 */
public class BioDataJsonParser {

    public ArrayList<BioData> getParsedBioData()
    {
        HttpGetService httpGetService = new HttpGetService();
        ArrayList<BioData> arrayList = new ArrayList<>();

        String JsonBioData = httpGetService.httpGet();

        try {
            JSONObject firstJsonObject = new JSONObject(JsonBioData);
            JSONArray studentInfoJsonArray = firstJsonObject.getJSONArray("studentsinfo");


            for(int i = 0 ;i<= studentInfoJsonArray.length();i++)
            {   BioData bioData = new BioData();
                JSONObject secondJsonObject = studentInfoJsonArray.getJSONObject(i);
                bioData.setName(secondJsonObject.getString("name"));
                bioData.setEmail(secondJsonObject.getString("email"));
                bioData.setAddress(secondJsonObject.getString("address"));
                bioData.setGender(secondJsonObject.getString("gender"));

                JSONObject phoneJsonObject = secondJsonObject.getJSONObject("phone");
                for(int j = 0 ; j<= phoneJsonObject.length();j++)
                {
                    bioData.setMobile(phoneJsonObject.getString("mobile"));
                    bioData.setHome(phoneJsonObject.getString("home"));
                    bioData.setOffice(phoneJsonObject.getString("office"));
                }

                arrayList.add(bioData);
            }
        }
        catch (JSONException je)
        {
            je.printStackTrace();
        }

        return arrayList;
    }
}
