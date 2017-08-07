package kr.co.tjeit.beautisalon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.tjeit.beautisalon.datas.DesignCase;
import kr.co.tjeit.beautisalon.datas.Designer;
import kr.co.tjeit.beautisalon.datas.User;
import kr.co.tjeit.beautisalon.utils.GeneralUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        addDesigners();
        addUsers(); // Alt + Enter
        addDesignCase();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(mContext, SelectLoginModeActivity.class);
                startActivity(myIntent);
                finish();
            }
        }, 2000);
        // postDealyed => 어떤 할 일을 재료 1, 몇초 후에 (millisecond) 재료 2
        // 할일 => new runnable
        // 재료2만큼의 시간이 지나면 할일을 실행


    }

    private void addDesignCase() {
        GeneralUtil.globalDesignCase.clear();

        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo,
                Calendar.getInstance(), 5, GeneralUtil.designers.get(0),
                GeneralUtil.users.get(0), 10000, "5점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo,
                Calendar.getInstance(), 4, GeneralUtil.designers.get(0),
                GeneralUtil.users.get(1), 20000, "4점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo,
                Calendar.getInstance(), 3, GeneralUtil.designers.get(0),
                GeneralUtil.users.get(2), 30000, "3점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo,
                Calendar.getInstance(), 2, GeneralUtil.designers.get(0),
                GeneralUtil.users.get(3), 40000, "2점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo,
                Calendar.getInstance(), 1, GeneralUtil.designers.get(0),
                GeneralUtil.users.get(4), 50000, "1점 드릴게요"));

        Designer leekj = GeneralUtil.designers.get(0);

        for (DesignCase dc : GeneralUtil.globalDesignCase) {
            leekj.getPortfolio().add(dc);
        }

    }

    private void addUsers() {
        GeneralUtil.users.clear();

        GeneralUtil.users.add(new User("한상열", 0, Calendar.getInstance(), new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/11379757_445206435653478_1894580131_n.jpg"));
        GeneralUtil.users.add(new User("최종환", 0, Calendar.getInstance(), new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/13731255_1566785090293996_693997005_n.jpg"));
        GeneralUtil.users.add(new User("이요한", 0, Calendar.getInstance(), new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/14.jpg"));
        GeneralUtil.users.add(new User("이승헌", 0, Calendar.getInstance(), new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/images+(1).jpg"));
        GeneralUtil.users.add(new User("손익상", 0, Calendar.getInstance(), new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/images.jpg"));

    }

    private void addDesigners() {
        GeneralUtil.designers.clear();
        GeneralUtil.designers.add(new Designer("이가자", 1, "KAJA", 40, 4.5f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("박승철", 0, "PSC", 20, 4.0f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("김정남", 1, "KJN", 30, 3.8f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("이승철", 0, "LSC", 50, 2.5f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("박준", 0, "PJ", 10, 4.8f, new ArrayList<DesignCase>()));

    }


}
