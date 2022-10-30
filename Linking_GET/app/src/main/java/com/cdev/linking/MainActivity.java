package com.cdev.linking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    String base_url = "http://10.31.4.46/mobile/";

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIClass api_get_ex = new APIClass();
        api_get_ex.execute(base_url + "get_articles.php");
    }


    class APIClass extends AsyncTask<String, Void, String> {
        private JSONArray response_array;

        protected String doInBackground(String... params){
            URL url;
            URLConnection http;

            try{
                url = new URL(params[0]);
                http = url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                BufferedReader br = new BufferedReader(reader);
                StringBuilder builder = new StringBuilder();

                String line;
                while( (line = br.readLine()) != null ){
                    builder.append(line + "\n");
                }

                br.close();
                return builder.toString();
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(String response){
            super.onPostExecute(response);

            try{
                response_array = new JSONArray(response);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public JSONArray getResponseArray(){
            return response_array;
        }
    }


}