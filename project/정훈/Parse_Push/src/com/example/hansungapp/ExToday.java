package com.example.hansungapp;

import java.util.ArrayList;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ExToday extends Activity implements OnItemClickListener,
		OnClickListener {
	MyDBHelper mDBHelper;
	String today;
	Cursor cursor;
	SimpleCursorAdapter adapter;
	ArrayList<String> str;
	
	ListView list;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extoday);

		Intent intent = getIntent();
		today = intent.getStringExtra("Param1");

		TextView text = (TextView) findViewById(R.id.texttoday);
		text.setText(today);

		/*
		mDBHelper = new MyDBHelper(this, "Today.db", null, 1);
		SQLiteDatabase db = mDBHelper.getWritableDatabase();
		
		cursor = db.rawQuery(
				"SELECT * FROM today WHERE date = '" + today + "'", null);
		*/
		
		try {
			ArrayList<ParseObject> gameScore = new ArrayList<ParseObject>(); // parse.com���� �о�� object���� ������ List
			ParseQuery<ParseObject> query = ParseQuery.getQuery("gameScore"); // ������ mydatas class ������ ��û
			query.whereEqualTo("Date", today); // my_type�� 1�� object�� �о��. �ش� �Լ� ȣ������ ������ class�� ��� �����͸� �о��.
			gameScore.addAll(query.find()); // �о�� �����͸� List�� ����
			
			// �о�� �����͸� ȭ�鿡 �����ֱ� ���� ó��
			//StringBuffer str_1 = new StringBuffer();
			
			
			str = new ArrayList<String>();
			
			for(ParseObject object : gameScore){
				//str_1.append(object.get("Title"));
				str.add((String) object.get("Title"));
			}
			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
		             this, android.R.layout.simple_list_item_1, str);
		
			
			ListView list = (ListView) findViewById(R.id.list1);
			list.setAdapter(adapter1);
			list.setOnItemClickListener(this);
			
			
			
			//tx1.setText(str.toString());
			 // TextView�� �����͸� �־��ش�.
				gameScore.clear();
			} catch (ParseException e) {
			e.printStackTrace();
			}		
		
		/*adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, cursor, new String[] {
						"title", "time" }, new int[] { android.R.id.text1,
						android.R.id.text2 });
		*/
		
		
		

		//mDBHelper.close();

		Button btn = (Button) findViewById(R.id.btnadd);
		btn.setOnClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		/*Intent intent = new Intent(this, Detail.class);
		cursor.moveToPosition(position);
		intent.putExtra("ParamID", cursor.getInt(0));
		startActivityForResult(intent, 0);*/
		
		String str_1=((TextView)view).getText().toString();
		Intent intent = new Intent(this, Detail.class);
		intent.putExtra ("Title", str_1);//*
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, Detail.class);
		intent.putExtra("today", today);
		startActivityForResult(intent, 1);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		// super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
		case 1:
			if (resultCode == RESULT_OK) {
				// adapter.notifyDataSetChanged();
				/*SQLiteDatabase db = mDBHelper.getWritableDatabase();
				cursor = db.rawQuery("SELECT * FROM today WHERE date = '"
						+ today + "'", null);
				adapter.changeCursor(cursor);
				mDBHelper.close();*/
			}
			break;
		}
	}
}
