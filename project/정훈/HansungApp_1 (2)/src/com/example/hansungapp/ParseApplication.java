package com.example.hansungapp;
//com.styleroot.dustnotify 부분은 사용자의 앱 패키지 이름을 적어주세요.

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

 @Override
 public void onCreate() {
     super.onCreate();

  // Enable Local Datastore.
     Parse.enableLocalDatastore(this);
      
     Parse.initialize(this, "sdfdbFgnLW1mIXiQwDhCux6o0xCTF8DqRRpjowi8","5nopO60yYBP5iVkGjLjAc9DJQZ4qHYt9TbMSZToc");
    		 
  // Enable Local Datastore.
     /*Parse.enableLocalDatastore(this);	  
     ParseInstallation.getCurrentInstallation().saveInBackground();
     Parse.initialize(this, "ApplicationID", "ClientKey");        
     ParseUser.enableAutomaticUser();
     ParseACL defaultACL = new ParseACL();
     defaultACL.setPublicReadAccess(true);
     ParseACL.setDefaultACL(defaultACL, true);*/

     //PushService.subscribe(getApplicationContext(), "", MainActivity.class);
     //PushService.setDefaultPushCallback(getApplicationContext(), MainActivity.class);
 }
}