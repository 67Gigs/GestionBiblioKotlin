import classes.*
import data.Bibliotheque
import utils.*

fun main() {
    var tmp: Int = 0

    // Initialize a list to store libraries
    val listeBibliotheque = mutableListOf<Bibliotheque>()

    // Create a new library and add some media items to it
    val bibliotheque = Bibliotheque("Bibliothèque de Montréal")
    val magazine = Magazine("National Geographic", "2024-10-28", "10")
    val journal = Journal("Le Monde", "2024-10-28")
    val enregistrementAudio = EnregistrementAudio("Beethoven - Symphonie No.9", 960, "Classical", "1967-01-01")
    val dvd = DVD("Inception", 8880, "Action", "2010-01-01") // 2h 28m
    val livre = Livre("1984", "George Orwell", "Gallimard", "1972-01-01")

    // Add media items to the library
    bibliotheque.ajouterMedia(magazine)
    bibliotheque.ajouterMedia(journal)
    bibliotheque.ajouterMedia(enregistrementAudio)
    bibliotheque.ajouterMedia(dvd)
    bibliotheque.ajouterMedia(livre)

    // Add the library to the list of libraries
    listeBibliotheque.add(bibliotheque)

    // Main loop to display the menu and handle user input
    do {
        afficherMenuPrincipal()
        tmp = inputIntValidator(readln())
        while (tmp == -1) {
            println("Choix invalide")
            tmp = inputIntValidator(readln())
        }
        when (tmp) {
            1 -> afficherListeBibliotheques(listeBibliotheque) // Display list of libraries
            2 -> {
                println("Entrez le nom de la bibliothèque")
                val nom = readln()
                listeBibliotheque.add(Bibliotheque(nom)) // Add a new library
            }
            3 -> {
                afficherListeBibliotheques(listeBibliotheque)
                println("Entrez le numéro de la bibliothèque")
                var choix = inputIntValidator(readln())
                while (choix == -1 || choix >= listeBibliotheque.size) {
                    println("Choix invalide")
                    choix = inputIntValidator(readln())
                }
                val bibliothequeChoisie = listeBibliotheque[choix]
                do {
                    afficherBibliothequeCommande()
                    tmp = inputIntValidator(readln())
                    while (tmp == -1) {
                        println("Choix invalide")
                        tmp = inputIntValidator(readln())
                    }
                    when (tmp) {
                        1 -> bibliothequeChoisie.afficherMedias() // Display media items
                        2 -> {
                            afficherAjouterMenu()
                            var ajoutChoix =  inputIntValidator(readln())
                            while (ajoutChoix == -1) {
                                println("Choix invalide")
                                ajoutChoix = inputIntValidator(readln())
                            }
                            when (ajoutChoix) {
                                1 -> {
                                    val livre = afficherAjoutLivre()
                                    bibliothequeChoisie.ajouterMedia(livre) // Add a book
                                }
                                2 -> {
                                    val dvd = afficherAjoutDVD()
                                    bibliothequeChoisie.ajouterMedia(dvd) // Add a DVD
                                }
                                3 -> {
                                    val enregistrementAudio = afficherAjouterEnregistrement()
                                    bibliothequeChoisie.ajouterMedia(enregistrementAudio) // Add an audio recording
                                }
                                4 -> {
                                    val journal = afficherAJoutJournal()
                                    bibliothequeChoisie.ajouterMedia(journal) // Add a journal
                                }
                                5 -> {
                                    val magazine = afficherAjoutMagazine()
                                    bibliothequeChoisie.ajouterMedia(magazine) // Add a magazine
                                }
                                9 -> tmp = 9 // Return to previous menu
                                0 -> tmp = 0 // Quit
                                else -> println("Choix invalide") // Invalid choice
                            }
                        }
                        3 -> {
                            bibliothequeChoisie.afficherMedias()
                            println("Entrez le numéro du média")
                            var choixMedia = inputIntValidator(readln())
                            while (choixMedia == -1 || choixMedia >= bibliothequeChoisie.medias.size) {
                                println("Choix invalide")
                                choixMedia = inputIntValidator(readln())
                            }
                            bibliothequeChoisie.emprunter(bibliothequeChoisie.medias[choixMedia]) // Borrow a media item
                        }
                        4 -> {
                            bibliothequeChoisie.afficherEmprunts()
                            println("Entrez le numéro du média")
                            var choixMedia = inputIntValidator(readln())
                            while (choixMedia == -1 || choixMedia >= bibliothequeChoisie.emprunts.size) {
                                println("Choix invalide")
                                choixMedia = inputIntValidator(readln())
                            }
                            bibliothequeChoisie.retourner(bibliothequeChoisie.emprunts[choixMedia]) // Return a media item
                        }
                        5 -> {
                            bibliothequeChoisie.afficherMedias()
                            println("Entrez le numéro du média")
                            var choixMedia = inputIntValidator(readln())
                            while (choixMedia == -1 || choixMedia >= bibliothequeChoisie.medias.size) {
                                println("Choix invalide")
                                choixMedia = inputIntValidator(readln())
                            }
                            bibliothequeChoisie.consulter(bibliothequeChoisie.medias[choixMedia]) // Consult a media item
                        }
                        6 -> bibliothequeChoisie.afficherEmprunts() // Display borrowed items
                        9 -> tmp = 9 // Return to main menu
                        0 -> tmp = 0 // Quit
                        else -> println("Choix invalide") // Invalid choice
                    }
                } while (tmp != 9 && tmp != 0)
            }
            4 -> {
                afficherListeBibliotheques(listeBibliotheque)
                println("Entrez le numéro de la bibliothèque")
                var choix = inputIntValidator(readln())
                while (choix == -1 || choix >= listeBibliotheque.size) {
                    println("Choix invalide")
                    choix = inputIntValidator(readln())
                }
                listeBibliotheque.removeAt(choix) // Remove a library
            }
            9 -> {
                // Demonstrate basic functionality
                val bibliothequeBase = Bibliotheque()
                val magazineBase = Magazine("National Geographic", "2024-10-28", "10")
                val journalBase = Journal("Le Monde", "2024-10-28")
                val enregistrementAudioBase = EnregistrementAudio("Beethoven - Symphonie No.9", 960, "Classical", "1967-01-01")
                val dvdBase = DVD("Inception", 8880, "Action", "2010-01-01") // 2h 28m
                val livreBase = Livre("1984", "George Orwell", "Gallimard", "1972-01-01")

                bibliothequeBase.ajouterMedia(magazineBase)
                bibliothequeBase.ajouterMedia(journalBase)
                bibliothequeBase.ajouterMedia(enregistrementAudioBase)
                bibliothequeBase.ajouterMedia(dvdBase)
                bibliothequeBase.ajouterMedia(livreBase)

                bibliothequeBase.emprunter(dvdBase)
                bibliothequeBase.emprunter(livreBase)

                bibliothequeBase.consulter(magazineBase)
                bibliothequeBase.consulter(journalBase)

                bibliothequeBase.emprunter(enregistrementAudioBase)

                bibliothequeBase.afficherEmprunts()

                bibliothequeBase.retourner(dvdBase)
                bibliothequeBase.retourner(livreBase)

                bibliothequeBase.afficherEmprunts()
            }
            0 -> tmp = 0 // Quit
            else -> println("Choix invalide") // Invalid choice
        }
    } while (tmp != 0)

    println("Au revoir!") // Goodbye message
}