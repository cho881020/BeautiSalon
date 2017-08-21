package kr.co.tjeit.beautisalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;

public class MakeReviewActivity extends BaseActivity {

    private android.widget.EditText reviewEdt;
    private android.widget.Button okBtn;
    private android.widget.RadioButton radioBtn1;
    private android.widget.RadioButton radioBtn2;
    private android.widget.RadioButton radioBtn3;
    private android.widget.RadioButton radioBtn4;
    private android.widget.RadioButton radioBtn5;
    private android.widget.RadioGroup ratingRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_review);
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
                if (ratingRadioGroup.getCheckedRadioButtonId() != -1) {
//                    라디오버튼에 값이 선택되어 있을때

                    int rating = 0;
//                    실제로 평점을 구해서, rating에 저장하면 마무리.

                    int checkedRadioBtnId = ratingRadioGroup.getCheckedRadioButtonId();
//                    R.id.radioBtn1 => 숫자.

////                    먼저, 선택된 라디오버튼 자체를 찾아내자.
//                    RadioButton tempRadio = (RadioButton) findViewById(checkedRadioBtnId);
////                    라디오버튼에 달려있는 태그를 스트링으로 저장.
//                    String tag = tempRadio.getTag().toString();
////                    찾아낸 태그 String -> int 로 변환해서 rating 에 저장.
//                    rating = Integer.parseInt(tag);
//
//
//                    // 라디오버튼을 굳이 저장하지 않고,
//                    // 뷰를 찾아내서 바로 태그를 스트링으로 저장. (1단계 축약)
//                    String checkedRadioTag = findViewById(checkedRadioBtnId).getTag().toString();
//                    rating = Integer.parseInt(checkedRadioTag);

                    // 뷰를 바로 찾아내서, 태그를 스트링으로 뽑아내고,
                    // 바로 숫자로 변환해서, rating에 저장
                    rating = Integer.parseInt(findViewById(checkedRadioBtnId).getTag().toString());



                    Intent intent = new Intent();
                    intent.putExtra("리뷰내용", reviewEdt.getText().toString());
                    intent.putExtra("점수", rating);
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
//                    아무것도 선택하지 않았을때
                    Toast.makeText(mContext, "점수를 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
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
        this.reviewEdt = (EditText) findViewById(R.id.reviewEdt);
        this.ratingRadioGroup = (RadioGroup) findViewById(R.id.ratingRadioGroup);
        this.radioBtn5 = (RadioButton) findViewById(R.id.radioBtn5);
        this.radioBtn4 = (RadioButton) findViewById(R.id.radioBtn4);
        this.radioBtn3 = (RadioButton) findViewById(R.id.radioBtn3);
        this.radioBtn2 = (RadioButton) findViewById(R.id.radioBtn2);
        this.radioBtn1 = (RadioButton) findViewById(R.id.radioBtn1);
    }
}
