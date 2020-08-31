package com.tanzim.userloginregistration;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeScreenActivity extends AppCompatActivity {
    TextView textView;

    Button buttonLogout;

    ListView userList;

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        sqliteHelper = new SqliteHelper(this);
        ArrayList<HashMap<String, String>> userData = sqliteHelper.GetUsers();
        ListAdapter adapter = new SimpleAdapter(HomeScreenActivity.this,
                userData, R.layout.activity_list_user,new String[]{"userName","email","today"},
                new int[]{R.id.userName, R.id.email, R.id.today});
        userList.setAdapter(adapter);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //User Logged out Successfully redirect to login page
                Intent intent=new Intent(HomeScreenActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initViews() {
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        textView = (TextView) findViewById(R.id.textView2);
        userList = (ListView) findViewById(R.id.userList);
    }
}
