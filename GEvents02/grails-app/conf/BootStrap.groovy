import com.spark.*
class BootStrap {

    def init = { servletContext ->
       new Event (
         name:"Serata a tema Grails",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date(),
         endDate: new Date(),
         organizer:" Paolo Foletto",
         description: "Workshop Grails" ).save()
    }
    def destroy = {
    }
}
