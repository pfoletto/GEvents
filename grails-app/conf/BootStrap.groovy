import com.spark.*
class BootStrap {

    def init = { servletContext ->
       def user1 = new User(fullName:"Paolo Foletto", 
       userName:"suntzu",
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
    
    def user2 = new User(fullName:"Lucio Bruno", 
       userName:"expertuslucius",
       password:"t0ps3cr3t",
       email:"expertuslucius@gmail.com",
       website:"este.linux.it",
       bio:''' la nuova leva del gruppo 
               che sviluppa in Arduino'''
    )
    if (!user2.save()){
      user2.errors.allErrors.each{error ->
         println "An error occured with user2: ${error}"
         }
    }       
    def user3 = new User(fullName:"Cristian Greggio", 
       userName:"gregg",
       password:"t0ps3cr3t",
       email:"cristiangreggio@gmail.com",
       website:"este.linux.it",
       bio:''' lunga esperienza  
               nelle installazioni di Linunx'''
    )
    if (!user3.save()){
      user3.errors.allErrors.each{error ->
         println "An error occured with user3: ${error}"
         }
    }
    def user4 = new User(fullName:"Fabio Lovato", 
       userName:"loviuz",
       password:"t0ps3cr3t",
       email:"fabio@l-web.it",
       website:"este.linux.it",
       bio:''' grande esperto 
               di grafica, user interface e Blender'''
    )
    if (!user4.save()){
      user4.errors.allErrors.each{error ->
         println "An error occured with user4: ${error}"
         }
    }
    

    def event1 =   new Event (
         name:"Serata a tema Grails",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('01/18/2012'),
         endDate: new Date('01/18/2012'),
         organizer: User.findByUserName("suntzu"),
         description: "Workshop Grails" )
      
         if (!event1.save()){
            event1.errors.allErrors.each{error ->
               println "An error occured with event1: ${error}"
            }
         }
     event1.addToVolunteers(User.findByUserName("loviuz"))     
     event1.addToVolunteers(User.findByUserName("gregg"))     
     event1.addToVolunteers(User.findByUserName("expertuslucius"))     

     def event2 =   new Event (
         name:"Serata a tema Arduino",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('03/14/2012'),
         endDate: new Date('03/14/2012'),
         organizer: User.findByUserName("expertuslucius"),
         description: "Arduino" )
      
         if (!event2.save()){
            event1.errors.allErrors.each{error ->
               println "An error occured with event2: ${error}"
            }
         }
         
           def event3 =   new Event (
         name:"Serata a tema Software libero per PMI",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('05/19/2012'),
         endDate: new Date('05/19/2012'),
         organizer: User.findByUserName("gregg"),
         description: "Software libero per PMI" )
      
         if (!event3.save()){
            event1.errors.allErrors.each{error ->
               println "An error occured with event3: ${error}"
            }
         }
         
      def event4 =   new Event (
         name:"Serata a tema Blender",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('09/19/2012'),
         endDate: new Date('09/19/2012'),
         organizer: User.findByUserName("loviuz"),
         description: "Blender" )
         if (!event4.save()){
            event1.errors.allErrors.each{error ->
               println "An error occured with event4: ${error}"
            }
         }
         
    }
    def destroy = {
    }
}
