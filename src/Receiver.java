import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

    public Receiver() throws SocketException {
    }

    public static void main(String[] args) {
        File file;
        file = new File(" people_table.csv ");
        System.out.println("Прием данных...");

        try {
            acceptFile(file, 22222, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void acceptFile(File file, int port, int packetSize) throws IOException {

        byte[] data = new byte[packetSize];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        DatagramSocket socket = new DatagramSocket(port);

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        try {
            socket.setSoTimeout(60000);
            while (true){

                socket.receive(packet);
                fileOutputStream.write(data);
                fileOutputStream.flush();
            }

        } catch (IOException e) {
            fileOutputStream.close();
            System.out.println(" Время ожидания истекло");
        }
    }
}