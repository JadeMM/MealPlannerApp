package com.csci412.mealfinder;

import android.content.Context;
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

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class AddRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);


        final LinearLayout layout = (LinearLayout) findViewById(R.id.add_recipe_layout);

        final LinearLayout ingr1 = (LinearLayout) findViewById(R.id.ingredient_1_layout);
        final LinearLayout ingr2 = (LinearLayout) findViewById(R.id.ingredient_2_layout);
        ingr2.setVisibility(View.GONE);
        final LinearLayout ingr3 = (LinearLayout) findViewById(R.id.ingredient_3_layout);
        ingr3.setVisibility(View.GONE);
        final LinearLayout ingr4 = (LinearLayout) findViewById(R.id.ingredient_4_layout);
        ingr4.setVisibility(View.GONE);
        final LinearLayout ingr5 = (LinearLayout) findViewById(R.id.ingredient_5_layout);
        ingr5.setVisibility(View.GONE);

        Button addIngr = (Button) findViewById(R.id.new_ing_button);
        addIngr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(ingr2.getVisibility() == View.GONE) {
                    ingr2.setVisibility(View.VISIBLE);
                } else if (ingr3.getVisibility() == View.GONE){
                    ingr3.setVisibility(View.VISIBLE);
                } else if (ingr4.getVisibility() == View.GONE){
                    ingr4.setVisibility(View.VISIBLE);
                } else {
                    ingr5.setVisibility(View.VISIBLE);
                }
            }

        });


        final LinearLayout step1 = (LinearLayout) findViewById(R.id.step_1_layout);
        final LinearLayout step2 = (LinearLayout) findViewById(R.id.step_2_layout);
        step2.setVisibility(View.GONE);
        final LinearLayout step3 = (LinearLayout) findViewById(R.id.step_3_layout);
        step3.setVisibility(View.GONE);
        final LinearLayout step4 = (LinearLayout) findViewById(R.id.step_4_layout);
        step4.setVisibility(View.GONE);
        final LinearLayout step5 = (LinearLayout) findViewById(R.id.step_5_layout);
        step5.setVisibility(View.GONE);

        Button addStep = (Button) findViewById(R.id.new_instr_button);
        addStep.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(step2.getVisibility() == View.GONE) {
                        step2.setVisibility(View.VISIBLE);
                    } else if (step3.getVisibility() == View.GONE) {
                        step3.setVisibility(View.VISIBLE);
                    } else if (step4.getVisibility() == View.GONE) {
                        step4.setVisibility(View.VISIBLE);
                    } else {
                        step5.setVisibility(View.VISIBLE);
                    }
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
