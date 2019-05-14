package com.csci412.mealfinder;

import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.*;
import android.view.View;
import android.content.Intent;

public class AddRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.add_recipe_layout);
        final LinearLayout newlayout = new LinearLayout(this);
        final EditText editText = new EditText(this);

        Button addIngr = (Button) findViewById(R.id.new_ing_button);
        addIngr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                /*newlayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                editText.setHint("Ingredient");
                editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                editText.setPadding(20, 20, 20, 20);

                // Add EditText to LinearLayout
                if (linearLayout != null) {
                    linearLayout.addView(editText);
                }*/

            }

        });

        Button save = (Button) findViewById(R.id.save_recipe_button);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });
    }
}
