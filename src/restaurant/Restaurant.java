package restaurant;

import commandeValidation.AllergeneValidator;
import commandeValidation.CommandeValidator;
import commandeValidation.PlatValidator;
import commandeValidation.SoldeClientValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private List<Plat> platList = new ArrayList<>();

    public Restaurant addPlat(Plat item) {
        this.platList.add(item);
        return this;
    }

    public void traiterCommande(Commande commande) throws InterruptedException {
        // Envoyer la commande dans le pattern chain of responsability
        CommandeValidator commandeValidator = new PlatValidator();
        CommandeValidator allergeneValidator = new AllergeneValidator();
        CommandeValidator soldeClientValidator = new SoldeClientValidator();

        commandeValidator.addValidator(allergeneValidator).addValidator(soldeClientValidator);

        commandeValidator.checkCommand(commande);

        if (commande.getStatus() == EStatutCommande.IMPOSSIBLE) {
            return;
        }

        // Si la commande est faisable, mettre à jour le statut de la commande
        commande.setConclusion("Validée");
        commande.setStatus(EStatutCommande.EN_PREPARATION);

        TimeUnit.SECONDS.sleep(2);

        commande.setStatus(EStatutCommande.TERMINEE);
    }
}