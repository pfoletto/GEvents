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
     
      def user1 = new User(fullName:"Paolo Foletto", 
         username:"suntzu",
         password:"t0ps3cr3t",
         email:"paolo.foletto@gmail.com",
         website:"este.linux.it",
         bio:''' una personalità 
               di un certo peso'''
      )
      if (!user1.save()){
         user1.errors.allErrors.each{error ->
            println "An error occured with user1: ${error}"
         }
      }
   }
   def destroy = {
   }
}
