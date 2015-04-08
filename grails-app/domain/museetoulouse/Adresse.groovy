package museetoulouse

class Adresse {
    String numero
    String rue
    String codePostal
    String ville
    static constraints = {
        numero blank: false, nullable: false
        rue blank: false
        codePostal blank: false, nullable: false
        ville blank: false, nullable: false
    }
}
