package classes

import interfaces.Consultable

// Déclaration de la classe Magazine qui hérite de Media et implémente l'interface Consultable
class Magazine(titre: String, dateParution: String) : Media(titre, dateParution), Consultable {
    // Propriété spécifique à la classe Magazine
    private var numero: String = ""

    // Constructeur secondaire qui initialise la propriété numero
    constructor(titre: String, dateParution: String, numero: String) : this(titre, dateParution) {
        this.numero = numero
    }

    // Méthode pour afficher les détails du magazine
    override fun afficher() {
        print(" - Magazine :")
        print(" Titre: '$titre'")
        print(", Date de parution: $dateParution")
        print(", Numero: $numero.")
    }

    // Méthode pour consulter le magazine, affiche un message indiquant que le magazine est consulté sur place
    override fun consulter() {
        println("Le magazine '$titre', numéro '$numero' ($dateParution) est consulté sur place.")
    }
}