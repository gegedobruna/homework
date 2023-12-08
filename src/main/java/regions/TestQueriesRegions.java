package regions;

import java.io.IOException;
import java.util.*;

public class TestQueriesRegions {
    public static void main(String[] args) throws IOException {
        RegionsRepo repository = new RegionsRepo();
        System.out.println(repository);

        System.out.println(repository.getMaximumOfArea());

        System.out.println(repository.getRegionsOrderBySizeThenByHouseThenByName());

        for (String name : repository.getNamesOfRegionsByContinents(Regions.Continent.WESTEROS)) {
            System.out.println(name);
        }


        Map<String, Regions.Continent> houseByContinent = repository.getHouseByContinent();
        for (Map.Entry<String, Regions.Continent> entry : houseByContinent.entrySet()) {
            String house = entry.getKey();
            Regions.Continent continent = entry.getValue();
            System.out.println("House: " + house + ", Continent: " + continent);
        }


        Map<String, Set<Regions.Settlements>> settlementsByContinent = repository.getSettlementsByContinent();
        for (Map.Entry<String, Set<Regions.Settlements>> entry : settlementsByContinent.entrySet()) {
            String continent = entry.getKey();
            Set<Regions.Settlements> settlements = entry.getValue();

            System.out.println("Continent: " + continent);
            System.out.println("Settlements: ");
            for (Regions.Settlements settlement : settlements) {
                System.out.println("(Name: " + settlement.getCity() + ", Sigil: " + settlement.getSigil() + ")");
            }
            System.out.println("------------");
        }

    }
}
