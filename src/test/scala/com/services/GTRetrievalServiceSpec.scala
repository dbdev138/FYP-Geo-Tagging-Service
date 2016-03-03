package com.services

import org.scalatest.{FlatSpec, ShouldMatchers}

class GTRetrievalServiceSpec extends FlatSpec {
    
    val testAddress = "19 Moylaragh Park Balbriggan Co Dublin"
    val expectedLat = "53.6122488"
    val expectedLong = "-6.1976569"
    
    
    "Calling the Get Geo Tags (Lat & Lng) function" should "return an object of type String" in {
        assert(GTRetrievalService.getGeoTags_single(testAddress).isInstanceOf[String])
    }
    it should "have a length greater or equal to 0" in {
        assert(GTRetrievalService.getGeoTags_single(testAddress).length >= 0)
    }
    it should "should return a valid JSON array" in {
        assert(GTRetrievalService.getGeoTags_single(testAddress).startsWith("[") && GTRetrievalService.getGeoTags_single(testAddress).endsWith("]"))
    }
    
    s"Given the address: $testAddress, the Get Geo Tag (Lat & Lng) function" should s"return the coordinates lat $expectedLat, lng:-$expectedLong " in {
        assert(GTRetrievalService.getGeoTags_single(testAddress).contains(expectedLat) && GTRetrievalService.getGeoTags_single(testAddress).contains(expectedLong))
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    "Calling the Get Geo Tags (Lat) function" should "return an object of type String" in {
        assert(GTRetrievalService.getGeoLats_single(testAddress).isInstanceOf[String])
    }
    it should "have a length greater or equal to 0" in {
        assert(GTRetrievalService.getGeoLats_single(testAddress).length >= 0)
    }
    
    s"Given the address: $testAddress, the Get Geo Tag (Lat) function" should s"return the coordinates lat $expectedLat" in {
        assert(GTRetrievalService.getGeoLats_single(testAddress).contains(expectedLat))
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    "Calling the Get Geo Tags (Lng) function" should "return an object of type String" in {
        assert(GTRetrievalService.getGeoLngs_single(testAddress).isInstanceOf[String])
    }
    it should "have a length greater or equal to 0" in {
        assert(GTRetrievalService.getGeoLngs_single(testAddress).length >= 0)
    }
    
    s"Given the address: $testAddress, the Get Geo Tag (Lng) function" should s"return the coordinates lng:-$expectedLong " in {
        assert(GTRetrievalService.getGeoLngs_single(testAddress).contains(expectedLong))
    }
    
}































