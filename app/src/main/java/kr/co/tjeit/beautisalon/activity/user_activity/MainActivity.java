package kr.co.tjeit.beautisalon.activity.user_activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.activity.BaseActivity;
import kr.co.tjeit.beautisalon.adapters.DesignerAdapter;
import kr.co.tjeit.beautisalon.utils.GlobalData;

public class MainActivity extends BaseActivity {

    private android.widget.ListView designerListView;
    DesignerAdapter mAdapter;
    private android.widget.ImageView filterBtn;

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
    }

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
