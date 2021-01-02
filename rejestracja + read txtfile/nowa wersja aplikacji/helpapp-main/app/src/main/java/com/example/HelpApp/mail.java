package com.example.HelpApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

public class mail extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_stusus);

		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"testapp7040@gmail.com"});
		i.putExtra(Intent.EXTRA_SUBJECT, "Zgłoszenie nr 1234");
		i.putExtra(Intent.EXTRA_TEXT   , "Tu powinny zaciągać się elementy formatki z dane osoboboe z rejestracj, imię, nazwisko, telefon, ALARM bądź szkody ->jakiego typu, " +
				"lokalizacja położenia osoby zgłaszającej zdarzenie, audio/video jako załączniki oraz dodatkowe miejsce na notke/nietypową sytuację");
		try {
			startActivity(Intent.createChooser(i, "Wyślij zgłoszenie do CPR"));
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(mail.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}
}