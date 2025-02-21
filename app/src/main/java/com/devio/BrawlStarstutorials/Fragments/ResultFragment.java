package com.devio.BrawlStarstutorials.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.devio.BrawlStarstutorials.Ads.myAds;
import com.devio.BrawlStarstutorials.MainActivity;
import com.devio.BrawlStarstutorials.R;
import com.devio.BrawlStarstutorials.logic.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btPlayAgain, btPlayScreen, btPlayNextLevel;
    TextView txtTotalQuesion, txtCoins, txtWrongQues, txtCorrectQues;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        // Inflate the layout for this fragment
        View resultfragment = inflater.inflate(R.layout.fragment_result, container, false);

        btPlayAgain = resultfragment.findViewById(R.id.bt_PlayAgainR);
        btPlayScreen = resultfragment.findViewById(R.id.bt_PlayScreenR);
        btPlayNextLevel = resultfragment.findViewById(R.id.bt_PlayNextLevelR);

        txtCoins = resultfragment.findViewById(R.id.txtCoinsR);
        txtCorrectQues = resultfragment.findViewById(R.id.txtCorrectR);
        txtWrongQues = resultfragment.findViewById(R.id.txtWrongR);
        txtTotalQuesion = resultfragment.findViewById(R.id.txtTotalQuestionsR);


        Bundle bundle = this.getArguments();

        int totalQuestions = bundle.getInt(Constants.TOTAL_QUESTIONS, 0);
        int coins = bundle.getInt(Constants.COINS, 0);
        int correct = bundle.getInt(Constants.CORRECT, 0);
        int wrong = bundle.getInt(Constants.WRONG, 0);
        final String categoryValue = bundle.getString("Category");
        final int levelsId = bundle.getInt("Level", 0);


        txtTotalQuesion.setText(String.valueOf(totalQuestions));
        txtCoins.setText(String.valueOf(coins));
        txtCorrectQues.setText(String.valueOf(correct));
        txtWrongQues.setText(String.valueOf(wrong));


        btPlayScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LetsPlayFragment quizfragment = new LetsPlayFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main, quizfragment);
                fragmentTransaction.commit();
                myAds.playintertisialad(requireContext(), requireActivity());
            }
        });


        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Category", categoryValue);
                bundle.putInt("Level", levelsId);
                ///fragment to open
                QuestionsFragment questionsfragment = new QuestionsFragment();
                questionsfragment.setArguments(bundle);

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                ////getSupportFragmentManager() here can changed with getParentFragmentManager() and on a fragment getChildFragmentManager()
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main, questionsfragment);

                fragmentTransaction.commit();
                myAds.playintertisialad(requireContext(), requireActivity());
            }
        });


        btPlayNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("Category", categoryValue);
                ///fragment to open
                LevelsFragment playfragment = new LevelsFragment();
                playfragment.setArguments(bundle);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                ////getSupportFragmentManager() here can changed with getParentFragmentManager() and on a fragment getChildFragmentManager()
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main, playfragment);


                fragmentTransaction.commit();
                myAds.playintertisialad(requireContext(), requireActivity());
            }
        });

        return resultfragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);

    }
}
