package com.example.asus.sanguo;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<Map<String, Object>> clist;
    private List<Map<String, Object>> slist;
    private CharacterListViewAdapter cadapter;
    private SkillListViewAdapter sadapter;
    private ListView mCharacterList;
    private ListView mSkillList;
    private Button CSChange;
    private Button mCharacterListAdd;
    private Button mLittletest;
    private ImageButton searchButton;
    private EditText msearch;
    private AlertDialog mcdialog;
    private AlertDialog msdialog;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCharacterList = findViewById(R.id.characterlist);
        mSkillList = findViewById(R.id.skilllist);
        mCharacterListAdd = findViewById(R.id.characterlistadd);
        mLittletest = findViewById(R.id.littletestgoto);
        CSChange = findViewById(R.id.characterskillchange);
        TextInputLayout characterlistsearch = findViewById(R.id.characterlistsearch);
        searchButton = findViewById(R.id.characterlistsearchButton);
        msearch = characterlistsearch.getEditText();
        if (CharacterDataBase.getInstances(MainActivity.this).query().getCount() == 0){
            CharacterDataBase.getInstances(MainActivity.this).insert("zhaoyun", "赵云(子龙)","lancer","男","158","228","常山真定","蜀汉","    身长八尺，姿颜雄伟，蜀汉五虎上将之一。\n    汉末军阀混战，赵云受本郡推举，率领义从加入白马将军公孙瓒。期间结识了汉室皇亲刘备，但不久之后，因为兄长去世而离开。赵云离开公孙瓒大约七年左右的时间，在邺城与刘备相见，从此追随刘备。","A","B","A+","A","EX","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("sunshangxiang", "孙尚香","archer","女","0","0","吴郡富春","吴","    孙夫人，乃孙权之妹，名曰孙仁。刘备向东吴借荆州不还，周瑜上书孙权，教使“美人计”，进妹予刘备为夫人，不料在诸葛亮的锦囊妙计安排下，假婚成真姻；后来夫人更助刘备返蜀，于路上怒斥追袭的吴将。后刘备入益州，孙权闻知刘备西征，遣周善引领舟船以迎孙夫人，而夫人带着后主刘禅回吴，幸得赵云与张飞勒兵截江，方重夺刘禅。\n    彝陵之战，刘备战败，有讹言传入吴中，道刘备已死，孙夫人伤心不已，望西痛哭，投江而死。后人为其立庙，号曰“枭姬祠”。","C","D","A+","C","A++","B");
            CharacterDataBase.getInstances(MainActivity.this).insert("huangyueying", "黄月英","caster","女","0","0","沔南白水","蜀汉","    黄承彦之女,有传闻说她容貌甚丑却知识广博。也有传闻说其极美，故意令黄承彦提亲时说自己貌丑以试探孔明心意。\n  黄月英十分擅长机关术，曾制木虎、木犬、木人等物，无需人力操控即可自动。诸葛亮发明木牛流马，据说也是从黄月英的传授的技巧上发展出来的。","E","D","D","A++","A","A+");
            CharacterDataBase.getInstances(MainActivity.this).insert("caiwenji", "蔡琰(文姬)","caster","女","0","0","陈留圉县","魏","    东汉大文学家蔡邕的女儿。初嫁于卫仲道，丈夫死去而回到自己家里，后值因匈奴入侵，蔡琰被匈奴左贤王掳走，嫁给匈奴人，并生育了两个孩子。十二年后，曹操统一北方，用重金将蔡琰赎回，并将其嫁给董祀。","E","C","E","B","E","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("diaochan", "貂蝉","assassin","女","0","0","未知","群","    中国古代四大美女之一，因遭十常侍之乱，避难出宫，为司徒王允收留为歌女。董卓祸乱朝纲，残忍暴戾，貂蝉挺身而出离间董卓和他的义子吕布，最终铲除了权倾一时的董卓。","D","D","B","B","A+","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("zhenfu", "甄宓","caster","女","183","221","中山无极","魏","    文昭甄皇后，上蔡令甄逸之女。魏文帝曹丕的正室，魏明帝曹叡的生母。初嫁与袁熙，袁氏败亡后，被曹丕纳为己有。\n    甄氏风华绝代，曹植以《洛神赋》赞之。","D","C","C","EX","C","A");
            CharacterDataBase.getInstances(MainActivity.this).insert("caocao", "曹操(孟德)","saber","男","155","220","沛国谯县","魏","    东汉末年，曹操以汉天子的名义征讨四方，统一了中国北方，并实行一系列政策恢复经济生产和社会秩序，使中原社会渐趋稳定、经济出现转机。 \n    精通兵法，重贤爱才，诗歌气魄雄伟，慷慨悲凉；散文亦清峻整洁，开启并繁荣了建安文学。","C","C","D","C","A++","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("lvbu", "吕布(奉先)","berserker","男","0","198","五原九原","群","    原为丁原部将，被唆使杀害丁原归附董卓，与董卓誓为父子，后又被司徒王允唆使诛杀董卓。 兴平元年，吕布趁曹操攻打陶谦时与陈宫等叛乱，先后击败刘备与夏侯惇。曹操亲自出马征讨吕布，水淹下邳，吕布被部下叛变，城破被俘，被处死。\n    历史上吕布以勇武闻名，号称“飞将”，时有“人中吕布，马中赤兔”之说。","A+","A+","A","C","C","A+");
            CharacterDataBase.getInstances(MainActivity.this).insert("zhugeliang", "诸葛亮(孔明)","caster","男","181","234","琅琊阳都","蜀汉","    早年随叔父诸葛玄到荆州，诸葛玄死后，诸葛亮就在隆中耕种。后刘备三顾茅庐请出，辅佐刘备建立蜀汉。蜀汉建立后，诸葛亮被封为丞相、武乡侯，内抚百姓，对外联吴抗魏，为实现兴复汉室的政治理想，数次北伐，但最终失败，最后病逝于五丈原。","D","D","C","A+++","A","EX");
            CharacterDataBase.getInstances(MainActivity.this).insert("zhouyu", "周瑜(公瑾)","archer","男","175","210","庐江舒","吴","    长壮有姿貌、精音律，江东有“曲有误，周郎顾”之语。\n     少与孙策交好，21岁起随孙策奔赴战场平定江东，后孙策遇刺身亡，孙权继任，周瑜将兵赴丧，以中护军的身份与长史张昭共掌众事。建安十三年，率军与刘备联合，于赤壁之战中大败曹军，由此奠定了“三分天下”的基础。","C","D","B","A","B","EX");
        }
        List<Map<String, Object>> data = getCharacterData("");
        cadapter = new CharacterListViewAdapter(this, data);
        mCharacterList.setAdapter(cadapter);
        mCharacterList.setTextFilterEnabled(true);
        cadapter.notifyDataSetChanged();

        List<Map<String, Object>> data1 = getSkillData("");
        sadapter = new SkillListViewAdapter(this, data1);
        mSkillList.setAdapter(sadapter);
        mSkillList.setTextFilterEnabled(true);
        sadapter.notifyDataSetChanged();

        CSChange.setTag("0");
        setListener();
    }


    private void setListener() {

        CSChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (CSChange.getTag() == "0"){
                    //CSChange.setImageResource(R.mipmap.mainpage);
                    CSChange.setTag("1");
                    mSkillList.setVisibility(View.VISIBLE);
                    mCharacterList.setVisibility(View.INVISIBLE);
                } else {
                    //CSChange.setImageResource(R.mipmap.shoplist);
                    CSChange.setTag("0");
                    mSkillList.setVisibility(View.INVISIBLE);
                    mCharacterList.setVisibility(View.VISIBLE);
                }
            }
        });
        
        //搜索按钮
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = msearch.getText().toString().trim();
                List<Map<String, Object>> data1 = getCharacterData(search);
                cadapter.refreshList(data1);
            }
        });

        //点击跳转英灵增加
        mCharacterListAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCharacter.class);
                startActivityForResult(intent, 0);
            }
        });

        //点击跳转小测试
        mLittletest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LittleTest.class);
                startActivityForResult(intent, 0);
            }
        });
        //英灵list的监听事件
        mCharacterList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            private int id;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//                //删除是要拿到当前行的id值才能删除当前行,下面的操作都是点击某个item拿到对应item的id字段
