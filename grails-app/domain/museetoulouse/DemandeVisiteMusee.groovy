package museetoulouse

class DemandeVisiteMusee {
    Date dateDemandeVisite
    static belongsTo = [musee: Musee, demandeVisite: DemandeVisite]
    static constraints = {
        dateDemandeVisite nullable: false
    }
}
