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
	  //ȭ���� chat.xml�� ����
	  setContentView(R.layout.activity_web);
	 }
	  
	 //��Ƽ��Ƽ ���� ��ư�� �������� ȣ��Ǵ� �޼ҵ�
	 public void end(View v){
	  //���� ��Ƽ��Ƽ�� ������Ѷ�(destroy:�޸𸮿��� �����)
	  finish();
	 }
}

