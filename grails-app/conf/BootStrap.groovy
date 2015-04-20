import museetoulouse.InitialiserDonneesService
import museetoulouse.MuseeService

class BootStrap {

    InitialiserDonneesService initialiserDonneesService

    def init = { servletContext ->

               initialiserDonneesService.initialiserDonnees()

    }

    def destroy = {
    }
}
