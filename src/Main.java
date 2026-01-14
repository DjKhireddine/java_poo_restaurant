void main() {
    Restaurant a = new Restaurant();
    // On remplit la liste de des plats du restaurant

    // On crée un client, avec un builder
    Client client = new Client();

    // Composition de la commande via un builder
    Commande commande = new Commande();

    // On essaie de traiter la commande
    a.traiterCommande(commande, client);

    // On affiche le statut de la commande, depuis le client
    System.out.println(client.getStatutCommande());
}
