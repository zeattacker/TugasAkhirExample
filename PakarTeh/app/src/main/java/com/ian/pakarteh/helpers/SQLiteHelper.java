package com.ian.pakarteh.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ian.pakarteh.models.Gejala;
import com.ian.pakarteh.models.Keputusan;
import com.ian.pakarteh.models.Penyakit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rama on 11/5/16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    static SQLiteHelper sqh;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "databaseKu";

    //TABLE
    private static final String TABLE_PENYAKIT = "penyakit";
    private static final String TABLE_GEJALA = "gejala";
    private static final String TABLE_KEPUTUSAN = "keputusan";
    private static final String TABLE_TEMP = "temp";

    //KOLOM
    private static final String KEY_ID = "id";
    private static final String KEY_PID = "pid";
    private static final String KEY_GID = "gid";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TIPE = "tipe";
    private static final String KEY_SOLUSI = "solusi";
    private static final String KEY_BOBOT = "bobot";
    private static final String KEY_INDEX_1 = "index1";
    private static final String KEY_INDEX_2 = "index2";
    private static final String KEY_INDEX_3 = "index3";
    private static final String KEY_INDEX_4 = "index4";
    private static final String KEY_INDEX_5 = "index5";
    private static final String KEY_INDEX_6 = "index6";
    private static final String KEY_TEMP_GID = "temp_gid";


    public static SQLiteHelper getInstance(Context context){
        if(sqh == null){
            sqh = new SQLiteHelper(context);
        }

        return sqh;
    }

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PENYAKIT_TBL = "CREATE TABLE " + TABLE_PENYAKIT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_PID + " TEXT,"
                + KEY_NAMA + " TEXT,"
                + KEY_SOLUSI + " TEXT" + ")";

        String CREATE_GEJALA_TBL = "CREATE TABLE " + TABLE_GEJALA + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_GID + " TEXT,"
                + KEY_INDEX_1 + " TEXT,"
                + KEY_INDEX_2 + " TEXT,"
                + KEY_INDEX_3 + " TEXT,"
                + KEY_INDEX_4 + " TEXT,"
                + KEY_INDEX_5 + " TEXT,"
                + KEY_INDEX_6 + " TEXT,"
                + KEY_NAMA + " TEXT" + ")";

        String CREATE_KEPUTUSAN_TBL = "CREATE TABLE " + TABLE_KEPUTUSAN + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_PID + " TEXT,"
                + KEY_GID + " TEXT,"
                + KEY_BOBOT + " TEXT" + ")";

        String CREATE_TEMP_TBL = "CREATE TABLE " + TABLE_TEMP + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_GID + " TEXT,"
                + KEY_TEMP_GID + " TEXT" + ")";

        db.execSQL(CREATE_PENYAKIT_TBL);
        db.execSQL(CREATE_GEJALA_TBL);
        db.execSQL(CREATE_KEPUTUSAN_TBL);
        db.execSQL(CREATE_TEMP_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PENYAKIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEPUTUSAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEJALA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMP);

        onCreate(db);
    }

    //HAMA
    public void addPenyakit(Penyakit penyakit){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PID, penyakit.getPid());
        cv.put(KEY_NAMA, penyakit.getNama());
        cv.put(KEY_SOLUSI, penyakit.getSolusi());

        db.insert(TABLE_PENYAKIT, null ,cv);
        db.close();
    }

    public Penyakit getPenyakit(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PENYAKIT, new String[] {KEY_ID,KEY_PID, KEY_NAMA, KEY_SOLUSI}, KEY_ID + "=?", new String[] { String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Penyakit penyakit = new Penyakit(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return penyakit;
    }

    public Penyakit getPenyakit(String pid){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PENYAKIT, new String[] {KEY_ID,KEY_PID, KEY_NAMA, KEY_SOLUSI}, KEY_PID + "=?", new String[] { pid}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Penyakit penyakit = new Penyakit(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return penyakit;
    }

    public Penyakit getPenyakitByPID(String pid){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PENYAKIT, new String[] {KEY_ID,KEY_PID, KEY_NAMA, KEY_SOLUSI}, KEY_PID + "=?", new String[] { pid }, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Penyakit penyakit = new Penyakit(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return penyakit;
    }

    public List<Penyakit> getAllPenyakit(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Penyakit> hamas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_PENYAKIT;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Penyakit hama = new Penyakit(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                hamas.add(hama);
            } while (cursor.moveToNext());
        }

        return hamas;
    }

    //GEJALA
    public void addGejala(Gejala gejala){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_GID, gejala.getGid());
        cv.put(KEY_INDEX_1,gejala.getIndex1());
        cv.put(KEY_INDEX_2,gejala.getIndex2());
        cv.put(KEY_INDEX_3,gejala.getIndex3());
        cv.put(KEY_INDEX_4,gejala.getIndex4());
        cv.put(KEY_INDEX_5,gejala.getIndex5());
        cv.put(KEY_INDEX_6,gejala.getIndex6());
        cv.put(KEY_NAMA, gejala.getNama());


        db.insert(TABLE_GEJALA, null ,cv);
        db.close();
    }

    public Gejala getGejala(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_GEJALA, new String[] {KEY_ID,KEY_GID, KEY_INDEX_1, KEY_INDEX_2, KEY_INDEX_3, KEY_INDEX_4, KEY_INDEX_5, KEY_INDEX_6, KEY_NAMA}, KEY_ID + "=?", new String[] { String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Gejala gejala = new Gejala(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));

        return gejala;
    }

    public List<Gejala> getGejalaByIndex(String index, String value){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Gejala> gejalas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_GEJALA + " WHERE " + index + " = '" + value + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Gejala gejala = new Gejala(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
                gejalas.add(gejala);
            } while (cursor.moveToNext());
        }

        return gejalas;
    }

    public List<Gejala> getGejalaByLikeIndex(String index, String value){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Gejala> gejalas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_GEJALA + " WHERE " + index + " LIKE '%" + value + "%'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Gejala gejala = new Gejala(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
                gejalas.add(gejala);
            } while (cursor.moveToNext());
        }

        return gejalas;
    }

    public List<Gejala> getGejalaByLikeIndex(String index,String index2, String value,String value2){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Gejala> gejalas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_GEJALA + " WHERE " + index + " LIKE '%" + value + "%' OR " + index2 + " LIKE '%" + value2 +"%'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Gejala gejala = new Gejala(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
                gejalas.add(gejala);
            } while (cursor.moveToNext());
        }

        return gejalas;
    }

    public List<Gejala> getAllGejala(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Gejala> gejalas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_GEJALA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Gejala gejala = new Gejala(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
                gejalas.add(gejala);
            } while (cursor.moveToNext());
        }

        return gejalas;
    }

    //KEPUTUSAN
    public void addKeputusan(Keputusan keputusan){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_GID, keputusan.getGid());
        cv.put(KEY_PID, keputusan.getPid());
        cv.put(KEY_BOBOT, keputusan.getBobot());

        db.insert(TABLE_KEPUTUSAN, null ,cv);
        db.close();
    }

    public Keputusan getKeputusan(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_KEPUTUSAN, new String[] {KEY_ID,KEY_GID, KEY_PID, KEY_BOBOT}, KEY_ID + "=?", new String[] { String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Keputusan putusan = new Keputusan(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getString(3));

        return putusan;
    }

    public List<Keputusan> getKeputusanByPid(String pid){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Keputusan> keputusans = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_KEPUTUSAN + " WHERE " + KEY_PID + " = '" + pid + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Keputusan keputusan = new Keputusan(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                keputusans.add(keputusan);
            } while (cursor.moveToNext());
        }

        return keputusans;
    }

    public List<Keputusan> getAllKeputusan(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Keputusan> keputusans = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_KEPUTUSAN;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Keputusan keputusan = new Keputusan(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                keputusans.add(keputusan);
            } while (cursor.moveToNext());
        }

        return keputusans;
    }

    //TEMP
    public void addTemp(String gid, String temp){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_GID, gid);
        cv.put(KEY_TEMP_GID, temp);

        db.insert(TABLE_TEMP, null, cv);
        db.close();
    }

    public List<String> getTempByGid(String gid){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> temps = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_TEMP + " WHERE " + KEY_GID + " = '" + gid + "'";

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                temps.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        return temps;
    }

    public ArrayList<String> getAllTemp(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> temps = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_TEMP;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                temps.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        return temps;
    }

    public int updateTemp(int id,String gid){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEMP_GID, gid);

        return db.update(TABLE_TEMP, values, KEY_ID + " = ?", new String[] { String.valueOf(id)});
    }

    public void deleteTemp(String gid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEMP, KEY_GID + " = ?",
                new String[] { gid });
        db.close();
    }

    public void deleteTemp(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_TEMP);
        db.close();
    }
}
