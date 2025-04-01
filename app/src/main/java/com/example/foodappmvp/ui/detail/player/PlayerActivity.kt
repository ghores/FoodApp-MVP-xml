package com.example.foodappmvp.ui.detail.player

import android.os.Bundle
import android.view.WindowManager
import com.example.foodappmvp.databinding.ActivityPlayerBinding
import com.example.foodappmvp.utils.YOUTUBE_API_KEY
import com.example.foodappmvp.utils.showSnackBar
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class PlayerActivity : YouTubeBaseActivity() {
    //Binding
    private lateinit var binding: ActivityPlayerBinding

    //Other
    private var videoId = ""
    private lateinit var player: YouTubePlayer

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        //Full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        //Get data
        videoId = intent.getStringExtra("video_id").toString()
        //InitViews
        binding.apply {
            val listener = object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer,
                    p2: Boolean
                ) {
                    player = p1
                    player.loadVideo(videoId)
                    player.play()
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {
                    root.showSnackBar("Error")
                }
            }
            videoPlayer.initialize(YOUTUBE_API_KEY, listener)
        }
    }

    override fun onStop() {
        super.onStop()
        player.release()
    }
}