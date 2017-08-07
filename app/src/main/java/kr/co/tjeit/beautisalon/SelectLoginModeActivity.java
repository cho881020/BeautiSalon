package kr.co.tjeit.beautisalon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectLoginModeActivity extends BaseActivity {

    public static SelectLoginModeActivity activity;
    // public 어느 클래스나 접근 가능
    // static => 객체화 하지 않아도 접근 가능하게
    // => 자료형 자체한테 접근 허가 하려고.
    // 자료형 : SelecLoginModeActivity.
    // 변수명 : activity


    private android.widget.Button userLoginBtn;
    private android.widget.Button workerLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_mode);
        activity = this;
        bindViews();
        setupEvents();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // userLogin버튼이 눌리면 실행될 일
                // LoginActivity로 넘겨주기
                // Intent 활용 -> SplashActivity 사용

                Intent myIntent = new Intent(mContext, LoginActivity.class);
                // Intent를 만들어서, 출발점과 목적지를 설정한다.
                // 목적지를 적을때는 반드시 액티비티이름.class

                myIntent.putExtra("wokerMode", false);
                // 직원모드가 아님을 알려줌.

                startActivity(myIntent);
                // 설정된 목적지로 출발

            }
        }); // 클릭시 할일 설정의 종료

        // 직원로그인 버튼이 눌렸을때
        // LoginActivity로 넘겨보자.

        workerLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                intent.putExtra("workerMode", true);
                startActivity(intent);
            }
        });


    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.workerLoginBtn = (Button) findViewById(R.id.workerLoginBtn);
        this.userLoginBtn = (Button) findViewById(R.id.userLoginBtn);
    }
}
