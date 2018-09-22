package com.example.administrator.insulin_needle;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

// 앱 시작 전 3초 대기 화면
public class Intro extends Activity {
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            // 3초 뒤에 다음화면(MainActivity)으로 넘어간다
            Intent intent = new Intent(Intro.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        // 반복 설정
        animationView.loop(true);
        // 실행
        animationView.playAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 3초 뒤에 Runnable 객체 수행
        handler.postDelayed(r, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 예약 취소
        handler.removeCallbacks(r);
    }
}
