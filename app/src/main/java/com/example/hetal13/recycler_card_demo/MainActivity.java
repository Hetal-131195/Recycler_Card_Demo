package com.example.hetal13.recycler_card_demo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView.LayoutManager layoutManager;
    int[] img_id={R.drawable.hetal,R.drawable.bhoomi,R.drawable.aditi,R.drawable.meghna,R.drawable.nidhi,R.drawable.mayuree};
    String[] name,email,mobile;
    Handler handler = new Handler();
    ArrayList<Contact> arrayList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);
        name=getResources().getStringArray(R.array.person_name);
        email=getResources().getStringArray(R.array.person_email);
        mobile=getResources().getStringArray(R.array.person_contact);
        int i =0;
        for(String pname : name){
            Contact contact = new Contact(img_id[i],pname,email[i],mobile[i]);
            arrayList.add(contact);
            i++;
            Log.v("here ","Mainactivity");
        }
        adapter = new ContactAdapter(MainActivity.this,arrayList);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                for(int i=0;i<4;i++) {
                    if(i==3) {
                        refreshContent();
                        mSwipeRefreshLayout.setRefreshing(false);

                    }
                }

            }
        });
        }

    private void refreshContent(){
        Toast.makeText(getApplicationContext(),"Called...",Toast.LENGTH_LONG).show();
        startActivity(getIntent());
       /* handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                mSwipeRefreshLayout.setRefreshing(false);


            }
        },4000);
*/
        }
    }

