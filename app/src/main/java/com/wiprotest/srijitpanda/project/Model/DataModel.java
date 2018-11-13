package com.wiprotest.srijitpanda.project.Model;

import java.util.ArrayList;

import javax.inject.Inject;

public class DataModel {

    @Inject
    DataModel(){
    }
    private String title;
    private ArrayList<RowDataModel> rows;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public ArrayList<RowDataModel> getRows ()
    {
        return rows;
    }

    public void setRows (ArrayList<RowDataModel> rows)
    {
        this.rows = rows;
    }

}
