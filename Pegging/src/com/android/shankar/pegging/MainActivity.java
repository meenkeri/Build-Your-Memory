package com.android.shankar.pegging;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] rowNames = {"Play", "High Score", "Instructions", "Quit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rowNames);
        setListAdapter(adapter);
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id){
    	switch (position) {
		case 0:
			Intent intent = new Intent(this, PlayActivity.class);
			startActivity(intent);
			return;

		case 1:
		//TODO - High Score
			return;
			
		case 2:
		// TODO - Instructions
			return;
			
		case 3: 
			finish();
			return;
		}
    }
}