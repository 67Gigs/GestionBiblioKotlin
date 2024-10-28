package classes

import interfaces.Empruntable

// Déclaration de la classe EnregistrementAudio qui hérite de Media et implémente l'interface Empruntable
class EnregistrementAudio(titre: String, dateParution: String) : Media(titre, dateParution), Empruntable {

    // Propriétés spécifiques à la classe EnregistrementAudio
    var duree: Int = 0
    var genre: String = ""

    // Constructeur secondaire qui initialise les propriétés duree et genre
    constructor(titre: String, duree: Int, genre: String, dateParution: String) : this(titre, dateParution) {
        this.duree = duree
        this.genre = genre
        this.titre = titre
        this.dateParution = dateParution
    }

    // Méthode pour afficher les détails de l'enregistrement audio
    override fun afficher() {
        print(" - Enregistrement audio :")
        print(" Titre: '$titre'")
        print(", Date de parution: $dateParution")
        print(", Durée: $duree minutes")
        print(", Genre: $genre.")
    }

    // Méthode pour emprunter l'enregistrement audio, retourne true pour indiquer le succès
    override fun emprunter(): Boolean {
        println("L'enregistrement audio '$titre' ($dateParution) est emprunté.")
        return true
    }

    // Méthode pour retourner l'enregistrement audio, retourne true pour indiquer le succès
    override fun retourner(): Boolean {
        println("L'enregistrement audio '$titre' ($dateParution) est retourné.")
        return true
    }
}