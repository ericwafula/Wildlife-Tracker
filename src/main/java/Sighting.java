import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class Sighting {
    private int id;
    private String name;
    private int animalId;

    public Sighting(String name, int animalId) {
        this.name = name;
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return getId() == sighting.getId() &&
                animalId == sighting.animalId &&
                Objects.equals(getName(), sighting.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), animalId);
    }
}
