package com.spark

class User {
   String fullName
   String userName
   String email
   String password
   String website
   String bio
   static searchable = true


    static constraints = {

       userName(unique:true) 
       fullName()
       email email:true, unique:true
       password(nullable:true)
       website(nullable:true)
       bio(nullable:true)
    }
    def String toString(){
       userName
    }
}
