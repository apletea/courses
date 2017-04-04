package repository;

import domain.Booking;

import java.io.*;
import java.util.Scanner;

/**
 * Created by apletea on 4.4.17.
 */
public class BookingDAO {

    public void cancel(long id) throws IOException {
        File inputFile = new File("booking.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        long idToRemove = id;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            Booking currentBook = new Booking(currentLine);
            if(currentBook.id == idToRemove)
                continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
    }

    public String getInfo(long id) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("booking.txt"));
        String booking ="";
        String session = "";
        while (sc.hasNext()){
            Booking currentBook = new Booking(sc.next());
            if (currentBook.id == id){
                booking = currentBook.toString();
                SessionDAO sessionDAO = new SessionDAO();
                session = sessionDAO.getInfo(currentBook.sessionId);
                break;
            }
        }
        sc.close();
        return booking+session;
    }

    public String bookPlace(long session_id, int place){

    }
}
