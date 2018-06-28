package com.component.zf.commmoncomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.leolin.shortcutbadger.ShortcutBadger;

public class ComponentMainActivity extends AppCompatActivity implements View.OnClickListener{
    private int badgeCount = 0;
    private TextView add_badge;
    private TextView delete_badge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        add_badge = findViewById(R.id.add_badge);
        delete_badge = findViewById(R.id.delete_badge);
        add_badge.setOnClickListener(this);
        delete_badge.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_badge:
                badgeCount =1+ badgeCount;
                add_badge.setText(badgeCount + "添加了");
                ShortcutBadger.applyCount(this, badgeCount);
                Toast.makeText(this, "添加了" + badgeCount, Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_badge:
                badgeCount = 0;
                ShortcutBadger.applyCount(this, badgeCount);
                delete_badge.setText(badgeCount + "删除了");
                Toast.makeText(this, "删除了" + badgeCount, Toast.LENGTH_SHORT).show();

                break;
        }

    }
}
