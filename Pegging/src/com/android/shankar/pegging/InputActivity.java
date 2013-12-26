package com.android.shankar.pegging;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InputActivity extends Activity {
	private static final String EMPTY = "";
	private static final String ALERT_MSG = "Let's recall those words to test your memory";
	private TextView textView;
	int i = 0;
	int n;
	String[] input = new String[100];
	String[] words = { "Bag", "Computer", "Tube", "Book", "Wood", "Plug",
			"Wire", "Sofa", "Water", "Pencil", "Light", "Window", "Cover",
			"Water", "Paper", "Pen", "Clock", "Carpet", "Shirt", "Door", "Car",
			"Bus", "Road", "Sand", "Paint", "Alarm", "Ball", "Cat", "Pot",
			"Potato", "Lime", "Tree", "Fruit", "School", "Parrot", "Table",
			"Carrot", "Spoon", "Peacock", "Pink", "Red", "Road", "White",
			"Flag", "Fan", "Sheep", "Shadow", "Belt", "Tent", "Basket",
			"Brochure", "Bottle", "Laptop", "Tap", "Heater", "Bridge", "Snow",
			"Speaker", "Board", "Counter", "Fence", "Face", "Fish", "Boat",
			"Aeroplane", "Bed", "Sheet", "Cooler", "Grass", "Fountain", "Sky",
			"Can", "Milk", "Money", "Mike", "Dog", "Danger", "Apple", "Ant",
			"Desk", "Chair", "Truck", "Bike", "Mobile", "Pillow",
			"CompactDisk", "Camara", "Ticket", "Ring", "Tiger", "Dog",
			"Microchip", "Zebra", "Charger", "Mirror", "Mint", "Pizza",
			"Machine", "Screen", "Button", "Bat" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView = (TextView) findViewById(R.id.textView1);
		Intent intent = getIntent();
		n = intent.getIntExtra("no", n);
	}

	public void doNext(View view) {
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		input[i] = words[randomNumber];
		textView.setText(++i + " - " + words[randomNumber]);
		if (i == n + 1) {
			textView.setText(EMPTY);
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setTitle(ALERT_MSG);
			alert.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							recall();
						}
					});
			alert.show();
			return;
		}
	}

	private void recall() {
		Intent intent = new Intent(this, RecallActivity.class);
		intent.putExtra("input", input);
		startActivity(intent);
	}
}
