package com.example.odc.ascenxnrf.database;

import android.util.Log;

public class supportDatabase {
    public String getDatabaseName() {
        return "ascenxnrf";
    }
    public String getApiKey() {
        return "ssE5ht1rTwwC_kxdyvwtbEhNtOiXsR1u";
    }
    public String getBaseUrl()
    {
        return "https://api.mlab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }
    public String apiKeyUrl()
    {
        return "?apiKey="+getApiKey();
    }
    public String collectionName()
    {
        return "test";
    }
    public String buildContactsSaveURL()
    {
        Log.d("result", getBaseUrl()+collectionName()+apiKeyUrl());
        return getBaseUrl()+collectionName()+apiKeyUrl();
    }
    public String buildContactsFetchURL()
    {
        return getBaseUrl()+collectionName()+apiKeyUrl();
    }
//    public String createContact(MyContact contact) {
//        return String.format("{\"first_name\": \"%s\", "+ "\"last_name\": \"%s\", " + "\"phone\": \"%s\"}", contact.getFirst_name(), contact.getLast_name(), contact.getPhone_nubmer());
//    }
}
