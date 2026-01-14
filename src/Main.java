import restaurant.*;

void main() throws InterruptedException {
    Restaurant restaurant = new Restaurant();
    // On remplit la liste de des plats du restaurant
    Plat saladeNicoise = new Plat.Builder("salade niçoise", 15)
            .addComposition("riz")
            .addComposition("thon")
            .addComposition("oeuf")
            .addAllergene(EAllergene.POISSON_CRUSTACES)
            .addAllergene(EAllergene.OEUF)
            .build();

    Plat saumonFrites = new Plat.Builder("Saumon-frites", 75)
            .addComposition("Frites")
            .addComposition("Saumon")
            .addAllergene(EAllergene.POISSON_CRUSTACES)
            .build();

    Plat bananaSplit = new Plat.Builder("Banana split", 10)
            .addComposition("Banane")
            .addComposition("chantilly")
            .addAllergene(EAllergene.LAIT_DE_VACHE)
            .build();

    restaurant.addPlat(saladeNicoise)
            .addPlat(saumonFrites)
            .addPlat(bananaSplit);

    // On crée un premier client avec une commande vide
    Client client1 = new Client.Builder(200)
            .addAllergie(EAllergene.FRUITS_A_COQUE)
            .build();

    Commande commande1 = new Commande.Builder(client1)
            .build();

    // On crée un deuxième client allergique à un aliment
    Client client2 = new Client.Builder(200)
            .addAllergie(EAllergene.POISSON_CRUSTACES)
            .build();
    Commande commande2 = new Commande.Builder(client2)
            .addPlat(saladeNicoise)
            .addPlat(saumonFrites)
            .build();

    // On crée un troisième client avec un solde insuffisant
    Client client3 = new Client.Builder(90)
            .addAllergie(EAllergene.FRUITS_A_COQUE)
            .build();
    Commande commande3 = new Commande.Builder(client3)
            .addPlat(saladeNicoise)
            .addPlat(saumonFrites)
            .addPlat(bananaSplit)
            .build();

    // On crée un quatrième client avec une commande valide
    Client client4 = new Client.Builder(200)
            .addAllergie(EAllergene.FRUITS_A_COQUE)
            .build();
    Commande commande4 = new Commande.Builder(client4)
            .addPlat(saladeNicoise)
            .addPlat(saumonFrites)
            .addPlat(bananaSplit)
            .build();

    // On essaie de traiter les commandes
    System.out.println("\n===== Commande N°1 =====");
    restaurant.traiterCommande(commande1);

    System.out.println("\n===== Commande N°2 =====");
    restaurant.traiterCommande(commande2);

    System.out.println("\n===== Commande N°3 =====");
    restaurant.traiterCommande(commande3);

    System.out.println("\n===== Commande N°4 =====");
    restaurant.traiterCommande(commande4);

    // On affiche le statut de la commande, depuis le client
    System.out.println(client1.getStatutCommande());

    CommandeArchive archive = SCommandeArchive.getInstance();
    System.out.println(archive.getListCommandes());
}
