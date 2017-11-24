package com.example.asus.sanguo;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

@SuppressLint("Registered")
public class CharacterEdit extends AppCompatActivity {

    private int id;
    private Spinner edit_imagename;
    private ImageView edit_image;
    private Spinner edit_job;
    private ImageView edit_jobframe;
    private TextInputLayout edit_name;
    private Spinner edit_sex;
    private TextInputLayout edit_birth;
    private TextInputLayout edit_death;
    private TextInputLayout edit_origo;
    private TextInputLayout edit_army;
    private TextInputLayout edit_introduction;
    private EditText medit_name;
    private EditText medit_birth;
    private EditText medit_death;
    private EditText medit_origo;
    private EditText medit_army;
    private EditText medit_introduction;
    private Spinner edit_stre;
    private Spinner edit_endu;
    private Spinner edit_agil;
    private Spinner edit_magi;
    private Spinner edit_luck;
    private Spinner edit_skil;
    public String str;
    public String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_characterdetail);
        id = getIntent().getIntExtra("id", 0);
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

        final Button edit_confirm = findViewById(R.id.edit_buttonconfirm);
        Button edit_cancel = findViewById(R.id.edit_buttoncancel);
        edit_imagename = findViewById(R.id.edit_image_name);
        edit_image = findViewById(R.id.edit_image);
        edit_job = findViewById(R.id.edit_job);
        edit_jobframe = findViewById(R.id.edit_imageframe);
        edit_name = findViewById(R.id.edit_name);
        edit_sex = findViewById(R.id.edit_sex);
        edit_birth = findViewById(R.id.edit_datebirth);
        edit_death = findViewById(R.id.edit_datedeath);
        edit_origo = findViewById(R.id.edit_origo);
        edit_army = findViewById(R.id.edit_army);
        edit_introduction = findViewById(R.id.edit_introduction);
        edit_stre = findViewById(R.id.edit_stre);
        edit_endu = findViewById(R.id.edit_endu);
        edit_agil = findViewById(R.id.edit_agil);
        edit_magi = findViewById(R.id.edit_magi);
        edit_luck = findViewById(R.id.edit_luck);
        edit_skil = findViewById(R.id.edit_skil);
        medit_name = edit_name.getEditText();
        medit_birth = edit_birth.getEditText();
        medit_death = edit_death.getEditText();
        medit_origo = edit_origo.getEditText();
        medit_army = edit_army.getEditText();
        medit_introduction = edit_introduction.getEditText();

        edit_imagename.setSelection(SpinnerSelect.getImageSelect(image));
        edit_job.setSelection(SpinnerSelect.getJobSelect(job));
        edit_stre.setSelection(SpinnerSelect.getLevel(stre));
        edit_endu.setSelection(SpinnerSelect.getLevel(endu));
        edit_agil.setSelection(SpinnerSelect.getLevel(agil));
        edit_magi.setSelection(SpinnerSelect.getLevel(magi));
        edit_luck.setSelection(SpinnerSelect.getLevel(luck));
        edit_skil.setSelection(SpinnerSelect.getLevel(skil));
        medit_name.setText(name);
        edit_sex.setSelection(SpinnerSelect.getSex(sex));
        medit_birth.setText(birth);
        medit_death.setText(death);
        medit_origo.setText(origo);
        medit_army.setText(army);
        medit_introduction.setText(introduction);
        str = (String) edit_imagename.getSelectedItem();
        str1 = (String) edit_job.getSelectedItem();

