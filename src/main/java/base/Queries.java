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
     * Gets the maximum area among all regions.
     *
     * @return The maximum area of any region.
     */
    int getMaximumOfArea();

    /**
     * Gets the list of Regions ordered by:
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
     * Retrieves the names of regions in a specific continent.
     *
     * @param continent The continent for which to retrieve region names.
     * @return A set of region names in the specified continent.
     */
    Set<String> getNamesOfRegionsByContinents(@NonNull V continent);

    /**
     * Provides a mapping of houses to continents for all regions.
     *
     * @return A map where keys are house names, and values are corresponding continents.
     */
    Map<String, V> getHouseByContinent();

    /**
     * Obtains a mapping of continents to sets of settlements for all regions.
     *
     * @return A map where keys are continent names, and values are sets of settlements in those continents.
     */
    Map<String, Set<U>> getSettlementsByContinent();

    /**
     * Creates a dictionary which maps each continent to the corresponding house, then each house to the corresponding name of the region.
     *
     * @return A map where the outer key is continent name, the middle key is house name,
     *         and the inner set contains region names for the respective continent and house.
     */
    Map<String, Map<String, Set<String>>> getHouseByContinentAndName();
}
