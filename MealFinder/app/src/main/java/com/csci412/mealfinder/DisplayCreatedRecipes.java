package com.csci412.mealfinder;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.widget.TextView;

import static android.view.View.GONE;

public class DisplayCreatedRecipes extends Activity {
    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb;

    TextView name ;
    TextView ing1;
    TextView ing2;
    TextView ing3;
    TextView ing4;
    TextView ing5;
    TextView step1;
    TextView step2;
    TextView step3;
    TextView step4;
    TextView step5;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_created_recipes);
        name = (TextView) findViewById(R.id.editTextName);
        ing1 = (TextView) findViewById(R.id.editTextIng1);
        ing2 = (TextView) findViewById(R.id.editTextIng2);
        ing3 = (TextView) findViewById(R.id.editTextIng3);
        ing4 = (TextView) findViewById(R.id.editTextIng4);
        ing5 = (TextView) findViewById(R.id.editTextIng5);
        step1 = (TextView) findViewById(R.id.editTextStep1);
        step2 = (TextView) findViewById(R.id.editTextStep2);
        step3 = (TextView) findViewById(R.id.editTextStep3);
        step4 = (TextView) findViewById(R.id.editTextStep4);
        step5 = (TextView) findViewById(R.id.editTextStep5);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String nam = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_NAME));
                String amou1 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_AMOUNT_1));
                String amou2 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_AMOUNT_2));
                String amou3 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_AMOUNT_3));
                String amou4 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_AMOUNT_4));
                String amou5 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_AMOUNT_5));
                String ingr1 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_ING_1));
                String ingr2 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_ING_2));
                String ingr3 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_ING_3));
                String ingr4 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_ING_4));
                String ingr5 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_ING_5));
                String ste1 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_STEP_1));
                String ste2 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_STEP_2));
                String ste3 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_STEP_3));
                String ste4 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_STEP_4));
                String ste5 = rs.getString(rs.getColumnIndex(DBHelper.RECIPE_COLUMN_STEP_5));

                if (!rs.isClosed())  {
                    rs.close();
                }

                name.setText((CharSequence)nam);
                name.setFocusable(false);
                name.setClickable(false);

                ing1.setText((CharSequence)(amou1 + " "  + ingr1));
                ing1.setFocusable(false);
                ing1.setClickable(false);

                ing2.setText((CharSequence)(amou2 + " "  + ingr2));
                ing2.setFocusable(false);
                ing2.setClickable(false);

                ing3.setText((CharSequence)(amou3 + " "  + ingr3));
                ing3.setFocusable(false);
                ing3.setClickable(false);

                ing4.setText((CharSequence)(amou4 + " "  + ingr4));
                ing4.setFocusable(false);
                ing4.setClickable(false);

                ing5.setText((CharSequence)(amou5 + " "  + ingr5));
                ing5.setFocusable(false);
                ing5.setClickable(false);

                step1.setText((CharSequence)ste1);
                step1.setFocusable(false);
                step1.setClickable(false);

                step2.setText((CharSequence)ste2);
                step2.setFocusable(false);
                step2.setClickable(false);

                step3.setText((CharSequence)ste3);
                step3.setFocusable(false);
                step3.setClickable(false);

                step4.setText((CharSequence)ste4);
                step4.setFocusable(false);
                step4.setClickable(false);

                step5.setText((CharSequence) ste5);
                step5.setFocusable(false);
                step5.setClickable(false);
            }
        }
    }

    /* @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.display_contact, menu);
            } else{
                getMenuInflater().inflate(R.menu.menu_main menu);
            }
        }
        return true;
    }*/

    /*public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.Edit_Contact:
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);

                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);

                street.setEnabled(true);
                street.setFocusableInTouchMode(true);
                street.setClickable(true);

                place.setEnabled(true);
                place.setFocusableInTouchMode(true);
                place.setClickable(true);

                return true;
            case R.id.Delete_Contact:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteContact(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });

                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }*/
}
