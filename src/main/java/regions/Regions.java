package regions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Regions implements Comparable<Regions> {
    public static final Comparator<Regions> COMPARATOR = new RegionComparator();
    @EqualsAndHashCode.Include
    private String name;
    private String house;
    private int area;
    private Continent continent;
    @ToString.Exclude
    private Set<Settlements> settlements;

    @Override
    public int compareTo(Regions o) {
        return Objects.compare(this, o, COMPARATOR);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Settlements {
        @EqualsAndHashCode.Include
        private final String city;
        private final int population;
        private final String sigil;
    }

    public enum Continent {
        @JsonProperty("Westeros") WESTEROS,
        @JsonProperty("Essos") ESSOS,
        @JsonProperty("Sothoryos") SOTHORYOS,
        @JsonProperty("Lands of Always Winter") LANDS_OF_ALWAYS_WINTER
    }

    public static class RegionComparator implements Comparator<Regions> {

        @Override
        public int compare(Regions o1, Regions o2) {
            if(o1.area != o2.area) {
                return Objects.compare(o1.area, o2.area, Comparator.reverseOrder());
            }
            if(!Objects.equals(o1.house, o2.house)) {
                return Objects.compare(o1.house, o2.house, Comparator.naturalOrder());
            }
            return Objects.compare(o1.name, o2.name, Comparator.naturalOrder());
        }
    }

}
