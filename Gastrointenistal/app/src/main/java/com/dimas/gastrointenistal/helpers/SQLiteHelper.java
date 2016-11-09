package com.dimas.gastrointenistal.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dimas.gastrointenistal.models.Artikel;
import com.dimas.gastrointenistal.models.Gejala;
import com.dimas.gastrointenistal.models.Hospital;
import com.dimas.gastrointenistal.models.Keputusan;
import com.dimas.gastrointenistal.models.Penyakit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rama on 11/2/16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    static SQLiteHelper sqh;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "databaseKu";

    //TABLE HOSPITAL
    private static final String TABLE_HOSPITAL = "hospitals";
    private static final String TABLE_PENYAKIT = "penyakits";
    private static final String TABLE_ARTIKEL = "artikel";
    private static final String TABLE_GEJALA = "gejala";
    private static final String TABLE_KEPUTUSAN = "keputusan";

    //KOLOM
    private static final String KEY_PENYAKIT_ID = "penyakid_id";
    private static final String KEY_GEJALA_ID = "gejala_id";
    private static final String KEY_HOSPITAL_ID = "hospital_id";
    private static final String KEY_ARTIKEL_ID = "artikel_id";
    private static final String KEY_KEPUTUSAN_ID = "keputusan_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "alamat";
    private static final String KEY_TELP = "telp";
    private static final String KEY_JADWAL = "jadwal";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LNG = "lng";
    private static final String KEY_KEC = "kec";
    private static final String KEY_PENANGANAN = "penanganan";
    private static final String KEY_DESC = "desc";
    private static final String KEY_KODE = "code";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_IMG = "img";
    private static final String KEY_PARAM = "param";
    private static final String KEY_GEJALA = "gejala";
    private static final String KEY_PENYAKIT = "penyakit";
    private static final String KEY_PROBALITAS = "probalitas";

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
        String CREATE_HOSPITAL_TBL = "CREATE TABLE " + TABLE_HOSPITAL + "("
                + KEY_HOSPITAL_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_KEC + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_TELP + " TEXT,"
                + KEY_JADWAL + " TEXT,"
                + KEY_LAT + " TEXT,"
                + KEY_LNG + " TEXT" + ")";

        String CREATE_PENYAKIT_TBL = "CREATE TABLE " + TABLE_PENYAKIT + "("
                + KEY_PENYAKIT_ID + " INTEGER PRIMARY KEY,"
                + KEY_KODE + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_PENANGANAN + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_IMG + " TEXT" + ")";

        String CREATE_ARTIKEL_TBL = "CREATE TABLE " + TABLE_ARTIKEL + "("
                + KEY_ARTIKEL_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT,"
                + KEY_CATEGORY + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_IMG + " TEXT" + ")";

        String CREATE_GEJALA_TBL = "CREATE TABLE " + TABLE_GEJALA + "("
                + KEY_GEJALA_ID + " INTEGER PRIMARY KEY,"
                + KEY_KODE + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_PARAM + " TEXT" + ")";

        String CREATE_KEPUTUSAN_TBL = "CREATE TABLE " + TABLE_KEPUTUSAN + "("
                + KEY_KEPUTUSAN_ID + " INTEGER PRIMARY KEY,"
                + KEY_PENYAKIT + " TEXT,"
                + KEY_GEJALA + " TEXT,"
                + KEY_PROBALITAS + " TEXT" + ")";

        db.execSQL(CREATE_HOSPITAL_TBL);
        db.execSQL(CREATE_PENYAKIT_TBL);
        db.execSQL(CREATE_ARTIKEL_TBL);
        db.execSQL(CREATE_GEJALA_TBL);
        db.execSQL(CREATE_KEPUTUSAN_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTIKEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOSPITAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PENYAKIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEJALA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEPUTUSAN);

        onCreate(db);
    }

    //CRUD HOSPITAL
    public void addHospital(Hospital hospital){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, hospital.getName());
        values.put(KEY_ADDRESS, hospital.getAlamat());
        values.put(KEY_KEC, hospital.getKec());
        values.put(KEY_LAT, hospital.getLat());
        values.put(KEY_LNG, hospital.getLng());
        values.put(KEY_JADWAL, hospital.getJadwal());
        values.put(KEY_TELP, hospital.getTelp());

        db.insert(TABLE_HOSPITAL, null, values);
        db.close();
    }

    public Hospital getHospital(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HOSPITAL, new String[] { KEY_HOSPITAL_ID, KEY_KEC, KEY_NAME, KEY_ADDRESS, KEY_TELP, KEY_JADWAL, KEY_LAT, KEY_LNG}, KEY_HOSPITAL_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Hospital hospital = new Hospital(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7)
        );

        return hospital;
    }

    public List<Hospital> getHospitals(){
        List<Hospital> hospitals = new ArrayList<Hospital>();

        String selectQuery = "SELECT * FROM " + TABLE_HOSPITAL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Hospital hospital = new Hospital(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7)
                );
                hospitals.add(hospital);
            } while (cursor.moveToNext());
        }

        return hospitals;
    }

    public List<Hospital> getHospitals(String kec){
        List<Hospital> hospitals = new ArrayList<Hospital>();

        String selectQuery = "SELECT * FROM " + TABLE_HOSPITAL + " WHERE " + KEY_KEC + " LIKE '%" + kec + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Hospital hospital = new Hospital(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7)
                );
                hospitals.add(hospital);
            } while (cursor.moveToNext());
        }

        return hospitals;
    }

    public int updateHospital(Hospital hospital){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, hospital.getName());
        values.put(KEY_ADDRESS, hospital.getAlamat());
        values.put(KEY_LAT, hospital.getLat());
        values.put(KEY_LNG, hospital.getLng());
        values.put(KEY_JADWAL, hospital.getJadwal());
        values.put(KEY_TELP, hospital.getTelp());

        return db.update(TABLE_HOSPITAL, values, KEY_HOSPITAL_ID + " = ?", new String[] { String.valueOf(hospital.getId())});
    }

    public void deleteHospital(Hospital hospital){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HOSPITAL, KEY_HOSPITAL_ID + " = ?",
                new String[] { String.valueOf(hospital.getId()) });
        db.close();
    }

    //CRUD ARTIKEL
    public void addArtikel(Artikel artikel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, artikel.getTitle());
        values.put(KEY_DESC, artikel.getDesc());
        values.put(KEY_CATEGORY, artikel.getCategory());
        values.put(KEY_IMG, artikel.getImg());

        db.insert(TABLE_ARTIKEL, null, values);
        db.close();
    }

    public Artikel getArtikel(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ARTIKEL, new String[] { KEY_ARTIKEL_ID, KEY_TITLE, KEY_DESC, KEY_CATEGORY, KEY_IMG}, KEY_ARTIKEL_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Artikel artikel = new Artikel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
        );

        return artikel;
    }

    public List<Artikel> getArtikels(){
        List<Artikel> artikels = new ArrayList<Artikel>();

        String selectQuery = "SELECT * FROM " + TABLE_ARTIKEL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Artikel artikel = new Artikel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                artikels.add(artikel);
            } while (cursor.moveToNext());
        }

        return artikels;
    }

    public int updateArtikel(Artikel artikel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, artikel.getCategory());
        values.put(KEY_TITLE, artikel.getTitle());
        values.put(KEY_DESC, artikel.getDesc());
        values.put(KEY_IMG, artikel.getImg());

        return db.update(TABLE_ARTIKEL, values, KEY_ARTIKEL_ID + " = ?", new String[] { String.valueOf(artikel.getId())});
    }

    public void deleteArtikel(Artikel artikel){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ARTIKEL, KEY_ARTIKEL_ID + " = ?",
                new String[] { String.valueOf(artikel.getId()) });
        db.close();
    }

    //CRUD PENYAKIT
    public void addPenyakit(Penyakit penyakit){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, penyakit.getName());
        values.put(KEY_KODE, penyakit.getKode());
        values.put(KEY_PENANGANAN, penyakit.getPenanganan());
        values.put(KEY_DESC, penyakit.getDesc());
        values.put(KEY_IMG, penyakit.getImg());

        db.insert(TABLE_PENYAKIT, null, values);
        db.close();
    }

    public Penyakit getPenyakit(String code){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PENYAKIT, new String[] { KEY_PENYAKIT_ID, KEY_NAME, KEY_KODE, KEY_PENANGANAN, KEY_DESC, KEY_IMG}, KEY_KODE + "=?",
                new String[] { code }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Penyakit penyakit = new Penyakit(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)
        );

        return penyakit;
    }

    public List<Penyakit> getPenyakits(){
        List<Penyakit> penyakits = new ArrayList<Penyakit>();

        String selectQuery = "SELECT * FROM " + TABLE_PENYAKIT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Penyakit penyakit = new Penyakit(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                );
                penyakits.add(penyakit);
            } while (cursor.moveToNext());
        }

        return penyakits;
    }

    public int updatePenyakit(Penyakit penyakit){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, penyakit.getName());
        values.put(KEY_KODE, penyakit.getKode());
        values.put(KEY_PENANGANAN, penyakit.getPenanganan());
        values.put(KEY_DESC, penyakit.getDesc());
        values.put(KEY_IMG, penyakit.getImg());

        return db.update(TABLE_ARTIKEL, values, KEY_PENYAKIT_ID + " = ?", new String[] { String.valueOf(penyakit.getId())});
    }

    public void deletePenyakit(Penyakit penyakit){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HOSPITAL, KEY_PENYAKIT_ID + " = ?",
                new String[] { String.valueOf(penyakit.getId()) });
        db.close();
    }

    //GEJALA

    public void addGejala(Gejala gejala){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PARAM, gejala.getParameter());
        cv.put(KEY_NAME, gejala.getNama());
        cv.put(KEY_KODE, gejala.getKode());

        db.insert(TABLE_GEJALA, null, cv);
        db.close();
    }

    public Gejala getGejala(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_GEJALA, new String[] { KEY_GEJALA_ID, KEY_PARAM, KEY_KODE, KEY_NAME}, KEY_GEJALA_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Gejala gejala = new Gejala(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
        );

        return gejala;
    }

    public List<Gejala> getGejalas(){
        List<Gejala> gejalas = new ArrayList<Gejala>();

        String selectQuery = "SELECT * FROM " + TABLE_GEJALA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Gejala penyakit = new Gejala(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(3),
                        cursor.getString(2)
                );
                gejalas.add(penyakit);
            } while (cursor.moveToNext());
        }

        return gejalas;
    }

    public int updateGejala(int id){
        return 0;
    }

    public void deleteGejala(){

    }

    //KEPUTUSAN
    public void addKeputusan(Keputusan keputusan){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_GEJALA,keputusan.getGejala());
        cv.put(KEY_PENYAKIT, keputusan.getPenyakit());
        cv.put(KEY_PROBALITAS, keputusan.getProbalitas());

        db.insert(TABLE_KEPUTUSAN, null, cv);
        db.close();
    }

    public Gejala getKeputusan(int id){
        return null;
    }

    public List<Keputusan> getKeputusans(){
        List<Keputusan> keputusans = new ArrayList<Keputusan>();

        String selectQuery = "SELECT * FROM " + TABLE_KEPUTUSAN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Keputusan penyakit = new Keputusan(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                keputusans.add(penyakit);
            } while (cursor.moveToNext());
        }

        return keputusans;
    }

    public int updateKeputusan(int id){
        return 0;
    }

    public void deleteKeputusan(){

    }
}
