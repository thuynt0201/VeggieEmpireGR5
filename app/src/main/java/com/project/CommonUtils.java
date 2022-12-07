package com.project;

import com.project.models.Voucher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
    private static String PATTERN = "MM/dd/yyyy HH:mm";
    private static final String FILE_NAME = "file_shared";
    private static CommonUtils instance;
    private CommonUtils() {
        //for singleton
    }

    public static CommonUtils getInstance(){
        if(instance==null){
            instance = new CommonUtils();
        }
        return instance;
    }

    public String getJsonStore(int path){
        InputStream is = App.getInstance().getResources().openRawResource(path);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // json string
        return writer.toString();
    }

    public ArrayList<Voucher> convertListVoucher (String jsonString) {
        ArrayList<Voucher> listVoucher = new ArrayList<>();
        JSONObject jsonRoot = null;
        try {
            jsonRoot = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRoot.getJSONArray("title");
            String[] titles = new String[jsonArray.length()];
            JSONArray jsonArray1 = jsonRoot.getJSONArray("time");
            String[] times = new String[jsonArray.length()];
            JSONArray jsonArray2 = jsonRoot.getJSONArray("status");
            String[] statuses = new String[jsonArray.length()];

            for(int i=0;i < jsonArray.length();i++) {
                titles[i] = jsonArray.getString(i);
                times[i] = jsonArray1.getString(i);
                statuses[i] = jsonArray2.getString(i);
                listVoucher.add(new Voucher(titles[i],times[i],statuses[i] ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listVoucher;
    }


    public String convertDateToString() {

        DateFormat df = new SimpleDateFormat(PATTERN);
        Date today = Calendar.getInstance().getTime();
        return df.format(today);

// Print the result!
    }
}
