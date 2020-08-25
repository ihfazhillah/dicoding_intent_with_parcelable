package com.ihfazh.intentwithparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Account account = intent.getParcelableExtra(EXTRA_PERSON);
        String text = "Nama: " + account.getNama() + "\n" + "Email: " + account.getEmail() + "\n" + "Password: " + account.getPassword();

        result = findViewById(R.id.text_result);
        result.setText(text);
    }
}