package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private Client client;
    // Pas de texte > La commande est faisable
    // Du texte > La commande est non faisable pour x raison
    private String conclusion;
    private EStatutCommande status;
    private List<Plat> listPlat;
    private static int counter = 0;
    private final int numeroCommande;

    private Commande (Builder builder) {
        this.client = builder.client;
        this.conclusion = builder.conclusion;
        this.status = builder.status;
        this.listPlat = builder.listPlat;
        this.numeroCommande = builder.numeroCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Plat> getListPlat() {
        return listPlat;
    }

    public int getPrixTotal() {
        int total = 0;
        for (Plat plat : this.getListPlat()) {
            total += plat.getPrix();
        }
        return total;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setListPlat(List<Plat> listPlat) {
        this.listPlat = listPlat;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public EStatutCommande getStatus() {
        return status;
    }

    public void setStatus(EStatutCommande status) {
        this.status = status;
        this.client.updateCommandStatus(this);
    }

    @Override
    public String toString() {
        return "\n\nrestaurant.Commande{" +
                "commande N°: " + numeroCommande +
                ", client=" + client +
                ", conclusion='" + conclusion + '\'' +
                ", status=" + status +
                ", listPlat=" + listPlat +
                '}';
    }

    public static class Builder {
        private final Client client;
        private final String conclusion;
        private final EStatutCommande status;
        private final List<Plat> listPlat;
        private int numeroCommande;

        public Builder(Client client) {
            this.client = client;
            this.conclusion = "";
            this.status = EStatutCommande.PASSEE;
            this.listPlat = new ArrayList<>();
        }

        public Builder addPlat(Plat plat) {
            this.listPlat.add(plat);
            return this;
        }

        public Commande build() {
            numeroCommande = ++counter;
            CommandeArchive archive = SCommandeArchive.getInstance();
            Commande commande = new Commande(this);
            archive.addCommande(commande);
            return commande;
        }
    }
}
