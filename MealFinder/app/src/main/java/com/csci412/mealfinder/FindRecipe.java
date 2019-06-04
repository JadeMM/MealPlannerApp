package com.csci412.mealfinder;



import android.net.Uri;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FindRecipe extends AppCompatActivity {
    final Bundle dataBundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_recipe);



        final EditText ing1 =  (EditText) findViewById(R.id.first_ingredient);
        final EditText ing2 = (EditText) findViewById(R.id.second_ingredient);
        final EditText ing3 = (EditText) findViewById(R.id.third_ingredient);
        final EditText ing4 = (EditText) findViewById(R.id.forth_ingredient);
        final EditText ing5 = (EditText) findViewById(R.id.fifth_ingredient);


        ing2.setVisibility(View.GONE);
        ing3.setVisibility(View.GONE);
        ing4.setVisibility(View.GONE);
        ing5.setVisibility(View.GONE);

        final Button add = (Button) findViewById(R.id.add_ingredient_button);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(ing2.getVisibility() == View.GONE) {
                    ing2.setVisibility(View.VISIBLE);
                } else if (ing3.getVisibility() == View.GONE){
                    ing3.setVisibility(View.VISIBLE);
                } else if (ing4.getVisibility() == View.GONE){
                    ing4.setVisibility(View.VISIBLE);
                } else {
                    ing5.setVisibility(View.VISIBLE);
                    add.setVisibility(View.GONE);
                }
            }

        });
        Button searchDB = (Button) findViewById(R.id.find_db_button);
        searchDB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dataBundle.putString("first", ing1.getText().toString());
                dataBundle.putString("second", ing2.getText().toString());
                dataBundle.putString("third", ing3.getText().toString());
                dataBundle.putString("fourth", ing4.getText().toString());
                dataBundle.putString("fifth", ing5.getText().toString());

                Intent intent = new Intent(getApplicationContext(),DBRecipes.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }

        });


            Button searchOnline = (Button)findViewById(R.id.find_button);
            searchOnline.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dataBundle.putString("first", ing1.getText().toString());
                    dataBundle.putString("second", ing2.getText().toString());
                    dataBundle.putString("third", ing3.getText().toString());
                    dataBundle.putString("fourth", ing4.getText().toString());
                    dataBundle.putString("fifth", ing5.getText().toString());

                    Intent myIntent = new Intent(getApplicationContext(), SearchRecipesOnline.class);
                    myIntent.putExtras(dataBundle);
                    startActivityForResult(myIntent, 0);
                }

            });








    }



}
