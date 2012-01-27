package com.spark

class User extends SecUser{
   String fullName
   String email
   String website
   String bio
   static searchable = true


    static constraints = {

       //userName(unique:true) 
       fullName()
       email email:true, unique:true
       //password(nullable:true)
       website(nullable:true)
       bio(nullable:true, maxSize:1000)
    }
    def String toString(){
       username
    }
}
