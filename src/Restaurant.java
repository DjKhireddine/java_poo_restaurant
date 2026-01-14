import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Plat> platList = new ArrayList<>();

    public void addPlat(Plat item) {}

    public void traiterCommande(Commande commande, Client client) {
        // Envoyer la commande dans le pattern chain of responsability

        // Si la commande est faisable, mettre à jour le statut de la commande
    }
}