package com.ihfazh.intentwithparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        ArrayList<Account> accounts = intent.getParcelableArrayListExtra(EXTRA_PERSON);

        StringBuilder stringBuilder = new StringBuilder();

        for (Account account :
                accounts) {
            stringBuilder.append("Nama: " + account.getNama() + "\n" + "Email: " + account.getEmail() + "\n" + "Password: " + account.getPassword() + "\n\n");
        }

        String text = stringBuilder.toString();

        result = findViewById(R.id.text_result);
        result.setText(text);
    }
}