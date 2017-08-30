package kr.co.tjeit.beautisalon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.user_activity.MainActivity;
import kr.co.tjeit.beautisalon.activity.worker_activity.WorkerMainActivity;
import kr.co.tjeit.beautisalon.utils.ContextUtil;

public class LoginActivity extends BaseActivity {

    //    직원 모드인지 아닌지 판별해주는 변수.
    boolean isWorkerMode = false;
    private TextView modeTxt;
    private EditText idEdt;
    private Button loginBtn;
    private android.widget.CheckBox autoLoginChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isWorkerMode = getIntent().getBooleanExtra("직원모드", false);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        autoLoginChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ContextUtil.setAutoLogin(mContext, isChecked);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContextUtil.setUserId(mContext, idEdt.getText().toString());

                ContextUtil.setLoginUser(mContext, "A사용자", 1);

                Intent intent;
                if (isWorkerMode) {
                    intent = new Intent(mContext, WorkerMainActivity.class);
                }
                else {
                    intent = new Intent(mContext, MainActivity.class);
                }

                startActivity(intent);

            }
        });


    }

    @Override
    public void setValues() {
        super.setValues();

        autoLoginChk.setChecked(ContextUtil.isAutoLogin(mContext));

        idEdt.setText(ContextUtil.getUserId(mContext));

        if (isWorkerMode) {
            modeTxt.setVisibility(View.VISIBLE);
        }
        else {
            modeTxt.setVisibility(View.GONE);
        }

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.autoLoginChk = (CheckBox) findViewById(R.id.autoLoginChk);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);
    }
}





