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
        TextView detailjob = findViewById(R.id.detail_job);
        TextView detailsex = findViewById(R.id.detail_sex);
        TextView detaildate = findViewById(R.id.detail_date);
        TextView detailorigo = findViewById(R.id.detail_origo);
        TextView detailarmy = findViewById(R.id.detail_army);
        TextView detailintroduction = findViewById(R.id.detail_introduction);
        TextView detailstre = findViewById(R.id.detail_stre);
        TextView detailendu = findViewById(R.id.detail_endu);
        TextView detailagil = findViewById(R.id.detail_agil);
        TextView detailmagi = findViewById(R.id.detail_magi);
        TextView detailluck = findViewById(R.id.detail_luck);
        TextView detailskil = findViewById(R.id.detail_skil);
        ImageView detailstrelv = findViewById(R.id.detail_strelv);
        ImageView detailendulv = findViewById(R.id.detail_endulv);
        ImageView detailagillv = findViewById(R.id.detail_agillv);
        ImageView detailmagilv = findViewById(R.id.detail_magilv);
        ImageView detaillucklv = findViewById(R.id.detail_lucklv);
        ImageView detailskillv = findViewById(R.id.detail_skillv);
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
        String stre = getIntent().getStringExtra("stre");
        String endu = getIntent().getStringExtra("endu");
        String agil = getIntent().getStringExtra("agil");
        String magi = getIntent().getStringExtra("magi");
        String luck = getIntent().getStringExtra("luck");
        String skil = getIntent().getStringExtra("skil");

        if (birth.equals("0"))
            birth = "?";
        if (death.equals("0"))
            death = "?";

        detailimage.setImageResource(ImageGet.getImage(image));
        detailframe.setImageResource(ImageGet.getBigFrame(job));
        detailname.setText(name);
        detailjob.setText(job);
        detailsex.setText(sex);
        detaildate.setText(birth + "-" + death);
        detailorigo.setText(origo);
        detailarmy.setText(army);
        detailintroduction.setText(introduction);
        detailstre.setText(stre);
        detailendu.setText(endu);
        detailagil.setText(agil);
        detailmagi.setText(magi);
        detailluck.setText(luck);
        detailskil.setText(skil);
        detailstrelv.setImageResource(ImageGet.getLevelImage(stre));
        detailendulv.setImageResource(ImageGet.getLevelImage(endu));
        detailagillv.setImageResource(ImageGet.getLevelImage(agil));
        detailmagilv.setImageResource(ImageGet.getLevelImage(magi));
        detaillucklv.setImageResource(ImageGet.getLevelImage(luck));
        detailskillv.setImageResource(ImageGet.getLevelImage(skil));
        detailback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
