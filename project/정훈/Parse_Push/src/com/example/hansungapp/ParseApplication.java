package com.example.hansungapp;
//com.styleroot.dustnotify 부분은 사용자의 앱 패키지 이름을 적어주세요.

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

import android.app.Application;
import android.util.Log;

public class ParseApplication extends Application {

 @Override
 public void onCreate() {
	  Parse.initialize(this, "sdfdbFgnLW1mIXiQwDhCux6o0xCTF8DqRRpjowi8", "5nopO60yYBP5iVkGjLjAc9DJQZ4qHYt9TbMSZToc");
	  ParseInstallation.getCurrentInstallation().saveInBackground();
	  
	  ParsePush.subscribeInBackground("", new SaveCallback() {
		  @Override
		  public void done(ParseException e) {
		    if (e == null) {
		      Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
		    } else {
		      Log.e("com.parse.push", "failed to subscribe for push", e);
		    }
		  }
		});

	 
      /*ParseUser.enableAutomaticUser();
      ParseACL defaultACL = new ParseACL();
      defaultACL.setPublicReadAccess(true);
      ParseACL.setDefaultACL(defaultACL, true);

      PushService.subscribe(getApplicationContext(), "", MainActivity.class);
      PushService.setDefaultPushCallback(getApplicationContext(), MainActivity.class);*/


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