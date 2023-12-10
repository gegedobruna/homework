package regions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

/** Represents a region with its properties such as name, house, area, continent, and settlements. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Regions implements Comparable<Regions> {
    /** Comparator for sorting regions based on area, house, and name. */
    public static final Comparator<Regions> COMPARATOR = new RegionComparator();
    /** Represents the name of the region. */
    @EqualsAndHashCode.Include
    private String name;
    /** Represents the house that rules the region. */
    private String house;
    /** Represents the size of the area of the region. */
    private int area;
    /** Represents the continent which the region is in. */
    private Continent continent;
    /** Represents the settlements in the region. */
    @ToString.Exclude
    private Set<Settlements> settlements;

    /** Compares this region with another region for ordering based on area, ruling house, and name. */
    @Override
    public int compareTo(Regions o) {
        return Objects.compare(this, o, COMPARATOR);
    }

    /** Represents a settlement within a region with properties such as city, population, and sigil. */
    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Settlements {
        /** Represents the name of the city. */
        @EqualsAndHashCode.Include
        private final String city;
        /** Represents the population. */
        private final int population;
        /** Represents the sigil (flag). */
        private final String sigil;
    }

    /** Enum representing continents with specified names. */
    public enum Continent {
        /** Represents continent Westeros. */
        @JsonProperty("Westeros") WESTEROS,
        /** Represents continent Essos. */
        @JsonProperty("Essos") ESSOS,
        /** Represents continent Sothoryos. */
        @JsonProperty("Sothoryos") SOTHORYOS,
        /** Represents continent Land of Always Winter. */
        @JsonProperty("Lands of Always Winter") LANDS_OF_ALWAYS_WINTER
    }

    /**
     * Comparator for comparing regions based on:
     * <ol>
     *      <li>the area of the region (descending)
     *      <li>house (ascending)
     *      <li>name (ascending)
     * </ol>
     */
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
