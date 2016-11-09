package com.dimas.gastrointenistal.views.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dimas.gastrointenistal.R;
import com.dimas.gastrointenistal.helpers.SQLiteHelper;
import com.dimas.gastrointenistal.helpers.SessionHelper;
import com.dimas.gastrointenistal.models.Gejala;
import com.dimas.gastrointenistal.models.Hospital;
import com.dimas.gastrointenistal.models.Keputusan;
import com.dimas.gastrointenistal.models.Penyakit;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(SessionHelper.getInstance(this).getAppFirstTime()){
            Log.d("MainApp","First session");
            queryHospital();
            queryPenyakit();
            queryGejala();
            queryKeputusan();

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

    private void queryHospital(){
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSU. Dr. Saiful Anwar", "Klojen", "Jalan Jaksa Agung Suprapto No.2, Kota Malang, Jawa Timur 65112", "(0623) 4362101", "Minggu-Sabtu 24 Jam", "-7.972159", "112.631648"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RS.Lavalette", "Klojen", "Jl. W.R. Supratman No.10, Rampal Celaket, Klojen, Kota Malang, Jawa Timur 65111", "(0341) 470805", "Minggu-Sabtu 24 Jam", "-7.965457", "112.637899"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RS. Hermina Tangkubanprahu", "Klojen", "Jalan Tangkubanprahu No. 31-33, Kota Malang, Jawa Timur", "(0341) 322525", "Minggu-Sabtu 24 Jam", "-7.977855", "112.624413"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSAB. Muhammadiyah", "Klojen", " Jl. Wahid Hasyim No. 30, Kauman, Klojen, Malang, Kota Malang, Jawa Timur 65119", "(0341) 326222", "Minggu-Sabtu 24 Jam", "-7.984266", "112.628710"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Husada Bunda", "Klojen", "Jalan Pahlawan Trip No. 2, Oro Oro Dowo, Klojen, Malang, Kota Malang, Jawa Timur 65119", "(0341) 566972", "(0341) 566972", "-7.967657", "112.623437"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Mardi Waloeja Hauman", "Klojen", "Jl. Kauman No. 23, Kota Malang, Jawa Timur", "(0341) 358508", "Minggu-Sabtu 24 Jam", "-7.982958", "112.627824"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSKB. Manu Husada", "Klojen", "Jl. Sultan Agung No.10-12, Kiduldalem, Klojen, Kota Malang, Jawa Timur 65119", "(0341) 320376", "Minggu-Sabtu 24 Jam", "-7.975992", "-7.975992"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSB. Mardi Waloeja Rampal","Klojen","Jl. W.R. Supratman No.1, Rampal Celaket, Klojen, Kota Malang, Jawa Timur 65111","(0341) 364756","Minggu-Sabtu 24 Jam","-7.964654","112.635232"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Melati Husada","Klojen","Jl. Kawi No. 32, Jawa Timur","(0341) 364756","Minggu Sabtu 08.00-20.00","-7.975747","112.621333"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA Ganesha Medika","Klojen","Jl. Mayjend. Panjaitan, Penanggungan, Malang, Kota Malang, Jawa Timur 65113","(0341) 552955","Minggu-Sabtu 24 Jam","-7.952582","112.619164"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Mutiara Bunda","Blimbing","Jl. Ciujung, Purwantoro, Malang, Kota Malang, Jawa Timur 65122","(0341) 400403","Minggu-Sabtu 24 Jam","-7.953024","112.641003"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Puri Bunda","Blimbing","Jalan Simpang Sulfat Utara No. 60 A, Pandanwangi, Blimbing, Kota Malang, Jawa Timur 65126","(0341) 480047","Minggu-Sabtu 24 Jam","-7.958428","112.655431"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("Persada Hospital","Blimbing","Kompleks Araya Business Centre Kav. 2-4, Jalan Panji Suroso, Blimbing, Jawa Timur 65126","(0341) 2996333","Minggu-Sabtu 24 Jam","-7.934335","112.649823"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RS. Panti Waluya","Kedungkandang","Jl. Nusakambangan No.56, Kasin, Kota Malang, Jawa Timur 65117","(0341) 366033","Minggu-Sabtu 24 Jam","-7.986040","112.625053"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSB. Permata Hati","Kedungkandang","Jl. Danau Toba Blok E 6 No.16 - 18, Lesanpuro, Kedungkandang, Kota Malang, Jawa Timur 65138","(0341) 718068","Minggu-Sabtu 24 Jam","-7.980249","112.660673"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Refa Husada","Kedungkandang","Jl. Mayjend Sungkono No. 9 RT. 005 RW. 004, Tlogowaru, Kedungkandang, Kota Malang, Jawa Timur","(0341) 754075","Minggu-Sabtu 24 Jam","-8.035711","112.642619"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSI. Aisyiyah","Kedungkandang","Jl. Sulawesi No.16, Kasin Kota Malang, Jawa Timur 65117","(0341) 326773","Minggu-Sabtu 24 Jam","-7.988631","112.625520"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RS. Permata Bunda","Lowokwaru","Jalan Soekarno Hatta No. 75, Mojolangu, Lowokwaru, Kota Malang, Jawa Timur 65142","(0341) 326773","Minggu-Sabtu 24 Jam","-7.938598","112.624825"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RS. Permata Bunda","Lowokwaru","Jl. Gajayana No.12, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144","(0341) 326773","Minggu-Sabtu 24 Jam","-7.946579","112.608491"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RSIA. Galeri Candra","Lowokwaru","Jl. Bunga Andong No.3, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141","(0341) 478571","Minggu-Sabtu 07.00 - 21.00","-7.947584","112.619595"));
        SQLiteHelper.getInstance(this).addHospital(new Hospital("RST. Dr. Soepraoen","Sukun","Jalan Sudanco Supriadi No. 22, Sukun, Malang, Jawa Timur, 65112","(0341) 325112","Minggu-Sabtu 24 Jam","-7.989513","112.620522"));

    }

    private void queryPenyakit(){
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P1", "Penyakit Gastritis", "Segera menghubungi dokter", "Gastritis adalah proses inflasi pada mukosa dan submokasa lambung. Gastritis merupakan gangguan kesehatan yang paling sering dijumpai di klinik, karena diagnosanya sering hanya berdasarkan gejala klinis bukan pemeriksaan histopatologi.","img_gastritis"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P2","Penyakit Hemorid","Perbaikan pola hidup, perbaikan pola makan dan minum, perbaikan pola atau cara defekasi. Memperbaiki defekasi merupakan pengobatan yang selalu harus ada dalam setiap bentuk dan derajat hemoroid.","Hemoroid merupakan pelebaran dan inflasi pembuluh darah vena di daerah anus yang berasal dari plexus hemorrhoidalis. Di badeah atau di luar linea dentate pelebaran vena yang berada di bawah kulit (subkutan) di sebut hemorid eksternal. Sedangkan di atas atau di dalam linea dentate, pelebaran vena yang berada di bawan mukosa (submukosa) di sebut hemoroid internal. Biasanya struktur anatomis anal canal masih normal.","img_hemorid"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P3","Penyakit Tukak Gaster", "Segera menghubungi dokter.", "Tukak gaster adalah suatu gambaran bulat atau semi bulat/oval, ukuran > 5 mm kedalaman submukosal pada mukosa lambung akibat terputusnya kontinuitas/integritas mukosa lambung. Tukas gaster merupkan luka terbuka dengan pinggir edema disertai indurasi dengan dasar ditutupi debris.","img_tukak_gaster"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P4", "Penyakit Tukak Duodenum", "Pemberian diet yang mudah cerna khususnya pada tukak yang aktif perlu dilakukan. Makan dalam jumlah sedikit dan lebih sering, lebih baik dari pada makan yang sekaligus kenyang. Mengurangi makanan yang merangsang pengeluaran asam lambung atau pepsin, makanan yang merangsang timbulnya nyeri dan zat-zat lain yang dapat mengganggu pertahanan mukosa gastroduedenal.", "Tukak duodenum secara anatomis didefinisikan sebagai suatu defek mukosa/submokusa yang terbatas tegas dapat menembus muskularis mukosa sampai lapisan serosa sehingga dapat terjadi perforasi. Secara klinis, suatu tukak adalah hilangnya epitel superfisial atau lapisan lebih dalam dengan diameter > 5 mm yang dapat diamati secara endoskopsis atau radiologis. ", "img_tukak_duodenum"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P5", "Penyakit Malnutrisi", "Segera menghubungi dokter", "Secara praktis pengertian malnutrisi adalah apabila terjadi penurunan berat badan lebih dari 10% dari berat badan sebelumnya dalam 3 bulan terakhir. Selain kriteria yang sering di gunakan adalah apabila pada saat pengukuran berat badan kurang dari 90% berat badan ideal berdasarkan tinggi badan atau jika indeks massa tubuh (IMT) kurang dari 18,5.", "img_malnutrisi"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P6", "Penyakit Dispepsia Fungsional", "Segera menghubungi dokter", "Dispepsia fungsional adalah keluhan yang berhubungan dengan makan atau keluhan yang oleh pasien ataupun dokternya dikaitkan dengan gangguan saluran cerna bagian atas. Dalam konsensus Roma II tahun 2000, disepakati bahwa definisi dispepsia sebagai dyspepsia ferers to pain or discomfort centered in the upper abdomen. Formulasi keluhan nyeri atau tidak nyaman menjadi sesuatu yang relatif, terlebih lagi bila diekspresikan dalam bahasa yang berbeda.", "img_dispepsia_fungsional"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P7", "Penyakit Irritable Bowel Sindrom", "Konsumsi air yang meningkat disertai olahraga rutin, menghindari beberapa makanan dan minuman seperti gandum, susu, kafein, bawang, coklat dan beberapa sayur-sayuran, bisa mengkonsumsi lagi setalah 3 bulan dengan jumlah diberikan secara bertahap", "Irritable bowel syndrome adalah satu penyakit gastrointestinal fungsional. Adanya nyeri perut, distensi dan gangguan pola defakasi tanpa gangguan organik.", "img_irritable_bowel_syndrome"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P8", "Penyakit Refluks Gastroesofageal", "Meninggikan posisi kepala pada saat tidur serta menghindari makan sebelum tidur, berhenti merokok dan mengkonsumsi alkohol, mengurangi konsumsi lemak, menurunkan berat badan pada pasien kegemukan serta menghindari pemakaian ketat, menghindari makanan atau minuman seperti coklat, teh, peppermint, kopi dan minuman bersoda", "Refluks gastroesofagel adalah suatu keadaan patologis sebagai akibat refluks kandungan lambung ke dalam esofagus, dengan berbagai gejala yang timbul akibat keterlibatan esofagus, faring, laring dan saluran nafas.", "img_refluks_gastroesofageal"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P9", "Penyakit Diare Akut", "Bila pasien keadaan umum baik baik tidak dehidrasi, asupan cairan dengan minuman ringan, sari buah, sup dan keripik asin. Bila pasien kehilangan cairan yang banyak dan dehidrasi dapat memberikan cairan isotonik mengandung elektrolit dan gula atau starch harus diberikan", "Diare adalah buang air besar (defakasi) dengan tinja berbentuk cair atau setengah cair (setengah padat), kandungan air tinjah lebih banyak dari biasanya lebih dari 200 gram atau 200 ml/24 jam. Definisi lain memakai kriteria frekuensi, yaitu buang air besar encer lebih dari 3 kali per hari. Buang air besar encer tersebut dapat atau tanpa di sertai lendir dan darah. Diare akut yaitu diare yang berlangsung kurang dari 15 hari, sedangkan menurut World Gastroenterology Organisation global guidelenis 2005, diare akut di definisikan sebagai pasase tinja yang cair  atau lembek dengan jumlah lebih banyak dari normal, berlangsung kurang dari 14 hari.", "img_diare_akut"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P10", "Penyakit Diare Kronis", "Bila pasien keadaan umum baik baik tidak dehidrasi, asupan cairan dengan minuman ringan, sari buah, sup dan keripik asin. Bila pasien kehilangan cairan yang banyak dan dehidrasi dapat memberikan cairan isotonik mengandung elektrolit dan gula atau starch harus diberikan", "Diare kronik adalah diare yang berlangsung lebih dari 15 hari. Sebenarnya para pakar di dunia telah mengajukan beberapa kriteria mengenai batasan kronik pada kasus diare tersebut, ada yang 15 hari, 3 minggu, 1 bulan dan 3 bulan, tetapi di indonesia dipilih waktu lebih 15 hari agar dokter tidak lengah, dapat lebih cepat menginvestigasi penyebab diare kronik dengan lebih cepat.","img_diare_kronik"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P11", "Penyakit Striktur/Stenosis Esofagus", "Memberikan nutrisi yang bergizi tinggi dengan kalori, protein, lemak dan karbohidrat yang seimbang", "Striktur/stenosis esofagus penyakit yang jarang didapatkan, namun sangat menggangu kehidupan, striktur/stenosis esofagus adalah penyempitan lumen esofagus, dapat karena tumor atau penyebab lain . Striktur/stenosis merupakan penyempitan lumen karena fibrosis dinding esofagus yang disebabkan oleh macam-macam penyebab. Proses striktur terjadi akibat reaksi inflamasi dan nekrosis esofagus yang disebabkan oleh macam-macam penyebab.", "img_striktur"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P12", "Penyakit Kolitis Infeksi", "Segera menghubungi dokter", "Kolitis infeksi adalah suatu peradangan akut atau kronik pada kolon, penyakit kolitis infeksi ini lebih di fokuskan kepada kolitis amebik yang sering ditemukan di indonesia sebagai daerah tropik. Manusia merupakan host sekaligus reservoir utama. Penularannya lewat kontaminasi tinja ke makanan dan minuman, dengan perantara lalat, kecoak, kontak interpersonal, atau lewat hubungan seksual anal-oral. Sanitasi lingkungan yang jelek, penduduk yang padat dan kurangnya sanitasi individual mempermudah penularannya.","img_kolitis_infeksi"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P13", "Penyakit Inflammatory Bowel Disaese", "Segera menghubungi dokter", "Inflammatory bowl disease adalah penyakit inflamasi yang melibatkan saluran cerna.", "img_inflammatory_bowel_disease"));
        SQLiteHelper.getInstance(this).addPenyakit(new Penyakit("P14", "Penyakit Pankreatis Kronik", "Perbikan keadaan umum, bila lemah dirawat, hentikan konsumsi alkohol, diet rendah lemak, diet kecil tapi sering, hndari makanan yang secara individu tidak dapat ditoleransi", "Pankreatis kronik terjadi karena defesiensi lithoastatin : Protein lithostatin disekresi oleh pancreas, berguna untuk mempertahankan kalsium dalam cairan pancreas sehingga tetap cair. Difesiensi lithostatin ini dibuktikan sebagai penyebab pembentukan presepitat protein.","img_pankreatis_kronik"));
    }

    private void queryGejala(){
        SQLiteHelper.getInstance(this).addGejala(new Gejala("tinja","G1","Tinja Berlendir"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("tinja","G2","Tinja berbau busuk"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("tinja","G3","Tinja bercampur darah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("tinja","G4","Tinja cair pada saat nyeri"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("tinja","G5","Tinja berjumlah kecil tapi sering"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("berat badan", "G6","Berat badan Menurun"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("berat badan", "G7","Berat badan menrun > 10%"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("berat badan", "G8","Berat badan kurang dari 18,5 kg"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("berat badan", "G9","Berat badan turun > 10% dalam 3 bulan"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("buang air besar", "G10","Buang air besar Sakit dan Sulit"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("buang air besar", "G11","Nyeri berkurang setelah buang air besar"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("buang air besar", "G12", "Perasaan tidak puas saat buang air besar"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("buang air besar", "G13", "Frekuensi buang air besar bertambah saat nyeri"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("buang air besar", "G14", "Buang air besar lebih dari tiga kali sehari dengan konsistensi cair"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("buang air besar", "G15", "Buang air besar lebih dari tiga kali sehari  dengan konsistensi cair selama 15 hari"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("dada", "G16", "Rasa nyeri atau terbakar di dada"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("dada", "G17", "Ada yang mengganjal di dada sewaktu makan"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("dubur", "G18", "Dubur terasa panas"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("dubur", "G19", "Ada benjolan di dubur"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("dubur", "G20", "Dubur terasa gatal"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("dubur", "G21", "Pendarahan melalui dubur dan berwarna merah muda"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("muntah", "G22", "Muntah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("muntah", "G23", "Rasa tidak nyaman disertai mudah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("muntah", "G24", "Muntah yang persisten"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("mual", "G25", "Mual"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("mual", "G26", "Mual sehabis makan"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("ulu hati", "G27", "Ulu hati tidak nyaman"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("ulu hati", "G28", "Ulu hati nyeri panas dan pedih"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("ulu hati", "G29", "Ulu hati rasa sakit seperti terbakar"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("ulu hati", "G30", "Ulu hati terasa penuh setelah makan"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("ulu hati", "G31", "Nyeri dominan di ulu hati disertai nyeri Pada malam hari"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G32", "Perut kram"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G33", "Perut kembung"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G34", "Perut nyeri ringan"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G35", "Rasa sakit setelah makan sebelah kiri garis tengah perut"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G36", "Nyeri atau sakit perut epigastirum yang berlokasi di abdomen tengah dan kiri atas"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G37", "Nyeri perut yang dirasakan berpindah-pindah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G38", "Rasa nyeri perut yang dirasakan tidak menentu"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("perut", "G39", "Waktu nyeri perut yang dirasakan sebentar"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("riwayat", "G40", "Riwayat keluarga terkena IBD"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("riwayat", "G41", "Riwayat pemakaian antibiotik yang lama"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("riwayat", "G42", "Riwayat TD"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("riwayat", "G43", "Adanya riwayat makanan siap santap"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("nyeri", "G44", "Nyeri epigestrik"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("nyeri", "G45", "Rasa nyeri, rasa tidak enak, atau rasa terbakar di epigestrum"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("nyeri", "G46", "Nyeri di daerah umbilikus"));

        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G47", "Adanya pendarahan hematemasis atau melana"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G48", "Anemia yang tidak diketahui penyebabnya"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G49", "Badan lemah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G50", "Cepat merasa kenyang disertai sendawa"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G51", "Demam"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G52", "Gigi membusuk"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G53", "Gusi bengkak dan berdarah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G54", "Keringat dingin"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G55", "Kelelahan dan kekurangan energi"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G56", "Kesulitan dalam menelan makanan"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G57", "Kulit kering dan bersisik"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G58", "Nadi cepat"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G59", "Nafsu makan menurun"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G60", "Rasa pahit di lidah"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G61", "Rasa cepat kenyang"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G62", "Rasa tidak enak pada retrostenal"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G63", "Rasa sakit menjalar pada punggung"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G64", "Sering dehidrasi"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G65", "Sering bersendawa dalam keadaan lapar"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G66", "Sensasi ingin kebelakang"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G67", "Stress"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G68", "Suhu badan meningkat"));
        SQLiteHelper.getInstance(this).addGejala(new Gejala("", "G69", "Umur > 45-50 keluhan muncul untuk pertama kali"));

    }

    private void queryKeputusan(){
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P1","G22,G25,G28,G54,G58,G59,G65,G68", ""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P2","G10,G18,G19,G20,G21",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P3","G15,G23,G25,G29,G30,G33,G35,G63", ""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P4","G69,G61,G47,G48,G42,G24,67", ""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P5","G8,G9,G33,G52,G53,G55,G57,G59",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P6","G67,G61,G44,G33,G31,G25,G22,G6",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P7","G1,G4,G11,G12,G13,G37,G38,G39",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P8","G62,G60,G56,G45,G25",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P9","G1,G3,G14,G22,G25,G33,G41,G43,G46,G51,",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P10","G3,G5,G6,G15,G22,G51,G64,G66",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P11","G16,G17,G26,G27,G33,G61",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P12","G1,G2,G3,G25,G32,G33,G34,G48,G49,G51",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P13","G3,G5,G6,G15,G22,G34,G40,G51,G64,G66",""));
        SQLiteHelper.getInstance(this).addKeputusan(new Keputusan("P14","G1,G3,G6,G14,G22,G25,G33,G36,G41,G43,G46,G51",""));
    }
}
