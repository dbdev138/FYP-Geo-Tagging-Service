package com.support

import java.util.Calendar

object LoggingSupport {
    
    //Helper method for logging 
	def serviceRequestlog1(requestedService: String, queryParamaeter: String) : Unit = {
	    val timeStamp = Calendar.getInstance.getTime
	    println("[ SERVICE REQUEST LOG ] -----------------------------")
	    println(s"--> Request for service: [ $requestedService ] received ")
	    println(s"--> At $timeStamp")
	    println(s"--> With query parameter: $queryParamaeter")
	    println(s"--> Query parameter is an instance of String = ${queryParamaeter.isInstanceOf[String]}")
	}
    
}

