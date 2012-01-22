/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spark

/**
 *
 * @author paolo
 */
class NewsMessage {
   final String TYPE_NEWS = "NEWS"
   final String TYPE_EVENT = "NEW_EVENT"
   final String TYPE_UPCOMING_EVENT = "UPCOMING_EVENT"
   final String TYPE_LINKED_EVENT = "LINKED_EVENT"

   String message
   String name
   String location
   Date startDate
   String baseUrl
   String type
	Event event
}

