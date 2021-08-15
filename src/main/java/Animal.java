import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;

public class Animal {
    private String name;
    private int id;

    public Animal(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
}
