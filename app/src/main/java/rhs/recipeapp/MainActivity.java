package rhs.recipeapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button); //creates the button to continue to the next activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

        // Create new helper
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        // Get the database. If it does not exist, this is where it will
        // also be created.
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_RECIPE_NAME.recipeName);
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_TIMES.times);
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_NUM_SERVINGS.numServings);
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_INGREDIENTS.ingredients);
        values.put(DatabaseContract.MyRecipes.COLUMN_NAME_INSTRUCTIONS.instructions);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DatabaseContract.MyRecipes.TABLE_NAME, null, values);
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);

    }




    //Is Github actually working?!
    //Is github working for Rachel?!
}
