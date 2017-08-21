package kr.co.tjeit.beautisalon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import kr.co.tjeit.beautisalon.R;

public class ReqPracticeActivity extends BaseActivity {

    private android.widget.EditText edt;
    private android.widget.Button btn;
    private android.widget.SeekBar ratingSeekbar;
    private Button ratingSelectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_practice);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        ratingSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("선택된평점", ratingSeekbar.getProgress());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("입력데이터", edt.getText().toString());
                setResult(RESULT_OK, intent);
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
        this.ratingSelectBtn = (Button) findViewById(R.id.ratingSelectBtn);
        this.ratingSeekbar = (SeekBar) findViewById(R.id.ratingSeekbar);
        this.btn = (Button) findViewById(R.id.btn);
        this.edt = (EditText) findViewById(R.id.edt);
    }
}
