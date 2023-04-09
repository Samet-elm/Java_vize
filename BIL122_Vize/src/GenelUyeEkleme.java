import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class GenelUyeEkleme {

    public GenelUyeEkleme() throws IOException {

        File dosya = new File("KullanıcılarGenel.txt");//kullanıcılarGenel dosyasını oluştur
        FileWriter yaz = new FileWriter(dosya, true);
        BufferedWriter byaz = new BufferedWriter(yaz);
        // Dosya yoksa, yeni dosya oluştur ve "GENEL ÜYELER" başlığı ekle
        if (!dosya.exists()) {
            dosya.createNewFile();
            byaz.write("GENEL UYELER\n");
            byaz.close();
        }

        // Dosya varsa, "GENEL ÜYELER" başlığı var mı kontrol et
        boolean genelUyelerVarmi = false;
        Scanner input1 = new Scanner(dosya);
        while (input1.hasNextLine()) {
            String satir = input1.nextLine();
            if (satir.equals("GENEL UYELER")) {
                genelUyelerVarmi = true;
                break;
            }
        }
        input1.close();

        // "GENEL ÜYELER" başlığı yoksa, dosyanın sonuna başlığı ekle
        if (!genelUyelerVarmi) {
            byaz.write("GENEL UYELER\n");
        }

        // Kullanıcı bilgilerini alınır
        Scanner input2 = new Scanner(System.in);
        System.out.print("İsim: ");
        String isim = input2.nextLine();

        System.out.print("Soyisim: ");
        String soyisim = input2.nextLine();

        System.out.print("E-posta: ");
        String email = input2.nextLine();

        byaz.write(isim + '\t' + soyisim + '\t' + email + '\n'); //dosyaya yaz
        byaz.close();
    }
}