//                //拿到当前position的 item的所有数据
                Object id = clist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String image = clist.get(position).get("image").toString();
                String name = clist.get(position).get("name").toString();
                String job = clist.get(position).get("job").toString();
                String sex = clist.get(position).get("sex").toString();
                String birth = clist.get(position).get("birth").toString();
                String death = clist.get(position).get("death").toString();
                String origo = clist.get(position).get("origo").toString();
                String army = clist.get(position).get("army").toString();
                String introduction = clist.get(position).get("introduction").toString();
                String stre = clist.get(position).get("stre").toString();
                String endu = clist.get(position).get("endu").toString();
                String agil = clist.get(position).get("agil").toString();
                String magi = clist.get(position).get("magi").toString();
                String luck = clist.get(position).get("luck").toString();
                String skil = clist.get(position).get("skil").toString();

                //将得到id传入到需要的方法中
                showCharacterDialog(i, image, name, job, sex, birth, death, origo, army ,introduction, stre, endu, agil, magi, luck, skil);
                return true;
            }
        });

        mCharacterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> cadapterView, View view, int position, long l) {
                Object id = clist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String image = clist.get(position).get("image").toString();
                String name = clist.get(position).get("name").toString();
                String job = clist.get(position).get("job").toString();
                String sex = clist.get(position).get("sex").toString();
                String birth = clist.get(position).get("birth").toString();
                String death = clist.get(position).get("death").toString();
                String origo = clist.get(position).get("origo").toString();
                String army = clist.get(position).get("army").toString();
                String introduction = clist.get(position).get("introduction").toString();
                String stre = clist.get(position).get("stre").toString();
                String endu = clist.get(position).get("endu").toString();
                String agil = clist.get(position).get("agil").toString();
                String magi = clist.get(position).get("magi").toString();
                String luck = clist.get(position).get("luck").toString();
                String skil = clist.get(position).get("skil").toString();
                Intent intent = new Intent(MainActivity.this, CharacterDetail.class);
                intent.putExtra("id", i);
                intent.putExtra("image", image);
                intent.putExtra("name", name);
                intent.putExtra("job", job);
                intent.putExtra("sex", sex);
                intent.putExtra("birth", birth);
                intent.putExtra("death", death);
                intent.putExtra("origo", origo);
                intent.putExtra("army", army);
                intent.putExtra("introduction", introduction)
                      .putExtra("stre", stre)
                        .putExtra("endu", endu)
                        .putExtra("agil", agil)
                        .putExtra("magi", magi)
                        .putExtra("luck", luck)
                        .putExtra("skil", skil);
                startActivityForResult(intent,0);
            }
        });

        //宝具跳转
        mSkillList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //            private int id;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//                //删除是要拿到当前行的id值才能删除当前行,下面的操作都是点击某个item拿到对应item的id字段
