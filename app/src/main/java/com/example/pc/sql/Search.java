package com.example.pc.sql;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView t1, t2;
    private Sql sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        sql = new Sql(this);
        editText = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button5);
        t1 = (TextView) findViewById(R.id.textView4);
        t2 = (TextView) findViewById(R.id.textView5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    Cursor c = sql.search(Integer.parseInt(editText.getText().toString()));
                    while (c.moveToNext()) {
                        t1.setText("Name is: " + c.getString(1));
                        t2.setText("Email is: " + c.getString(3));
                    }
                }
                else {
                    Toast.makeText(Search.this, "Enter Number", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
