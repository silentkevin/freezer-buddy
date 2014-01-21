class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/freezer"(resources: "freezer") {
            "/containedItem"(resources: "containedItem")
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
