package com.happy.trans;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;




public class HospitalList extends AppCompatActivity {
    static final String KEYYY = "put your key here";
    ArrayList<HospitalData> HOSPITAL = new ArrayList<HospitalData>();
    int pageNo = 1;


    public void HosLocations(String city, String distriction) throws IOException {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        boolean lat = false;
        boolean lon = false;
        boolean name = false;
        boolean b_hpid = false;
        boolean b_pageNo = false;
        boolean b_totalCount = false;


        URL url = new URL("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire"
                + "?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + KEYYY
                + "&" + URLEncoder.encode("Q0", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8")
                + "&" + URLEncoder.encode("Q1", "UTF-8") + "=" + URLEncoder.encode(distriction, "UTF-8")
                + "&" + URLEncoder.encode("pageNo", "UTF-8") + "="+ Integer.toString(pageNo)
                + "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=100");

        String hoslon = null;
        String hoslat = null;
        String hosname = null;
        String hoshpid = null;
        
        try {
         
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), "UTF-8");
            int parserEvent = parser.getEventType();
            
            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equalsIgnoreCase("pageNo")) {
                            b_pageNo = true;
                        }
                        if (parser.getName().equalsIgnoreCase("totalCount")) {
                            b_totalCount = true;
                        }
                        if (parser.getName().equalsIgnoreCase("wgs84Lat")) {
                            lat = true;
                        }
                        if (parser.getName().equalsIgnoreCase("wgs84Lon")) {
                            lon = true;
                        }
                        if (parser.getName().equalsIgnoreCase("dutyName")) {
                            name = true;
                        }
                        if (parser.getName().equalsIgnoreCase("hpid")) {
                            b_hpid = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if (b_pageNo) {
                            pageNo++;
                            b_pageNo = false;
                        }
                        if (b_totalCount) {
                            if(HOSPITAL.size() >= Integer.parseInt(parser.getText().trim())){
                                b_totalCount = false;
                                break;
                            }
                        }
                        if (lat) { 
                            hoslat = parser.getText().trim();
                            lat = false;
                        }
                        if (lon) {
                            hoslon = parser.getText().trim();
                            lon = false;
                        }
                        if (name) {
                            hosname = parser.getText().trim();
                            name = false;
                        }
                        if (b_hpid) {
                            hoshpid = parser.getText().trim();
                            b_hpid = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equalsIgnoreCase("item")){
                            HospitalData Data = new HospitalData();
                            Data.hoslat1 = hoslat;
                            Data.hoslon1 = hoslon;
                            Data.hosname1 = hosname;
                            Data.hoshpid1 = hoshpid;

                            HOSPITAL.add(Data);

                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }


    }


}
