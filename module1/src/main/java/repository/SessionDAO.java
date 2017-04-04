package repository;


import config.Config;
import domain.Session;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by apletea on 9.2.17.
 */
public class SessionDAO {


        public String getInfo(long id) throws FileNotFoundException{
            Scanner sc = new Scanner(new File(Config.TIMETABLE));
            while (sc.hasNext()){
                Session currentSession = new Session(sc.next());
                if (currentSession.id == id)
                    return currentSession.toString();
            }
            return "";
        }
}
