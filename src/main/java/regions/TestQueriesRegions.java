package regions;


import java.io.IOException;
import java.util.*;

/**
 * The main class for testing region queries.
 */
public class TestQueriesRegions {
    /** Prints a separator line. */
    private static void printSeparator() {
        System.out.println("//////////////////////////////////////////////////////////////");
    }

    /** Main method to execute region queries using TestQueriesRegionsPrinter. */
    public static void main(String[] args) throws IOException {
        TestQueriesRegionsPrinter printer = new TestQueriesRegionsPrinter();

        printer.printRepository();
        printSeparator();

        printer.printMaximumArea();
        printSeparator();

        printer.printOrderedRegions();
        printSeparator();

        printer.printRegionsInContinent();
        printSeparator();

        printer.printHousesByContinent();
        printSeparator();

        printer.printSettlementsByContinent();
        printSeparator();

        printer.printContinentHousesAndRegions();
    }
}

/** Class for printing various region queries. */
class TestQueriesRegionsPrinter {
    private final RegionsRepo repository;
    /** Constructs a TestQueriesRegionsPrinter object. */
    public TestQueriesRegionsPrinter() throws IOException {
        this.repository = new RegionsRepo();
    }

    /** Prints the details of the region repository. */
    public void printRepository() {
        System.out.println("Print repository:\n" + repository);
    }

    /** Prints the maximum area of a region. */
    public void printMaximumArea() {
        System.out.println("Print maximum area:\n" + repository.getMaximumOfArea() + "m2");
    }

    /** Prints the regions ordered by size, house, and name. */
    public void printOrderedRegions() {
        System.out.println("Print the regions ordered:\n" + repository.getRegionsOrderBySizeThenByHouseThenByName());
    }

    /** Prints the names of regions in the Westeros continent. */
    public void printRegionsInContinent() {
        System.out.println("Print only the regions in continent Westeros:");
        for (String name : repository.getNamesOfRegionsByContinents(Regions.Continent.WESTEROS)) {
            System.out.println(name);
        }
    }
    /** Prints houses that belong to continents. */
    public void printHousesByContinent() {
        System.out.println("Print houses that belong to continents:");
        Map<String, Regions.Continent> houseByContinent = repository.getHouseByContinent();

        for (Map.Entry<String, Regions.Continent> entry : houseByContinent.entrySet()) {
            String house = entry.getKey();
            Regions.Continent continent = entry.getValue();

            System.out.println("House: " + house + ", Continent: " + continent);
        }
    }

    /** Prints settlements based on the continents they're in. */
    public void printSettlementsByContinent() {
        System.out.println("Print settlements based on the continents they're in: ");
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

    /** Prints the continents along with their houses and the houses' respective region. */
    public void printContinentHousesAndRegions() {
        Map<String, Map<String, Set<String>>> houseByContinentAndName = repository.getHouseByContinentAndName();

        for (Map.Entry<String, Map<String, Set<String>>> continentEntry : houseByContinentAndName.entrySet()) {
            String continent = continentEntry.getKey();
            Map<String, Set<String>> houseMap = continentEntry.getValue();
            System.out.println("Continent: " + continent);

            for (Map.Entry<String, Set<String>> houseEntry : houseMap.entrySet()) {
                String house = houseEntry.getKey();
                Set<String> regions = houseEntry.getValue();

                System.out.println("  House: " + house);
                System.out.println("    Regions: " + String.join(", ", regions));
            }
            System.out.println("--------------");
    }
}
}