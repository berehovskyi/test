package patterns.designpatterns.other.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Jewellery> jewelleries = new ArrayList<>();
        jewelleries.add(new Jewellery("Emerald", "Gold", 300));
        jewelleries.add(new Jewellery("Turquoise", "Platinum", 200));
        jewelleries.add(new Jewellery("Ruby", "Gold", 100));

        List<Jewellery> jewelleriesWithEmerald = Filter.filterByGemstone(jewelleries, "Emerald");
        List<Jewellery> jewelleriesWithGold = Filter.filterByMetal(jewelleries, "Gold");
        List<Jewellery> filterByWeight = Filter.filterByWeight(jewelleries, 150);

        List<List<Jewellery>> lists = Arrays.asList(jewelleriesWithEmerald, jewelleriesWithGold, filterByWeight);
        lists.forEach(System.out::println);
    }
}

class Filter {
    public static List<Jewellery> filterByWeight(List<Jewellery> jewelleries, Integer moreThan) {
        List<Jewellery> filtered = new ArrayList<>();
        for (Jewellery jewellery: jewelleries) {
            if (jewellery.getWeight() > moreThan) {
                filtered.add(jewellery);
            }
        }
        return filtered;
    }

    public static List<Jewellery> filterByGemstone(List<Jewellery> jewelleries, String hasGemstone) {
        List<Jewellery> filtered = new ArrayList<>();
        for (Jewellery jewellery: jewelleries) {
            if (jewellery.getGemstone().equalsIgnoreCase(hasGemstone)) {
                filtered.add(jewellery);
            }
        }
        return filtered;
    }

    public static List<Jewellery> filterByMetal(List<Jewellery> jewelleries, String hasMetal) {
        List<Jewellery> filtered = new ArrayList<>();
        for (Jewellery jewellery: jewelleries) {
            if (jewellery.getMetal().equalsIgnoreCase(hasMetal)) {
                filtered.add(jewellery);
            }
        }
        return filtered;
    }
}

class Jewellery {
    private String gemstone;
    private String metal;
    private Integer weight;

    public Jewellery(String gemstone, String metal, Integer weight) {
        this.gemstone = gemstone;
        this.metal = metal;
        this.weight = weight;
    }

    public String getGemstone() {
        return gemstone;
    }

    public void setGemstone(String gemstone) {
        this.gemstone = gemstone;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
