package museetoulouse

class DemandeVisite {
    int code
    Date dateDebut
    Date dateFin
    int nombreVisiteurs
    String statut

    static constraints = {
        statut blank: false
        nombreVisiteurs min: 1, max: 6
    }
}
