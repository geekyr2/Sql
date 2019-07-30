package com.example.pc.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    private EditText e1, e2, e3;
    private Button b;
    private Sql sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        sql = new Sql(this);
        e1 = findViewById(R.id.editText6);
        e2 = findViewById(R.id.editText7);
        e3 = findViewById(R.id.editText8);
        b = findViewById(R.id.button8);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!e1.getText().toString().isEmpty()) && (!e2.getText().toString().isEmpty()) && (!e3.getText().toString().isEmpty())) {
                    sql.update(e1.getText().toString(), e2.getText().toString(), e3.getText().toString());
                    Toast.makeText(Update.this, "Updated Successfully", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Update.this, "Enter data", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
