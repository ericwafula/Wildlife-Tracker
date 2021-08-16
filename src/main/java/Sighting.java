import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Sighting {
    private int id;
    private int animalId;
    private String rangerName;
    private String location;

    public Sighting(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return getAnimalId() == sighting.getAnimalId() &&
                getRangerName().equals(sighting.getRangerName()) &&
                getLocation().equals(sighting.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnimalId(), getRangerName(), getLocation());
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalid, location, rangername) VALUES (:animalId, :location, :rangerName)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
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

    public static Sighting find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }
}
