package commandeValidation;

import restaurant.Commande;
import restaurant.EStatutCommande;

public class SoldeClientValidator extends CommandeValidator{
    @Override
    public void checkCommand(Commande commande) {
        if (commande.getClient().getSolde() < commande.getPrixTotal()) {
            commande.setConclusion("Le client n'a pas assez d'argent pour payer la commande!");
            commande.setStatus(EStatutCommande.IMPOSSIBLE);
            return;
        }

        if (nextValidator != null) {
            nextValidator.checkCommand(commande);
        }
    }
}
