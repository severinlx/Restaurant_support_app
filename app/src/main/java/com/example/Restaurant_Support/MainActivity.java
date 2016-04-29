package com.example.Restaurant_Support;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        fillData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void fillData () {

        //check if database allready exist

        Cursor cont = getContentResolver().query(Uri.parse("content://com.example.Restaurant_Support.MyProvider/cte"), null, null, null, null);
        if (cont.moveToNext()) {	// expect 001 row(s)
            Toast.makeText(this, "Menu support App has already been initialized, please go to UI app for Menu", Toast.LENGTH_LONG).show();
            return;
        }

        //if it doesn exist:

         else {

            //fill JSON strings in Content Providers database

            ContentValues values = new ContentValues();
            values.put(MyProvider.name, "{\"id\" : \"1\", \"name\":\"main food 1\", \"price\": \"30 eu\", \"type\": \"main\"}");
            Uri uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"2\", \"name\":\"main food 2\", \"price\": \"30 eu\", \"type\": \"main\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"3\", \"name\":\"main food 3\", \"price\": \"30 eu\", \"type\": \"main\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"4\", \"name\":\"appetizer 1\", \"price\": \"20 eu\", \"type\": \"appetizer\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"5\", \"name\":\"appetizer 2\", \"price\": \"20 eu\", \"type\": \"appetizer\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"6\", \"name\":\"appetizer 3\", \"price\": \"10 eu\", \"type\": \"appetizer\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"7\", \"name\":\"drink 1\", \"price\": \"5 eu\", \"type\": \"drink\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"8\", \"name\":\"drink 2\", \"price\": \"6 eu\", \"type\": \"drink\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
            values.put(MyProvider.name, "{\"id\" : \"9\", \"name\":\"drink 3\", \"price\": \"7 eu\", \"type\": \"drink\"}");
            uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);


            Toast.makeText(getBaseContext(), "App has been initialized, please open now  UI Restaurant Menu to see Menu", Toast.LENGTH_LONG)
                    .show();
        }

	}
}
