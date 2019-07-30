package com.example.pc.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {
    private EditText e1, e2, e3;
    private Button b1;
    private Sql sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sql = new Sql(this);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((!e1.getText().toString().isEmpty()) && (!e2.getText().toString().isEmpty()) && (!e3.getText().toString().isEmpty())) {
                    //  boolean result =
                    sql.insertData(e1.getText().toString(), Integer.parseInt(e2.getText().toString()), e3.getText().toString());
                    Toast.makeText(Add.this, "Added Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Add.this, "Enter data", Toast.LENGTH_LONG).show();

                }//
//                if (result) {
//                    Toast.makeText(Add.this, "data inserted", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(Add.this, "Error", Toast.LENGTH_LONG).show();
//
//                }
            }


        });

    }
}
