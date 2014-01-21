modules = {
    application {
        resource url:'js/application.js'

        dependsOn 'angular', 'angular-route', 'angular-cookies'

        resource url: 'js/app.js'

        //resource url: 'js/services/'

        //resource url: 'js/controllers/'

        //resource url: 'js/filters/'

        //resource url: 'js/directives/'
    }
}
