package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressLint("Registered")
public class SkillDetail extends AppCompatActivity{

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skilldetail);

        TextView detailname = findViewById(R.id.skilldetail_name);
        TextView detailtype = findViewById(R.id.skilldetail_type);
        TextView detaillevel = findViewById(R.id.skilldetail_level);
        TextView detailintroduction = findViewById(R.id.skilldetail_introduction);
        ImageView detaillevellv = findViewById(R.id.skilldetail_levellv);
        ImageButton detailback = findViewById(R.id.skillback);

        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String level = getIntent().getStringExtra("level");
        String introduction = getIntent().getStringExtra("introduction");
        detailname.setText(name);
        detailtype.setText(type);
        detaillevel.setText(level);
        detailintroduction.setText(introduction);
        detaillevellv.setImageResource(ImageGet.getLevelImage(level));
        detailback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
