package museetoulouse

import grails.transaction.Transactional

@Transactional
class InitialiserDonneesService {

    def initialiserDonnees(){
        Adresse adresse0=new Adresse(numero: "2",rue: "Rue des archives", codePostal: "31500",ville: "TOULOUSE")
        Adresse adresse1=new Adresse(numero: "5",rue: "Rue Saint Pantaleon",codePostal: "31000",ville: "TOULOUSE")
        Adresse adresse2=new Adresse(numero: "69",rue: "Rue Pargaminieres",codePostal: "31000",ville: "TOULOUSE")
        Adresse adresse3=new Adresse(numero: "31",rue: "Rue de la fonderie",codePostal: "31000",ville: "TOULOUSE")
        Adresse adresse4=new Adresse(numero: "5",rue: "Rue Montmorency",codePostal: "31200",ville: "TOULOUSE")
        Adresse adresse5=new Adresse(numero: "2",rue: "Rue Viguerie",codePostal: "31300",ville: "TOULOUSE")
        Adresse adresse6=new Adresse(numero: "21",rue: "Rue de Metz",codePostal: "31000",ville: "TOULOUSE")
        Adresse adresse7=new Adresse(numero: "2",rue: "Rue Tripiere",codePostal: "31000",ville: "TOULOUSE")
        Adresse adresse8=new Adresse(numero: "7",rue: "Rue du May",codePostal: "31000",ville: "TOULOUSE")
        Adresse adresse9=new Adresse(numero: "5",rue:"Rue du Japon",codePostal: "31400",ville:  "TOULOUSE")
        Adresse adresse10=new Adresse(numero: "13",rue: "Rue de la peau",codePostal: "31000",ville: "TOULOUSE")

        adresse0.save(failOnError: true)
        adresse1.save(failOnError: true)
        adresse2.save(failOnError: true)
        adresse3.save(failOnError: true)
        adresse4.save(failOnError: true)
        adresse5.save(failOnError: true)
        adresse6.save(failOnError: true)
        adresse7.save(failOnError: true)
        adresse8.save(failOnError: true)
        adresse9.save(failOnError: true)
        adresse10.save(failOnError: true)

        Gestionnaire mairie=new Gestionnaire(nom: "Mairie de TOULOUSE - DGA Culture")
        Gestionnaire association=new Gestionnaire(nom: "Association")
        Gestionnaire institution=new Gestionnaire(nom: "Autre institution publique")
        Gestionnaire structure=new Gestionnaire(nom: "Structure commerciale")

        mairie.save(failOnError: true)
        association.save(failOnError: true)
        institution.save(failOnError: true)
        structure.save(failOnError: true)

        Musee musee0=new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE",horaireOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",telephone: "05 61 61 63 33",accesMetro: "Roseraie (A)",accesBus: "36, 38",gestionnaire: mairie,adresse: adresse0)
        Musee musee1=new Musee(nom: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE",horaireOuverture: "Ouvert du mardi au samedi de 13h à 19hfermé les dimanches, jours fériés et du 1er au 15 août",telephone: "05 61 23 30 49",accesMetro: "Capitole (A), Jean Jaurès (B)",accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80",gestionnaire:association,adresse: adresse1)
        Musee musee2=new Musee(nom: "ENSEMBLE CONVENTUEL DES JACOBINS",horaireOuverture: "Ouvert tous les jours de 9h à 19h.",telephone: "05 61 22 21 92", accesMetro: "Esquirol, Capitole (A)",accesBus: "NCV, 2, 10, 12, 14, 38, 78, 80",gestionnaire:mairie,adresse: adresse2)
        Musee musee3=new Musee(nom: "INSTITUT CATHOLIQUE DE TOULOUSE - ESPACE MUSEOGRAPHIQUE BACCRABERE -",horaireOuverture:"Ouvert le premier vendredi de chaque mois de 18h à 20h.",telephone: "05 61 36 81 12",accesMetro:"Carmes (B)",accesBus: "2, 38",gestionnaire: institution,adresse: adresse3)
        Musee musee4=new Musee(nom: "L'AEROTHEQUE",horaireOuverture: "Ouvert le lundi et le mercredi de 14h à 17h et le mardi de 9h à 12h",telephone:"05 61 93 93 57",accesMetro: "",accesBus: "15",gestionnaire: structure,adresse: adresse4)
        Musee musee5=new Musee(nom: "MUSEE DE L'HISTOIRE DE LA MEDECINE DE TOULOUSE",horaireOuverture: "Ouvert tous les jeudi et vendredi de 11h à 17h, et le dimande de 10h à 18h.Visites guidées sur demande.",telephone: "05 61 77 84 25",accesMetro: "Saint-Cyprien-République, Esquirol (A)",accesBus: "2, 10, 12, 14, 78, 80",gestionnaire: association,adresse: adresse5)
        Musee musee6=new Musee(nom: "MUSEE DES AUGUSTINS - MUSEE DES BEAUX ARTS DE TOULOUSE",horaireOuverture: "Tous les jours : 10h - 18h /  nocturne le mercredi jusqu'à 21h.",telephone: "05 61 22 21 82",accesMetro:"Esquirol (A) ou Carmes (B)",accesBus: "ncv, 2, 10, 14, 38, 78, 80",gestionnaire: mairie,adresse: adresse6)
        Musee musee7=new Musee(nom: "MUSEE DES COMPAGNONS",horaireOuverture: "Le Mercredi et le 1er dimanche de chaque mois de 14h à 17h",telephone: "05 62 47 41 77",accesMetro: "Esquirol, Capitole (A)",accesBus: "2, 10, 12, 14, 38, 78, 80",gestionnaire: association,adresse: adresse7)
        Musee musee8=new Musee(nom: "MUSEE DES INSTRUMENTS DE MEDECINE DES HOPITAUX DE TOULOUSE",horaireOuverture: "Ouvert tous les jeudi et vendredi de 13h à 17h. Ouvert le premier dimanche du mois.Visites guidées sur demande.",telephone: "05 61 77 82 72",accesMetro: "Saint-Cyprien-République, Esquirol (A)",accesBus: "2, 10, 12, 14, 78, 80",gestionnaire: structure,adresse: adresse5)
        Musee musee9=new Musee(nom: "MUSEE DU VIEUX TOULOUSE",horaireOuverture: "Ouvert tous les jours du 2 mai au 31 octobre de 14h00 à 18h00.Fermé le dimanche et jours fériés.",telephone: "05 62 27 11 50",accesMetro: "Esquirol, Capitole (A)",accesBus: "2, 10, 12, 14, 38, 78, 80",gestionnaire: association,adresse: adresse8)
        Musee musee10=new Musee(nom: "MUSEE GEORGES-LABIT",horaireOuverture:"Musée ouvert de 10h à 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermeture hebdomadaire le mardi.Bibliothèque ouverte le lundi de 14h à 17h, le mardi et le mercredi : 9h-12h et 14h-17h.",telephone: "05 61 14 65 50",accesMetro: "François Verdier (B)",accesBus: "10, 2, 27",gestionnaire: mairie,adresse: adresse9)
        Musee musee11=new Musee(nom: "MUSEE PAUL-DUPUY - ARTS GRAPHIQUES ET ARTS DECORATIFS",horaireOuverture: "Ouvert de 10h - 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermé le mardi et jours fériés.",telephone: "05 61 14 65 50",accesMetro: "Esquirol (A) Carmes (B)",accesBus: "ncv, 2, 12, 52",gestionnaire: mairie,adresse: adresse10)

        musee0.save(failOnError: true)
        musee1.save(failOnError: true)
        musee2.save(failOnError: true)
        musee3.save(failOnError: true)
        musee4.save(failOnError: true)
        musee5.save(failOnError: true)
        musee6.save(failOnError: true)
        musee7.save(failOnError: true)
        musee8.save(failOnError: true)
        musee9.save(failOnError: true)
        musee10.save(failOnError: true)
        musee11.save(failOnError: true)
    }

}
