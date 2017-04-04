package domain;


/**
 * Created by apletea on 9.2.17.
 */

public class Booking {
    public long id;
    public long sessionId;
    public int place;

     public Booking(String str){
        String[] info = str.split(" ");
        id = Long.parseLong(info[0]);
        sessionId = Long.parseLong(info[1]);
        place = Integer.parseInt(info[2]);
    }

    public Booking(long session_id, int place){
         id = sessionId *1000+place;
         sessionId = sessionId;
         this.place = place;
    }


    @Override
    public String toString() {
        return "Booking : {" +
                "id :" + id +
                ", sessionId :" + sessionId +
                ", place :" + place +
                '}';
    }
}
