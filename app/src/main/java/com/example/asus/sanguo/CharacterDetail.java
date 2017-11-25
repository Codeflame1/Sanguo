package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CharacterDetail extends AppCompatActivity{


    private CharacterSkillListViewAdapter sadapter;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characterdetail);

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
        ListView skillList = findViewById(R.id.detail_skilllist);
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

        List<Map<String, Object>> data = getSkillListData(name);
        sadapter = new CharacterSkillListViewAdapter(this, data);

        skillList.setAdapter(sadapter);
        setListViewHeightBasedOnChildren(skillList);
        sadapter.notifyDataSetChanged();

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

    private List<Map<String, Object>> getSkillListData(String s) {
        List<Map<String, Object>> slist = new ArrayList<>();
        Cursor query = SkillDataBase.getInstances(CharacterDetail.this).query();
        /*
        游标cursor默认是在-1的位置,query.moveToFirst()将游标移动到第一行,如果不写这个就会报
         Caused by: android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 12
         这个问题坑爹,以后一定要注意
         */
        if (query.moveToFirst()) {
            do {
                String owner = query.getString(query.getColumnIndex("owner"));
                String type = query.getString(query.getColumnIndex("type"));
                String name = query.getString(query.getColumnIndex("name"));
                String level = query.getString(query.getColumnIndex("level"));
                String introduction = query.getString(query.getColumnIndex("introduction"));
                int id = query.getInt(query.getColumnIndex("id"));
                Map<String, Object> map = new HashMap<>();


                if (s.equals(owner)) {
                    map.put("id", id);
                    map.put("owner", owner);
                    map.put("type", type);
                    map.put("name", name);
                    map.put("level", level);
                    map.put("introduction", introduction);
                    slist.add(map);
                }

            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return slist;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        //获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {   //listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);  //计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight();  //统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        //listView.getDividerHeight()获取子项间分隔符占用的高度
        //params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            List<Map<String, Object>> data1 = getSkillListData("");
//            cadapter = new CharacterListViewAdapter(this, data1);
//            mCharacterList.setAdapter(cadapter);
            sadapter.refreshList(data1);

        }
    }
}
