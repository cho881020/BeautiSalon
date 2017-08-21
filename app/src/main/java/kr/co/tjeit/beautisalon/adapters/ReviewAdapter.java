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

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import kr.co.tjeit.beautisalon.R;
import kr.co.tjeit.beautisalon.datas.DesignCase;
import kr.co.tjeit.beautisalon.datas.Designer;

/**
 * Created by user on 2017-08-21.
 */

public class ReviewAdapter extends ArrayAdapter<DesignCase> {

    Context mContext;
    List<DesignCase> mList;
    LayoutInflater inf;


    public ReviewAdapter(Context context, List<DesignCase> list) {
        super(context, R.layout.portfolio_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.portfolio_list_item, null);
        }

        DesignCase data = mList.get(position);

        // xml에는 분명 CircleImageView 형태로 정의 됨.
        // 그런데 자바에서 ImageView 형태로 저장을 하고
        // 심지어 ImageView형태로 캐스팅까지 하는데도 아무 문제가 없다.
//        왜? => 1. JAVA의 객체지향적 특성중 하나인, 다형성.
//        2. CircleImageView extends ImageView

//        JAVA의 객체지향으로서의 특징 3가지. 1) 상속 2) 캡슐화 3) 다형성

//        다형성.? => 여러가지 형태로 존재할수 있다.

//        다형성 1. Overloading
//        다형성 2. 부모는 자식을 담아둘 수 있다. ★
        ImageView profileImg = (ImageView) row.findViewById(R.id.profileImg);

//        라이브러리 1. 인터넷 이미지 불러오기 => 이미지 로더! AUIL, Piccaso
//        라이브러리 2. 동그란 이미지뷰 => CircleImageView
//        개발의 폭이 매우 넓어진다. => 라이브러리 : 다양한 종류의 레고 블럭

//        라이브러리 단점 : 깊이가 안깊어진다.
//        라이브러리 공부. => 분석

        Glide.with(mContext).load(data.getUser().getProfilePicturePath()).into(profileImg);

        TextView nameTxt = (TextView) row.findViewById(R.id.nameTxt);
        nameTxt.setText(data.getUser().getName());

        TextView reviewTxt = (TextView) row.findViewById(R.id.reviewTxt);
        reviewTxt.setText(data.getUserReview());

        TextView createdOnTxt = (TextView) row.findViewById(R.id.createdOnTxt);

//        날짜를 (Calendar를) String으로 출력하고자 할때, SimpleDateFormat을 활용
//        생성자에, 원하는 출력 형태를 넣어주면됨.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        만들어진 날짜형태를 이용해, String을 만들어준다. dateFormat.format(원하는Calendar.getTime)
        String dateStr = dateFormat.format(data.getCreatedOn().getTime());
        createdOnTxt.setText(dateStr);

//        배열을 이용한 별표 찍어주기.

        ImageView star1 = (ImageView) row.findViewById(R.id.star1);
        ImageView star2 = (ImageView) row.findViewById(R.id.star2);
        ImageView star3 = (ImageView) row.findViewById(R.id.star3);
        ImageView star4 = (ImageView) row.findViewById(R.id.star4);
        ImageView star5 = (ImageView) row.findViewById(R.id.star5);

        ImageView[] stars = {star1, star2, star3, star4, star5};
//        모든 별표를 숨겨주는 부분
        for (ImageView iv : stars) {
            iv.setVisibility(View.GONE);
        }

//        필요한 만큼 출력
        int starCount = data.getUserRating();

        for (int i =0 ; i < starCount ; i++) {
            stars[i].setVisibility(View.VISIBLE);
        }

        return row;
    }

}
