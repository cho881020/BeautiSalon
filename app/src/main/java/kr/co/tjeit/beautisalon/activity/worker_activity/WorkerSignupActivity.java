package kr.co.tjeit.beautisalon.activity.worker_activity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;
import kr.co.tjeit.beautisalon.utils.DBManager;

public class WorkerSignupActivity extends BaseActivity {

    private android.widget.EditText nameEdt;
    private android.widget.EditText nickNameEdt;
    private android.widget.RadioButton manBtn;
    private android.widget.RadioButton womanBtn;
    private android.widget.RadioGroup radioGroup;
    private android.widget.RadioButton ageBtn1;
    private android.widget.RadioButton ageBtn2;
    private android.widget.RadioButton ageBtn3;
    private android.widget.RadioButton ageBtn4;
    private android.widget.RadioButton ageBtn5;
    private android.widget.Button okBtn;
    private RadioGroup ageRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_signup);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues cv = new ContentValues();

                if (nameEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "데이터를 마저 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                cv.put("name", nameEdt.getText().toString());


                if (nickNameEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "데이터를 마저 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                cv.put("nickName", nickNameEdt.getText().toString());

                if (manBtn.isChecked()) {
                    cv.put("gender", 0);
                } else if (womanBtn.isChecked()) {

                    cv.put("gender", 1);
                } else {
                    Toast.makeText(mContext, "데이터를 마저 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ageRadioGroup.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(mContext, "데이터를 마저 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
//                    나이대 데이터 설정.


                    int age = Integer.parseInt(findViewById(ageRadioGroup.getCheckedRadioButtonId()).getTag().toString());

//                    Toast.makeText(mContext, "나이대 : "+ age, Toast.LENGTH_SHORT).show();

                    cv.put("majorAge", age);

                }

                long insertedId = DBManager.getInstance(mContext).insertDesigner(cv);

                Toast.makeText(mContext, insertedId + "번째 디자이너 추가", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void setValues() {
        super.setValues();
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.ageRadioGroup = (RadioGroup) findViewById(R.id.ageRadioGroup);
        this.ageBtn5 = (RadioButton) findViewById(R.id.ageBtn5);
        this.ageBtn4 = (RadioButton) findViewById(R.id.ageBtn4);
        this.ageBtn3 = (RadioButton) findViewById(R.id.ageBtn3);
        this.ageBtn2 = (RadioButton) findViewById(R.id.ageBtn2);
        this.ageBtn1 = (RadioButton) findViewById(R.id.ageBtn1);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.womanBtn = (RadioButton) findViewById(R.id.womanBtn);
        this.manBtn = (RadioButton) findViewById(R.id.manBtn);
        this.nickNameEdt = (EditText) findViewById(R.id.nickNameEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
    }
}
