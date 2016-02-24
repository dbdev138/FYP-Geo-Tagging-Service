package com.services

import org.scalatest.{FlatSpec, ShouldMatchers}

class GTRetrievalServiceSpec extends FlatSpec {
    
    val testAddress = "19 Moylaragh Park Balbriggan Co Dublin"
    val expectedLat = "53.6122488"
    val expectedLong = "-6.1976569"
    
    
    "Calling the Get Geo Tag function" should "return an object of type String" in {
        assert(GTRetrievalService.getGeoTag(testAddress).isInstanceOf[String])
    }
    it should "have a length greater or equal to 0" in {
        assert(GTRetrievalService.getGeoTag(testAddress).length >= 0)
    }
    it should "should return a valid JSON array" in {
        assert(GTRetrievalService.getGeoTag(testAddress).startsWith("{") && GTRetrievalService.getGeoTag(testAddress).endsWith("}"))
    }
    
    s"Given the address: $testAddress, the Get Geo Tag function" should s"return the coordinates lat $expectedLat, lng:-$expectedLong " in {
        assert(GTRetrievalService.getGeoTag(testAddress).contains(expectedLat) && GTRetrievalService.getGeoTag(testAddress).contains(expectedLong))
    }
    
}