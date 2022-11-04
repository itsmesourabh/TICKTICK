package com.example.retro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<videoModel> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2=findViewById(R.id.viewPager);
        videos=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            videoModel ob2 = new videoModel("https://media.istockphoto.com/videos/young-couple-gardening-together-in-house-backyard-video-id1332993552", "this is video 1", "Video 1");
            videos.add(ob2);
            videoModel ob3 = new videoModel("https://media.istockphoto.com/videos/container-ship-isometric-3d-loopable-animation-video-id1220204077", "this is video 2", "Video 2");
            videos.add(ob3);
            videoModel ob4 = new videoModel("https://media.istockphoto.com/videos/3d-render-precision-concept-seamless-loop-of-an-array-of-golden-balls-video-id1302647775", "this is video 3", "Video 3");
            videos.add(ob4);
            videoModel ob5 = new videoModel("https://media.istockphoto.com/videos/abstract-3d-render-red-geometric-background-with-cubes-motion-design-video-id1300951702", "this is video 4", "Video 4");
            videos.add(ob5);
            videoModel ob6 = new videoModel("https://media.istockphoto.com/videos/abstract-3d-render-red-geometric-background-with-cubes-motion-design-video-id1300951702", "this is video 5", "Video 5");
            videos.add(ob6);
        }

        viewPager2.setAdapter(new videoAdapter(videos));

    }
}