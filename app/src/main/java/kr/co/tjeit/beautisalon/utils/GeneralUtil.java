package kr.co.tjeit.beautisalon.utils;

import java.util.ArrayList;

import kr.co.tjeit.beautisalon.datas.DesignCase;
import kr.co.tjeit.beautisalon.datas.Designer;
import kr.co.tjeit.beautisalon.datas.User;

/**
 * Created by user on 2017-07-27.
 */

public class GeneralUtil {
    // 앱에서 공통적으로 사용되는 데이터를 임시 저장하는 클래스
    // 대부분의 변수/메쏘드는 public static으로
    // GeneralUtil.메쏘드(), GeneralUtil.변수

    public static ArrayList<DesignCase> globalDesignCase = new ArrayList<DesignCase>();
    public static ArrayList<Designer> designers = new ArrayList<Designer>();
    public static ArrayList<User> users = new ArrayList<User>();

}
