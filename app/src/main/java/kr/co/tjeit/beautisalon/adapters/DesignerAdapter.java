package kr.co.tjeit.beautisalon.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.datas.Designer;

/**
 * Created by user on 2017-07-28.
 */

public class DesignerAdapter extends ArrayAdapter<Designer> {

    private Context mContext;
    private ArrayList<Designer> mList;
    LayoutInflater inf;
    // 화면에 그림을 그려주는 역할을 담당 => 인플레이팅
    // layout폴더에 있는 xml을 분석해서 화면에 뿌려준다

    public DesignerAdapter(Context context, ArrayList<Designer> list) {

        super(context, R.layout.designer_list_item, list);

        // 커스텀으로 직접 리스트뷰의 모양을 구현
        // context 다음 인자 => 직접 구현한 리스트뷰 아이템의 id

        // 어떤 데이터를 뿌려줄 것인가?

        // 세가지 멤버 변수를 초기화
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            // 리스트뷰의 각 아이템을 새로 그려줘야 할때
            row = inf.inflate(R.layout.designer_list_item, null);
        }

        Designer myDesigner = mList.get(position);

        TextView designerNameTxt = (TextView) row.findViewById(R.id.designerNameTxt);
        designerNameTxt.setText(myDesigner.getNickName() + " (" + myDesigner.getName() + ")");

        TextView majorAgeTxt = (TextView) row.findViewById(R.id.majorAgeTxt);
        majorAgeTxt.setText(myDesigner.getMajorAge() + "대");

        TextView genderDesignerTxt = (TextView) row.findViewById(R.id.genderDesignerTxt);

        if (myDesigner.getGender() == 0) {
            // 남자 디자이너
            genderDesignerTxt.setText(R.string.man);
        }
        else if (myDesigner.getGender() == 1) {
            // 여자 디자이너

            genderDesignerTxt.setText(R.string.woman);

        }

        ImageView star1 = (ImageView) row.findViewById(R.id.star1);
        ImageView star2 = (ImageView) row.findViewById(R.id.star2);
        ImageView star3 = (ImageView) row.findViewById(R.id.star3);
        ImageView star4 = (ImageView) row.findViewById(R.id.star4);
        ImageView star5 = (ImageView) row.findViewById(R.id.star5);

        ArrayList<ImageView> stars = new ArrayList<ImageView>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        for (ImageView iv : stars) {
            iv.setVisibility(View.GONE);
        }


        int rating = (int) myDesigner.getAvgRating();
        for (int i=0 ; i < rating ; i++) {
            stars.get(i).setVisibility(View.VISIBLE);
        }

        // 닉네임 -> 닉네임 (이름)
        // 닉네임 (이름) => 출력


        return row;
    }
}






