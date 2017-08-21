package kr.co.tjeit.beautisalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;
import kr.co.tjeit.beautisalon.activity.ReqPracticeActivity;
import kr.co.tjeit.beautisalon.adapters.DesignerAdapter;
import kr.co.tjeit.beautisalon.datas.Designer;
import kr.co.tjeit.beautisalon.utils.GlobalData;

public class MainActivity extends BaseActivity {

    final int REQUEST_FOR_DESIGNER_FILTER = 1;
    final int REQUEST_FOR_TEST = 2;

    private android.widget.ListView designerListView;
    DesignerAdapter mAdapter;
    private android.widget.ImageView filterBtn;

    // 남자가 보여져야 하는지?
    boolean manSelect = true;
    // 여자가 보여져야 하는지?
    boolean womanSelect = true;
    // 몇점 이상의 디자이너를 보여줄건지?
    int minRating = 0;
    private android.widget.Button reqTestBtn;
    private android.widget.TextView titleTxt;

    // 화면에 출력되는 디자이너 목록을 담는 리스트
    List<Designer> mDisplayDesignerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        reqTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReqPracticeActivity.class);
                startActivityForResult(intent, REQUEST_FOR_TEST);
            }
        });

        designerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(mContext, ViewDesignerDetailActivity.class);
                intent.putExtra("designer", GlobalData.designers.get(position));
                startActivity(intent);
            }
        });

        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DesignerFilterActivity.class);
//                startActivity(intent);
//               데이터를 돌려받기 위한 startActivity
                startActivityForResult(intent, REQUEST_FOR_DESIGNER_FILTER);

            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_FOR_TEST) {
//            if (resultCode == RESULT_OK) {
//                String tempText = data.getStringExtra("입력데이터");
////                기본형변수 (int, double) => 첨부되지 않은경우에 쓸 기본값 세팅
////                참조형변수 (String, 데이터클래스) => 기본값 X. null로 들어감.
//
////                Toast.makeText(mContext, tempText, Toast.LENGTH_SHORT).show();
//                titleTxt.setText(tempText);
//
//            }
//        }
//
//    }

    //    언제가될진 모르지만, 언젠가 데이터를 돌려받는다.
//    돌려받는 이벤트에 대응 되는 메쏘드를 구현
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        어떤 요청이었는지.
        if (requestCode == REQUEST_FOR_DESIGNER_FILTER) {
//            성별 필터에 달아두었던 1번 요청.
            if (resultCode == RESULT_OK) {
                manSelect = data.getBooleanExtra("남자선택여부", true);
                womanSelect = data.getBooleanExtra("여자선택여부", true);

                filterAndRefreshListView();

            }
        }
        else if (requestCode == REQUEST_FOR_TEST) {
            if (resultCode == RESULT_OK) {
                int selectedProgress = data.getIntExtra("선택된평점", -1);
                Log.d("선택된평점", selectedProgress+"");
            }
        }

    }

    private void filterAndRefreshListView() {
        // 실제로 데이터들을 걸러주는 부분.
        // 걸러준다 ? 일단 싸그리 비우고,
        // 전체적으로 다시 검사해서, 조건에 맞는 객체들만 출력.
        // 출력? mDisplay리스트 에 추가해준다.


        // 일단 출력용 리스트를 싹 비움.
        mDisplayDesignerList.clear();

        // 필터 => 조건에 맞는 객체들만 화면에 보여준다.
        // 원본들은 보존하고, 원본을 하나하나 검사해서
        // 조건이 맞을경우 화면에 표시되도록.

        for (Designer ds : GlobalData.designers) {

            // 성별이 올바른지 기록하는 boolean
            boolean genderOk = false;

            // 남자가 선택되어야 하는지?
            if (manSelect) {
                // 실제로 성별이 남성인지?
                if (ds.getGender() == 0) {
                    // 상황이 맞으므로, 성별이 올바르다고 기록.
                    genderOk = true;
                }
            }

            // 여성에 대해 확인.
            if (womanSelect) {
                if (ds.getGender() == 1) {
                    genderOk = true;
                }
            }

            // 상황이 맞는지 재확인해서, 실제로 데이터를 추가
            if (genderOk) {
                mDisplayDesignerList.add(ds);
            }

        }


        mAdapter.notifyDataSetChanged();

    }


    @Override
    public void setValues() {
        // 뭐 하는 함수?
        // 액티비티가 처음 생성될 때 필요한 데이터/화면 값 설정.
        super.setValues();

        // 처음에는 조건없이 모든 디자이너를 화면에 출력해야함.
        // 화면에 표시될 List에, Global데이터의 모든 디자이너를 추가.
        mDisplayDesignerList.addAll(GlobalData.designers);

        // 글로벌 데이터를 바로 화면에 띄우는게 아니라,
        // 화면 표시용 리스트를 기반으로 나타내도록 설정.
        // => 필터 / 검색 등 임시로 결과를 추려내야할 경우에.
        mAdapter = new DesignerAdapter(mContext, mDisplayDesignerList);
        designerListView.setAdapter(mAdapter);


    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.designerListView = (ListView) findViewById(R.id.designerListView);
        this.filterBtn = (ImageView) findViewById(R.id.filterBtn);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        this.reqTestBtn = (Button) findViewById(R.id.reqTestBtn);
    }
}
