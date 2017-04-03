package com.example.hetal13.recycler_card_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_Details extends AppCompatActivity {
ImageView imageView;
    TextView name,email,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact__details);
        imageView=(ImageView) findViewById(R.id.detail_image);
        name=(TextView)findViewById(R.id.detail_name);
        email=(TextView)findViewById(R.id.detail_email);
        mobile=(TextView)findViewById(R.id.detail_mobile);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        name.setText("Name:"+getIntent().getStringExtra("name"));
        email.setText("Email:"+getIntent().getStringExtra("email"));
        mobile.setText("Mobile:"+getIntent().getStringExtra("mobile"));
        Log.v("here","second");


    }
}
