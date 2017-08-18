package kr.co.tjeit.beautisalon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.tjeit.beautisalon.R;

public class ReqPracticeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_practice);
        bindViews();
        setupEvents();
        setValues();
    }
}
