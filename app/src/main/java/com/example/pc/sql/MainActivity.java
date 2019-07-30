
package com.example.pc.sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Sql sql;
    private Button buttonSearch, buttonAdd, buttonDel, buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sql = new Sql(this);
        buttonAdd = findViewById(R.id.b1);
        buttonSearch = (Button) findViewById(R.id.b2);
        buttonUpdate = findViewById(R.id.b3);
        buttonDel = findViewById(R.id.b4);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Update.class);
                startActivity(intent);
            }
        });
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Delete.class);
                startActivity(intent);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                startActivity(intent);

            }
        });
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Search.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onDestroy() {
        sql.close();
        super.onDestroy();
    }
}
