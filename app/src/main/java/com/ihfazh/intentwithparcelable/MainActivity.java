package com.ihfazh.intentwithparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, email, password;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edt_nama);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        save = findViewById(R.id.btn_save);


        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save){
            // start new activity with parcelable here
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);

            Account account = new Account();
            account.setEmail(email.getText().toString());
            account.setPassword(password.getText().toString());
            account.setNama(name.getText().toString());

            intent.putExtra(DetailActivity.EXTRA_PERSON, account);

            startActivity(intent);
        }
    }
}