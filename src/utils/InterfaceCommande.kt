package utils

import classes.*
import data.Bibliotheque

// Function to display the main menu
fun afficherMenuPrincipal() {
    println("--------------------------------")
    // system clear console
    println("1. Afficher les bibliothèques")
    println("2. Ajouter une bibliothèque")
    println("3. Choisir une bibliothèque")
    println("4. Supprimer une bibliothèque")
    println("9. Comportement de base du TP")
    println("0. Quitter")
}

// Function to display the library command menu
fun afficherBibliothequeCommande() {
    println("--------------------------------")
    println("1. Afficher les médias")
    println("2. Ajouter un média")
    println("3. Emprunter un média")
    println("4. Retourner un média")
    println("5. Consulter un média")
    println("6. Afficher les emprunts")
    println("9. Retourner au menu principal")
    println("0. Quitter")
}

// Function to display the add media menu
fun afficherAjouterMenu() {
    println("--------------------------------")
    println("1. Ajouter un livre")
    println("2. Ajouter un DVD")
    println("3. Ajouter un enregistrement audio")
    println("4. Ajouter un journal")
    println("5. Ajouter un magazine")
    println("9. Retourner au menu précédent")
    println("0. Quitter")
}

// Function to display the list of libraries
fun afficherListeBibliotheques(listeBibliotheque: MutableList<Bibliotheque>) {
    println("--------------------------------")
    for (i in listeBibliotheque.indices) {
        println("$i. ${listeBibliotheque[i].nom}")
    }
}

// Function to display the add book form and return a new Livre object
fun afficherAjoutLivre(): Livre {
    println("--------------------------------")
    println("Entrez le titre")
    val titre = readln()
    println("Entrez l'auteur")
    val auteur = readln()
    println("Entrez l'editeur")
    val editeur = readln()
    var dateParution: String
    do {
        println("Entrez la date de parution")
        dateParution = readln()
    } while (!dateValidator(dateParution))
    return Livre(titre, auteur, editeur, dateParution)
}

// Function to display the add DVD form and return a new DVD object
fun afficherAjoutDVD(): DVD {
    println("--------------------------------")
    println("Entrez le titre")
    val titre: String = readln()
    println("Entrez la durée")
    val duree: Int = readlnOrNull()?.toInt() ?: 0
    println("Entrez le genre")
    val genre: String = readln()
    var dateParution: String
    do {
        println("Entrez la date de parution")
        dateParution = readln()
    } while (!dateValidator(dateParution))
    return DVD(titre, duree, genre, dateParution)
}

// Function to display the add audio recording form and return a new EnregistrementAudio object
fun afficherAjouterEnregistrement(): EnregistrementAudio {
    println("--------------------------------")
    println("Entrez le titre")
    val titre: String = readln()
    println("Entrez la durée")
    val duree: Int = readlnOrNull()?.toInt() ?: 0
    println("Entrez le genre")
    val genre: String = readln()
    var dateParution: String
    do {
        println("Entrez la date de parution")
        dateParution = readln()
    } while (!dateValidator(dateParution))
    return EnregistrementAudio(titre, duree, genre, dateParution)
}

// Function to display the add journal form and return a new Journal object
fun afficherAJoutJournal(): Journal {
    println("--------------------------------")
    ("Entrez le titre")
    val titre: String = readln()
    var dateParution: String
    do {
        println("Entrez la date de parution")
        dateParution = readln()
    } while (!dateValidator(dateParution))
    return Journal(titre, dateParution)
}

// Function to display the add magazine form and return a new Magazine object
fun afficherAjoutMagazine(): Magazine {
    println("--------------------------------")
    println("Entrez le titre")
    val titre: String = readln()
    println("Entrez le numéro")
    var numero: String = readln()
    var dateParution: String
    do {
        println("Entrez la date de parution")
        dateParution = readln()
    } while (!dateValidator(dateParution))
    return Magazine(titre, numero, dateParution)
}