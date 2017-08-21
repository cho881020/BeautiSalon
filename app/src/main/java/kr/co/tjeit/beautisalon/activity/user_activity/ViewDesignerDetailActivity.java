package kr.co.tjeit.beautisalon.activity.user_activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;
import kr.co.tjeit.beautisalon.datas.Designer;

public class ViewDesignerDetailActivity extends BaseActivity {

    private android.widget.TextView nameTxt;
    private android.widget.TextView genderTxt;
    private android.widget.TextView nickNameTxt;
    private android.widget.TextView majorAgeTxt;
    private android.widget.TextView ratingTxt;
    private android.widget.ImageView star1;
    private android.widget.ImageView star2;
    private android.widget.ImageView star3;
    private android.widget.ImageView star4;
    private android.widget.ImageView star5;
    private android.widget.ListView portfolioListView;
    private android.widget.Button checkScheduleBtn;
    private android.widget.Button reservationBtn;

    Designer mDesigner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_designer_detail);
        mDesigner = (Designer) getIntent().getSerializableExtra("디자이너데이터");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();
    }

    @Override
    public void setValues() {
        super.setValues();

//        이름을 설정
        nameTxt.setText(mDesigner.getName());

//        성별을 설정
//        성별은 0이면 남자, 1이면 여자라고 출력.
        if (mDesigner.getGender() == 0) {
            genderTxt.setText("남자");
        }
        else if (mDesigner.getGender() == 1) {
            genderTxt.setText("여자");
        }

//        디자이너의 닉네임 설정
        nickNameTxt.setText(mDesigner.getNickName());

//        디자이너의 연령대 설정
        String majorAgeStr = String.format(Locale.KOREA, "%d대", mDesigner.getMajorAge());
        majorAgeTxt.setText(majorAgeStr);

//        평점을 설정하는 알고리즘

//        모든 별들을 하나의 공간에 묶어 넣기 위한 공간.
        List<ImageView> stars = new ArrayList<>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

//        배열로 간단히 코딩 할 수도 있다.
//        ImageView[] starArray = {star1, star2, star3, star4, star5};

//        일단 모든 별을 다 숨김 처리.
        for (ImageView iv : stars) {
            iv.setVisibility(View.GONE);
        }

//        필요한 갯수만큼 별표를 출력
//        필요한 갯수?
        int starCount = (int) mDesigner.getAvgRating();

//        구해진 갯수만큼 반복을 돌면서, 다시 별표를 표시.
        for (int i=0 ; i < starCount ; i++) {
            ImageView iv = stars.get(i);
            iv.setVisibility(View.VISIBLE);
        }



    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.reservationBtn = (Button) findViewById(R.id.reservationBtn);
        this.checkScheduleBtn = (Button) findViewById(R.id.checkScheduleBtn);
        this.portfolioListView = (ListView) findViewById(R.id.portfolioListView);
        this.star5 = (ImageView) findViewById(R.id.star5);
        this.star4 = (ImageView) findViewById(R.id.star4);
        this.star3 = (ImageView) findViewById(R.id.star3);
        this.star2 = (ImageView) findViewById(R.id.star2);
        this.star1 = (ImageView) findViewById(R.id.star1);
        this.ratingTxt = (TextView) findViewById(R.id.ratingTxt);
        this.majorAgeTxt = (TextView) findViewById(R.id.majorAgeTxt);
        this.nickNameTxt = (TextView) findViewById(R.id.nickNameTxt);
        this.genderTxt = (TextView) findViewById(R.id.genderTxt);
        this.nameTxt = (TextView) findViewById(R.id.nameTxt);
    }
}
