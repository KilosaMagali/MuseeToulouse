package museetoulouse

class Musee {
    String nom
    String horaireOuverture
    String telephone
    String accesMetro
    String accesBus
    Adresse adresse
    Gestionnaire gestionnaire
    static hasMany = [demandesVisite : DemandeVisiteMusee]

    static constraints = {
        nom blank: false, nullable: false
        horaireOuverture blank: false, nullable: false
        telephone blank: false, nullable: false
        accesMetro blank: false, nullable: true
        accesBus  blank: false, nullable: true
    }
}
