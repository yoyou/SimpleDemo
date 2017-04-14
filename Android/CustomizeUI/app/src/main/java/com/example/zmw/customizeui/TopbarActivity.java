package com.example.zmw.customizeui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zmw.topbar.Topbar;

public class TopbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topbar);

        Topbar topbar = (Topbar) findViewById(R.id.topbar);

        topbar.setTopbarlisten(new Topbar.Topbarlisten() {
            @Override
            public void left() {
                Toast.makeText(TopbarActivity.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void right() {
                Toast.makeText(TopbarActivity.this,"right",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
