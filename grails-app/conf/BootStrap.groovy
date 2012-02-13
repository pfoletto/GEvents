import com.spark.*
//import org.yaml.snakeyaml.Yaml
import org.ho.yaml.Yaml

class BootStrap {
    def springSecurityService
    def init = { servletContext ->
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
 
        def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
            username: 'admin',
            password: 'admin',
            enabled: true).save(failOnError: true)
 
        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
 
        def user1 = User.findByUsername('suntzu') ?:new User(fullName:"Paolo Foletto", 
            username:"suntzu",
            password:"t0ps3cr3t",
            email:"paolo.foletto@gmail.com",
            website:"este.linux.it",
            bio:''' una personalità 
               di un certo peso'''
        )
        if (!user1.save(flush: true)){
            user1.errors.allErrors.each{error ->
                println "An error occured with user1: ${error}"
            }
        }
    
        def user2 =  User.findByUsername('expertuslucius') ?:new User(fullName:"Lucio Bruno", 
            username:"expertuslucius",
            password:"t0ps3cr3t",
            email:"expertuslucius@gmail.com",
            website:"este.linux.it",
            bio:''' la nuova leva del gruppo 
               che sviluppa in Arduino'''
        )
        if (!user2.save(flush: true)){
            user2.errors.allErrors.each{error ->
                println "An error occured with user2: ${error}"
            }
        }       
        def user3 = User.findByUsername('gregg') ?: new User(fullName:"Cristian Greggio", 
            username:"gregg",
            password:"t0ps3cr3t",
            email:"cristiangreggio@gmail.com",
            website:"este.linux.it",
            bio:''' lunga esperienza  
               nelle installazioni di Linunx'''
        )
        if (!user3.save(flush: true)){
            user3.errors.allErrors.each{error ->
                println "An error occured with user3: ${error}"
            }
        }
        def user4 = User.findByUsername('loviuz') ?:new User(fullName:"Fabio Lovato", 
            username:"loviuz",
            password:"t0ps3cr3t",
            email:"fabio@l-web.it",
            website:"este.linux.it",
            bio:''' grande esperto 
               di grafica, user interface e Blender'''
        )
        if (!user4.save(flush: true)){
            user4.errors.allErrors.each{error ->
                println "An error occured with user4: ${error}"
            }
        }
    

        def event1 = Event.findByName('Serata a tema Grails') ?:new Event (
            name:"Serata a tema Grails",
            location:"Este",
            venue:"IIS Euganeo",
            startDate: new Date('01/18/2012'),
            endDate: new Date('01/18/2012'),
            organizer: User.findByUsername("suntzu"),
            description: "Workshop Grails",
            directions: "Via Borgofuro, 6 - 35042 Este (PD)" )
      
        if (!event1.save(flush: true)){
            event1.errors.allErrors.each{error ->
                println "An error occured with event1: ${error}"
            }
        }
        event1.addToVolunteers(User.findByUsername("loviuz"))     
        event1.addToVolunteers(User.findByUsername("gregg"))     
        event1.addToVolunteers(User.findByUsername("expertuslucius"))     

        def event2 = Event.findByName('Serata a tema Arduino') ?:  new Event (
            name:"Serata a tema Arduino",
            location:"Este",
            venue:"IIS Euganeo",
            startDate: new Date('03/14/2012'),
            endDate: new Date('03/14/2012'),
            organizer: User.findByUsername("expertuslucius"),
            description: "Arduino" ,
            directions: "Via Borgofuro, 6 - 35042 Este (PD)")
      
        if (!event2.save(flush: true)){
            event2.errors.allErrors.each{error ->
                println "An error occured with event2: ${error}"
            }
        }
         
        def event3 = Event.findByName('Software Libero per PMI') ?:  new Event (
            name:"Software Libero per PMI",
            location:"Este",
            venue:"IIS Euganeo",
            startDate: new Date('05/19/2012'),
            endDate: new Date('05/19/2012'),
            organizer: User.findByUsername("gregg"),
            description: "Software libero per PMI",
            directions: "Via Borgofuro, 6 - 35042 Este (PD)" )
      
