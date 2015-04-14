package museetoulouse

class DemandeVisite {
    String code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    String statut
    static hasMany = [musees : DemandeVisiteMusee]


    static constraints = {
        statut inList: ["En cours de traitement","Confirmée", "Refusée"]
        nbPersonnes min: 1, max: 6
        dateDebutPeriode nullable: false
        dateFinPeriode nullable: false
        code blank: false, nullable: false
    }


}
