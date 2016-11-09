package com.ian.pakarteh.views.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ian.pakarteh.R;
import com.ian.pakarteh.helpers.SQLiteHelper;
import com.ian.pakarteh.helpers.SessionHelper;
import com.ian.pakarteh.models.Gejala;
import com.ian.pakarteh.models.Keputusan;
import com.ian.pakarteh.models.Penyakit;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(SessionHelper.getInstance(this).getAppFirstTime()){
            //penyakit
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P001","Cendawan Akar Merah","Pemberantasan secara langsung dapat dilakukan dengan cara membongkar pohon pelindung yang terserang penyakit itu dan juga pohon teh yang sudah terserang. • Beri pupuk kandang atau pupuk organik di sekitar tanaman yang terserang penyakit Untuk pengendalian pada penyakit ini dengan membongkar dan membakar teh yang sakit, menggali selokan sedalam 60 hingga 100 cm di sekeliling tanaman sehat, fumigasi metal bromide atau Vapam."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P002","Cendawan Akar Hitam","Pohon teh yang terserang penyakit cendawan akar hitam ini harus dibongkar dan kemudian lobang bekas bongkaran pohon teh tersebut kita siram dengan lumpur belerang sebanyak 200 gram untuk tiap lobangnya."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P003","Cendawan Leher Akar","Kalau saja serangan penyakit ini belum masuk ke dalam kayu, maka bisa dengan jalan/mengupas kulit yang terserang. lalu lukanya dilabur dengan obat penutup luka. • Beri pupuk kandang atau pupuk organik di sekitar tanaman yang terserang penyakit Pencegahannya dengan menjaga jangan sampai melukai pohon sewaktu kita mengerjakan tanah maupun merumput."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P004","Jamur Upas","Bila Penyakit jamur upas masih menyerang beberapa tumbuhan teh saja, bisa dikendalikan dengan memotong batang atau cabang yang berpenyakit sepanjang. Selanjutnya potongan-potongan tersebut dikumpulkan dan dibakar segera untuk memusnahkan bibit penyakit. • Batang yang terkena serangan diolesi dengan fungisida Calixin, Fylomax atau bubur bordo dengan kuas sampai 30 cm ke atas dan ke bawah bagian yang terserang. Bubur bordo tidak dianjurkan pada tanaman yang sudah menghasilkan karena dapat mengurangi kualitas lateks yang dihasilkan. • Bila terkena serangan tingkat lanjut, dilakukan pengupasan pada kulit yang busuk. Kemudian dilumaskan Calixin RM secukupnya. Pada cabang yang diameternya lebih dari 1 cm, aplikasikan fungisida Calixin RM atau Copper Sandoz 0,4% formulasi pada bagian tanaman yang berpenyakit. Sedangkan jika infeksi jamur sudah terbilang parah, pangkas bagian tanaman yang rusak tersebut. Lalu oleskan fungisida Calixin RM atau Copper Sandoz pada bekas pemangkasan secara merata"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P005","Cacar Daun","Pemetikan dengan daur petik pendek (7-8 hari). • Pemberian mulsa atau serasah pada kebun teh • Penanaman dan pengelolaan pohon pelindung (mindi, sagawe, lamtoro hantu, manii, dan silver oak). • Pemupukan K2O ditambah 10-20% dari dosis normal untuk meningkatkan ketahanan tanaman. • Menggunakan pestisida nabati dari tanaman papaitan, mindi, babandotan, suren, nimba, biji sirsak, akar tuba dengan dosis 10 kg bahan baku/Ha. Penggunaan fungisida berbahan aktif mankozeb, tembaga hidroksida, triadimefon secara bijaksana berdasarkan pemantauan berkala."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P006","Busuk Daun","segera cabut dan bakar ranting/ daun yang terkena busuk daun - Hindari pengairan yang berlebih. Pertimbangkan pemberian air irigasi selama pagi hari untuk memberi kesempatan daun mengering. - Perlakuan fungisida dilakukan untuk upaya pencegahan terhadap serangan patogen dengan mempertimbangkan kondisi lingkungan. Aplikasi fungisida dilakukan tiap 5 hari sekali jika kondisi lingkungan lembab dan basah, namun jika kondisi cuaca sedang kering, maka aplikasi fungisida dapat dilakukan dalam inetrval waktu 7-10 hari"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P007","Mati Ujung","Pengaturan naungan sehingga bidang petiknya tidak terkena sinar matahari langsung. - Melakukan pemupukan berimbang dan bijaksana - Pemberian fungisida yang mengandung tembaga. Membuang bagian tanaman yang terinfeksi"));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P008","Cacing Tanah (Heterodera Marioni)","Menggunakan racun DDT atau HCH yang disemprotkan ke dalam tanah. - Apabila serangan belum terlalu banyak, gunakan pestisida alami Pestona yang disiramkan dalam lubang tanam. Aplikasi pengendalian sebaiknya dilakukan pada sore hari. Apabila serangannya sudah melebihi ambang batas dapat dilakukan dengan penyemprotan/penyiraman insektisida berbahan aktif karbofuran sebanyak 1 gram pada lubang tanam. Campurkan Aero 810 sebagai bahan pelarut untuk membantu bahan aktif pestisida. Aplikasi pengendalian sebaiknya dilakukan pada sore hari."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P009","Ulat penggulung daun (Homona spp)","Menggunakan insektisida dengan berbahan aktif Lamda Sihalotrin. • Cara hayati dengan menggunakan musuh alami antara lain Macrocentrus homonae, Elasmus homonae, jamur penyebab Wilt disease dan bakteri entomopatogenik. Melakukan pemetikan daun yang terserang dan pengambilan kelompok telur."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P010","Kepik Penghisap Daun (Helopetis spp)","Pengaturan pupuk N dan K. Pemupukan dengan pupuk N yang tinggi akan lebih disukai oleh Helopeltis karena kandungan asam amino tanaman tinggi. Kekurangan pemupukan K menyebabkan tanaman peka terhadap serangan Helopeltis. • Secara kimiawi yaitu dengan memilih insektisida yaitu residu efeknya rendah. Penggunaan insektisida dengan berbahan aktif Lamda Sihalotrin dengan konsentrasi 0,25 ml/l dan Beta Sipermetrin dengan konsentrasi 0,5 ml/l. Melakukan pemetikan dengan daur petik 7 hari, pemupukan berimbang, sanitasi, mekanis."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P011","Ulat Jengkal","Pemberian Insektisida nabati yaitu ekstrak dari daun mimba yang mempunyai sifat sebagai insektisida. Mekanisme dari ekstrak daun mimba dalam mengendalikan ulat jengkal ini disebabkan karena adanya senyawa azadirachtin yang bersifat sebagai penghambat aktivitas makan dan penghalau selera makan (Puslitkoka, 2008). Insektisida kimiawi yang direkomendasikan untuk digunakan antara lain insektisida kimiawi yang berbahan aktif klorfluazuron, permetrin, sihalotrin, dan sipermetrin."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P012","Ulat Api","Memangkas semua daun yang terserang lalu membakarnya serta memupuk tanaman untuk mempercepat pemulihan tanaman. Membasmi ulat api untuk tanaman setinggi 1 meter sampai 3 meter dapat dilakukan penyemprotan dengan insektisida secara berkala dengan dosis 10 cc untuk 15 liter air."));
            SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P013","Tungau","Menyemprotkan menggunakan pestisida jenis Akarisida, misalnya seperti: Samite 135EC, juga dengan pengembusan tepung belerang. Pengendalian secara sederhana adalah dengan menyemprot air cabai atau air sabun"));

            //gejala
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G001","","G002,G006","","","","","Akar di permukaan berwarna merah darah jika terkena air"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G002","akar","","","","","G001,G007","Akar di permukaan berwarna hitam"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G003","","","","","G001,G007","G001,G007,","Akar di permukaan berwarna putih"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G004","","","","","G001,G007","G001,G007","Daun menguning"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G005","","","","","G021,G001,G007,G012","G001,G024,G040,G007,G021,G012,G037","Daun layu/mati"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G006","daun","","","","G021,G001,G007,G046","G001,G024,G021,G046,G012,G047","Daun gugur"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G007","","G002,G006","","","","","Akar di permukaan berwarna hitam mengkilat jika terkena air"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G009","","","","","G007","G007","Akar di permukaan berwarna kelabu"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G010","","","","","G007","G007","Benang hitam di bagian akar"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G011","akar","G012","","","","","Pembusukan pada leher akar"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G012","batang","G023","G023","","G011","","Kulit batang mengelupas"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G013","","","","","G011","G011","Kulit akar mengandung banyak air"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G014","","","","","G011","G011","Kulit akar menjadi lunak"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G015","","G012","","","","","Kulit batang membusuk"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G016","","","","","","G015","Kulit batang menjadi kering"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G017","","","","","","G015","Kulit batang berwarna putih"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G018","","","","","","G015","Kulit batang berwarna merah"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G019","","","","","G021","G021","Bintik hitam pada daun"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G020","daun","G022,G006","","","G047","G046,G040,G047","Bercak hitam pada daun"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G021","","G020","G022,G020","G020","","","Warna daun coklat "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G022","daun","","","","G047","G021,G048,G046,G047,G045","Daun berlubang"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G023","daun","G006","","","G046","G024,G028,G048,G046","Bercak coklat pada daun "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G024","","G012","","","G012","G012","Tunas mengering"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G025","","G023","","","","G028","Pucuk daun tidak terbentuk "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G026","","","","","","G028,G025","Bercak daun berwarna abu-abu "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G027","","","","","","G028,G025","Bercak coklat pada ranting"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G028","batang","","","","","G025","Ranting mengering"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G029","","","","","","G052,G032","Akar mekar"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G030","","","","","","G052,G032","Akar busuk"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G031","","","","","","G052,G032","Batang mudah patah"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G032","batang","","","","","G052","Tanaman menjadi kerdil"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G033","","G034","","","","","Beberapa daun menggulung menjadi satu"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G034","daun","","","","G046,G047","G042,G048,G046,G047","Daun menggulung"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G035","","","","","","G033","Daun berkerut"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G036","","","","","","G033","Daun tergerek"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G037","","G020","","","","G040","Daun berubah warna menjadi hijau kotor "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G038","","","","","","G040,G037","Daun berwarna coklat "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G039","","","","","","G040,G037","Ranting bengkok"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G040","batang","","","","","G037","Batang bengkok"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G041","","","","","","G042","Tepi daun berlubang "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G042","","G022","","","","","Daun tinggal tulang daun saja"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G043","","","","","","G042","Bercak putih pada daun"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G045","","G022,G034","","","","","Pucuk daun berlubang"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G046","","G020,G034","G022,G020","G020","G047","G048,G047","Daun menebal "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G047","","G023","G023","","G046","G048,G046","Daun mengeriting"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G048","","","","G020","G046,G047",",G046,G047","Tunas gugur"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G050","","","","","G046,G047","G048,G046,G047","Bintik kuning pada daun "));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G051","","","","","","G028,G025","Tepi daun berwarna coklat"));
            SQLiteHelper.getInstance(this).addGejala(new Gejala("G052","akar","","","","","G032","Akar Menggembung"));

            //Keputusan
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P001","G001","0.8"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P001","G002","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P001","G003","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P001","G004","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P001","G005","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P001","G006","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G007","0.6"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G008","0.2"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G009","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G002","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G004","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G005","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P002","G006","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P003","G011","0.65"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P003","G012","0.2"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P003","G013","0.1"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P003","G014","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P004","G012","0.6"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P004","G015","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P004","G016","0.1"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P004","G017","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P004","G018","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P005","G019","0.3"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P005","G020","0.3"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P005","G021","0.3"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P005","G022","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P005","G005","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P005","G006","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P006","G023","0.35"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P006","G012","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P006","G024","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P006","G005","0.075"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P006","G006","0.075"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P007","G025","0.45"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P007","G051","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P007","G023","0.1"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P007","G026","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P007","G027","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P007","G028","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P008","G052","0.4"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P008","G029","0.4"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P008","G030","0.15"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P008","G031","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P008","G032","0.025"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P009","G033","0.7"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P009","G034","0.15"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P009","G035","0.075"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P009","G036","0.075"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G020","0.5"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G037","0.3"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G038","0.1"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G005","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G039","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P010","G040","0.033"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P011","G041","0.5"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P011","G042","0.35"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P011","G043","0.10"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P011","G022","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P012","G045","0.7"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P012","G022","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P012","G034","0.05"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G046","0.4"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G047","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G048","0.25"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G006","0.167"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G050","0.167"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G023","0.167"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G020","0.167"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G034","0.167"));
            SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P013","G022","0.167"));

            SessionHelper.getInstance(this).setAppFirstTime(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
