package repository;

import config.Config;
import domain.Session;
import domain.Timetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by apletea on 4.4.17.
 */
public class TimetableDAO {

    public static Timetable getTimetable() throws FileNotFoundException{
        Scanner sc = new Scanner(new File(Config.TIMETABLE));
        Timetable timetable = new Timetable();
        while (sc.hasNext()){
            String str = sc.next();
            Session session = new Session(str);
            timetable.addSession(session);
        }
        sc.close();
        return timetable;
    }
}
