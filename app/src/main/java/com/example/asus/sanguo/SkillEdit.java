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
public class SkillEdit extends AppCompatActivity {

    private int id;
    private Spinner edit_type;
    private TextInputLayout edit_name;
    private TextInputLayout edit_introduction;
    private EditText medit_name;
    private EditText medit_introduction;
    private Spinner edit_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_skilldetail);
        id = getIntent().getIntExtra("id", 0);
        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String level = getIntent().getStringExtra("level");
        String introduction = getIntent().getStringExtra("introduction");

        final Button edit_confirm = findViewById(R.id.skilledit_buttonconfirm);
        Button edit_cancel = findViewById(R.id.skilledit_buttoncancel);
        edit_type = findViewById(R.id.skilledit_type);
        edit_name = findViewById(R.id.skilledit_name);
        edit_introduction = findViewById(R.id.edit_introduction);
        edit_level = findViewById(R.id.skilledit_level);
        medit_name = edit_name.getEditText();
        medit_introduction = edit_introduction.getEditText();

        edit_type.setSelection(SpinnerSelect.getType(type));
        edit_level.setSelection(SpinnerSelect.getLevel(level));
        medit_name.setText(name);
        medit_introduction.setText(introduction);


        edit_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拿到输入的数据
                String name = medit_name.getText().toString().trim();
                String type = (String) edit_type.getSelectedItem();
                String introduction = medit_introduction.getText().toString().trim();
                String level = (String) edit_level.getSelectedItem();

                edit_name.setErrorEnabled(false);
                edit_introduction.setErrorEnabled(false);
                if (TextUtils.isEmpty(name)) {
                    edit_name.setErrorEnabled(true);
                    edit_name.setError(getString(R.string.name) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(introduction)) {
                    edit_introduction.setErrorEnabled(true);
                    edit_introduction.setError(getString(R.string.introduction) + getString(R.string.text_error_empty));
                } else {
                    //调用插入方法
                    SkillDataBase.getInstances(SkillEdit.this).updata(id, name, type, introduction, level);
                    finish();
                }
            }
        });

        edit_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}