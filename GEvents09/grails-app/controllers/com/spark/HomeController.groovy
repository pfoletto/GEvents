package com.spark

class HomeController {

   def index() { 
      params.max = Math.min(params.max ? params.int('max') : 10, 100)
      [eventInstanceList: Event.currentEvents.list()]
   }
}
