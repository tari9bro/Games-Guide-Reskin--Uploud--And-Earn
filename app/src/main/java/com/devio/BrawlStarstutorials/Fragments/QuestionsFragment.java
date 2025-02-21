package com.devio.BrawlStarstutorials.Fragments;

import static com.devio.BrawlStarstutorials.logic.Constants.COINS;
import static com.devio.BrawlStarstutorials.logic.Constants.CORRECT;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_CAT_JAVA_LEVEL_2;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_CAT_JAVA_LEVEL_3;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_CAT_JAVA_LEVEL_4;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_CAT_JAVA_LEVEL_5;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_CAT_JAVA_LEVEL_6;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_JAVA_LEVEL_2;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_JAVA_LEVEL_3;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_JAVA_LEVEL_4;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_JAVA_LEVEL_5;
import static com.devio.BrawlStarstutorials.logic.Constants.KEY_JAVA_LEVEL_6;
import static com.devio.BrawlStarstutorials.logic.Constants.MY_LEVEL_PREFFILE;
import static com.devio.BrawlStarstutorials.logic.Constants.TOTAL_QUESTIONS;
import static com.devio.BrawlStarstutorials.logic.Constants.WRONG;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.devio.BrawlStarstutorials.Ads.myAds;
import com.devio.BrawlStarstutorials.MainActivity;
import com.devio.BrawlStarstutorials.R;
import com.devio.BrawlStarstutorials.logic.PlayAudio;
import com.devio.BrawlStarstutorials.logic.TriviaQuestion;
import com.devio.BrawlStarstutorials.logic.TriviaQuizHelper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final long COUNTDOWN_IN_MILLIS = 32000;
    private final Handler handler = new Handler();
    private final Handler handler2 = new Handler();
    public TextView ruby;
    public MaterialAlertDialogBuilder dialog;
    TextView answerA, answerB, answerC, answerD, back;
    AppCompatTextView questionText, txtTotalQuesText, timeText, txtLevelIndicator;
    TriviaQuizHelper triviaQuizHelper;
    TriviaQuestion currentQuestion;
    List<TriviaQuestion> list;
   public int qid = 1, curentRuby;
    AnimationDrawable anim;
    long savedTime = 0,backPressedTime = 0;
    LevelsFragment playfragment;
    LetsPlayFragment quizfragment;
    Animation correctAnsAnimation,wrongAnsAnimation;
    PlayAudio playAudio;
    String categoryValue;
  private   int UNLOCK_JL2 = 0;
    private int UNLOCK_JL3 = 0;
    private int UNLOCK_JL4 = 0;
    private int UNLOCK_JL5 = 0;
    private int UNLOCK_JL6 = 0;
    private int levelsId;
    private int FLAG = -1;
    private int correct = 0;
    private int wrong = 0;
    private int coins = 0;
    private final int sizeofQuiz = 5; // total size of Quiz
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CountDownTimer countDownTimer;
    private long timeLeftMillis;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionsFragment newInstance(String param1, String param2) {

        QuestionsFragment fragment = new QuestionsFragment();
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
            Bundle bundle = this.getArguments();
            categoryValue = bundle.getString("Category");
            levelsId = bundle.getInt("Level", 0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentquestions = inflater.inflate(R.layout.fragment_questions, container, false);


        questionText = fragmentquestions.findViewById(R.id.txtTriviaQuestion);
        txtTotalQuesText = fragmentquestions.findViewById(R.id.txtTotalQuestion);
        answerA = fragmentquestions.findViewById(R.id.answerA);
        answerB = fragmentquestions.findViewById(R.id.answerB);
        answerC = fragmentquestions.findViewById(R.id.answerC);
        answerD = fragmentquestions.findViewById(R.id.answerD);
        back = fragmentquestions.findViewById(R.id.back);
        timeText = fragmentquestions.findViewById(R.id.txtTimer);
        txtLevelIndicator = fragmentquestions.findViewById(R.id.txtLevel3);
        MainActivity activity = (MainActivity) requireContext();
        TextView ruby = activity.findViewById(R.id.ruby);
        ruby.setText(String.valueOf(activity.LoadInt("ruby")));
        activity.rubyh.setText(String.valueOf(activity.LoadInt("ruby")));
        curentRuby = Integer.parseInt((String) ruby.getText());


        answerA.setOnClickListener(v -> {
            countDownTimer.cancel();
            disableOptions();
            answerA.setBackgroundResource(R.drawable.flash_background);
            anim = (AnimationDrawable) answerA.getBackground();
            anim.start();
            handler.postDelayed(() -> {
                if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())) {
                    raightAnwser(activity,answerA);
                    Log.i("QuizInfo", "Correct");
                    handler2.postDelayed(() -> {
                        if (qid != sizeofQuiz) {
                            SetNewQuestion();
                        } else {
                            finalResult();
                        }
                    }, 500);
                } else {
                    wrongAnswer(activity,answerA);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(() -> {
                        if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())) {
                            answerB.setBackgroundResource(R.drawable.correct_button_bg);
                        } else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())) {
                            answerC.setBackgroundResource(R.drawable.correct_button_bg);
                        } else {
                            answerD.setBackgroundResource(R.drawable.correct_button_bg);
                        }
                    }, 500);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(() -> {
                        if (qid != sizeofQuiz) {
                            SetNewQuestion();
                        } else {
                            finalResult();
                        }
                    }, 700);
                }
            }, 1000);
        });
        answerB.setOnClickListener(v -> {
            countDownTimer.cancel();
            disableOptions();
            answerB.setBackgroundResource(R.drawable.flash_background);
            anim = (AnimationDrawable) answerB.getBackground();
            anim.start();
            handler.postDelayed(() -> {
                if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())) {
                    raightAnwser(activity,answerB);

                    Log.i("QuizInfo", "Correct");

                    handler2.postDelayed(() -> {

                        if (qid != sizeofQuiz) {

                            SetNewQuestion();

                        } else {
                            finalResult();
                        }


                    }, 500);
                } else {
                    wrongAnswer(activity,answerB);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(() -> {

                        if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())) {
                            answerA.setBackgroundResource(R.drawable.correct_button_bg);
                        } else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())) {
                            answerC.setBackgroundResource(R.drawable.correct_button_bg);
                        } else {
                            answerD.setBackgroundResource(R.drawable.correct_button_bg);
                        }
                    }, 500);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(() -> {

                        if (qid != sizeofQuiz) {

                            SetNewQuestion();

                        } else {
                            finalResult();
                        }
                    }, 700);


                }


            }, 1000);


        });
        answerC.setOnClickListener(v -> {
            countDownTimer.cancel();

            disableOptions();
            answerC.setBackgroundResource(R.drawable.flash_background);
            anim = (AnimationDrawable) answerC.getBackground();
            anim.start();
            handler.postDelayed(() -> {
                if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())) {
                    raightAnwser(activity,answerC);
                    handler2.postDelayed(() -> {
                        if (qid != sizeofQuiz) {
                            SetNewQuestion();
                        } else {
                            finalResult();
                        }
                    }, 500);
                } else {
                    wrongAnswer(activity,answerC);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(() -> {
                        if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())) {
                            answerB.setBackgroundResource(R.drawable.correct_button_bg);
                        } else if (currentQuestion.getOption1().equals(currentQuestion.getAnswerNr())) {
                            answerA.setBackgroundResource(R.drawable.correct_button_bg);
                        } else {
                            answerD.setBackgroundResource(R.drawable.correct_button_bg);
                        }
                    }, 500);
                    Handler handler4 = new Handler();
                    handler4.postDelayed(() -> {
                        if (qid != sizeofQuiz) {
                            SetNewQuestion();
                        } else {
                            finalResult();
                        }
                    }, 700);
                }
            }, 1000);
        });
        answerD.setOnClickListener(v -> {

            countDownTimer.cancel();
            disableOptions();
            answerD.setBackgroundResource(R.drawable.flash_background);
            anim = (AnimationDrawable) answerD.getBackground();
            anim.start();


            handler.postDelayed(() -> {
                if (currentQuestion.getOption4().equals(currentQuestion.getAnswerNr())) {
                    raightAnwser(activity,answerD);

                    Log.i("QuizInfo", "Correct");

                    handler2.postDelayed(() -> {

                        if (qid != sizeofQuiz) {

                            SetNewQuestion();

                        } else {
                            finalResult();
                        }


                    }, 500);
                } else {
                    wrongAnswer(activity,answerD);
                    Handler handler3 = new Handler();
                    handler3.postDelayed(() -> {

                        if (currentQuestion.getOption2().equals(currentQuestion.getAnswerNr())) {
                            answerB.setBackgroundResource(R.drawable.correct_button_bg);
                        } else if (currentQuestion.getOption3().equals(currentQuestion.getAnswerNr())) {
                            answerC.setBackgroundResource(R.drawable.correct_button_bg);
                        } else {
                            answerA.setBackgroundResource(R.drawable.correct_button_bg);
                        }
                    }, 500);

                    Handler handler4 = new Handler();
                    handler4.postDelayed(() -> {

                        if (qid != sizeofQuiz) {

                            SetNewQuestion();

                        } else {
                            finalResult();
                        }
                    }, 700);


                }


            }, 1000);
        });
        back.setOnClickListener(view -> {
            LevelsFragment levelsfragment = new LevelsFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main, levelsfragment);
            fragmentTransaction.commit();
            myAds.playintertisialad(requireContext(), requireActivity());
        });
        correctAnsAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.correct_ans_animation);
        correctAnsAnimation.setRepeatCount(3);
        wrongAnsAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.wrong_ans_animation);
        wrongAnsAnimation.setRepeatCount(3);
        playAudio = new PlayAudio(getContext());
        triviaQuizHelper = new TriviaQuizHelper(getContext());
        triviaQuizHelper.getReadableDatabase();
        list = triviaQuizHelper.getQuestionsByLevelsAndCategory(categoryValue, levelsId);
        Collections.shuffle(list);
        currentQuestion = list.get(qid);
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);
        txtLevelIndicator.setText("Level " + levelsId);
        updateQueAnsOptions();

        return fragmentquestions;
    }

    private void wrongAnswer(MainActivity activity,TextView answer) {
        answer.setBackgroundResource(R.drawable.wrong_button_bg);
        answer.startAnimation(wrongAnsAnimation);
        wrong++;
        FLAG = 2;
        playAudio.setAudioforEvent(FLAG);
        coins = coins -1;
        TextView ruby = activity.findViewById(R.id.ruby);
        curentRuby = Integer.parseInt((String) ruby.getText());
        ruby.setText(String.valueOf((curentRuby - 1)));
        activity.rubyh.setText(String.valueOf((curentRuby - 1)));
        activity.SaveInt("ruby", curentRuby - 1);
        activity.greattoast(getActivity(), "1 -");
    }

    private void raightAnwser(MainActivity activity,TextView answer) {
        answer.setBackgroundResource(R.drawable.correct_button_bg);
        answer.startAnimation(correctAnsAnimation);
        correct++;
        FLAG = 1;
        playAudio.setAudioforEvent(FLAG);
        coins = coins + 1;
        TextView ruby = activity.findViewById(R.id.ruby);
        curentRuby = Integer.parseInt((String) ruby.getText());
        ruby.setText(String.valueOf(curentRuby + 1));
        activity.rubyh.setText(String.valueOf((curentRuby + 1)));
        activity.SaveInt("ruby", curentRuby + 1);
        activity.greattoast(getActivity(), "1 +");
        //coinsUpdateText(coins);
        Log.i("QuizInfo", "Correct");
    }

    private void timerDialog() {
        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(requireContext());
        dialog.setTitle(R.string.times_up);
        dialog.setIcon(R.drawable.ic_time);

        dialog.setCancelable(false);
        dialog.setNeutralButton(R.string.yes, (dialog12, which) -> {
            LevelsFragment playfragment = new LevelsFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main, playfragment);
            fragmentTransaction.commit();
        });
        dialog.show();
    }

    private void updateQueAnsOptions() {
        answerA.setBackgroundResource(R.drawable.side_nav_bar);
        answerB.setBackgroundResource(R.drawable.side_nav_bar);
        answerC.setBackgroundResource(R.drawable.side_nav_bar);
        answerD.setBackgroundResource(R.drawable.side_nav_bar);
        questionText.setText(currentQuestion.getQuestion());
        answerA.setText(currentQuestion.getOption1());
        answerB.setText(currentQuestion.getOption2());
        answerC.setText(currentQuestion.getOption3());
        answerD.setText(currentQuestion.getOption4());
        timeLeftMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();
    }

    private void SetNewQuestion() {
        qid++;
        txtTotalQuesText.setText(qid + "/" + sizeofQuiz);
        currentQuestion = list.get(qid);
        enableOptions();
        updateQueAnsOptions();
    }


    @Override
    public void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

    @Override
    public void onResume() {
        MainActivity activity = new MainActivity();
        super.onResume();
        requireView().setFocusableInTouchMode(true);
        requireView().requestFocus();
        requireView().setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                countDownTimer.cancel();
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    FragmentManager fm = requireActivity().getSupportFragmentManager();
                    fm.popBackStack();
                } else {
                    activity.greattoast(getActivity(), "Press Again to Exit");
                }
                backPressedTime = System.currentTimeMillis();
                activity.greattoast(getActivity(), "Press Again to Exit");
                return true;
            }
            return false;
        });

    }

    private void disableOptions() {
        answerA.setEnabled(false);
        answerB.setEnabled(false);
        answerC.setEnabled(false);
        answerD.setEnabled(false);
    }

    private void enableOptions() {
        answerA.setEnabled(true);
        answerB.setEnabled(true);
        answerC.setEnabled(true);
        answerD.setEnabled(true);
    }

    private void finalResult() {
        unLockTheLevels();
        Bundle bundle = new Bundle();
        bundle.putString("Category", categoryValue);
        bundle.putInt("Level", levelsId);
        bundle.putInt(TOTAL_QUESTIONS, sizeofQuiz);
        bundle.putInt(COINS, coins);
        bundle.putInt(WRONG, wrong);
        bundle.putInt(CORRECT, correct);
        ///fragment to open
        ResultFragment resultfragment = new ResultFragment();
        resultfragment.setArguments(bundle);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main, resultfragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void unLockTheLevels() {
        unLockJavaLevels();
    }

    private void unLockJavaLevels() {


        if (levelsId == 1 && categoryValue.equals("Java")) {
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_JL2 = correct;
            if (UNLOCK_JL2 >= 3) {
                saveLevels(KEY_JAVA_LEVEL_2, KEY_CAT_JAVA_LEVEL_2);
            }
        } else if (levelsId == 2 && categoryValue.equals("Java")) {
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_JL3 = correct;
            if (UNLOCK_JL3 >= 3) {
                saveLevels(KEY_JAVA_LEVEL_3, KEY_CAT_JAVA_LEVEL_3);
            }
        } else if (levelsId == 3 && categoryValue.equals("Java")) {
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_JL4 = correct;
            if (UNLOCK_JL4 >= 3) {
                saveLevels(KEY_JAVA_LEVEL_4, KEY_CAT_JAVA_LEVEL_4);

            }
        } else if (levelsId == 4 && categoryValue.equals("Java")) {
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_JL5 = correct;
            if (UNLOCK_JL5 >= 3) {
                saveLevels(KEY_JAVA_LEVEL_5, KEY_CAT_JAVA_LEVEL_5);
            }
        } else if (levelsId == 5 && categoryValue.equals("Java")) {
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_JL6 = correct;
            if (UNLOCK_JL6 >= 3) {
                saveLevels(KEY_JAVA_LEVEL_6, KEY_CAT_JAVA_LEVEL_6);
            }
        }
    }

    private void saveLevels(String i, String s) {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(requireContext().getPackageName() + MY_LEVEL_PREFFILE,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(String.valueOf(i), 1);    /// Unlock the level 2
        editor.apply();
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.putString(s, "Unlock");
        editor1.apply();
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftMillis, 500) {
            @Override
            public void onTick(long millsUnilFinished) {
                timeLeftMillis = millsUnilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftMillis = 0;
                updateCountDownText();
            }
        }.start();
    }

    private void updateCountDownText() {
        int seconds = (int) (timeLeftMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        savedTime = Long.parseLong(timeFormatted);
        timeText.setText(timeFormatted);
        if (timeLeftMillis < 10000) {
            timeText.setTextColor(ContextCompat.getColor(requireContext(), R.color.red));
        } else {
            timeText.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        }
        if (timeLeftMillis == 0) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    timerDialog();
                }
            }, 700);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);

    }
}