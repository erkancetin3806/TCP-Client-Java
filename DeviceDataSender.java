import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DeviceDataSender {

    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // Hedef bilgisayarın IP adresi
        int serverPort = 9999;          // Hedef port numarası
    
        try (Socket socket = new Socket(serverIP, serverPort)) {
            System.out.println("Bağlantı kuruldu.");

            // Veriyi göndermek için bir OutputStream alınır.
            OutputStream outputStream = socket.getOutputStream();

            // Gönderilecek veri
            String dataToSend = "\020\010CH;0;993B\015\012";
                                // 0   1 234567890
            // Veriyi byte dizisine çevirip gönder
            byte[] dataBytes = dataToSend.getBytes();
            outputStream.write(dataBytes);
            System.out.println("Veri gönderildi: " + new String(dataBytes)); // dataBytes'ı doğrudan yazdırabilirsiniz

            // Kullanıcıdan bir tuşa basmasını bekleyebilirsiniz
            System.out.println("Enter tuşuna basın ve ardından kapatmak için bir tuş daha basın.");
            new Scanner(System.in).nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
