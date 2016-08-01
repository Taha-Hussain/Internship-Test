package com.intellisenseglobal.internshiptest.Helper;

import com.intellisenseglobal.internshiptest.Model.BioData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Taha on 01/08/2016.
 */
public class DataWrapper implements Serializable {

    private ArrayList<BioData> parliaments;

    public DataWrapper(ArrayList<BioData> data) {
        this.parliaments = data;
    }

    public ArrayList<BioData> getBioData() {
        return this.parliaments;
    }

}