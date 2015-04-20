class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
       // "/" ( controller:'musee', action:'index' ) // Personnaliser Index page
        "500"(view:'/error')
	}
}
