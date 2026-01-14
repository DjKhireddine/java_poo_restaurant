package restaurant;

public class SCommandeArchive {
    private static CommandeArchive instance = null;

    private SCommandeArchive() {}

    public static CommandeArchive getInstance() {
        if (instance == null) {
            instance = new CommandeArchive();
        }

        return instance;
    }
}
