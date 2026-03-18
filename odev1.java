import java.util.Scanner;

public class odev1{
    public static final int MAXPUAN = 200;//şifre güç puanı için alınabilecek max değer.
    public static void main(String [] args){
        /*

        Öğrenci Numarası: 250706056

        Öğrenci Ad-Soyad: İbrahim Yıldız Bilgisayar Müh. 1.sınıf

        Amaç: Bir sistem yöneticisi, kullanıcıların belirlediği şifrelerin güvenlik
        açısından yeterli olup olmadığını kontrol etmek istemektedir. Sizden, kullanıcıdan
        art arda şifre alan ve bu şifreleri analiz eden bir Java programı yazmanız istenmektedir.
        Kullanıcı BİTİR yazdığında veri girişi sonlanacaktır.

         */

        System.out.print("----------------------------\n");
        System.out.print("--- Şifre Analiz Sistemi --- \n");
        System.out.print("----------------------------\n");
        Scanner input = new Scanner(System.in);//kullanıcıdan bilgi almamızı sağlar

        //atamalar ve ilklendirmeler
        String enSayiliSifre = " ";
        int numsayisiBuyuk = 0;
        int numsayisi = 0;
        String enFazlaHata = " ";
        int karakterHatasi = 0, uzunlukHatasi = 0, yasakKelimeveArtArda = 0;
        double sifreOrt = 0;
        double sifreGucToplam = 0;
        int gucludekiler = 0;
        String enGuclu = " ";
        int enGucluPuan = 0;
        boolean tekrarediyor = false;
        boolean buyuk = false ,kucuk = false ,sayi = false, ozel = false;
        String sifreGucu = " ";
        String gizliSifre = " ";
        char karakter1 = ' ';
        char karakter2 = ' ';
        boolean calisiyor = true;
        boolean sifreDurumu = false;
        int sifrePuani = 0;
        int gecerliSifreSayisi = 0,gecersizSifreSayisi = 0;
        String sifre = " ";
        int boslukVArmi = -1;
        int sifreSayisi = 0;
        int sifreUzunluk = 0;
        int karakterSayisi = 0;
        int puanSeviye = 0;
        gizliSifre = sifre;

        while(calisiyor){//bayrak methodu ile eğer döngü bitirilmesi gerekirse calisiyor false atanır...
            System.out.print("Şifre Giriniz: ");//şifre girişleri
            sifre = input.next();
            sifreUzunluk = sifre.length();//şifrenin uzunluğu
            karakterSayisi = 0;
            sifrePuani = 0;
            if (!(sifre.equals("BİTİR"))) {//eğer bitir değilse kontroller başlasın

                sifreSayisi += 1;//girilen şifre sayısını tutar.
                if ((sifreUzunluk >= 8) && (sifreUzunluk <= 20)) {//şifrenin uzunluğunu kontrol eder.
                    sifreDurumu = true;
                    if (sifreUzunluk < 11)
                        sifrePuani += 10;
                    if (sifreUzunluk > 10 && sifreUzunluk < 15)
                        sifrePuani += 20;
                    if (sifreUzunluk > 14)
                        sifrePuani += 30;
                }
                else if (sifreUzunluk < 8) {//8den kucuk
                    System.out.println("GEÇERSİZ ŞİFRE: ŞİFRE ÇOK KISA(uzunluk hatası)!");
                    gecersizSifreSayisi ++;
                    uzunlukHatasi ++;
                    continue;
                }
                else {// 20 den buyuk
                    System.out.println("GEÇERSİZ ŞİFRE: ŞİFRE ÇOK UZUN(uzunluk hatası)!");
                    gecersizSifreSayisi ++ ;
                    uzunlukHatasi ++;
                    continue;
                }


                if (sifre.contains(" ")) {//boşluk kontrolu
                    System.out.println("GEÇERSİZ ŞİFRE: BOŞLUK HATASI(KARAKTER HATASI)!");
                    gecersizSifreSayisi ++ ;
                    karakterHatasi ++;
                    continue;
                }

                if (sifre.contains("admin") || sifre.contains("ADMİN") || sifre.contains("1234")//yasaklı kelime kontrolu
                        || sifre.contains("qwerty") || sifre.contains("QWERTY") || sifre.contains("password")
                        || sifre.contains("PASSWORD")) {
                    System.out.println("GEÇERSİZ ŞİFRE: YASAKLI KELIME(yasak kelimeve art arda)!");
                    gecersizSifreSayisi ++;
                    yasakKelimeveArtArda ++;
                    continue;
                }


                for(int index = 0; index < sifreUzunluk ; index ++ ) {//küçük harf,büyük harf,özel karakter ve sayı kontrolü
                    karakter1 = sifre.charAt(index);

                    if (karakter1 >= 'A' && karakter1 <= 'Z') {
                        buyuk = true;
                        sifrePuani += 10;
                    }
                }
                for(int index = 0; index < sifreUzunluk ; index ++ ) {//küçük harf,büyük harf,özel karakter ve sayı kontrolü
                    karakter1 = sifre.charAt(index);
                    if (karakter1 >= 'a' && karakter1 <= 'z') {
                        kucuk = true;
                        sifrePuani += 10;
                        break;
                    }
                }
                for(int index = 0; index < sifreUzunluk ; index ++ ) {//küçük harf,büyük harf,özel karakter ve sayı kontrolü
                    karakter1 = sifre.charAt(index);
                    if (karakter1 >= '0' && karakter1 <= '9') {
                        sayi = true;
                        sifrePuani += 10;
                        break;
                    }
                }

                for(int index = 0; index < sifreUzunluk ; index ++ ) {//küçük harf,büyük harf,özel karakter ve sayı kontrolü
                    karakter1 = sifre.charAt(index);
                    if (karakter1 >= '0' && karakter1 <= '9')
                        continue;
                    else if (karakter1 >= 'A' && karakter1 <= 'Z')
                        continue;
                    else if (karakter1 >= 'a' && karakter1 <= 'z')
                        continue;
                    else {
                        ozel = true;
                        sifrePuani += 15;
                        break;
                    }
                }





                    if(!(buyuk && kucuk && ozel && sayi)) {//karakterlerın hepsınden en az bır tane varsa true dondursun.
                    System.out.println("GEÇERSİZ GİRİŞ: EKSİK KARAKTER(buyuk,kucuk,ozel,sayi)!");
                    gecersizSifreSayisi++;
                    karakterHatasi ++ ;
                    continue;
                }

                for(int index = 0; index + 2 < sifreUzunluk ; index ++ ){// art arda kontrolu
                    if (sifre.charAt(index) == sifre.charAt(index + 1) && sifre.charAt(index) == sifre.charAt(index + 2)) {
                        System.out.println("GEÇERSİZ GİRİŞ: ŞİFREDE ART ARDA 3 KARAKTER İÇERMEMELİ(artarda)!");
                        tekrarediyor = true;
                        gecersizSifreSayisi ++;
                        yasakKelimeveArtArda ++;
                        break;
                    }
                }
                if(tekrarediyor)
                    continue;

                for(int index1 = 0; index1 < sifreUzunluk  ; index1 ++ ){//tekrar eden karakter kontrolu
                    karakter1 = sifre.charAt(index1);
                    boolean dahaOnceVarmi = false;
                    for(int index2 = index1 + 1; index2 < sifreUzunluk  ; index2 ++ ){
                        karakter2 = sifre.charAt(index2);
                        if(karakter1 == karakter2) {
                            dahaOnceVarmi = true;
                            break;
                        }
                    }
                    if(!(dahaOnceVarmi))
                        karakterSayisi ++ ;
                    else
                        sifrePuani -- ;
                }



                if(karakterSayisi >= 5 && karakterSayisi < 8)//karakter sayısına gore puanlama
                    sifrePuani += 5;
                else if (karakterSayisi >= 8 && karakterSayisi < 10)
                    sifrePuani += 10;
                else if (karakterSayisi >= 11)
                    sifrePuani += 20;



                gizliSifre = sifre;
                for(int index1 = 0; index1 < sifreUzunluk ; index1 ++ ) {//elimizdeki sifreyi maskelesin
                    karakter1 = sifre.charAt(index1);

                    if (karakter1 >= 'a' && karakter1 <= 'z')
                        gizliSifre = gizliSifre.replace(karakter1, '*');

                    else if (karakter1 >= '0' && karakter1 <= '9')
                        gizliSifre = gizliSifre.replace(karakter1, '#');
                }



                if(sifrePuani>0 && sifrePuani <= 34)//switch-case için kolaylaştırma
                    puanSeviye =1;
                else if (sifrePuani > 35 && sifrePuani <=59)
                    puanSeviye =2;
                else if (sifrePuani > 60 && sifrePuani <=79)
                    puanSeviye = 3;
                else if(sifrePuani >80 && sifrePuani <= MAXPUAN)
                    puanSeviye = 4;



                switch (puanSeviye){//sifrenin puanını derecelendırsın
                    case 1:
                        sifreGucu = "ZAYIF";
                        break;
                    case 2:
                        sifreGucu = "ORTA";
                        break;
                    case 3:
                        sifreGucu = "GUÇLÜ";
                        break;
                    case 4:
                        sifreGucu = "ÇOK GÜÇLÜ";
                        gucludekiler ++;
                        break;
                }


                System.out.println("GEÇERLİ ŞİFRE!");
                System.out.println("Şifre: " + sifre);
                System.out.println("Uzunluk: " + sifreUzunluk);
                System.out.println("Farklı Karakter Sayısı: " + karakterSayisi);
                System.out.println("Güç Puanı: " + sifrePuani);
                System.out.println("Güç Sınıfı: " + sifreGucu);
                System.out.println("Maskelenmiş Şifre: " + gizliSifre);
                gecerliSifreSayisi ++ ;//her gecerlı sıfrede bır arttırsın



                if(enGucluPuan < sifrePuani)//en guclu sıfre ıcın kontrol teknıgı
                    enGucluPuan = sifrePuani;



                sifreGucToplam += sifrePuani;//toplam sifre puanı ve onunla ortalaması
                sifreOrt = sifreGucToplam/sifreSayisi;



                if(uzunlukHatasi >karakterHatasi && uzunlukHatasi > yasakKelimeveArtArda)//en fazla hata hangisi ise onu geri dondurme
                    enFazlaHata = "UZUNLUK HATASI";
                else if(karakterHatasi > uzunlukHatasi && karakterHatasi > yasakKelimeveArtArda)
                    enFazlaHata = "KARAKTER HATASI";
                else if(yasakKelimeveArtArda > uzunlukHatasi && yasakKelimeveArtArda >karakterHatasi)
                    enFazlaHata = "YASAK KELİMELER VEYA ART ARDA YAZMA HATASI";



                for(int index = 0; index< sifreUzunluk;index++){
                    karakter1 = sifre.charAt(index);
                    if(karakter1 >= '0' && karakter1 <= '9')
                        numsayisi ++;
                }


                if(numsayisiBuyuk < numsayisi) {
                    numsayisiBuyuk = numsayisi;
                    enSayiliSifre = sifre;
                }
            }

            else//BİTİR yazıldı
                calisiyor = false;
        }
        //rapor kısmı
        System.out.print("===== ÖZET RAPOR =====\n");
        System.out.println("Toplam Girilen Şifre Sayısı: " + sifreSayisi);
        System.out.println("Geçerli Şifre Sayısı: " + gecerliSifreSayisi);
        System.out.println("Geçersiz Şifre Sayısı: " + gecersizSifreSayisi);
        System.out.println("En Yüksek Puanlı Şifre: " + enGucluPuan);
        System.out.println("Ortalama Güç Puanı: " + sifreOrt);
        System.out.println("Çok Güçlü Sınıfındaki Şifre Sayısı: " + gucludekiler);
        System.out.println("İçinde En Fazla Rakam Bulunan Şifre: " + enSayiliSifre);
        System.out.println("En Sık Görülen Geçersizlik Nedeni: " + enFazlaHata);


    }
}