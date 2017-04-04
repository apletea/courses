package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apletea on 4.4.17.
 */
public class Timetable {
    List<Session> timetable;

    public Timetable() {
        this.timetable =new ArrayList<>();
    }

    public List<Session> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Session> timetable) {
        this.timetable = timetable;
    }

    public void addSession(Session session){
        timetable.add(session);
    }

    @Override
    public String toString() {
        return "Timetable : {" +
                "timetable :" + timetable +
                '}';
    }
}
