package com.cdev.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String base_url = "http://10.31.4.46/mobile/";
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(MainActivity.this);

        addArticle("Session Mobile", "LAU", "Byblos");

    }

    public void getArticles( int id){
        String url = base_url + "get_articles.php?id=" + id ;
        request = new StringRequest(Request.Method.GET, url, this::onResponse, this::onError);
        queue.add(request);
    }


    public void addArticle(String name, String author, String location){
        String url = base_url + "add_article.php";


        request = new StringRequest(Request.Method.POST, url, this::onResponse, this::onError) {

            public Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("author", author);
                params.put("location", location);
                return params;
            }

        };
        queue.add(request);
    }

    public void onError(VolleyError error){
        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
    }

    public void onResponse(String response){
        Toast.makeText(MainActivity.this, "Data Retreived from the Server", Toast.LENGTH_SHORT).show();
        try{
            JSONObject json = new JSONObject((response));
            Log.i("Response", json.toString());
        }catch(Exception e){
            Log.i("Error", Arrays.toString(e.getStackTrace()));
        }
    }


}