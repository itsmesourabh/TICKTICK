package com.example.retro;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.myViewHolder> {
    ArrayList<videoModel> videos;

    public videoAdapter(ArrayList<videoModel> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view
               = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
       return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    holder.setData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView title,desc;
        ProgressBar progressBar;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView=itemView.findViewById(R.id.videoView);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            progressBar=itemView.findViewById(R.id.progressBar);


        }

        void setData(videoModel obj){
            videoView.setVideoURI(Uri.parse(obj.getUrl()));
            title.setText(obj.getTitle());
            desc.setText(obj.getDesc());
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float)
                            videoView.getHeight();
                    float scaleX = videoRatio / screenRatio;
                    if (scaleX >= 1f) {
                        videoView.setScaleX(scaleX);
                    } else {
                        videoView.setScaleY(1f / scaleX);
                    }
                }
            });
//            MediaController mediaController = new MediaController(itemView.getContext());
////            mediaController.setAnchorView(videoView);
//            mediaController.setMediaPlayer(videoView);
//            videoView.setMediaController(mediaController);
            videoView.start();
        }
    }
}
