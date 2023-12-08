package base;

import lombok.NonNull;
import regions.Regions;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Defines queries for your {@link Repository} implementation.
 *
 * @param <T> the type of your entity (first class)
 * @param <U> the type of your nested class (second class)
 * @param <V> the type of your enum class
 */
public interface Queries<T, U, V extends Enum<V>> {
    /**
     * Returns the greatest (maximum) value of area.
     *
     * @return the maximum of area
     */
    int getMaximumOfArea();

    /**
     * Returns the list of Regions ordered by:
     *
     * <ol>
     *     <li>the area of the region (descending)
     *     <li>house (ascending)
     *     <li>name (ascending)
     * </ol>
     *
     * The method cannot modify the original list.
     *
     * @return the sorted list of Regions
     */
    List<Regions> getRegionsOrderBySizeThenByHouseThenByName();

    /**
     * Returns the name of each Region that belongs to a continent.
     *
     * @param continent the continent
     * @return the names
     */
    Set<String> getNamesOfRegionsByContinents(@NonNull V continent);

    /**
     * Returns a dictionary that maps the name of each house to its continent.
     *
     * @return the dictionary
     */
    Map<String, V> getHouseByContinent();

    /**
     * Returns a Map with continents as keys and Sets of settlements as values.
     *
     * @return The generated Map.
     */
    Map<String, Set<U>> getSettlementsByContinent();

    /**
     * Returns a dictionary which maps each continent to the corresponding house, then each house to the corresponding name of the region.
     *
     * @return The generated Map with String keys and Map values
     */
    Map<String, Map<String, Set<String>>> getHouseByContinentAndName();
}
