package com.spark

class GEventsTagLib {
   def postit = {attrs ->
      postitGreen(attrs)
   }
   
         def postitGreen(attrs)  { 
      out << '<div class="postit postitGreen">'   

      out << '  <div class="postitText">'
      out << '     <div class="postitDate">' 
      //out <<         '<g:formatDate format="MM/dd/yyyy" date='
      out <<            attrs.message.startDate.format("MM/dd/yyyy")
      //out <<          '/>'
      out << '     </div>'
      out << '     <div class="postitContent">' 
      out <<         attrs.message.location  
      out << '     </div>'
      out << '     <div class="postitText">' 
      out <<         attrs.message.name 
      out << '     </div>'

      out << '     <div class="postitSignature">' 

      out << '     </div>'
      out << '  </div>'
      out << '</div>'

   }


}
