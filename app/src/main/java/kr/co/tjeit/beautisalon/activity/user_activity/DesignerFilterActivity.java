package kr.co.tjeit.beautisalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;

public class DesignerFilterActivity extends BaseActivity {

    private android.widget.Button okBtn;
    private android.widget.ToggleButton manSelectToggleBtn;
    private android.widget.ToggleButton womanSelectToggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_filter);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

//        확인 버튼을 눌렀을때, 일단 화면을 종료.

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishIntent = new Intent();
                finishIntent.putExtra("남자선택여부", manSelectToggleBtn.isChecked());
                finishIntent.putExtra("여자선택여부", womanSelectToggleBtn.isChecked());
                setResult(RESULT_OK, finishIntent);
                finish();
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
        this.womanSelectToggleBtn = (ToggleButton) findViewById(R.id.womanSelectToggleBtn);
        this.manSelectToggleBtn = (ToggleButton) findViewById(R.id.manSelectToggleBtn);
        this.okBtn = (Button) findViewById(R.id.okBtn);
    }
}







