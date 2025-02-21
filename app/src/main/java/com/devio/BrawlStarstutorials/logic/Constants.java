package com.devio.BrawlStarstutorials.logic;

import com.devio.BrawlStarstutorials.R;
import com.google.android.gms.ads.rewarded.RewardedAd;

public class Constants {

    public static final boolean DEFAULT_MUSIC_SETTING = false;

    public static final String COINS = "Total Coins : ";
    public static final String TOTAL_QUESTIONS = "Total Questions : ";
    public static final String WRONG = "Wrong : ";
    public static final String CORRECT = "Correct : ";


    public static final String MY_LEVEL_PREFFILE = "Level_Prefes";
    public static final String KEY_JAVA_LEVEL_1 = "Java_Level_1";
    public static final String KEY_JAVA_LEVEL_2 = "Java_Level_2";
    public static final String KEY_JAVA_LEVEL_3 = "Java_Level_3";
    public static final String KEY_JAVA_LEVEL_4 = "Java_Level_4";
    public static final String KEY_JAVA_LEVEL_5 = "Java_Level_5";
    public static final String KEY_JAVA_LEVEL_6 = "Java_Level_6";
    public static final String KEY_CAT_JAVA_LEVEL_1 = "Category_Java_Level1";
    public static final String KEY_CAT_JAVA_LEVEL_2 = "Category_Java_Level2";
    public static final String KEY_CAT_JAVA_LEVEL_3 = "Category_Java_Level3";
    public static final String KEY_CAT_JAVA_LEVEL_4 = "Category_Java_Level4";
    public static final String KEY_CAT_JAVA_LEVEL_5 = "Category_Java_Level5";
    public static final String KEY_CAT_JAVA_LEVEL_6 = "Category_Java_Level6";
    public static int[] buttommenu = new int[]{R.id.Explore, R.id.Quiz, R.id.Settings};
    public static int[] history;
    public static RewardedAd mRewardedAd;

    public static void inisializehistory() {
        history = new int[22];
        history[0] = 0;
        history[1] = 100;

    }

    public static int largest() {
        int i;
        int max = history[0];
        for (i = 1; i < history.length; i++)
            if (history[i] > max)
                max = history[i];
        return max;
    }

    public static void loadhistory(int loaded) {
        int s = loaded;
        for (int i = (loaded / 100); i > -1; i--) {
            history[i] = s;
            s = s - 100;
        }


    }

    public static boolean check(int[] history, int toCheckValue) {
        boolean test = false;
        for (int element : history) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }

}
