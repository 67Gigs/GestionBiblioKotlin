package classes

import interfaces.Empruntable
import utils.dateValidator

// Déclaration de la classe DVD qui hérite de Media et implémente l'interface Empruntable
class DVD(titre: String, dateParution: String) : Media(titre, dateParution), Empruntable {

    // Propriétés spécifiques à la classe DVD
    var duree: Int = 0
    var genre: String = ""

    // Constructeur secondaire qui initialise les propriétés duree et genre
    constructor(titre: String, duree: Int, genre: String, dateParution: String) : this(titre, dateParution) {
        this.duree = duree
        this.genre = genre
        this.titre = titre
    }

    // Méthode pour afficher les détails du DVD
    override fun afficher() {
        print(" - DVD : ")
        print(" Titre: '$titre'")
        print(", Date de parution: $dateParution")
        print(", Durée: $duree minutes")
        print(", Genre: $genre.")
    }

    // Méthode pour emprunter le DVD, retourne true pour indiquer le succès
    override fun emprunter(): Boolean {
        println("Le DVD '$titre' ($dateParution) est emprunté.")
        return true
    }

    // Méthode pour retourner le DVD, retourne true pour indiquer le succès
    override fun retourner(): Boolean {
        println("Le DVD '$titre' ($dateParution) est retourné.")
        return true
    }
}