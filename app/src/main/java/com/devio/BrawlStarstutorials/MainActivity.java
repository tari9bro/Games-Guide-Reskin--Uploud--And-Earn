package com.devio.BrawlStarstutorials;

import static com.devio.BrawlStarstutorials.logic.Constants.buttommenu;
import static com.devio.BrawlStarstutorials.logic.Constants.check;
import static com.devio.BrawlStarstutorials.logic.Constants.history;
import static com.devio.BrawlStarstutorials.logic.Constants.inisializehistory;
import static com.devio.BrawlStarstutorials.logic.Constants.largest;
import static com.devio.BrawlStarstutorials.logic.Constants.loadhistory;
import static com.devio.BrawlStarstutorials.logic.Constants.mRewardedAd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.devio.BrawlStarstutorials.Ads.myAds;
import com.devio.BrawlStarstutorials.Fragments.ExploreFragment;
import com.devio.BrawlStarstutorials.Fragments.QuestionsFragment;
import com.github.hariprasanths.floatingtoast.FloatingToast;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

public class  MainActivity extends AppCompatActivity {
    public TextView rubyh;
    TextView coinsh, coins, ruby;
    NavController navController;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    WebView webView;
    ExploreFragment explorefragment = new ExploreFragment();
QuestionsFragment questionsFragment=new QuestionsFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main, explorefragment);
        fragmentTransaction.commit();
        MobileAds.initialize(this, initializationStatus -> {
        });
        myAds.loadBanner(MainActivity.this);
        init();
        inisializehistory();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setItemIconTintList(null);
        setbadg(bottomNavigationView.getOrCreateBadge(R.id.Quiz),99);

        View headerv = navigationView.getHeaderView(0);
        coinsh = headerv.findViewById(R.id.coinsh);
        coins = findViewById(R.id.coins);
        rubyh = headerv.findViewById(R.id.rubyh);
        loadhistory(LoadInt("key"));
        ruby = findViewById(R.id.ruby);
        ruby.setText(String.valueOf(LoadInt("ruby")));
        rubyh.setText(String.valueOf(LoadInt("ruby")));
        ruby.setOnClickListener(v -> {
            playvideoadforruby();
        });
        rubyh.setOnClickListener(v -> {
            playvideoadforruby();
        });

        savediconstatue(navigationView);
        loadVideo();
        myAds.loadIntertesial(MainActivity.this, this);
        coinsh.setText(String.valueOf(largest()));
        coins.setText(String.valueOf(largest()));


        myAds.loadIntertesial(MainActivity.this, this);
        loadVideo();

        myAds.playintertisialad(MainActivity.this, this);
    navigationView.setNavigationItemSelectedListener(menuItem -> {

            if (menuItem.getItemId() == R.id.a1) {
               switchlogic(100, 0, R.string.link1, menuItem, 1);

                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a2) {
                switchlogic(200, 100, R.string.link2, menuItem, 2);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a3) {
                switchlogic(300, 200, R.string.link3, menuItem, 3);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));
            }
            if (menuItem.getItemId() == R.id.a4) {
                switchlogic(400, 300, R.string.link4, menuItem, 4);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a5) {
                switchlogic(500, 400, R.string.link5, menuItem, 5);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a6) {
                switchlogic(600, 500, R.string.link6, menuItem, 6);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a7) {
                switchlogic(700, 600, R.string.link7, menuItem, 7);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a8) {
                switchlogic(800, 700, R.string.link8, menuItem, 8);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a9) {
                switchlogic(900, 800, R.string.link9, menuItem, 9);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a10) {
                switchlogic(1000, 900, R.string.link10, menuItem, 10);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a11) {
                switchlogic(1100, 1000, R.string.link11, menuItem, 11);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a12) {
                switchlogic(1200, 1100, R.string.link12, menuItem, 12);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));


            }
            if (menuItem.getItemId() == R.id.a13) {
                switchlogic(1300, 1200, R.string.link13, menuItem, 13);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a14) {
                switchlogic(1400, 1300, R.string.link14, menuItem, 14);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a15) {
                switchlogic(1500, 1400, R.string.link15, menuItem, 15);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a16) {
                switchlogic(1600, 1500, R.string.link16, menuItem, 16);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a17) {
                switchlogic(1700, 1600, R.string.link17, menuItem, 17);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a18) {
                switchlogic(1800, 1700, R.string.link18, menuItem, 18);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a19) {
                switchlogic(1900, 1800, R.string.link19, menuItem, 19);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }
            if (menuItem.getItemId() == R.id.a20) {
                switchlogic(2000, 1900, R.string.link20, menuItem, 20);
                coinsh.setText(String.valueOf(largest()));
                coins.setText(String.valueOf(largest()));

            }

            if (menuItem.getItemId() == R.id.About_App) {
                loadweurl(R.string.linkpp);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (menuItem.getItemId() == R.id.Privacy_Policy) {
                loadweurl(R.string.linkpp);
                drawerLayout.closeDrawer(GravityCompat.START);
            }

            return false;
        });
    }

    private void setbadg(BadgeDrawable item, int number) {
        BadgeDrawable badge= item ;
        badge.setVisible(true);
        badge.setVerticalOffsetWithText(20);
        badge.setNumber(number);
        badge.setAlpha(255);
    }


    public void loadweurl(int msg) {
       WebView webview = this.explorefragment.getwebview();
      //  webview.loadUrl(msg);
        String  str = "<meta content=\"width=device-width, initial-scale=1, user-scalable=no\" name=\"viewport\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/main.css\" /><link href=\"assets/css/noscript.css\" rel=\"stylesheet\" />" + getString(msg);
        webview.loadDataWithBaseURL("file:///android_asset/", str, "text/html", "UTF-8",null);
    }

    private void init() {
        drawerLayout = findViewById(R.id.drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navmenu);
        navigationView.setItemIconTintList(null);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.setDrawerSlideAnimationEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.animate().start();
        navController = Navigation.findNavController(this, R.id.main);
        appBarConfiguration = new AppBarConfiguration.Builder(buttommenu).setOpenableLayout(drawerLayout).build();


    }

    public void score(int max, int min, MenuItem menuItem, int url, int nmbr) {

        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(MainActivity.this);
        dialog.setTitle(R.string.rewarded_dialog_title);
        dialog.setMessage(R.string.rewarded_dialog_msg);
        dialog.setIcon(R.drawable.coin);
        dialog.setNeutralButton(R.string.exit, (dialogInterface, i) -> {
            greattoast(MainActivity.this, getString(R.string.refuse_to_watch_rewarded));
            dialogInterface.dismiss();
        });

        dialog.setPositiveButton(R.string.yes, (dialogInterface, i) -> playvideoad(max, min, menuItem, url, nmbr));

        dialog.setNegativeButton(R.string.no, (dialogInterface, i) -> {
            greattoast(MainActivity.this, getString(R.string.refuse_to_watch_rewarded));
            dialogInterface.dismiss();
        });
        dialog.show();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void switchlogic(int max, int min, int url, MenuItem menuItem, int nmbr) {
        if (!check(history, max) && check(history, min)) {
            history[nmbr] = max;
            menuItem.setIcon(R.drawable.unlock);

            loadweurl(url);
            drawerLayout.closeDrawer(GravityCompat.START);
            myAds.playintertisialad(MainActivity.this, this);
            SaveInt("key", max);
        } else if (!check(history, min)) {
            score(max, min, menuItem, url, nmbr);
        } else {
            if (!(menuItem.getIcon() == AppCompatResources.getDrawable(this, R.drawable.lock))) {
                menuItem.setIcon(R.drawable.unlock);
            }
            loadweurl(url);
            drawerLayout.closeDrawer(GravityCompat.START);
            myAds.playintertisialad(MainActivity.this, this);
        }
    }

    public void SaveInt(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int LoadInt(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPreferences.getInt(key, 0);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void savediconstatue(NavigationView nav) {
        Menu m = nav.getMenu();
        if (check(history, 200)) {
            m.findItem(R.id.a2).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 300)) {
            m.findItem(R.id.a3).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 400)) {
            m.findItem(R.id.a4).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 500)) {
            m.findItem(R.id.a5).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 600)) {
            m.findItem(R.id.a6).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 700)) {
            m.findItem(R.id.a7).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 800)) {
            m.findItem(R.id.a8).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 900)) {
            m.findItem(R.id.a9).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1000)) {
            m.findItem(R.id.a10).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1100)) {
            m.findItem(R.id.a11).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1200)) {
            m.findItem(R.id.a12).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1300)) {
            m.findItem(R.id.a13).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1400)) {
            m.findItem(R.id.a14).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1500)) {
            m.findItem(R.id.a15).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1600)) {
            m.findItem(R.id.a16).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1700)) {
            m.findItem(R.id.a17).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1800)) {
            m.findItem(R.id.a18).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 1900)) {
            m.findItem(R.id.a19).setIcon(getDrawable(R.drawable.unlock));
        }
        if (check(history, 2000)) {
            m.findItem(R.id.a20).setIcon(getDrawable(R.drawable.unlock));
        }
    }

    public void loadVideo() {
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, getString(R.string.Video_id),
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdShowedFullScreenContent() {
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                greattoast(MainActivity.this, getString(R.string.reward_earned_msg));
                                mRewardedAd = null;
                                loadVideo();
                            }
                        });

                    }
                });
    }

    public void playvideoad(int max, int min, MenuItem menuItem, int url, int nmbr) {
        if (mRewardedAd != null) {
            mRewardedAd.show(this, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    greattoast(MainActivity.this, getString(R.string.earned_reward_msg));
                    history[nmbr - 1] = min;
                    history[nmbr] = max;
                    menuItem.setIcon(R.drawable.unlock);
                    loadweurl(url);

                    drawerLayout.closeDrawer(GravityCompat.START);
                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();
                }
            });
        } else {
            loadVideo();
        }

    }
    public void playvideoadforruby() {
        if (mRewardedAd != null) {
            mRewardedAd.show(this, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    greattoast(MainActivity.this, getString(R.string.earned_reward_msg));
                    questionsFragment.curentRuby = Integer.parseInt((String) ruby.getText());
                    ruby.setText(String.valueOf((questionsFragment.curentRuby + 1)));
                    rubyh.setText(String.valueOf((questionsFragment.curentRuby + 1)));

                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();
                }
            });
        } else {
            loadVideo();
        }

    }
    public void greattoast(Activity activity, String text) {
        FloatingToast.makeToast(activity, text, FloatingToast.LENGTH_MEDIUM)
                .setFadeOutDuration(FloatingToast.FADE_DURATION_LONG)
                .setTextSizeInDp(25)
                .setGravity(FloatingToast.GRAVITY_MID_TOP)
                .setFloatDistance(FloatingToast.DISTANCE_LONG)
                .setTextColor(Color.parseColor("#E1B530"))
                .show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        loadhistory(LoadInt("key"));
        super.onStart();
    }

    @Override
    protected void onResume() {
        loadhistory(LoadInt("key"));

        super.onResume();
    }


}
