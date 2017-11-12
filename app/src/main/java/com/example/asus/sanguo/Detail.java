package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressLint("Registered")
public class Detail extends AppCompatActivity{

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        ImageView detailimage = findViewById(R.id.detail_image);
        ImageView detailframe = findViewById(R.id.detail_imageframe);
        TextView detailname = findViewById(R.id.detail_name);
        TextView detailsex = findViewById(R.id.detail_sex);
        TextView detaildate = findViewById(R.id.detail_date);
        TextView detailorigo = findViewById(R.id.detail_origo);
        TextView detailarmy = findViewById(R.id.detail_army);
        TextView detailintroduction = findViewById(R.id.detail_introduction);
        ImageButton detailback = findViewById(R.id.back);

        String name = getIntent().getStringExtra("name");
        String job = getIntent().getStringExtra("job");
        String sex = getIntent().getStringExtra("sex");
        String birth = getIntent().getStringExtra("birth");
        String death = getIntent().getStringExtra("death");
        String origo = getIntent().getStringExtra("origo");
        String army = getIntent().getStringExtra("army");
        String introduction = getIntent().getStringExtra("introduction");
        String image = getIntent().getStringExtra("image");

        detailimage.setImageResource(ImageGet.getImage(image));
        detailframe.setImageResource(ImageGet.getBigFrame(job));
        detailname.setText(name);
        detailsex.setText(sex);
        detaildate.setText(birth + "-" + death);
        detailorigo.setText(origo);
        detailarmy.setText(army);
        detailintroduction.setText(introduction);
        detailback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