//                //拿到当前position的 item的所有数据
                Object id = clist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String type = slist.get(position).get("type").toString();
                String name = clist.get(position).get("name").toString();
                String skill = clist.get(position).get("skill").toString();
                String introduction = clist.get(position).get("introduction").toString();

                //将得到id传入到需要的方法中
                showSkillDialog(i, type, name, skill, introduction);
                return true;
            }
        });

        mCharacterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> cadapterView, View view, int position, long l) {
                Object id = clist.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String type = slist.get(position).get("type").toString();
                String name = clist.get(position).get("name").toString();
                String skill = clist.get(position).get("skill").toString();
                String introduction = clist.get(position).get("introduction").toString();
                Intent intent = new Intent(MainActivity.this, SkillDetail.class);
                intent.putExtra("id", i);
                intent.putExtra("type", type);
                intent.putExtra("name", name);
                intent.putExtra("skill", skill);
                intent.putExtra("introduction", introduction);
                startActivityForResult(intent,0);
            }
        });
    }

    /**
     * 点击显示对话框选择修改或者是删除
     */
    private void showCharacterDialog(final int id, final String image, final String name, final String job, final String sex, final String birth, final String death, final String origo, final String army, final String introduction, final  String stre, final String endu, final String agil, final String magi, final String luck, final String skil) {

        mcdialog = new AlertDialog.Builder(MainActivity.this).create();
        mcdialog.show();
        mcdialog.getWindow().setContentView(R.layout.alertdialog);
        mcdialog.getWindow().findViewById(R.id.dia_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditCharacter.class);
                intent.putExtra("id", id);
                intent.putExtra("image", image);
                intent.putExtra("name", name);
                intent.putExtra("job", job);
                intent.putExtra("sex", sex);
                intent.putExtra("birth", birth);
                intent.putExtra("death", death);
                intent.putExtra("origo", origo);
                intent.putExtra("army", army);
                intent.putExtra("introduction", introduction)
                        .putExtra("stre", stre)
                        .putExtra("endu", endu)
                        .putExtra("agil", agil)
                        .putExtra("magi", magi)
                        .putExtra("luck", luck)
                        .putExtra("skil", skil);
                startActivityForResult(intent,0);
                mcdialog.dismiss();
            }
        });

        mcdialog.getWindow().findViewById(R.id.dia_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharacterDataBase.getInstances(MainActivity.this).delete(id);
                //重新查询,然后显示
                List<Map<String, Object>> data = getCharacterData("");
                cadapter.refreshList(data);
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                mcdialog.dismiss();
            }
        });
        //设置一个标题
        mcdialog.getWindow().findViewById(R.id.dia_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcdialog.dismiss();
            }
        });
    }

    private void showSkillDialog(final int id, final String name, final String type, final String level, final String introduction) {

        msdialog = new AlertDialog.Builder(MainActivity.this).create();
        msdialog.show();
        msdialog.getWindow().setContentView(R.layout.alertdialog);
        msdialog.getWindow().findViewById(R.id.dia_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditCharacter.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("type", type);
                intent.putExtra("level", level);
                intent.putExtra("introduction", introduction);
                startActivityForResult(intent,0);
                msdialog.dismiss();
            }
        });

        msdialog.getWindow().findViewById(R.id.dia_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkillDataBase.getInstances(MainActivity.this).delete(id);
                //重新查询,然后显示
                List<Map<String, Object>> data = getSkillData("");
                sadapter.refreshList(data);
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                msdialog.dismiss();
            }
        });
        //设置一个标题
        msdialog.getWindow().findViewById(R.id.dia_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msdialog.dismiss();
            }
        });
    }

    /**
     * 通过查找数据库,拿到里面的数据
     */
    private List<Map<String, Object>> getCharacterData(String s) {
        clist = new ArrayList<>();
        Cursor query = CharacterDataBase.getInstances(MainActivity.this).query();
        /*
        游标cursor默认是在-1的位置,query.moveToFirst()将游标移动到第一行,如果不写这个就会报
         Caused by: android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 12
         这个问题坑爹,以后一定要注意
         */
        if (query.moveToFirst()) {
            do {
                String image = query.getString(query.getColumnIndex("image"));
                String name = query.getString(query.getColumnIndex("name"));
                String job = query.getString(query.getColumnIndex("job"));
                String sex = query.getString(query.getColumnIndex("sex"));
                String birth = query.getString(query.getColumnIndex("birth"));
                String death = query.getString(query.getColumnIndex("death"));
                String origo = query.getString(query.getColumnIndex("origo"));
                String army = query.getString(query.getColumnIndex("army"));
                String introduction = query.getString(query.getColumnIndex("introduction"));
                String stre = query.getString(query.getColumnIndex("stre"));
                String endu = query.getString(query.getColumnIndex("endu"));
                String agil = query.getString(query.getColumnIndex("agil"));
                String magi = query.getString(query.getColumnIndex("magi"));
                String luck = query.getString(query.getColumnIndex("luck"));
                String skil = query.getString(query.getColumnIndex("skil"));
                int id = query.getInt(query.getColumnIndex("id"));
                Map<String, Object> map = new HashMap<>();


                if (s.isEmpty()) {
                    map.put("id", id);
                    map.put("image", image);
                    map.put("name", name);
                    map.put("job", job);
                    map.put("sex", sex);
                    map.put("birth", birth);
                    map.put("death", death);
                    map.put("origo", origo);
                    map.put("army", army);
                    map.put("introduction", introduction);
                    map.put("stre", stre);
                    map.put("endu", endu);
                    map.put("agil", agil);
                    map.put("magi", magi);
                    map.put("luck", luck);
                    map.put("skil", skil);
                    clist.add(map);
                } else {
                    if (name.contains(s)||job.contains(s)||sex.contains(s)||birth.contains(s)||death.contains(s)) {
                        map.put("id", id);
                        map.put("image", image);
                        map.put("name", name);
                        map.put("job", job);
                        map.put("sex", sex);
                        map.put("birth", birth);
                        map.put("death", death);
                        map.put("origo", origo);
                        map.put("army", army);
                        map.put("introduction", introduction);
                        map.put("stre", stre);
                        map.put("endu", endu);
                        map.put("agil", agil);
                        map.put("magi", magi);
                        map.put("luck", luck);
                        map.put("skil", skil);
                        clist.add(map);
                    }
                }

            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return clist;
    }

    private List<Map<String, Object>> getSkillData(String s) {
        slist = new ArrayList<>();
        Cursor query = SkillDataBase.getInstances(MainActivity.this).query();
        /*
        游标cursor默认是在-1的位置,query.moveToFirst()将游标移动到第一行,如果不写这个就会报
         Caused by: android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 12
         这个问题坑爹,以后一定要注意
         */
        if (query.moveToFirst()) {
            do {
                String type = query.getString(query.getColumnIndex("type"));
                String name = query.getString(query.getColumnIndex("name"));
                String level = query.getString(query.getColumnIndex("level"));
                String introduction = query.getString(query.getColumnIndex("introduction"));
                int id = query.getInt(query.getColumnIndex("id"));
                Map<String, Object> map = new HashMap<>();


                if (s.isEmpty()) {
                    map.put("id", id);
                    map.put("type", type);
                    map.put("name", name);
                    map.put("level", level);
                    map.put("introduction", introduction);
                    slist.add(map);
                } else {
                    if (name.contains(s)||level.contains(s)) {
                        map.put("id", id);
                        map.put("type", type);
                        map.put("name", name);
                        map.put("level", level);
                        map.put("introduction", introduction);
                        slist.add(map);
                    }
                }

            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return slist;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            List<Map<String, Object>> data1 = getCharacterData("");
            List<Map<String, Object>> data2 = getSkillData("");
//            cadapter = new CharacterListViewAdapter(this, data1);
//            mCharacterList.setAdapter(cadapter);
            cadapter.refreshList(data1);
            sadapter.refreshList(data2);

        }
    }
}