package com.givemepass.FragmentTabs;

import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class man {
	
	private int id;
	private int rate;
	private String time;

	public man() {
	}

	public man(String time, int rate) {
		super();
		this.time = time;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "man [id=" + id + ", time=" + time + ", rate=" + rate + "]";
	}

	public String getTime() {
		return time;
	}

	public int getId() {
		return id;
	}

	public int getRate() {
		return rate;
	}

	public void setTime(String a) {
		this.time = a;
	}

	public void setId(int i) {
		this.id = i;
	}

	public void setRate(int s) {
		this.rate = s;
	}
}

public class database extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "manDB";

	public database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_man_TABLE = "CREATE TABLE mans ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "time TEXT, "
				+ " rate INTEGER )";

		db.execSQL(CREATE_man_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS mans");

		this.onCreate(db);
	}

	private static final String TABLE_manS = "mans";

	private static final String KEY_ID = "id";
	private static final String KEY_TIME = "time";
	private static final String KEY_RATE = "rate";

	private static final String[] COLUMNS = { KEY_ID, KEY_TIME, KEY_RATE };

	public void addman(man man) {
		Log.d("addman", man.toString());
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_TIME, man.getTime());
		values.put(KEY_RATE, man.getRate());

		db.insert(TABLE_manS, null, values);

		db.close();
	}

	public List<man> getAllmans() {
		List<man> mans = new LinkedList<man>();

		 String query = " SELECT  * FROM " + TABLE_manS;
		
		 SQLiteDatabase db = this.getWritableDatabase();
		 Cursor cursor = db.rawQuery(query, null);
		
		 man man = null;
		 if (cursor.moveToFirst()) {
		 do {
			 man = new man();
			 man.setId(Integer.parseInt(cursor.getString(0)));
			 man.setTime(cursor.getString(1));
			 man.setRate(cursor.getInt(2));
		
			 mans.add(man);
		 } while (cursor.moveToNext());
		 }

		mans.add(man);

		Log.d("getAllmans()", mans.toString());

		return mans;
	}

	public void deleteman(man man) {

		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_manS, KEY_ID + " = ?",
				new String[] { String.valueOf(man.getId()) });

		db.close();

		Log.d("deleteman", man.toString());

	}
	
	public int getLastId() {
		String query = "SELECT MAX(id) AS max_id FROM " + TABLE_manS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		int id = 0;     
	    if (cursor.moveToFirst())
	    {
	        do
	        {           
	            id = cursor.getInt(0);                  
	        } while(cursor.moveToNext());           
	    }
	    return id;
	}
}
