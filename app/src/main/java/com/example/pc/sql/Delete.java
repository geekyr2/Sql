package com.example.pc.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private Sql sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        sql = new Sql(this);
        button = findViewById(R.id.button7);
        editText = findViewById(R.id.editText5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    sql.delete(Integer.parseInt(editText.getText().toString()));
                    Toast.makeText(Delete.this, "Deleted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Delete.this, "Enter Number", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
