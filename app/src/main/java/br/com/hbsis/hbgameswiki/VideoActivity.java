package br.com.hbsis.hbgameswiki;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends YouTubeBaseActivity {

    private  static final String TAG = "VideoActivity";

    YouTubePlayerView myYuTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Log.d(TAG, "onCreate: Starting ");
        btnPlay = findViewById(R.id.btnPlay);
        myYuTubePlayerView = findViewById(R.id.youtubePlay);
        String url = getIntent().getStringExtra("video");

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                List<String> videoList = new ArrayList<>();
                videoList.add(String.valueOf(btnPlay));
                youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: FAILED. ");
            }
        };
        myYuTubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);
    }
}
