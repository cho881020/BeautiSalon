package kr.co.tjeit.beautisalon.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.user_activity.MainActivity;
import kr.co.tjeit.beautisalon.activity.worker_activity.WorkerMainActivity;
import kr.co.tjeit.beautisalon.utils.ContextUtil;

public class LoginActivity extends BaseActivity {

    CallbackManager cm;
    ProfileTracker pt;

    //    직원 모드인지 아닌지 판별해주는 변수.
    boolean isWorkerMode = false;
    private TextView modeTxt;
    private EditText idEdt;
    private Button loginBtn;
    private android.widget.CheckBox autoLoginChk;
    private com.facebook.login.widget.LoginButton fbLoginBtn;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isWorkerMode = getIntent().getBooleanExtra("직원모드", false);
        bindViews();
        setupEvents();
        setValues();

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "kr.kjstudio.share_tdd",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SignupActivity.class);
                startActivity(intent);
            }
        });

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
                } else {
                    intent = new Intent(mContext, MainActivity.class);
                }

                startActivity(intent);

            }
        });


    }

    @Override
    public void setValues() {
        super.setValues();

        pt = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                if (currentProfile != null) {
                    ContextUtil.setLoginUser(mContext, currentProfile.getName(), 0);

                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        cm = CallbackManager.Factory.create();
        fbLoginBtn.registerCallback(cm, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        autoLoginChk.setChecked(ContextUtil.isAutoLogin(mContext));

        idEdt.setText(ContextUtil.getUserId(mContext));

        if (isWorkerMode) {
            modeTxt.setVisibility(View.VISIBLE);
        } else {
            modeTxt.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cm.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.fbLoginBtn = (LoginButton) findViewById(R.id.fbLoginBtn);
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.autoLoginChk = (CheckBox) findViewById(R.id.autoLoginChk);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);
    }
}





