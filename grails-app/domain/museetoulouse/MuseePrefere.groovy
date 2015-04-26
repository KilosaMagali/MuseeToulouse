package museetoulouse

class MuseePrefere {
        String idSession
        static hasMany = [museePreferes : Musee]
        static constraints = {
        }



}
