package com.example.asus.sanguo;


import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


public class AddCharacter extends AppCompatActivity{

    private ImageView add_image;
    private Spinner add_imagename;
    private Spinner add_job;
    private ImageView add_jobframe;
    private TextInputLayout add_name;
    private Spinner add_sex;
    private TextInputLayout add_birth;
    private TextInputLayout add_death;
    private TextInputLayout add_origo;
    private TextInputLayout add_army;
    private TextInputLayout add_introduction;
    private EditText madd_name;
    private EditText madd_birth;
    private EditText madd_death;
    private EditText madd_origo;
    private EditText madd_army;
    private EditText madd_introduction;
    public String str;
    public String str1;
//    public String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_detail);

        Button add_confirm = findViewById(R.id.add_buttonconfirm);
        Button add_cancel = findViewById(R.id.add_buttoncancel);
        add_imagename = findViewById(R.id.add_image_name);
        add_image = findViewById(R.id.add_image);
        add_job = findViewById(R.id.add_job);
        add_jobframe = findViewById(R.id.add_imageframe);
        add_name = findViewById(R.id.add_name);
        add_sex = findViewById(R.id.add_sex);
        add_birth = findViewById(R.id.add_datebirth);
        add_death = findViewById(R.id.add_datedeath);
        add_origo = findViewById(R.id.add_origo);
        add_army = findViewById(R.id.add_army);
        add_introduction = findViewById(R.id.add_introduction);
        madd_name = add_name.getEditText();
        madd_birth = add_birth.getEditText();
        madd_death = add_death.getEditText();
        madd_origo = add_origo.getEditText();
        madd_army = add_army.getEditText();
        madd_introduction = add_introduction.getEditText();
        str = (String) add_imagename.getSelectedItem();
        str1 = (String) add_job.getSelectedItem();
//        filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/a.png";

//        add_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, 0x1);
//            }
//        });

        add_imagename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str = (String) add_imagename.getSelectedItem();
                add_image.setImageResource(ImageGet.getImage(str));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                add_image.setImageResource(ImageGet.getImage("1"));
            }
        });

        add_job.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str1 = (String) add_job.getSelectedItem();
                add_jobframe.setImageResource(ImageGet.getBigFrame(str1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                add_jobframe.setImageResource(ImageGet.getBigFrame(""));
            }
        });

        add_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拿到输入的数据
                String image = (String) add_imagename.getSelectedItem();
                String name = madd_name.getText().toString().trim();
                String job = (String)add_job.getSelectedItem();
                String sex = (String)add_sex.getSelectedItem();
                String birth = madd_birth.getText().toString().trim();
                String death = madd_death.getText().toString().trim();
                String origo = madd_origo.getText().toString().trim();
                String army = madd_army.getText().toString().trim();
                String introduction = madd_introduction.getText().toString().trim();

                add_name.setErrorEnabled(false);
                add_birth.setErrorEnabled(false);
                add_death.setErrorEnabled(false);
                add_origo.setErrorEnabled(false);
                add_army.setErrorEnabled(false);
                add_introduction.setErrorEnabled(false);
                if (TextUtils.isEmpty(name)) {
                    add_name.setErrorEnabled(true);
                    add_name.setError(getString(R.string.name) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(birth)) {
                    add_birth.setErrorEnabled(true);
                    add_birth.setError(getString(R.string.date_birth) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(death)) {
                    add_death.setErrorEnabled(true);
                    add_death.setError(getString(R.string.date_death) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(origo)) {
                    add_origo.setErrorEnabled(true);
                    add_origo.setError(getString(R.string.origo) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(army)) {
                    add_army.setErrorEnabled(true);
                    add_army.setError(getString(R.string.army) + getString(R.string.text_error_empty));
                } else if (TextUtils.isEmpty(introduction)) {
                    add_introduction.setErrorEnabled(true);
                    add_introduction.setError(getString(R.string.introduction) + getString(R.string.text_error_empty));
                } else {
                    //调用插入方法
                    MyDataBase.getInstances(AddCharacter.this).insert(image, name, job, sex, birth, death, origo, army, introduction);
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

//        Bitmap bitmap1= readImg();
//        if(bitmap1!=null){
//            add_image.setImageBitmap(bitmap1);
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
//                add_image.setImageBitmap(bitmap);
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
