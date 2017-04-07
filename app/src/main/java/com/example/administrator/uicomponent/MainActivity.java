package com.example.administrator.uicomponent;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.uicomponent.R;
import com.example.administrator.uicomponent.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView menuTest;

    Button list;
    Button dialog;
    Button action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        menuTest = (TextView) findViewById(R.id.menu_test);


        list = (Button) findViewById(R.id.listbtn);
        list.setOnClickListener(this);
        dialog = (Button) findViewById(R.id.dialogbtn);
        dialog.setOnClickListener(this);
        action = (Button) findViewById(R.id.actionbtn);
        action.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()){
            item.setChecked(true);
        }
        switch (item.getItemId()){
            case R.id.main_size10:
                menuTest.setTextSize(10 * 2);
                break;
            case R.id.main_size16:
                menuTest.setTextSize(16 * 2);
                break;
            case R.id.main_size20:
                menuTest.setTextSize(20 * 2);
                break;
            case R.id.main_red:
                menuTest.setTextColor(Color.RED);
                break;
            case R.id.main_black:
                menuTest.setTextColor(Color.BLACK);
                break;
            case R.id.main_normal:
                Toast.makeText(this,"你点击了普通菜单项",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.listbtn:
                overlay(ListActivity.class);
                break;
            case R.id.dialogbtn:
                LoginDialog login = new LoginDialog(this);
                login.show();
                break;
            case R.id.actionbtn:
                overlay(ActionActivity.class);
                break;
        }
    }

    /**
     * 覆盖
     */
    public void overlay(Class<?> classObj) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClass(this, classObj);
        startActivity(intent);
    }
}