//        edit_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, 0x1);
//            }
//        });

        edit_imagename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str = (String) edit_imagename.getSelectedItem();
                edit_image.setImageResource(ImageGet.getImage(str));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                edit_image.setImageResource(ImageGet.getImage(""));
            }
        });

        edit_job.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str1 = (String) edit_job.getSelectedItem();
                edit_jobframe.setImageResource(ImageGet.getBigFrame(str1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                edit_jobframe.setImageResource(ImageGet.getBigFrame(""));
            }
        });

        edit_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拿到输入的数据
                String image = (String)edit_imagename.getSelectedItem();
                String name = medit_name.getText().toString().trim();
                String job = (String)edit_job.getSelectedItem();
                String sex = (String)edit_sex.getSelectedItem();
                String birth = medit_birth.getText().toString().trim();
                String death = medit_death.getText().toString().trim();
                String origo = medit_origo.getText().toString().trim();
                String army = medit_army.getText().toString().trim();
                String introduction = medit_introduction.getText().toString().trim();
                String stre = (String)edit_stre.getSelectedItem();
                String endu = (String)edit_endu.getSelectedItem();
                String agil = (String)edit_agil.getSelectedItem();
                String magi = (String)edit_magi.getSelectedItem();
                String luck = (String)edit_luck.getSelectedItem();
                String skil = (String)edit_skil.getSelectedItem();

                edit_name.setErrorEnabled(false);
                edit_birth.setErrorEnabled(false);
                edit_death.setErrorEnabled(false);
                edit_origo.setErrorEnabled(false);
                edit_army.setErrorEnabled(false);
                edit_introduction.setErrorEnabled(false);
                if (TextUtils.isEmpty(name)) {
                    edit_name.setErrorEnabled(true);
                    edit_name.setError(getString(R.string.name) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(birth)) {
                    edit_birth.setErrorEnabled(true);
                    edit_birth.setError(getString(R.string.date_birth) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(death)) {
                    edit_death.setErrorEnabled(true);
                    edit_death.setError(getString(R.string.date_death) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(origo)) {
                    edit_origo.setErrorEnabled(true);
                    edit_origo.setError(getString(R.string.origo) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(army)) {
                    edit_army.setErrorEnabled(true);
                    edit_army.setError(getString(R.string.army) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(introduction)) {
                    edit_introduction.setErrorEnabled(true);
                    edit_introduction.setError(getString(R.string.introduction) + getString(R.string.text_error_empty));
                } else {
                    //调用插入方法
                    CharacterDataBase.getInstances(CharacterEdit.this).updata(id, image, name, job, sex, birth, death, origo, army ,introduction, stre, endu, agil, magi, luck, skil);
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
//
//        Bitmap bitmap1= readImg();
//        if(bitmap1!=null){
//            edit_image.setImageBitmap(bitmap1);
//        }else{
//        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 0x1) {
//            if (data != null) {
//                Uri uri = data.getData();
//                getImg(uri);
//            } else {
//                return;
//            }
//        }
//        if (requestCode == 0x2) {
//            if (data != null) {
//                Bundle bundle = data.getExtras();
//                //得到图片
//                Bitmap bitmap = bundle.getParcelable("data");
//                //保存到图片到本地
//                saveImg(bitmap);
//                //设置图片
//                edit_image.setImageBitmap(bitmap);
//                filePath = data.getData().getPath();
//            } else {
//                return;
//            }
//        }
//    }
//
//    //读取位图（图片）
//    private Bitmap readImg() {
//        File mfile = new File(filePath);
//        Bitmap bm = null;
//        if (mfile.exists()) {        //若该文件存在
//            bm = BitmapFactory.decodeFile(filePath);
//        }
//        return bm;
//    }
//
//    //保存图片到本地，下次直接读取
//    private void saveImg(Bitmap mBitmap)  {
//        File f = new File(filePath);
//        try {
//            //如果文件不存在，则创建文件
//            if(!f.exists()){
//                f.createNewFile();
//            }
//            //输出流
//            FileOutputStream out = new FileOutputStream(f);
//            /** mBitmap.compress 压缩图片
//             *
//             *  Bitmap.CompressFormat.PNG   图片的格式
//             *   100  图片的质量（0-100）
//             *   out  文件输出流
//             */
//            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//            out.flush();
//            out.close();
//            Toast.makeText(this,f.getAbsolutePath().toString(),Toast.LENGTH_SHORT).show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private void getImg(Uri uri) {
//        try {
//            InputStream inputStream = getContentResolver().openInputStream(uri);
//            //从输入流中解码位图
//            // Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            //保存位图
//            // img.setImageBitmap(bitmap);
//            cutImg(uri);
//            //关闭流
//            inputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    //裁剪图片
//    private void cutImg(Uri uri) {
//        if (uri != null) {
//            Intent intent = new Intent("com.android.camera.action.CROP");
//            intent.setDataAndType(uri, "image/*");
//            //true:出现裁剪的框
//            intent.putExtra("crop", "true");
//            //裁剪宽高时的比例
//            intent.putExtra("aspectX", 1);
//            intent.putExtra("aspectY", 1);
//            //裁剪后的图片的大小
//            intent.putExtra("outputX", 300);
//            intent.putExtra("outputY", 300);
//            intent.putExtra("return-data", true);  // 返回数据
//            intent.putExtra("output", uri);
//            intent.putExtra("scale", true);
//            startActivityForResult(intent, 0x2);
//        } else {
//            return;
//        }
//    }
}
