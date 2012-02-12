package com.spark

class GEventsTagLib {
   
   def postit = {attrs ->
      if (attrs.message.type == "UPCOMING_EVENT")
         postitColor(attrs, 'postitGreen',"")
      if (attrs.message.type == "NEW_EVENT")
         postitColor(attrs, 'postitYellow', message( code:"default.newevent.label") )
   }
   
         def postitColor(attrs, color, postitNew)  { 
      out << '<div class="postit '+color+' ">'
      out << '  <div class="postitText">'
      out << '     <div class="postitDate">' 
      //out <<         '<g:formatDate format="MM/dd/yyyy" date='
      out <<            attrs.message.startDate.format("MM/dd/yyyy")
      //out <<          '/>'
            if ( postitNew ){
      out << '<span class="postitNew"> '
      out << postitNew
      out << '</span>'
      }
      out << '     </div>'
         
      out << '     <div class="postitContent">' 
      out <<         attrs.message.name 
      out << '     </div>'
      out << '     <div class="postitLocation">' 
      out <<         attrs.message.location 
      out << '     </div>'

      out << '     <div class="postitSignature">' 

      out << '     </div>'
      out << '  </div>'
      out << '</div>'

   }

def customDatePicker = {attrs, body ->        
def unstyled = g.datePicker(attrs, body)        
def sizes = [day: 2, month: 2, year:2]        
def styled = unstyled.replaceAll('name="\\S+_(day|month|year)"') { match, timeUnit -> 
println match           
"${match} class=\"span${sizes[timeUnit]}\""
  }       
out << styled    
}
}
