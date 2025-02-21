package com.devio.BrawlStarstutorials.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

import com.devio.BrawlStarstutorials.Ads.myAds;
import com.devio.BrawlStarstutorials.MainActivity;
import com.devio.BrawlStarstutorials.R;
import com.devio.BrawlStarstutorials.logic.Constants;
import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class LetsPlayFragment extends Fragment {
    MaterialButton lets_play;
    NavController navController;

    public LetsPlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Quizfragment = inflater.inflate(R.layout.fragment_lets_play, container, false);
        myAds.loadBanner(getActivity());

        lets_play = Quizfragment.findViewById(R.id.lets_play);

        lets_play.setOnClickListener(v -> {
            createLevelsForJava();

            LevelsFragment levelsfragment = new LevelsFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main, levelsfragment);
            fragmentTransaction.commit();
            myAds.playintertisialad(requireContext(), requireActivity());

        });
        return Quizfragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);

    }

    public void createLevelsForJava() {

        SharedPreferences sharedPreferences;
        sharedPreferences = getContext().getSharedPreferences(getContext().getPackageName() + Constants.MY_LEVEL_PREFFILE,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);
        editor.putString(Constants.KEY_CAT_JAVA_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_1, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_JAVA_LEVEL_2, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_2, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2, 1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_JAVA_LEVEL_3, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_3, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3, 1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_JAVA_LEVEL_4, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_4, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4, 1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_JAVA_LEVEL_5, 0);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_5, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5, 1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_JAVA_LEVEL_6, 0);

        } else if (sharedPreferences.getString(Constants.KEY_CAT_JAVA_LEVEL_6, "N/A").equals("Unlock")) {

            editor.putInt(Constants.KEY_JAVA_LEVEL_1, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_2, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_3, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_4, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_5, 1);
            editor.putInt(Constants.KEY_JAVA_LEVEL_6, 1);  ///  Unlock Level 6

        }
    }


}
