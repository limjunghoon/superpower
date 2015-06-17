package com.example.hansungapp;


import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ValidFragment")
public class Tab2 extends Fragment  implements OnClickListener,
OnItemClickListener {

	ArrayList<String> mItems;
	ArrayAdapter<String> adapter;
	TextView textYear;
	TextView textMon;
	Context mContext;

	public Tab2(Context context)
	{
		mContext = context;
	}
	public Tab2()
	{

	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.tab2, null);
		
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);

		textYear = (TextView) view.findViewById(R.id.edit1);
		textMon = (TextView) view.findViewById(R.id.edit2);

		mItems = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mItems);
				

		GridView gird = (GridView) view.findViewById(R.id.grid1);
		gird.setAdapter(adapter);
		gird.setOnItemClickListener(this);

		Date date = new Date();// 오늘에 날짜를 세팅 해준다.
		int year = date.getYear() + 1900;
		int mon = date.getMonth() + 1;
		textYear.setText(year + "");
		textMon.setText(mon + "");

		fillDate(year, mon);

		Button btnmove = (Button) view.findViewById(R.id.bt1);
		btnmove.setOnClickListener(this);
		

		return view;
	}
	private void fillDate(int year, int mon) {
		mItems.clear();

		mItems.add("일");
		mItems.add("월");
		mItems.add("화");
		mItems.add("수");
		mItems.add("목");
		mItems.add("금");
		mItems.add("토");

		Date current = new Date(year - 1900, mon - 1, 1);
		int day = current.getDay(); // 요일도 int로 저장.

		for (int i = 0; i < day; i++) {
			mItems.add("");
		}

		current.setDate(32);// 32일까지 입력하면 1일로 바꿔준다.
		int last = 32 - current.getDate();

		for (int i = 1; i <= last; i++) {
			mItems.add(i + "");
		}
		adapter.notifyDataSetChanged();

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if (mItems.get(arg2).equals("")) {
			;
		} else {
			Intent intent = new Intent(getActivity(), ExToday.class);
			intent.putExtra("Param1", textYear.getText().toString() + "/"
					+ textMon.getText().toString() + "/" + mItems.get(arg2));
			startActivity(intent);
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.bt1) {
			int year = Integer.parseInt(textYear.getText().toString());
			int mon = Integer.parseInt(textMon.getText().toString());
			fillDate(year, mon);
		}

	}


}