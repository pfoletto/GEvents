package com.spark

class Event {
   String name
   String location
   String venue
   Date startDate
   Date endDate
   String organizer
   String description
   static constraints = {
      name(blank:false)
      location()
      venue()
      startDate()
      endDate()
      organizer()
      description(maxSize:1000)
   }
}
