package com.spark

class User {
	String fullName
   String username
   String email
   String password
   String website
   String bio
   static constraints = {
      username(unique:true) 
      fullName()
      email email:true, unique:true
      password(nullable:true)
      website(nullable:true)
      bio(nullable:true, maxSize:1000)
   }
   
   def String toString(){
      username
   }
}
