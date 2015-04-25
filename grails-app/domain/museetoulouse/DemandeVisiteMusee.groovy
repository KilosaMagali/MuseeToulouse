package museetoulouse

class DemandeVisiteMusee {
    Date dateDemandeVisite
    static belongsTo = [musee: Musee, demandeVisite: DemandeVisite]

    static constraints = {
        dateDemandeVisite nullable: false
    }
    static mapping = {
        musee fetch: "join"
        demandeVisite fetch: "join"
    }
    String toString() {
        "$dateDemandeVisite $musee $demandeVisite"
    }


}
