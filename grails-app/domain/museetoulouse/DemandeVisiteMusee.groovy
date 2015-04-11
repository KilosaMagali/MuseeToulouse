package museetoulouse

class DemandeVisiteMusee {
    Date dateDemandeVisite
    Musee musee;
    DemandeVisite demandeVisiste;
    static constraints = {
        dateDemandeVisite nullable: false
    }
}
