package domain;


import java.util.Date;

/**
 * Created by apletea on 4.4.17.
 */
public class Session {
    public long id;
    public long date;
    public String name;

    public Session(String str){
        String strs[] = str.split(" ");
        id = Long.parseLong(strs[0]);
        name = strs[2];
        date = Date.parse(strs[1]);
    }

    @Override
    public String toString() {
        return "Session : {" +
                "id : " + id +
                ", date :" + date +
                ", name :'" + name + '\'' +
                '}';
    }

}
