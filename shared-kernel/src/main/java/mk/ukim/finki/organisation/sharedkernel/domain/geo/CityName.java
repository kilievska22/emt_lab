package mk.ukim.finki.organisation.sharedkernel.domain.geo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.organisation.sharedkernel.domain.base.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class CityName implements ValueObject {
    @Column(name="city_name")
    private  String name;

    @JsonCreator
    public CityName(@NonNull String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }
    public CityName(){}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityName cityName = (CityName) o;
        return Objects.equals(name, cityName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    @JsonValue
    public String toString() {
        return name;
    }
}
