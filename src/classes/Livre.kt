package classes

import interfaces.Consultable
import interfaces.Empruntable

// Déclaration de la classe Livre qui hérite de Media et implémente les interfaces Empruntable et Consultable
class Livre(titre: String, dateParution: String) : Media(titre, dateParution), Empruntable, Consultable {

    // Propriétés spécifiques à la classe Livre
    var auteur: String = ""
    var editeur: String = ""

    // Constructeur secondaire qui initialise les propriétés auteur et editeur
    constructor(titre: String, auteur: String, editeur: String, dateParution: String) : this(titre, dateParution) {
        this.auteur = auteur
        this.editeur = editeur
        this.titre = titre
        this.dateParution = dateParution
    }

    // Méthode pour afficher les détails du livre
    override fun afficher() {
        print(" - Livre :")
        print(" Titre: '$titre'")
        print(", Date de parution: $dateParution")
        print(", Auteur: $auteur")
        print(", Editeur: $editeur.")
    }

    // Méthode pour consulter le livre, affiche un message indiquant que le livre est consulté sur place
    override fun consulter() {
        println("Le livre '$titre' de '$auteur' ($dateParution) est consulté sur place.")
    }

    // Méthode pour emprunter le livre, retourne true pour indiquer le succès
    override fun emprunter(): Boolean {
        println("Le livre '$titre' de '$auteur' ($dateParution) est emprunté.")
        return true
    }

    // Méthode pour retourner le livre, retourne true pour indiquer le succès
    override fun retourner(): Boolean {
        println("Le livre '$titre' de '$auteur' ($dateParution) est retourné.")
        return true
    }
}