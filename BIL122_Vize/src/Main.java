import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("HESAP İSLEM MENÜSÜ : ");
        System.out.println("1. Genel üye ekleme " + '\n' + "2. Elit üye eklme " + '\n' + "3. Mail gönderme  " + '\n');
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz . ");
        Scanner input = new Scanner(System.in);

        int k = input.nextInt();
        switch (k) {

            case 1:

                System.out.println("isim soyisim ve mail adresinizi giriniz");
                GenelUyeEkleme a = new GenelUyeEkleme();
                break;

            case 2:
                System.out.println("isim soyisim ve mail adresinizi giriniz");
                elitUyeEkleme b = new elitUyeEkleme();

                break;

            case 3:

                Scanner girdi = new Scanner(System.in);
                System.out.println("MAİL GONDERME MENUSU");
                System.out.println("1. genel uyelere gonder" + "\n" + "2. Elit uyelere gonder" + "\n" + "3.Bütün uyelere gonder");
                int emg = girdi.nextInt();
                UyelereMailGonder UMG = new UyelereMailGonder();
                switch (emg) {
                    case 1:
                        System.out.println("lutfen mesaj içeriğini giriniz");
                        Scanner scan = new Scanner(System.in);
                        String MesajGovdesi = scan.nextLine();
                        UMG.UyelereMailGonderG(MesajGovdesi);
                        System.out.println("Mesaj başarıyla gönderildi!");
                        break;
                    case 2:
                        System.out.println("lutfen mesaj içeriğini giriniz");
                        Scanner scan1 = new Scanner(System.in);
                        String MesajGovdesi2 = scan1.nextLine();
                        UMG.UyelereMailGonderE(MesajGovdesi2);
                        System.out.println("Mesaj başarıyla gönderildi!");
                        break;
                    case 3:
                        System.out.println("lutfen mesaj içeriğini giriniz");
                        Scanner scan3 = new Scanner(System.in);
                        String MesajGovdesi3 = scan3.nextLine();
                        UMG.UyelereMailGonderG(MesajGovdesi3);
                        UMG.UyelereMailGonderE(MesajGovdesi3);
                        System.out.println("Mesaj başarıyla gönderildi!");
                        break;
                }
                break;
        }
    }
}