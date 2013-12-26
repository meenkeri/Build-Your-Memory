package com.android.shankar.pegging;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PlayActivity extends ListActivity {

	TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = (TextView) findViewById(R.id.textView1);
		String[] rowNames = { "10 Words", "20 Words", "40 Words", "60 Words",
				"80 Words", "100 Words" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, rowNames);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		int n;
		switch (position) {
		case 0:
			n = 10;
			play(n);
			return;
		case 1:
			n = 20;
			play(n);
			return;
		case 2:
			n = 40;
			play(n);
			return;
		case 3:
			n = 60;
			play(n);
			return;
		case 4:
			n = 80;
			play(n);
			return;
		case 5:
			n = 100;
			play(n);
			return;
		}
		super.onListItemClick(l, v, position, id);
	}

	private void play(int n) {
		Intent intent = new Intent(this, InputActivity.class);
		intent.putExtra("no", n);
		startActivity(intent);
	}

}
