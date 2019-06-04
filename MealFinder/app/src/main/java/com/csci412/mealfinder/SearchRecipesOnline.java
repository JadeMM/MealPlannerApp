package com.csci412.mealfinder;
//code based of off https://github.com/fanysoft/Android_Google_Custom_SearchDemo to fit our project

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.net.HttpURLConnection;
 import java.net.MalformedURLException;
 import java.net.URL;


 import android.content.Intent;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.TextView;
 import android.os.AsyncTask;
 import android.os.Bundle;
 import android.text.method.ScrollingMovementMethod;
 import android.util.Log;

 import android.widget.ProgressBar;

 import org.json.JSONException;
 import org.json.JSONObject;


public class SearchRecipesOnline extends FindRecipe {

    TextView resultTextView;
    ProgressBar progressBar;
    JSONObject resultJSON;

    static String result = null;
    Integer responseCode = null;
    String responseMessage = "";
    private static final String TAG = "MealFinder";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_recipes_online);

        Bundle extras = getIntent().getExtras();
        String first = extras.getString("first");
        String second = extras.getString("second");
        String third = extras.getString("third");
        String fourth = extras.getString("fourth");
        String fifth = extras.getString("fifth");

        resultTextView = (TextView) findViewById(R.id.textView1);
        progressBar = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        final String searchString = first +" "+ second +" "+ third +" "+ fourth +" "+ fifth;
        Log.d(TAG, searchString);

        //Log.d(TAG, "Searching for : " + searchString);
        resultTextView.setText("Looking for recipes with " + searchString + "...");
        String searchStringNoSpaces = searchString.replace(" ", "+");
        String key="AIzaSyCiNbWwYyuqZh7LJ6HWeWCTiM56X25hfJM";
        String cx = "003106805242594598942:aoqnwfkvezk";
        String urlString = "https://www.googleapis.com/customsearch/v1?q=" + searchStringNoSpaces + "&key=" + key + "&cx=" + cx + "&alt=json";
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
        }
        GoogleSearchAsyncTask searchTask = new GoogleSearchAsyncTask();
        searchTask.execute(url);

    }



    private class GoogleSearchAsyncTask extends AsyncTask<URL, Integer, String>{

        protected void onPreExecute(){
            // show progressbar
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(URL... urls) {

            URL url = urls[0];
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
            }


            try {
                responseCode = conn.getResponseCode();
                responseMessage = conn.getResponseMessage();
            } catch (IOException e) {
            }


            try {

                if(responseCode == 200) {

                    // response is good
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;

                    while ((line = rd.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    rd.close();

                    conn.disconnect();

                    result = sb.toString();
                    try {
                        resultJSON = new JSONObject(result);
                        // Log.d(TAG, "created obj");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    return result;

                }else{

                    // response problem
                    String errorMsg = "Check Google API key and Search Engine ID!";
                    result = errorMsg;
                    return  result;
                }
            } catch (IOException e) {
            }
            return null;
        }

        protected void onPostExecute(String result) {
            // hide progressbar
            progressBar.setVisibility(View.GONE);
            // make TextView scrollable
            resultTextView.setMovementMethod(new ScrollingMovementMethod());

            resultTextView.setText(result);


        }


    }

}
