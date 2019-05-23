import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;

public class Sender {

        public static void main(String[] args) {

        try {
            byte[] data = new byte[1000];


            DatagramSocket socket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getLocalHost();
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(new File(" people_table.csv "));
            DatagramPacket packet;

            while(fileInputStream.read(data)!=-1){

                packet = new DatagramPacket(data, data.length, inetAddress, 22222);

                socket.send(packet);

            }

            fileInputStream.close();
            socket.close();

            System.out.println("пакет отправлен");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}