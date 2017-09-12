package kr.co.tjeit.beautisalon.utils;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.beautisalon.datas.Designer;

/**
 * Created by user on 2017-09-12.
 */

public class DataBaseUtil {

    public static List<Designer> getDesignersFromDB(Context context) {

        List<Designer> mList = new ArrayList<>();

        Cursor c = DBManager.getInstance(context).getAllDesigners();

        if (c != null) {
            while (c.moveToNext()) {
                Designer d = new Designer();
                d.setName(c.getString(1));
                d.setGender(c.getInt(2));
                d.setNickName(c.getString(3));
                d.setMajorAge(c.getInt(4));
                d.setAvgRating(c.getFloat(c.getColumnIndex("avgRating")));

                mList.add(d);
            }
        }


        return mList;
    }

}
