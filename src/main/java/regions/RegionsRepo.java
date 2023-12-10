package regions;

import base.Queries;
import base.Repository;
import lombok.NonNull;

import java.io.IOException;
import java.util.*;

/**
 * The {@code RegionsRepo} class is a repository for managing regions and implements queries
 * defined in the {@link Queries} interface for retrieving information about regions, settlements, and continents.
 */
public class RegionsRepo extends Repository<Regions> implements Queries<Regions, Regions.Settlements, Regions.Continent> {

    public RegionsRepo() throws IOException {
        super(Regions.class);
    }

    @Override
    public int getMaximumOfArea() {
        int max = getAll().get(0).getArea();
        for (int i = 1; i < getAll().size(); i++) {
            if (getAll().get(i).getArea() > max) {
                max = getAll().get(i).getArea();
            }
        }
        return max;
    }

    @Override
    public List<Regions> getRegionsOrderBySizeThenByHouseThenByName() {
        List<Regions> copy = new ArrayList<>(getAll());
        copy.sort(Regions.COMPARATOR);
        return copy;
    }

    @Override
    public Set<String> getNamesOfRegionsByContinents(Regions.@NonNull Continent continent) {
        Set<String> names = new HashSet<>();
        for (Regions regions : getAll()) {
            if (regions.getContinent() == continent) {
                names.add(regions.getName());
            }
        }
        return names;
    }

    @Override
    public Map<String, Regions.Continent> getHouseByContinent() {
        Map<String, Regions.Continent> result = new HashMap<>();
        for (Regions regions : getAll()) {
            result.put(regions.getHouse(), regions.getContinent());
        }
        return result;
    }

    @Override
    public Map<String, Set<Regions.Settlements>> getSettlementsByContinent() {
        Map<String, Set<Regions.Settlements>> result = new HashMap<>();

        for (Regions region : getAll()) {
            String continent = region.getContinent().toString();
            if (!result.containsKey(continent)) {
                result.put(continent, new HashSet<>());
            }
            result.get(continent).addAll(region.getSettlements());
        }

        return result;
    }

    @Override
    public Map<String, Map<String, Set<String>>> getHouseByContinentAndName() {
        Map<String, Map<String, Set<String>>> result = new HashMap<>();
        for (Regions region : getAll()) {
            String continent = region.getContinent().name();
            String house = region.getHouse();
            String name = region.getName();
            if (!result.containsKey(continent)) {
                result.put(continent, new HashMap<>());
            }
            if (!result.get(continent).containsKey(house)) {
                result.get(continent).put(house, new HashSet<>());
            }
            result.get(continent).get(house).add(name);
        }

        return result;
    }

}
