package commandeValidation;

import restaurant.*;

public class AllergeneValidator extends CommandeValidator {
    @Override
    public void checkCommand(Commande commande) {
        Client client = commande.getClient();
        if (!client.getAllergies().isEmpty()) {
            for (Plat plat : commande.getListPlat()) {
                for (EAllergene allergene : plat.getAllergenes()) {
                    if (client.getAllergies().contains(allergene)) {
                        commande.setConclusion("Le plat '"+plat.getNom()+"' commandé contient l'allergène '" + allergene + "' non toléré par le client!");
                        commande.setStatus(EStatutCommande.IMPOSSIBLE);
                        return;
                    }
                }
            }
        }

        if (nextValidator != null) {
            nextValidator.checkCommand(commande);
        }
    }
}
