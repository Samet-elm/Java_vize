import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class UyelereMailGonder {
    public void UyelereMailGonderG(String bodyx) throws IOException {//main metodda mail gonderme seçeneğinde kullanıcıdan
        //mesaj içeriğini alıyoruz
        System.out.println("genel uyelere mesaj gonderiliyor");
        File dosya1 = new File("KullanıcılarGenel.txt");// KullanıcılarGenel dosyasını okumak için açılır
        FileReader eoku = new FileReader(dosya1);
        BufferedReader k = new BufferedReader(eoku);
        ArrayList<String> emailList = new ArrayList<String>(); //mailleri listeleyebilmek için arraylist oluşturma

        try {
            String line;
            while ((line = k.readLine()) != null) {     //dosyayı satır satır okuyup başlık dışındaki satırlarla
                if (line.equals("GENEL UYELER")) {      //işlem yapılır
                    continue;
                }
                String[] valuesG = line.split("\t");    //Dosyadaki satırları tab karekterlere göre 3 parçaya ayırıyoruz
                emailList.add(valuesG[2]);  // son parça olan mail adresleri arraylistte yutuyoruz
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] emails = emailList.toArray(new String[0]);     //arraylisti tekrar string haline getiriyoruz
        k.close();          //sonrası için işimizi kolaylaştırıyor stringe çevirmek

        for (String email : emails) {  //elimizde bulunan mail sayısı kadar ePostaGonder metodunu çağırıyoruz
            ePostaGonder gonderG = new ePostaGonder(email, bodyx);
        }
    }

    public void UyelereMailGonderE(String body) throws IOException {//main metodda mail gonderme seçeneğinde kullanıcıdan
        //mesaj içeriğini alıyoruz
        System.out.println("elit uyelere mesaj gonderiliyor");
        File dosya2 = new File("KullanıcılarElit.txt");// KullanıcılarGenel dosyasını okumak için açılır
        FileReader eEoku = new FileReader(dosya2);
        BufferedReader ke = new BufferedReader(eEoku);
        ArrayList<String> emailListE = new ArrayList<String>();//mailleri listeleyebilmek için arraylist oluşturma

        try {
            String line2;
            while ((line2 = ke.readLine()) != null) {   //dosyayı satır satır okuyup başlık dışındaki satırlarla
                if (line2.equals("ELIT UYELER")) {     //işlem yapılır
                    continue;
                }
                String[] values = line2.split("\t");        //Dosyadaki satırları tab karekterlere göre 3 parçaya ayırıyoruz
                emailListE.add(values[2]);          // son parça olan mail adresleri arraylistte tutuyoruz

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] emailsE = emailListE.toArray(new String[0]);   //arraylisti tekrar string haline getiriyoruz
        ke.close();         //sonrası için işimizi kolaylaştırıyor stringe çevirmek

        for (String emailE : emailsE) { //mail adresi sayısı kadar mail gönderiyoruz
            ePostaGonder eGonder = new ePostaGonder(emailE, body);
        }
    }
}

