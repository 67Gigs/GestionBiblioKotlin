package classes

import utils.dateValidator
import utils.jourManquant
import utils.moisManquant

abstract class Media(open var titre: String, dateParution: String) {
    var dateParution: String = ""
        set(value) {
            field = if (!dateValidator(value)) {
                throw IllegalArgumentException("La date de parution doit être au format YYYY-MM-DD.")
            } else {
                if (moisManquant(value)) {
                    "$value-01-01"
                } else if (jourManquant(value)) {
                    "$value-01"
                } else {
                    value
                }
            }
        }

    init {
        if (!dateValidator(dateParution)) {
            throw IllegalArgumentException("La date de parution doit être au format YYYY-MM-DD.")
        } else {
            this.dateParution = dateParution
        }
    }

    abstract fun afficher()
}