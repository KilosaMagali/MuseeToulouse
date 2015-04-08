package museetoulouse

class Musee {
    String nom
    String horaireOuverture
    String telephone
    String accesMetro
    String accesBus
    Adresse adresse
    Gestionnaire gestionnaire
    static hasMany = [demandesVisite : DemandeVisite]

    static constraints = {
        nom blank: false, nullable: false
        horaireOuverture blank: false, nullable: false
        adresse nullable: false
        telephone blank: false, nullable: true
        gestionnaire nullable: false
        accesMetro blank: true
        accesBus blank: true
    }
}
