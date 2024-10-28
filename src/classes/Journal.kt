package classes

import interfaces.Consultable

// Déclaration de la classe Journal qui hérite de Media et implémente l'interface Consultable
class Journal(titre: String, dateParution: String) : Media(titre, dateParution), Consultable {

    // Méthode pour afficher les détails du journal
    override fun afficher() {
        print(" - Journal :")
        print(" Titre: '$titre'")
        print(", Date de parution: $dateParution.")
    }

    // Méthode pour consulter le journal, affiche un message indiquant que le journal est consulté sur place
    override fun consulter() {
        println("Le journal '$titre' ($dateParution) est consulté sur place.")
    }
}