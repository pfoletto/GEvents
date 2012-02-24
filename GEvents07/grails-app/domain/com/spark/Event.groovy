package com.spark

class Event {
   String name
   String location
   String venue
   Date startDate
   Date endDate
   User organizer
   String description
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
   
   def String toString(){
      "$name, $location"
   }
}
