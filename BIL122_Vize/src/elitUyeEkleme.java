import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class elitUyeEkleme {

    public elitUyeEkleme() throws IOException {

        File dosya = new File("KullanıcılarElit.txt");
        FileWriter yaz = new FileWriter(dosya, true);
        BufferedWriter byaz = new BufferedWriter(yaz);
        // Dosya yoksa, yeni dosya oluştur ve "ELIT ÜYELER" başlığı ekle
        if (!dosya.exists()) {
            dosya.createNewFile();
            byaz.write("ELIT UYELER\n");
            byaz.close();
        }

        // Dosya varsa, "ELIT ÜYELER" başlığı var mı kontrol et
        boolean elitUyelerVarmi = false;
        Scanner input1 = new Scanner(dosya);
        while (input1.hasNextLine()) {
            String satir = input1.nextLine();
            if (satir.equals("ELIT UYELER")) {
                elitUyelerVarmi = true;
                break;
            }
        }
        input1.close();

        // "ELIT ÜYELER" başlığı yoksa, dosyanın sonuna ekle
        if (!elitUyelerVarmi) {

            byaz.write("ELIT UYELER\n");
        }

        // Kullanıcı bilgilerini al
        Scanner input2 = new Scanner(System.in);
        System.out.print("İsim: ");
        String isim = input2.nextLine();

        System.out.print("Soyisim: ");
        String soyisim = input2.nextLine();

        System.out.print("E-posta: ");
        String email = input2.nextLine();

        byaz.write(isim + '\t' + soyisim + '\t' + email + '\n');
        byaz.close();
    }
}
