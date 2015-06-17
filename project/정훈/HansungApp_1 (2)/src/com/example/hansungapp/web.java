package com.example.hansungapp;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class web extends Activity{

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  //화면을 chat.xml로 지정
	  setContentView(R.layout.activity_web);
	 }
	  
	 //액티비티 종료 버튼을 눌렀을때 호출되는 메소드
	 public void end(View v){
	  //현재 액티비티를 종료시켜라(destroy:메모리에서 사라짐)
	  finish();
	 }
}

