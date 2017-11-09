package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

@SuppressLint("Registered")
public class Detail extends AppCompatActivity{

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        ImageView detailimage = findViewById(R.id.detail_image);
        TextView detailname = findViewById(R.id.detail_name);
        TextView detailsex = findViewById(R.id.detail_sex);
        TextView detaildate = findViewById(R.id.detail_date);
        TextView detailorigo = findViewById(R.id.detail_origo);
        TextView detailarmy = findViewById(R.id.detail_army);
        TextView detailintroduction = findViewById(R.id.detail_introduction);
        ImageButton detailback = findViewById(R.id.back);

        int id = getIntent().getIntExtra("id", 0);
        Cursor cursor = MyDataBase.myDataBase.rawQuery(id);

        String image = cursor.getString(cursor.getColumnIndex("image"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String sex = cursor.getString(cursor.getColumnIndex("sex"));
        String birth = cursor.getString(cursor.getColumnIndex("birth"));
        String death = cursor.getString(cursor.getColumnIndex("death"));
        String origo = cursor.getString(cursor.getColumnIndex("origo"));
        String army = cursor.getString(cursor.getColumnIndex("army"));
        String introduction = cursor.getString(cursor.getColumnIndex("introduction"));

        detailimage.setImageURI(Uri.fromFile(new File(image)));
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
