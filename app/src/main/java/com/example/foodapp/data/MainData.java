package com.example.foodapp.data;

import com.example.foodapp.model.MainModel;

import java.util.ArrayList;

public class MainData {

    public static String[][] data=new String[][]{
            {"Soto", "Jawa", "Soto, sroto, sauto, tauto, atau coto adalah makanan khas Indonesia seperti sop yang terbuat dari kaldu daging dan sayuran. Daging yang paling sering digunakan adalah daging sapi dan ayam, tetapi ada pula yang menggunakan daging babi atau kambing. Berbagai daerah di Indonesia memiliki soto khas daerahnya masing-masing dengan komposisi yang berbeda-beda, misalnya soto Madura, soto Kediri, soto Pemalang, soto Lamongan, soto Jepara, soto Semarang, soto Kudus, soto Betawi, soto Padang, soto Bandung, sroto Sokaraja, soto Banjar, soto Medan, dan coto Makassar. Soto juga diberi nama sesuai isinya, misalnya soto ayam, soto babat, atau soto kambing. Ada pula soto yang dibuat dari daging kaki sapi yang disebut dengan soto sekengkel.\n" +
                    "\n" +
                    "Cara penyajian soto berbeda-beda sesuai kekhasan di setiap daerah. Soto biasa dihidangkan dengan nasi, lontong, ketupat, mi, atau bihun. Untuk menambah kenikmatan soto, biasanya juga disertai berbagai macam lauk, misalnya kerupuk, perkedel, emping, sambal, dan sambal kacang. Ada pula yang menambahkan telur puyuh, sate kerang, jeruk limau, berbagai macam gorengan (tempe, tahu, bakwan) dan koya. *Wikipedia", "https://upload.wikimedia.org/wikipedia/commons/0/05/Soto_ayam.JPG"},
            {"Gorengan", "jakarta", "Di Indonesia gorengan adalah makanan ringan yang populer. Penjual gorengan dapat ditemukan di tepi jalan atau berkeliling dengan pikulan atau gerobak. Bahan-bahan yang dilapis adonan tepung dan digoreng antara lain; pisang, tempe, tahu, oncom, ubi, singkong, cireng (Bahasa Sunda: Aci digoreng), yaitu tepung singkong digoreng, sukun, dan bakwan (di Jawa Barat disebut \"bala-bala\") yaitu adonan tepung yang dicampur cacahan kubis dan wortel. Salah satu jenis gorengan yang populer adalah Tahu Sumedang. Perkedel jagung dan perkedel kentang juga masuk dalam kategori gorengan. Gorengan biasanya dimakan dengan cabe rawit. Di Malaysia gorengan juga lazim ditemui, antara lain pisang goreng dan ubi goreng.\n" +
                    "\n" +
                    "Dalam masakan Jepang, sayuran dan hidangan laut (terutama udang) yang digoreng disebut tempura, dimakan dengan dicelupkan pada saus kecap asin-manis yang cair dan ringan. Sama halnya dengan di India gorengan juga populer. *Wikipedia", "https://upload.wikimedia.org/wikipedia/commons/c/c7/Gorengan_in_Jakarta.JPG"},
            {"Pempek", "Palembang", "Pempek atau empek-empek adalah makanan yang terbuat dari daging ikan yang digiling lembut yang dicampur tepung kanji atau tepung sagu, serta komposisi beberapa bahan lain seperti telur, bawang putih yang dihaluskan, penyedap rasa, dan garam. Pempek biasanya disajikan dengan kuah cuka yang memiliki rasa asam, manis, dan pedas. Pempek sering disebut sebagai makanan khas Palembang,[1] meskipun hampir semua daerah di Sumatera Selatan memroduksinya.\n" +
                    "\n" +
                    "Pempek dapat ditemukan dengan mudah di Kota Palembang; ada yang menjualnya di restoran, ada yang di pinggir jalan, dan pula yang dipikul. Pada tahun 1980-an, penjual biasa memikul satu keranjang penuh pempek sambil berjalan kaki berkeliling menjajakan dagangannya. *Wikipedia", "https://upload.wikimedia.org/wikipedia/commons/6/62/Pempekraden_kapal_selam_dan_kulit_ikan.jpg"},
            {"Sate Padang", "Padang", "Sate Padang adalah sebutan untuk tiga jenis varian sate di Sumatra Barat, yaitu Sate Padang, Sate Padang Panjang dan Sate Pariaman.\n" +
                    "\n" +
                    "Sate Padang memakai bahan daging sapi, lidah, atau jerohan (jantung, usus, dan tetelan)[1] dengan bumbu kuah kacang kental (mirip bubur) ditambah cabai yang banyak sehingga rasanya pedas.\n" +
                    "\n" +
                    "Sate Padang Panjang dibedakan dengan kuah sate nya yang berwarna kuning sedangkan sate Pariaman kuahnya berwarna merah. Rasa kedua jenis sate ini juga berbeda. Sedangkan sate Padang mempunyai bermacam rasa perpaduan kedua jenis varian sate di atas. *Wikipedia", "https://upload.wikimedia.org/wikipedia/commons/2/25/Sate_Padang_Pariaman%2C_Masakan_Buyung.jpg"},
            {"Rendang ", "Sumatera Barat", "Rendang merupakan masakan yang kaya rempah dengan daging sebagai bahan dasarnya. Rendang juga menggunakan karambia (santan kelapa) dan campuran bumbu khas yang dihaluskan seperti cabai, lengkuas, jahe, kunyit, bawang, dan bumbu-bumbu lainnya. Keunikan rendang adalah bumbu alami yang digunakan memiliki sifat antiseptik, sehingga bisa berguna sebagai pengawet alami. Bumbu lain juga diketahui punya aktivitas antimikroba yang kuat, dan tidak heran jika rendang bisa bertahan berbulan-bulan. Untuk pemasakan rendang hingga kuah benar-benar kering, prosesnya akan menghabiskan waktu sekitar delapan jam. *Wikipedia", "https://upload.wikimedia.org/wikipedia/commons/1/13/Lamb_rendang.jpg"}

    };

    public static ArrayList<MainModel> getListData(){
        MainModel mainModel ;
        ArrayList<MainModel> list=new ArrayList<>();
        for(String[] aData : data){
            mainModel=new MainModel();
            mainModel.setName(aData[0]);
            mainModel.setDaerah(aData[1]);
            mainModel.setDesc(aData[2]);
            mainModel.setPhoto(aData[3]);

            list.add(mainModel);
        }

        return list;
    }
}
