package designpatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        Jewellery crown = new Jewellery.Builder("Jewellery", "Crown")
                .withMetal("Gold")
                .withGemstone("Emerald")
                .atWeight(700)
                .wantDiamonds(true)
                .build();
        Jewellery necklace = new Jewellery.Builder("Treasure", "Necklace")
                .withMetal("Silver")
                .withGemstone("Ruby")
                .atWeight(300)
                .wantDiamonds(false)
                .build();
    }
}

class Jewellery {

    private Jewellery(Builder builder) {
    }

    static class Builder {
        private String name;
        private String form;
        private String metal;
        private String gemstone;
        private Integer weight;
        private Boolean diamonds;

        Builder(String name, String form) {
            this.name = name;
            this.form = form;
        }

        Builder withMetal(String metal) {
            this.metal = metal;
            return this;
        }

        Builder withGemstone(String gemstone) {
            this.gemstone = gemstone;
            return this;
        }

        Builder atWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        Builder wantDiamonds(Boolean diamonds) {
            this.diamonds = diamonds;
            return this;
        }

        Jewellery build() {
            return new Jewellery(this);
        }
    }
}
