package data

import classes.Media
import interfaces.Consultable
import interfaces.Empruntable

// Déclaration de la classe Bibliotheque
class Bibliotheque(var nom: String = "Bibliothèque") {

    // Liste des médias disponibles dans la bibliothèque
    val medias: MutableList<Media> = mutableListOf()
    // Liste des médias empruntés
    val emprunts: MutableList<Media> = mutableListOf()

    // Fonction pour ajouter un média à la bibliothèque
    fun ajouterMedia(media: Media) {
        // Vérifie si le média est déjà dans la bibliothèque
        if (medias.contains(media)) {
            println("Ce media est déjà dans la bibliothèque")
        } else {
            // Ajoute le média à la liste des médias
            medias.add(media)
        }
    }

    // Fonction pour emprunter un média
    fun emprunter(media: Media) {
        // Vérifie si le média est déjà emprunté
        if (emprunts.contains(media)) {
            println("Ce media est déjà emprunté")
        } else {
            // Vérifie si le média est dans la bibliothèque
            if (medias.contains(media)) {
                // Vérifie si le média est empruntable
                if (media is Empruntable) {
                    // Emprunte le média et l'ajoute à la liste des emprunts
                    media.emprunter()
                    emprunts.add(media)
                } else {
                    println("Ce media n'est pas empruntable")
                }
            } else {
                println("Ce media n'est pas dans la bibliothèque")
            }
        }
    }

    // Fonction pour retourner un média emprunté
    fun retourner(media: Media) {
        // Vérifie si le média est emprunté
        if (emprunts.contains(media)) {
            // Vérifie si le média est empruntable
            if (media is Empruntable) {
                // Retourne le média et le retire de la liste des emprunts
                media.retourner()
                emprunts.remove(media)
            }
        } else {
            println("Ce media n'est pas emprunté")
        }
    }

    // Fonction pour consulter un média
    fun consulter(media: Media) {
        // Vérifie si le média est emprunté
        if (emprunts.contains(media)) {
            println("Ce media est emprunté")
        } else {
            // Vérifie si le média est dans la bibliothèque
            if (medias.contains(media)) {
                // Vérifie si le média est consultable
                if (media is Consultable) {
                    // Consulte le média
                    media.consulter()
                } else {
                    println("Ce media n'est pas consultable")
                }
            } else {
                println("Ce media n'est pas dans la bibliothèque")
            }
        }
    }

    // Fonction pour afficher la liste des emprunts en cours
    fun afficherEmprunts() {
        println("Emprunts en cours: ")
        // Parcourt la liste des emprunts et affiche chaque média
        emprunts.forEach {
            it.afficher()
            println()
        }
    }

    // Afficher les médias de la bibliothèque
    fun afficherMedias() {
        println("Médias disponibles: ")
        // Parcourt la liste des médias et affiche chaque média
        medias.forEach {
            it.afficher()
            println()
        }
    }
}