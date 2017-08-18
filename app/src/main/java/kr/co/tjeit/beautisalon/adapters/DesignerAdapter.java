package kr.co.tjeit.beautisalon.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.datas.Designer;

/**
 * Created by user on 2017-08-18.
 */

public class DesignerAdapter extends ArrayAdapter<Designer> {

    Context mContext;
    List<Designer> mList;
    LayoutInflater inf;

    public DesignerAdapter(Context context, List<Designer> list) {
        super(context, R.layout.designer_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.designer_list_item, null);
        }

        Designer data = mList.get(position);

        ImageView designerProfileImgView = (ImageView) row.findViewById(R.id.designerProfileImgView);
        TextView designerNameTxt = (TextView) row.findViewById(R.id.designerNameTxt);
        TextView majorAgeTxt = (TextView) row.findViewById(R.id.majorAgeTxt);
        TextView genderDesignerTxt = (TextView) row.findViewById(R.id.genderDesignerTxt);
        ImageView star1 = (ImageView) row.findViewById(R.id.star1);
        ImageView star2 = (ImageView) row.findViewById(R.id.star2);
        ImageView star3 = (ImageView) row.findViewById(R.id.star3);
        ImageView star4 = (ImageView) row.findViewById(R.id.star4);
        ImageView star5 = (ImageView) row.findViewById(R.id.star5);

//        디자이너의 본명을 출력 => 본명(별명)
        String designerNameStr = String.format(Locale.KOREA, "%s(%s)", data.getName(), data.getNickName());
        designerNameTxt.setText(designerNameStr);
//        디자이너의 주력 나이대 출력
        String majorAgeStr = String.format(Locale.KOREA, "주력분야 : %d대", data.getMajorAge());
        majorAgeTxt.setText(majorAgeStr);

//        디자이너의 본인의 성별 출력
        if (data.getGender() == 0) {
            genderDesignerTxt.setText("남성");
        }
        else if (data.getGender() == 1) {
            genderDesignerTxt.setText("여성");
        }

//        평점에 맞는 별 찍기
        ImageView[] stars = {star1, star2, star3, star4, star5};

//        일단 별은 기본적으로 숨김처리 하도록 한다.
        for (ImageView iv : stars) {
            iv.setVisibility(View.GONE);
        }
//        평점에 맞는 갯수만큼 별표를 다시 보여준다.
//        평점에 맞는 갯수? => int 형태로 구해져야.
//        4.3 => 4개. 3.8 => 3개 소수점 버림.
        int starCount = (int) data.getAvgRating();

//        구해진 갯수만큼 별표를 다시 표기
        for (int i=0 ; i < starCount ; i++) {
            ImageView tempStar = stars[i];
            tempStar.setVisibility(View.VISIBLE);
        }


        return row;
    }

}










