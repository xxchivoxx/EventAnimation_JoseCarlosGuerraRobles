package com.example.carlos.eventanimation_josecarlosguerrarobles;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;
    boolean clickCiclos=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.faceIcon);
        canvas = findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {
        int screenHeight = canvas.getHeight();
        int targetY = 0;
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    imageView, "y", screenHeight, targetY)
                    .setDuration(2000);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
    }

    public void Acelerar(View v) {
        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(3000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }
    public void DesAcelerar(View v) {
        int screenHeight = canvas.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 800, 0)
                .setDuration(3000);

        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    public void ciclos(View v) {

        CycleInterpolator cycleInterpolator = new CycleInterpolator(10f);
        ViewPropertyAnimator anim = imageView.animate();
        anim.alpha(0);
        anim.setDuration(1000);
        anim.setInterpolator(cycleInterpolator);
    }
}