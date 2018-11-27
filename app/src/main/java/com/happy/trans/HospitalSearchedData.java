package com.happy.trans;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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




public class HospitalSearchedData extends AppCompatActivity {
    static final String KEYYY = "Oko%2BtmV0bs5qVS5X902wm1wU%2BdwWjNwxC%2BCs6J0637Cv0Tkl%2FAdYHae6SPOrrlL4MhORDluYibA%2FFUn3D8ZLgA%3D%3D";

    public String HosInfo(String hpid) throws IOException {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        boolean name = false;
        boolean dgidIdName = false;//진료과목
        boolean addr = false;
        boolean tell = false;
        boolean emertell = false;//응급실전화
        boolean bednum = false;//병상수
        boolean maping = false;//간이약도
        boolean time1s = false;
        boolean time1c = false;
        boolean time2s = false;
        boolean time2c = false;
        boolean time3s = false;
        boolean time3c = false;
        boolean time4s = false;
        boolean time4c = false;
        boolean time5s = false;
        boolean time5c = false;
        boolean time6s = false;
        boolean time6c = false;
        boolean time7s = false;
        boolean time7c = false;
        boolean time8s = false;
        boolean time8c = false;


        URL url = new URL("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire"
                + "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + KEYYY
                + "&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(hpid, "UTF-8")
                + "&" + URLEncoder.encode("pageNo", "UTF-8") + "=1"
                + "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=1");


        Log.d("bbbbb", url.toString());

        String hosname = null;
        String hosdgidIdName = null;
        String hosaddr = null;
        String hostell = null;
        String hosemertell = "정보 없음";
        String hosbednum = "정보 없음";
        String hosmaping = "정보 없음";
        String hosmonstart = null;
        String hosmonclose = null;
        String hostuestart = null;
        String hostueclose = null;
        String hoswedstart = null;
        String hoswedclose = null;
        String hosthustart = null;
        String hosthuclose = null;
        String hosfristart = null;
        String hosfriclose = null;
        String hossatstart = null;
        String hossatclose = null;
        String hossunstart = null;
        String hossunclose = null;
        String hosredstart = null;
        String hosredclose = null;
        String printing = null;


        //여기 try catch
        try {
            //정의
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), "UTF-8");//시작한다
            int parserEvent = parser.getEventType();//현재위치 response
            //HospitalData Data;
            while (parserEvent != XmlPullParser.END_DOCUMENT) {// response오면 종료
                switch (parserEvent) {//item dutyAdder
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
                        if (parser.getName().equalsIgnoreCase("dutyName")) {
                            name = true;
                        }//병원이름
                        if (parser.getName().equalsIgnoreCase("dgidIdName")) {
                            dgidIdName = true;
                        }//병원응급실운영여부
                        if (parser.getName().equalsIgnoreCase("dutyAddr")) {
                            addr = true;
                        }//주소
                        if (parser.getName().equalsIgnoreCase("dutyTel1")) {
                            tell = true;
                        }//전화번호
                        if (parser.getName().equalsIgnoreCase("dutyTel3")) {
                            emertell = true;
                        }//응급실전화번호
                        if (parser.getName().equalsIgnoreCase("dutyHano")) {
                            bednum = true;
                        }//병상수
                        if (parser.getName().equalsIgnoreCase("dutyMapimg")) {
                            maping = true;
                        }//간이약도
                        if (parser.getName().equalsIgnoreCase("dutyTime1s")) {
                            time1s = true;
                        }//월요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime1c")) {
                            time1c = true;
                        }//월요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime2s")) {
                            time2s = true;
                        }//화요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime2c")) {
                            time2c = true;
                        }//화요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime3s")) {
                            time3s = true;
                        }//수요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime3c")) {
                            time3c = true;
                        }//수요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime4s")) {
                            time4s = true;
                        }//목요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime4c")) {
                            time4c = true;
                        }//목요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime5s")) {
                            time5s = true;
                        }//금요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime5c")) {
                            time5c = true;
                        }//금요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime6s")) {
                            time6s = true;
                        }//토요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime6c")) {
                            time6c = true;
                        }//토요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime7s")) {
                            time7s = true;
                        }//일요일open
                        if (parser.getName().equalsIgnoreCase("dutyTime7c")) {
                            time7c = true;
                        }//일요일close
                        if (parser.getName().equalsIgnoreCase("dutyTime8s")) {
                            time8s = true;
                        }//공휴일open
                        if (parser.getName().equalsIgnoreCase("dutyTime8c")) {
                            time8c = true;
                        }//공휴일close
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
                        if (name) {
                            hosname = parser.getText().trim();
                            Log.d("배다영", hosname);
                            name = false;
                        }
                        if (dgidIdName) {
                            hosdgidIdName = parser.getText().trim();
                            dgidIdName = false;
                        }
                        if (addr) {
                            hosaddr = parser.getText().trim();
                            addr = false;
                        }
                        if (tell) {
                            hostell = parser.getText().trim();
                            tell = false;
                        }
                        if (emertell) {
                            hosemertell = parser.getText().trim();
                            emertell = false;
                        }
                        if (bednum) {
                            hosbednum = parser.getText().trim();
                            bednum = false;
                        }
                        if (maping) {
                            hosmaping = parser.getText().trim();
                            maping = false;
                        }
                        if (time1s) {
                            hosmonstart = parser.getText().trim();
                            time1s = false;
                        }
                        if (time1c) {
                            hosmonclose = parser.getText().trim();
                            time1c = false;
                        }
                        if (time2s) {
                            hostuestart = parser.getText().trim();
                            time2s = false;
                        }
                        if (time2c) {
                            hostueclose = parser.getText().trim();
                            time2c = false;
                        }
                        if (time3s) {
                            hoswedstart = parser.getText().trim();
                            time3s = false;
                        }
                        if (time3c) {
                            hoswedclose = parser.getText().trim();
                            time3c = false;
                        }
                        if (time4s) {
                            hosthustart = parser.getText().trim();
                            time4s = false;
                        }
                        if (time4c) {
                            hosthuclose = parser.getText().trim();
                            time4c = false;
                        }
                        if (time5s) {
                            hosfristart = parser.getText().trim();
                            time5s = false;
                        }
                        if (time5c) {
                            hosfriclose = parser.getText().trim();
                            time5c = false;
                        }
                        if (time6s) {
                            hossatstart = parser.getText().trim();
                            time6s = false;
                        }
                        if (time6c) {
                            hossatclose = parser.getText().trim();
                            time6c = false;
                        }
                        if (time7s) {
                            hossunstart = parser.getText().trim();
                            time7s = false;
                        }
                        if (time7c) {
                            hossunclose = parser.getText().trim();
                            time7c = false;
                        }
                        if (time8s) {
                            hosredstart = parser.getText().trim();
                            time8s = false;
                        }
                        if (time8c) {
                            hosredclose = parser.getText().trim();
                            time8c = false;
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


        printing = "[ 병원 상세 정보 ]\n\n" +
                "- 전화번호 : " + hostell + "\n" +
                "- 응급전화 : " + hosemertell +"\n"+
                "- 진료과목 : " + hosdgidIdName +"\n"+
                "- 주소 : " + hosaddr +"\n"+
                "- 병상 개수 : " + bednum +"\n"+
                "- 간이약도 : " + maping +"\n"+
                "- 영업시간\n";
        if(TextUtils.isEmpty(hosmonstart)){
            printing += "    월요일 : 휴무\n" ;
        }
        else{
            printing += "    월요일 : " + hosmonstart.substring(0,2)+":"+hosmonstart.substring(2,4)+"~"+ hosmonclose.substring(0,2)+":"+hosmonclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hostuestart)){
            printing += "    화요일 : 휴무\n" ;
        }
        else{
            printing += "    화요일 : " + hostuestart.substring(0,2)+":"+hostuestart.substring(2,4)+"~"+ hostueclose.substring(0,2)+":"+hostueclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hoswedstart)){
            printing += "    수요일 : 휴무\n" ;
        }
        else{
            printing += "    수요일 : " + hoswedstart.substring(0,2)+":"+hoswedstart.substring(2,4)+"~"+ hoswedclose.substring(0,2)+":"+hoswedclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hosthustart)){
            printing += "    목요일 : 휴무\n" ;
        }
        else{
            printing += "    목요일 : " + hosthustart.substring(0,2)+":"+hosthustart.substring(2,4)+"~"+ hosthuclose.substring(0,2)+":"+hosthuclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hosfristart)){
            printing += "    금요일 : 휴무\n" ;
        }
        else{
            printing += "    금요일 : " + hosfristart.substring(0,2)+":"+hosfristart.substring(2,4)+"~"+ hosfriclose.substring(0,2)+":"+hosfriclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hossatstart)){
            printing += "    토요일 : 휴무\n" ;
        }
        else{
            printing += "    토요일 : " + hossatstart.substring(0,2)+":"+hossatstart.substring(2,4)+"~"+ hossatclose.substring(0,2)+":"+hossatclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hossunstart)){
            printing += "    일요일 : 휴무\n" ;
        }
        else{
            printing += "    일요일 : " + hossunstart.substring(0,2)+":"+hossunstart.substring(2,4)+"~"+ hossunclose.substring(0,2)+":"+hossunclose.substring(2,4) + "\n" ;
        }

        if(TextUtils.isEmpty(hosredstart)){
            printing += "    공휴일 : 휴무\n" ;
        }
        else{
            printing += "    공휴일 : " + hosredstart.substring(0,2)+":"+hosredstart.substring(2,4)+"~"+ hosredclose.substring(0,2)+":"+hosredclose.substring(2,4) + "\n";
        }

        return printing;

    }


}

