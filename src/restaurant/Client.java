package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Client implements ICommandNotifier {
    private EStatutCommande statutCommande;
    private String motifRefus;
    private List<EAllergene> allergies;
    private int solde;

    private Client(Builder builder) {
        this.statutCommande = builder.statutCommande;
        this.motifRefus = builder.motifRefus;
        this.allergies = builder.allergies;
        this.solde = builder.solde;
    }

    @Override
    public void updateCommandStatus(Commande commande) {
        EStatutCommande commandeStatus = commande.getStatus();
        String motifRefus = commande.getConclusion();
        this.statutCommande = commandeStatus;
        this.motifRefus = motifRefus;
        System.out.println("Le client de la commande N° "+commande.getNumeroCommande()+" a été informé que sa commande est '"+commandeStatus+"' ("+motifRefus+")");
    }

    public EStatutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(EStatutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }

    public String getMotifRefus() {
        return motifRefus;
    }

    public List<EAllergene> getAllergies() {
        return allergies;
    }

    public int getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return "restaurant.Client{" +
                "statutCommande=" + statutCommande +
                ", allergies=" + allergies +
                ", solde=" + solde +
                '}';
    }

    public static class Builder {
        private final EStatutCommande statutCommande;
        private final String motifRefus;
        private final List<EAllergene> allergies;
        private final int solde;

        public Builder(int solde) {
            this.statutCommande = EStatutCommande.AUCUNE;
            this.motifRefus = "";
            this.allergies = new ArrayList<>();
            this.solde = solde;
        }

        public Builder addAllergie(EAllergene allergie) {
            this.allergies.add(allergie);
            return this;
        }

        public Client build() {
            return new Client(this);
        }

    }
}
