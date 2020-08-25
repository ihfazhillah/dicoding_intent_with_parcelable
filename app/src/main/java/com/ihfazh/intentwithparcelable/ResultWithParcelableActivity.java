package com.ihfazh.intentwithparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultWithParcelableActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 112;
    public static final String ACCOUNT_EXTRA = "Account Extra";
    private EditText name, email, password;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_with_parcelable);

        name = findViewById(R.id.edt_nama);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        save = findViewById(R.id.btn_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account account = new Account();
                account.setNama(name.getText().toString());
                account.setPassword(password.getText().toString());
                account.setEmail(email.getText().toString());

                Intent intent;
                intent = new Intent();
                intent.putExtra(ACCOUNT_EXTRA, account);

                setResult(RESULT_CODE, intent);
                finish();
            }
        });
    }
}