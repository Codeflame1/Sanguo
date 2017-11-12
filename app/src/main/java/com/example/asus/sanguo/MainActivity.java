package com.example.asus.sanguo;

import android.content.DialogInterface;
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
    private List<Map<String, Object>> list;
    private MyListViewAdapter adapter;
    private ListView mListView;
    private Button mListAdd;
    private ImageButton searchButton;
    private EditText msearch;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.characterlist);
        mListAdd = findViewById(R.id.characterlistadd);
        TextInputLayout characterlistsearch = findViewById(R.id.characterlistsearch);
        searchButton = findViewById(R.id.characterlistsearchButton);
        msearch = characterlistsearch.getEditText();
        MyDataBase.getInstances(MainActivity.this).insert("2", "赵云(子龙)","lancer","男","158","228","常山真定","蜀汉","    身长八尺，姿颜雄伟，蜀汉五虎上将之一。\n    汉末军阀混战，赵云受本郡推举，率领义从加入白马将军公孙瓒。期间结识了汉室皇亲刘备，但不久之后，因为兄长去世而离开。赵云离开公孙瓒大约七年左右的时间，在邺城与刘备相见，从此追随刘备。");
        List<Map<String, Object>> data = getData("");
        adapter = new MyListViewAdapter(this, data);
        mListView.setAdapter(adapter);
        mListView.setTextFilterEnabled(true);
        adapter.notifyDataSetChanged();
        setListener();
    }


    private void setListener() {

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = msearch.getText().toString().trim();
                List<Map<String, Object>> data1 = getData(search);
                adapter.refreshList(data1);
            }
        });

        //点击跳转
        mListAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCharacter.class);
                startActivityForResult(intent, 0);
            }
        });
        //ListView的监听事件
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            private int id;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//                //删除是要拿到当前行的id值才能删除当前行,下面的操作都是点击某个item拿到对应item的id字段
//                //拿到当前position的 item的所有数据
//                //返回的数据格式为{name=段炼, age=25, sex=男, id=12, death=吃饭。睡觉}
//                Object itemAtPosition = mListView.getItemAtPosition(position);
//                Log.e("duanlian", itemAtPosition+"");
//                //转换成String
//                String s = itemAtPosition.toString();
//                //如果字符串包含"id"字段
//                if (s.contains("id")) {
//                    //拿到id字段是处于字符串第几个位置
//                    int a = s.indexOf("id");
//                    //"id"字段后面是"death"字段,拿到death字段的位置
//                    int b = s.indexOf("death");
//                    //切割字符串{name=段炼, age=25, sex=男, id=12, death=吃饭。睡觉}
//                    //从i开始+3个正好是id开始的地方,death-2正好是id结束的位置减去了一个h和一个逗号
//                    String substring = s.substring(a + 3, b-2);
//                    //得到id后转换成int类型
//                    id = Integer.parseInt(substring);
//                }
//                //将得到id传入到需要的方法中
//                showMyDialog(id, position);
                //得到对应item里面的id
                Object id = list.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String image = list.get(position).get("image").toString();
                String name = list.get(position).get("name").toString();
                String job = list.get(position).get("job").toString();
                String sex = list.get(position).get("sex").toString();
                String birth = list.get(position).get("birth").toString();
                String death = list.get(position).get("death").toString();
                String origo = list.get(position).get("origo").toString();
                String army = list.get(position).get("army").toString();
                String introduction = list.get(position).get("introduction").toString();
                //将得到id传入到需要的方法中
                showMyDialog(i, image, name, job, sex, birth, death, origo, army, introduction);
                return true;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object id = list.get(position).get("id");
                int i = Integer.parseInt(id.toString());
                String image = list.get(position).get("image").toString();
                String name = list.get(position).get("name").toString();
                String job = list.get(position).get("job").toString();
                String sex = list.get(position).get("sex").toString();
                String birth = list.get(position).get("birth").toString();
                String death = list.get(position).get("death").toString();
                String origo = list.get(position).get("origo").toString();
                String army = list.get(position).get("army").toString();
                String introduction = list.get(position).get("introduction").toString();
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("id", i);
                intent.putExtra("image", image);
                intent.putExtra("name", name);
                intent.putExtra("job", job);
                intent.putExtra("sex", sex);
                intent.putExtra("birth", birth);
                intent.putExtra("death", death);
                intent.putExtra("origo", origo);
                intent.putExtra("army", army);
                intent.putExtra("introduction", introduction);
                startActivityForResult(intent,0);
            }
        });
    }

    /**
     * 点击显示对话框选择修改或者是删除
     */
    private void showMyDialog(final int id, final String image, final String name, final String job, final String sex, final String birth, final String death, final String origo, final String army, final String introduction) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置一个标题
        builder.setTitle("请选择");
        //给dialog设置item
        builder.setItems(new String[]{"修改", "删除"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                switch (position) {
                    case 0://修改
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
                        intent.putExtra("introduction", introduction);
                        startActivityForResult(intent,0);
                        break;
                    case 1://删除
                        MyDataBase.getInstances(MainActivity.this).delete(id);
                        //重新查询,然后显示
                        List<Map<String, Object>> data = getData("");
                        adapter.refreshList(data);
                        Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        builder.show();
    }

    /**
     * 通过查找数据库,拿到里面的数据
     */
    private List<Map<String, Object>> getData(String s) {
        list = new ArrayList<>();
        Cursor query = MyDataBase.getInstances(MainActivity.this).query();
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
                    list.add(map);
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
                        list.add(map);
                    }
                }

            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return list;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            List<Map<String, Object>> data1 = getData("");
//            adapter = new MyListViewAdapter(this, data1);
//            mListView.setAdapter(adapter);
            adapter.refreshList(data1);

        }
    }
}