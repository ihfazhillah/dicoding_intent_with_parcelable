package com.ihfazh.intentwithparcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 100;
    private EditText name, email, password;
    private Button save, getForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edt_nama);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        save = findViewById(R.id.btn_save);


        save.setOnClickListener(this);

        getForResult = findViewById(R.id.btn_get_result_from_child);
        getForResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save){
            // start new activity with parcelable here
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);

            int count = 0;

            ArrayList<Account> accounts = new ArrayList<>();

            while (true){
                if (count == 5){
                    break;
                }

                Account account = new Account();
                account.setEmail(email.getText().toString());
                account.setPassword(password.getText().toString());
                account.setNama(name.getText().toString());

                accounts.add(account);

                count += 1;
            }


//            intent.putExtra(DetailActivity.EXTRA_PERSON, account);
            intent.putParcelableArrayListExtra(DetailActivity.EXTRA_PERSON, accounts);

            startActivity(intent);
        } else if (view.getId() == R.id.btn_get_result_from_child){
            Intent intent = new Intent(MainActivity.this, ResultWithParcelableActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE & resultCode == ResultWithParcelableActivity.RESULT_CODE){
            if (data != null){
                Account account = data.getParcelableExtra(ResultWithParcelableActivity.ACCOUNT_EXTRA);
                name.setText(account.getNama());
                email.setText(account.getEmail());
                password.setText(account.getPassword());
            }
        }
    }
}