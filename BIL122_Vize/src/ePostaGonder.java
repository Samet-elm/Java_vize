import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ePostaGonder {
    public ePostaGonder(String mailAdres, String body) {

        // Giriş bilgilerini ayarlayın
        String host = "smtp.gmail.com";
        String gonderen = "gonderen@gmail.com";
        String HesapSifresi = "15Haneliuygulamaşifresi";


        // Gönderen ve konu bilgilerini ayarlayın
        String fromAddress = "gonderen@gmail.com";
        String konu = "Mail gönderme kodu deneme";

        // Mail Ayarlarını yapılandırma
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Oturum açın
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(gonderen, HesapSifresi);
            }
        });

        try {
            // Mesajı oluştuma ve gönderme işlemleri
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailAdres));
            message.setSubject(konu);
            message.setText(body);
            Transport.send(message);

        } catch (MessagingException ex) {
            System.out.println("Mesaj gönderilirken bir hata oluştu: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
