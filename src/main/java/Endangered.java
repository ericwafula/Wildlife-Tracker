import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class Endangered {
    private String name;
    private int animalId;
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

    public Endangered(String name, int animalId) {
        this.name = name;
        this.animalId = animalId;
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

    public int getAnimalId(){
        return animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endangered)) return false;
        Endangered that = (Endangered) o;
        return getAnimalId() == that.getAnimalId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAnimalId());
    }
}
