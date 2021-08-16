import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class Sighting {
    private int id;
    private String rangerName;
    private int animalId;
    private String location;

    public Sighting(int animalId, String location, String rangerName) {
        this.rangerName = rangerName;
        this.animalId = animalId;
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return getAnimalId() == sighting.getAnimalId() &&
                animalId == sighting.animalId &&
                Objects.equals(getRangerName(), sighting.getRangerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnimalId(), getRangerName(), animalId);
    }


    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings (animalid, location, rangername) VALUES (:animalId, :location, :rangerName)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sighting> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings";
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }
}
