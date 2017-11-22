package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

@SuppressLint("Registered")
public class AddSkill extends AppCompatActivity {

    private int id;
    private Spinner add_type;
    private TextInputLayout add_name;
    private TextInputLayout add_introduction;
    private EditText madd_name;
    private EditText madd_introduction;
    private Spinner add_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_skilldetail);

        final Button add_confirm = findViewById(R.id.skilladd_buttonconfirm);
        Button add_cancel = findViewById(R.id.skilladd_buttoncancel);
        add_type = findViewById(R.id.skilladd_type);
        add_name = findViewById(R.id.skilladd_name);
        add_introduction = findViewById(R.id.add_introduction);
        add_level = findViewById(R.id.skilladd_level);
        madd_name = add_name.getEditText();
        madd_introduction = add_introduction.getEditText();

        add_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拿到输入的数据
                String name = madd_name.getText().toString().trim();
                String type = (String) add_type.getSelectedItem();
                String introduction = madd_introduction.getText().toString().trim();
                String level = (String) add_level.getSelectedItem();

                add_name.setErrorEnabled(false);
                add_introduction.setErrorEnabled(false);
                if (TextUtils.isEmpty(name)) {
                    add_name.setErrorEnabled(true);
                    add_name.setError(getString(R.string.name) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(introduction)) {
                    add_introduction.setErrorEnabled(true);
                    add_introduction.setError(getString(R.string.introduction) + getString(R.string.text_error_empty));
                } else {
                    //调用插入方法
                    SkillDataBase.getInstances(AddSkill.this).updata(id, name, type, introduction, level);
                    finish();
                }
            }
        });

        add_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}