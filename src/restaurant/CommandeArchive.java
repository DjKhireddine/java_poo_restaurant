package restaurant;

import java.util.ArrayList;
import java.util.List;

public class CommandeArchive {
    private List<Commande> listCommandes = new ArrayList<>();

    public List<Commande> getListCommandes() {
        return listCommandes;
    }

    public void addCommande(Commande commande) {
        this.listCommandes.add(commande);
    }
}
