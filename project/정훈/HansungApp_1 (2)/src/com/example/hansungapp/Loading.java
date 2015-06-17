package com.example.hansungapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;


public class Loading extends Activity {    
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();      
            }
        }, 3000); // 3초 후 이미지를 닫습니다
 
    }
}