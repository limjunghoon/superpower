package com.example.hansungapp;

import java.util.ArrayList;

import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Detail extends Activity implements OnClickListener {
	MyDBHelper mDBHelper;
	int mId;
	String title,today;
	EditText editDate, editTitle, editTime, editMemo;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		editDate = (EditText) findViewById(R.id.editdate);
		editTitle = (EditText) findViewById(R.id.edittitle);
		editTime = (EditText) findViewById(R.id.edittime);
		editMemo = (EditText) findViewById(R.id.editmemo);

		Intent intent = getIntent();
		//mId = intent.getIntExtra("ParamId", -1);
		today = intent.getStringExtra("today");
		title = intent.getStringExtra("Title");

		//mDBHelper = new MyDBHelper(this, "Today.db", null, 1);
		try {
			ArrayList<ParseObject> gameScore = new ArrayList<ParseObject>(); // parse.com에서 읽어온 object들을 저장할 List
			ParseQuery<ParseObject> query = ParseQuery.getQuery("gameScore"); // 서버에 mydatas class 데이터 요청
			query.whereEqualTo("Title", title ); // my_type이 1인 object만 읽어옴. 해당 함수 호출하지 않으면 class의 모든 데이터를 읽어옴.
			gameScore.addAll(query.find()); // 읽어온 데이터를 List에 저장
			
			// 읽어온 데이터를 화면에 보여주기 위한 처리
			//StringBuffer str = new StringBuffer();
			StringBuffer str = new StringBuffer();

			/*if (mId == -1) {
				editDate.setText(today);
				
			} else {*/
				/*SQLiteDatabase db = mDBHelper.getWritableDatabase();
				Cursor cursor = db.rawQuery("SELECT * FROM today WHERE _id='" + mId
						+ "'", null);*/
				editDate.setText(today);	
				for(ParseObject object : gameScore){
					//str.add((String) object.get("Title"));
					//str.append(object.get("Title"));
					
					editTitle.setText((String)object.get("Title"));
					editDate.setText((String)object.get("Date"));
					editTime.setText((String)object.get("Time"));
					editMemo.setText((String)object.get("Memo"));
				}
					
				
				//mDBHelper.close();
			//}
			
			
			//tx1.setText(str.toString());
			 // TextView에 데이터를 넣어준다.
				gameScore.clear();
			} catch (ParseException e) {
			e.printStackTrace();
			}		
		

		Button btn1 = (Button) findViewById(R.id.btnsave);
		btn1.setOnClickListener(this);
		Button btn2 = (Button) findViewById(R.id.btndel);
		btn2.setOnClickListener(this);
		Button btn3 = (Button) findViewById(R.id.btncancel);
		btn3.setOnClickListener(this);

		if (mId == -1) {
			btn2.setVisibility(View.INVISIBLE);

		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ParseACL defaultACL = new ParseACL();
		defaultACL.setPublicReadAccess(true); 
		ParseObject gameScore = new ParseObject("gameScore");
		//SQLiteDatabase db = mDBHelper.getWritableDatabase();
		//ParseObject Detail = new ParseObject("detail");
		
		switch (v.getId()) {
		case R.id.btnsave:
	
			
			
			if (mId != -1) {
				
				//업데이트
				/*db.execSQL("UPDATE today SET title='"
						+ editTitle.getText().toString() + "',date='"
						+ editDate.getText().toString() + "', time='"
						+ editTime.getText().toString() + "', memo='"
						+ editMemo.getText().toString() + "' WHERE _id='" + mId
						+ "';");
				
					ParseObject Detail = new ParseObject("detail");
					Detail.put("Title", editTitle);
			        Detail.put("Date", editDate);
			        Detail.put("Time", editTime);
			        Detail.put("Description", editMemo);
			        Detail.saveInBackground();
			    */
				gameScore.put("Title", editTitle.getText().toString());
				gameScore.put("Date", editDate.getText().toString());
				gameScore.put("Memo", editMemo.getText().toString());
				gameScore.put("Time", editTime.getText().toString());
				gameScore.setACL(defaultACL); // object에 ACL set
				

				gameScore.saveInBackground();
			        
				
			} else {
				
				/*db.execSQL("INSERT INTO today VALUES(null, '"
						+ editTitle.getText().toString() + "', '"
						+ editDate.getText().toString() + "', '"
						+ editTime.getText().toString() + "', '"
						+ editMemo.getText().toString() + "');");
		        */
				gameScore.put("Title", editTitle.getText().toString());
				gameScore.put("Date", editDate.getText().toString());
				gameScore.put("Memo", editMemo.getText().toString());
				gameScore.put("Time", editTime.getText().toString());
				gameScore.setACL(defaultACL); // object에 ACL set
				

				gameScore.saveInBackground();
		        
			}
			//mDBHelper.close();
			setResult(RESULT_OK);
			break;
		case R.id.btndel:
			//삭제 구현 필요
			if (mId != -1) {
				//db.execSQL("DELETE FROM today WHERE _id='" + mId + "';");
				//mDBHelper.close();
			}
			setResult(RESULT_OK);
			break;
		case R.id.btncancel:
			setResult(RESULT_CANCELED);
			break;
		}
		finish();
	}
}