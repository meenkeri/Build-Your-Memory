package com.android.shankar.pegging;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecallActivity extends Activity {
	private static final String CORRECT = "Correct!";
	private static final String WRONG = "Wrong!";
	private static final String EMPTY_MSG = "Please enter the word";
	private static final String EMPTY = "";
	private TextView textView;
	private EditText editText;
	private int j = 0;
	private String[] input;
	public int score = 0;
	private boolean wrong;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recall);
		textView = (TextView) findViewById(R.id.textView2);
		editText = (EditText) findViewById(R.id.editText1);
		textView.setText("1");
		Intent intent = getIntent();
		input = intent.getStringArrayExtra("input");
	}

	public void doSubmitButton(View view) {
		if (editText.getText().toString().length() == 0) {
			new AlertDialog.Builder(this).setTitle(EMPTY_MSG)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setPositiveButton(android.R.string.ok, null).show();
			return;
		}
		String word = editText.getText().toString();
		if (word.equals(input[j])) {
			j++;
			score++;
			Toast.makeText(this, CORRECT, Toast.LENGTH_SHORT).show();
			editText.setText(EMPTY);
			textView.setText(j + 1 + EMPTY);
			return;
		} else {
			if (wrong) {
				Toast.makeText(this, "That was " + WRONG, Toast.LENGTH_SHORT)
						.show();
				Toast.makeText(this,
						"The answer was " + "\"" + input[j] + "\"",
						Toast.LENGTH_SHORT).show();
				j++;
				editText.setText(EMPTY);
				textView.setText(j + 1 + EMPTY);
				wrong = false;
				return;
			}
			Toast.makeText(this, WRONG + "\n" + "Try again", Toast.LENGTH_SHORT)
					.show();
			wrong = true;
			editText.setText(EMPTY);
			return;
		}
	}
}