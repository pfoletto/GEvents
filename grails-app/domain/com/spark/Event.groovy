package com.spark

class Event {
   String name
   String location
   String venue
   Date startDate
   Date endDate
   User organizer
   String description
   Date createdAt =new Date()
   static hasMany = [volunteers:User]
   //static searchable = true
   static searchable = {
      organizer component: true
      volunteers component: true
      }
    static constraints = {
       name(blank:false)
       location()
       venue()
       startDate()
       endDate()
       organizer()
       description(maxSize:1000)
    }
     
   
   static namedQueries = {
       currentEvents {
           def now = new Date()
           gt 'startDate', now 
        }
        upcomingEvents {
           def now = new Date()
           gt 'startDate', now
           lt 'startDate', now +120
           order("startDate")
        }
        newEvents {
           def now = new Date()
           gt 'startDate', now
           lt 'createdAt', now +15
           order("startDate")
        }
   }
   
   def String toString(){
      "$name, $location"
   } 
   
}
