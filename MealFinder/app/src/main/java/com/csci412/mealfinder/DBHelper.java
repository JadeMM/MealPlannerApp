package com.csci412.mealfinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RecipeDB.db";
    public static final String RECIPE_TABLE_NAME = "recipes";
    public static final String RECIPE_COLUMN_ID = "id";
    public static final String RECIPE_COLUMN_NAME = "name";
    public static final String RECIPE_COLUMN_AMOUNT_1 = "amount1";
    public static final String RECIPE_COLUMN_AMOUNT_2 = "amount2";
    public static final String RECIPE_COLUMN_AMOUNT_3 = "amount3";
    public static final String RECIPE_COLUMN_AMOUNT_4 = "amount4";
    public static final String RECIPE_COLUMN_AMOUNT_5 = "amount5";
    public static final String RECIPE_COLUMN_ING_1 = "ing1";
    public static final String RECIPE_COLUMN_ING_2 = "ing2";
    public static final String RECIPE_COLUMN_ING_3 = "ing3";
    public static final String RECIPE_COLUMN_ING_4 = "ing4";
    public static final String RECIPE_COLUMN_ING_5 = "ing5";
    public static final String RECIPE_COLUMN_STEP_1 = "step1";
    public static final String RECIPE_COLUMN_STEP_2 = "step2";
    public static final String RECIPE_COLUMN_STEP_3 = "step3";
    public static final String RECIPE_COLUMN_STEP_4 = "step4";
    public static final String RECIPE_COLUMN_STEP_5 = "step5";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table recipes " +
                        "(id integer primary key, name text, amount1 text, amount2 text, amount3 text, amount4 text, amount5 text," +
                        "ing1 text, ing2 text, ing3 text, ing4 text, ing5 text," +
                        " step1 text, step2 text, step3 text, step4 text, step5 text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS recipes");
        onCreate(db);
    }

    public boolean insertRecipe (String name, String ing1, String ing2, String ing3, String ing4, String ing5,
            String amount1, String amount2, String amount3, String amount4, String amount5,
            String step1, String step2, String step3, String step4, String step5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);

        if(amount1 != " ") {
            contentValues.put("amount1", amount1);
        } else {
            contentValues.putNull("amount1");
        }
        if(amount2 != " ") {
            contentValues.put("amount2", amount2);
        } else {
            contentValues.putNull("amount2");
        }
        if(amount3 != " ") {
            contentValues.put("amount3", amount3);
        } else {
            contentValues.putNull("amount3");
        }
        if(amount4 != " ") {
            contentValues.put("amount4", amount4);
        } else {
            contentValues.putNull("amount4");
        }
        if(amount5 != " ") {
            contentValues.put("amount5", amount5);
        } else {
            contentValues.putNull("amount5");
        }

        if(ing1 != " ")
            contentValues.put("ing1", ing1);
        else
            contentValues.putNull("ing1");

        if(ing2 != " ")
            contentValues.put("ing2", ing2);
        else
            contentValues.putNull("ing2");

        if(ing3 != " ")
            contentValues.put("ing3", ing3);
        else
            contentValues.putNull("ing3");

        if(ing4 != " ")
            contentValues.put("ing4", ing4);
        else
            contentValues.putNull("ing4");

        if(ing5 != " ")
            contentValues.put("ing5", ing5);
        else
            contentValues.putNull("ing5");

        if(step1 != " ")
            contentValues.put("step1", step1);
        else
            contentValues.putNull("step1");

        if(step2 != " ")
            contentValues.put("step2", step2);
        else
            contentValues.putNull("step2");

        if(step3 != " ")
            contentValues.put("step3", step3);
        else
            contentValues.putNull("step3");

        if(step4 != " ")
            contentValues.put("step4", step4);
        else
            contentValues.putNull("step4");

        if(step5 != " ")
            contentValues.put("step5", step5);
        else
            contentValues.putNull("step5");

        db.insert("recipes", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from recipes where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, RECIPE_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String ing1, String ing2, String ing3, String ing4, String ing5,
                                  String amount1, String amount2, String amount3, String amount4, String amount5,
                                  String step1, String step2, String step3, String step4, String step5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("amount1", amount1);
        contentValues.put("amount2", amount2);
        contentValues.put("amount3", amount3);
        contentValues.put("amount4", amount4);
        contentValues.put("amount5", amount5);
        contentValues.put("ing1", ing1);
        contentValues.put("ing1", ing2);
        contentValues.put("ing1", ing3);
        contentValues.put("ing1", ing4);
        contentValues.put("ing1", ing5);
        contentValues.put("step1", step1);
        contentValues.put("step2", step2);
        contentValues.put("step3", step3);
        contentValues.put("step4", step4);
        contentValues.put("step5", step5);
        db.update("recipes", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("recipes",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from recipes", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(RECIPE_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
