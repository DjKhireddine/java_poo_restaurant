package commandeValidation;

import restaurant.Commande;
import restaurant.EStatutCommande;

public class PlatValidator extends CommandeValidator {
    @Override
    public void checkCommand(Commande commande) {
        if (commande.getListPlat().isEmpty()) {
            System.out.println();
            commande.setConclusion("Rien n'a été commandé!");
            commande.setStatus(EStatutCommande.IMPOSSIBLE);
            return;
        }

        if (nextValidator != null) {
            nextValidator.checkCommand(commande);
        }
    }
}
