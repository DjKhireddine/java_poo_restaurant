package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Plat {
    private String nom;
    private List<String> composition;
    private List<EAllergene> allergenes;
    private int prix;

    private Plat(Builder builder) {
        this.nom = builder.nom;
        this.composition = builder.composition;
        this.allergenes = builder.allergenes;
        this.prix = builder.prix;
    }

    public String getNom() {
        return nom;
    }

    public List<EAllergene> getAllergenes() {
        return allergenes;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "nom='" + nom + '\'' +
                ", composition=" + composition +
                ", allergenes=" + allergenes +
                ", prix=" + prix +
                '}';
    }

    public static class Builder {
        private String nom;
        private final List<String> composition;
        private final List<EAllergene> allergenes;
        private final int prix;

        public Builder(String nom, int prix) {
            this.nom = nom;
            this.composition = new ArrayList<>();
            this.allergenes = new ArrayList<>();
            this.prix = prix;
        }

        public Builder addComposition(String composition) {
            this.composition.add(composition);
            return this;
        }

        public Builder addAllergene(EAllergene allergene) {
            this.allergenes.add(allergene);
            return this;
        }

        public Plat build() {
            return new Plat(this);
        }
    }
}