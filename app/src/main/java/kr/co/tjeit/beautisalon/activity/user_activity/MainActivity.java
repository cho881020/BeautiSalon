package kr.co.tjeit.beautisalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;
import kr.co.tjeit.beautisalon.adapters.DesignerAdapter;
import kr.co.tjeit.beautisalon.datas.Designer;
import kr.co.tjeit.beautisalon.utils.GlobalData;

public class MainActivity extends BaseActivity {

    int REQUEST_FOR_DESIGNER_FILTER = 1;

    private android.widget.ListView designerListView;
    DesignerAdapter mAdapter;
    private android.widget.ImageView filterBtn;

    boolean manSelect = true;
    boolean womanSelect = true;

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

//    언제가될진 모르지만, 언젠가 데이터를 돌려받는다.
//    돌려받는 이벤트에 대응 되는 메쏘드를 구현
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
////        어떤 요청이었는지.
//        if (requestCode == REQUEST_FOR_DESIGNER_FILTER) {
////            성별 필터에 달아두었던 1번 요청.
//            if (resultCode == RESULT_OK) {
//                boolean manOk = data.getBooleanExtra("남자선택여부", true);
//                boolean womanOk = data.getBooleanExtra("여자선택여부", true);
//
//                Toast.makeText(mContext, "남자 : " + manOk + ", 여자 : " + womanOk, Toast.LENGTH_SHORT).show();
//
//            }
//        }
//
//    }




    @Override
    public void setValues() {
        super.setValues();
        mAdapter = new DesignerAdapter(mContext, GlobalData.designers);
        designerListView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.designerListView = (ListView) findViewById(R.id.designerListView);
        this.filterBtn = (ImageView) findViewById(R.id.filterBtn);
    }
}
