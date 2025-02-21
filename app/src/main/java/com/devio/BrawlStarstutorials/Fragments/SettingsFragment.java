package com.devio.BrawlStarstutorials.Fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.devio.BrawlStarstutorials.MainActivity;
import com.devio.BrawlStarstutorials.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    public Context context;
    public Activity activity;
    TextView Exit_App;
    TextView Rate_App;
    TextView Share_App;
    TextView More_Apps;
    private ReviewInfo reviewinfo;
    private ReviewManager manager;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static void exittheapp(Activity activity, Context context) {
        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(context);
        dialog.setTitle(R.string.exit_dialog_title);
        dialog.setIcon(R.drawable.ic_exit);
        dialog.setMessage(R.string.exit_dialog_msg);
        dialog.setCancelable(false);
        dialog.setPositiveButton(R.string.yes, (dialogInterface, i) -> activity.finish());
        dialog.setNegativeButton(R.string.no, (dialogInterface, i) -> Toast.makeText(context, activity.getString(R.string.cancel_exit), Toast.LENGTH_LONG).show());
        dialog.show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View settingview = inflater.inflate(R.layout.fragment_settings, container, false);
        activatereviewinfo();
        Exit_App = settingview.findViewById(R.id.Exit_App);
        Rate_App = settingview.findViewById(R.id.Rate_App);
        Share_App = settingview.findViewById(R.id.Share_App);
        More_Apps = settingview.findViewById(R.id.More_Apps);
        Exit_App.setOnClickListener(v -> {
            exittheapp(getActivity(), getContext());
        });
        Rate_App.setOnClickListener(v -> {
            startReviewFlow();
        });
        Share_App.setOnClickListener(v -> {
            shartheapp();
        });
        More_Apps.setOnClickListener(v -> {
            moreapps();
        });

        return settingview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);

    }

    public void moreapps() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.developer_search))));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.developer_id))));
        }
    }

    public void shartheapp() {
        String url = getString(R.string.app_link);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plane");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_dialog_msg));
        intent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(intent, getString(R.string.share_dialog_title)));
    }

    public void activatereviewinfo() {
        manager = ReviewManagerFactory.create(getContext());
        Task<ReviewInfo> managerInfoTask = manager.requestReviewFlow();
        managerInfoTask.addOnCompleteListener((task) ->
        {
            if (task.isSuccessful()) {
                reviewinfo = task.getResult();
            } else {
                Toast.makeText(getContext(), getString(R.string.review_fail), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void startReviewFlow() {
        if (reviewinfo != null) {
            Task<Void> flow = manager.launchReviewFlow(getActivity(), reviewinfo);
            flow.addOnCompleteListener(task ->
                    Toast.makeText(getContext(), R.string.review_succeed, Toast.LENGTH_SHORT).show());
        }
    }


}
