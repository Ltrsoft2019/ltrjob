package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Award_Deo {
    private static String URL="http://job.ltr-soft.com/course_detail.php";
    private static String Create_URL="";
    private static String Update_URL="";
    private static String Delete_URL="";
    private static String ReadAll_URL="";
    Award award;

    ArrayList<Award>list=new ArrayList<>();

    public void getAllAward(Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String award_name = jsonObject.getString("award_name");
                                String award_given_by = jsonObject.getString("award_given_by");
                                String award_date_recieved = jsonObject.getString("award_date_recieved");
                                String award_venue = jsonObject.getString("award_venue");

                                award=new Award(award_name,award_given_by,award_date_recieved,award_venue);

                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(award);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                return map;
            }
        };
    }

    public void getAward(String user_id,Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String award_name = jsonObject.getString("award_name");
                                String award_given_by = jsonObject.getString("award_given_by");
                                String award_date_recieved = jsonObject.getString("award_date_recieved");
                                String award_venue = jsonObject.getString("award_venue");

                                award=new Award(award_name,award_given_by,award_date_recieved,award_venue);

                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(award);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("user_id",user_id); 
                return map;
            }
        };
    }
    public void createAward(Award award, String user_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Create_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();

                map.put("award_name",award.getAward_name());
                map.put("award_given_by",award.getAward_given_by());
                map.put("award_date_recieved",award.getAward_date_recieved());
                map.put("award_venue",award.getAward_venue());
                return map;
            }
        };
    }
    public void updateAward(Award award, String user_id, Context context, UserCallBack userCallBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Update_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();

                map.put("award_name", award.getAward_name());
                map.put("award_given_by", award.getAward_given_by());
                map.put("award_date_recieved", award.getAward_date_recieved());
                map.put("award_venue", award.getAward_venue());
                return map;
            }
        };
    }
        public void deleteAward(Award award, String user_id, Context context, UserCallBack userCallBack){
            StringRequest stringRequest=new StringRequest(Request.Method.POST, Delete_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains("success")) {
                                userCallBack.userSuccess("success");
                            } else {
                                userCallBack.userError(response.toString());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    userCallBack.userError(error.toString());
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String>map=new HashMap<>();

                    map.put("user_id",award.getUser_id());
                    return map;
                }
            };
        }
    public void searchAward(Award award, String user_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();

                map.put("user_id",award.getUser_id());
                return map;
            }
        };
    }
}
