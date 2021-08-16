import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class Endangered {
    private String name;
    private int id;
    private String age;

    private String healthy;
    private String ill;
    private String okay;

    private String newBorn;
    private String young;
    private String adult;

    public static final String HEALTH_HEALTHY = "healthy";
    public static final String HEALTH_ILL = "ill";
    public static final String HEALTH_OKAY = "okay";

    public static final String AGE_NEWBORN = "newborn";
    public static final String AGE_YOUNG = "young";
    public static final String AGE_ADULT = "adult";

    public Endangered(String name) {
        this.name = name;
        this.healthy = HEALTH_HEALTHY;
        this.ill = HEALTH_ILL;
        this.okay = HEALTH_OKAY;
        this.newBorn = AGE_NEWBORN;
        this.young = AGE_YOUNG;
        this.adult = AGE_ADULT;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endangered)) return false;
        Endangered that = (Endangered) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }

    public int getId(){
        return id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Endangered> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals";
            return con.createQuery(sql)
                    .executeAndFetch(Endangered.class);
        }
    }

    public static Endangered find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals WHERE id= :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endangered.class);
        }
    }

    public List<Sighting> getSightings(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings WHERE animalId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sighting.class);
        }
    }


}
