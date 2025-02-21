package com.devio.BrawlStarstutorials.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.devio.BrawlStarstutorials.MainActivity;
import com.devio.BrawlStarstutorials.R;
import com.devio.BrawlStarstutorials.logic.Constants;
import com.devio.BrawlStarstutorials.logic.TriviaQuestion;
import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LevelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LevelsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //    LinearLayouttxtLevel1,Level2,Level3;
//    LinearLayouttxtLevel4,Level5,Level6;
    AppCompatTextView txtLevel1;
    TextView txtLevel2, txtLevel3, txtLevel4, txtLevel5, txtLevel6, txtLevel7, txtLevel8;
    ImageView imgLevel1, imgLevel2, imgLevel3, imgLevel4, imgLevel5, imgLevel6;
    int JL1, JL2, JL3, JL4, JL5, JL6;
    String CategoryValue = "";
    MaterialButton back2;
    private WebView webView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public LevelsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment webviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LevelsFragment newInstance(String param1, String param2) {
        LevelsFragment fragment = new LevelsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString("Category", TriviaQuestion.CATEGORY_JAVA);
        args.putInt("Level", 2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View playfragment = inflater.inflate(R.layout.fragment_levels, container, false);
        txtLevel1 = playfragment.findViewById(R.id.txtLevel1);
        txtLevel2 = playfragment.findViewById(R.id.txtLevel2);
        txtLevel3 = playfragment.findViewById(R.id.txtLevel3);
        txtLevel4 = playfragment.findViewById(R.id.txtLevel4);
        txtLevel5 = playfragment.findViewById(R.id.txtLevel5);
        txtLevel6 = playfragment.findViewById(R.id.txtLevel6);
        imgLevel1 = playfragment.findViewById(R.id.imgLevel1);
        imgLevel2 = playfragment.findViewById(R.id.imgLevel2);
        imgLevel3 = playfragment.findViewById(R.id.imgLevel3);
        imgLevel4 = playfragment.findViewById(R.id.imgLevel4);
        imgLevel5 = playfragment.findViewById(R.id.imgLevel5);
        imgLevel6 = playfragment.findViewById(R.id.imgLevel6);
        lockandUnlockLevels();
        back2 = playfragment.findViewById(R.id.back2);
        back2.setOnClickListener(view -> {
            LetsPlayFragment letsPlayFragment = new LetsPlayFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main, letsPlayFragment);
            fragmentTransaction.commit();
        });
        return playfragment;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void lockandUnlockLevels() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getContext().getPackageName() + Constants.MY_LEVEL_PREFFILE,
                Context.MODE_PRIVATE);
        JL1 = sharedPreferences.getInt(Constants.KEY_JAVA_LEVEL_1, 0);
        JL2 = sharedPreferences.getInt(Constants.KEY_JAVA_LEVEL_2, 0);
        JL3 = sharedPreferences.getInt(Constants.KEY_JAVA_LEVEL_3, 0);
        JL4 = sharedPreferences.getInt(Constants.KEY_JAVA_LEVEL_4, 0);
        JL5 = sharedPreferences.getInt(Constants.KEY_JAVA_LEVEL_5, 0);
        JL6 = sharedPreferences.getInt(Constants.KEY_JAVA_LEVEL_6, 0);
        QuestionsFragment questionsfragment = new QuestionsFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        // Level 1
        if (JL1 == 1) {
            txtLevel1.setClickable(true);
            txtLevel1.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("Category", TriviaQuestion.CATEGORY_JAVA);
                bundle.putInt("Level", 1);
                questionsfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main, questionsfragment);
                fragmentTransaction.commit();
            });
            imgLevel1.setImageResource(R.drawable.unlock_24);
        } else {
            txtLevel1.setClickable(false);
            imgLevel1.setImageResource(R.drawable.lock_24);
        }
        // Level 2
        if (JL2 == 1) {
            txtLevel2.setClickable(true);
            txtLevel2.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("Category", TriviaQuestion.CATEGORY_JAVA);
                bundle.putInt("Level", 2);
                questionsfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main, questionsfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            });
            imgLevel2.setImageResource(R.drawable.unlock_24);
        } else {
            txtLevel2.setClickable(false);
            imgLevel2.setImageResource(R.drawable.lock_24);
        }
        // Level 3
        if (JL3 == 1) {
            txtLevel3.setClickable(true);
            txtLevel3.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("Category", TriviaQuestion.CATEGORY_JAVA);
                bundle.putInt("Level", 3);
                questionsfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main, questionsfragment);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            });
            imgLevel3.setImageResource(R.drawable.unlock_24);
        } else {
            txtLevel3.setClickable(false);
            imgLevel3.setImageResource(R.drawable.lock_24);
        }
        // Level 4
        if (JL4 == 1) {
            txtLevel4.setClickable(true);
            txtLevel4.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("Category", TriviaQuestion.CATEGORY_JAVA);
                bundle.putInt("Level", 4);
                questionsfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main, questionsfragment);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main, questionsfragment);
            });
            imgLevel4.setImageResource(R.drawable.unlock_24);
        } else {
            txtLevel4.setClickable(false);
            imgLevel4.setImageResource(R.drawable.lock_24);
        }
        // Level 5
        if (JL5 == 1) {
            txtLevel5.setClickable(true);
            txtLevel5.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("Category", TriviaQuestion.CATEGORY_JAVA);
                bundle.putInt("Level", 5);
                questionsfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main, questionsfragment);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            });
            imgLevel5.setImageResource(R.drawable.unlock_24);
        } else {
            txtLevel5.setClickable(false);
            imgLevel5.setImageResource(R.drawable.lock_24);
        }
        // Level 6
        if (JL6 == 1) {
            txtLevel6.setClickable(true);
            txtLevel6.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("Category", TriviaQuestion.CATEGORY_JAVA);
                bundle.putInt("Level", 6);
                questionsfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main, questionsfragment);
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            });
            imgLevel6.setImageResource(R.drawable.unlock_24);
        } else {
            txtLevel6.setClickable(false);
            imgLevel6.setImageResource(R.drawable.lock_24);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);

    }
}