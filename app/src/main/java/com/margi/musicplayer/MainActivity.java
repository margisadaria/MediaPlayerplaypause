package com.margi.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton =(ToggleButton)findViewById(R.id.main_toggle);
        ImageView imageView =(ImageView) findViewById(R.id.main_img);
        imageView.setImageResource(R.drawable.margi);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.shreya);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                 if(toggleButton.isChecked())
                 {
                     mediaPlayer.start();
                 }
                else
                 {
                     mediaPlayer.pause();
                 }
            }
        });


    }

    @Override
    protected void onPause()
    {
        super.onPause();

        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
