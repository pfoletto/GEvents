package com.spark

class HomeController {

def index() { 
         params.max = Math.min(params.max ? params.int('max') : 10, 100)
         def msgList = []

         def events = Event.upcomingEvents.list()
         events.each(){
            def msg = new NewsMessage( name:it.name, 
            location:it.location,
            event:it,
            startDate: it.startDate,
            type: "UPCOMING_EVENT")
            msgList.add(msg)
         }
         events = Event.newEvents.list()
         events.each(){
            def msg = new NewsMessage( name:it.name, 
            location:it.location,
            event:it,
            startDate: it.startDate,
            type: "NEW_EVENT")
            msgList.add(msg)
         }   
        [eventInstanceList: msgList]
      }
}