        if (!event3.save(flush: true)){
            event3.errors.allErrors.each{error ->
                println "An error occured with event3: ${error}"
            }
        }
         
        def event4 = Event.findByName('Serata a tema Blender') ?:  new Event (
            name:"Serata a tema Blender",
            location:"Este",
            venue:"IIS Euganeo",
            startDate: new Date('09/19/2012'),
            endDate: new Date('09/19/2012'),
            organizer: User.findByUsername("loviuz"),
            description: "Blender",
            directions: "Via Borgofuro, 6 - 35042 Este (PD)" )
        if (!event4.save(flush: true)){
            event4.errors.allErrors.each{error ->
                println "An error occured with event4: ${error}"
            }
        }
        def event5 = Event.findByName('Grails Workshop') ?:  new Event (
            name:"Grails Workshop",
            location:"Solesino",
            venue:"Studio di Giulio Toffoli",
            startDate: new Date('02/25/2012'),
            endDate: new Date('02/25/2012'),
            organizer: User.findByUsername("suntzu"),
            description: "Grails Workshop",
            directions: "Solesino (PD)" )
        if (!event5.save(flush: true)){
            event5.errors.allErrors.each{error ->
                println "An error occured with event5: ${error}"
            }
        }
        def event6 = Event.findByName('Serata a tema i progetti del gruppo') ?:  new Event (
            name:"Serata a tema i progetti del gruppo",
            location:"Este",
            venue:"Totem",
            startDate: new Date('02/16/2012'),
            endDate: new Date('02/16/2012'),
            organizer: User.findByUsername("suntzu"),
            description: "Grails Workshop",
            directions: "Casa delle Associazioni - Piazzale Ca' Pesaro, 1 - 35042 Este (PD)" )
        if (!event6.save(flush: true)){
            event6.errors.allErrors.each{error ->
                println "An error occured with event6: ${error}"
            }
        }
         
        user1.setEnabled(true)?.save(flush: true)     
        user2.setEnabled(true)?.save(flush: true)     
        user3.setEnabled(true)?.save(flush: true)     
        user4.setEnabled(true)?.save(flush: true)     
        SecUserSecRole.create user1, userRole
        SecUserSecRole.create user1, adminRole
        SecUserSecRole.create user2, userRole
        SecUserSecRole.create user3, userRole
        SecUserSecRole.create user4, userRole
    
        loadInitialContinent()
        loadInitialCountry()

    }
    void loadInitialContinent(){
        def numContinents = Continent.count() 
        if (numContinents.value != 7){
            Continent.executeUpdate("delete Continent c ")
            InputStream input = new FileInputStream(new File("resources/initialData/Continent.yml"));
            Yaml yaml = new Yaml();
            Object data = yaml.load(input);
            data.each{
                new Continent(
                    name:it.name).save()
            }  
        }
    }

    void loadInitialCountry(){
        def numCountries = Country.count() 
        if (numCountries.value != 87){
            Country.executeUpdate("delete Country c ")
            InputStream input = new FileInputStream(new File("resources/initialData/Country.yml"));
            Yaml yaml = new Yaml();
            Object data = yaml.load(input);
            data.each{
                println it.isoCode + it.continent
                def country = new Country(isoCode: it.isoCode, 
                    languageIsoCode: it.languageIsoCode,
                    languageVariant: it.languageVariant, 
                    localName: it.localName,
                    englishName: it.englishName,
                    continent:Continent.findByName(it.continent))
                if (!country.save(flush: true)){
                    country.errors.allErrors.each{error ->
                        println "An error occured with country: ${error}"
                    }
                }
            }
        }  
 
        //        new Country(name: "", continent:Continent.findByName("North America")).save();
    }
    
    def destroy = {
    }
}

