package commandeValidation;

import restaurant.Commande;

public abstract class CommandeValidator {
    protected CommandeValidator nextValidator;

    public CommandeValidator addValidator(CommandeValidator validator) {
        nextValidator = validator;
        return nextValidator;
    }

    public abstract void checkCommand(Commande commande);
}
