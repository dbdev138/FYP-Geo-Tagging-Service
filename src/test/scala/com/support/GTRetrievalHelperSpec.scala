package com.support

import org.scalatest.{FlatSpec, ShouldMatchers}
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import com.services.GTRetrievalService

class GTRetrievalHelperSpec extends FlatSpec {
    
    implicit val formats = DefaultFormats
    
    val jsonString = """{
	"results": [{
		"address_components": [{
			"long_name": "19",
			"short_name": "19",
			"types": ["street_number"]
		}, {
			"long_name": "Moylaragh Park",
			"short_name": "Moylaragh Park",
			"types": ["route"]
		}, {
			"long_name": "Balbriggan",
			"short_name": "Balbriggan",
			"types": ["locality", "political"]
		}, {
			"long_name": "Fingal",
			"short_name": "Fingal",
			"types": ["administrative_area_level_2", "political"]
		}, {
			"long_name": "Dublin",
			"short_name": "Dublin",
			"types": ["administrative_area_level_1", "political"]
		}, {
			"long_name": "Ireland",
			"short_name": "IE",
			"types": ["country", "political"]
		}],
		"formatted_address": "19 Moylaragh Park, Balbriggan, Co. Dublin, Ireland",
		"geometry": {
			"location": {
				"lat": 53.6122488,
				"lng": -6.1976569
			},
			"location_type": "ROOFTOP",
			"viewport": {
				"northeast": {
					"lat": 53.61359778029149,
					"lng": -6.196307919708498
				},
				"southwest": {
					"lat": 53.6108998197085,
					"lng": -6.199005880291502
				}
			}
		},
		"place_id": "ChIJbzR4ptsiZ0gR5xoMOChVnoA",
		"types": ["street_address"]
	}],
	"status": "OK"
}"""

    val json = parse(jsonString)
    
    val expectedLat = "53.6122488"
    val expectedLong = "-6.1976569"
    val apiEndpoint = "https://maps.googleapis.com/maps/api/geocode/json?address="
    val apiKey = "&key=AIzaSyCW6S4V0IgkgoXwsgZUtdTTNRzM2zPqe9E"
    val sampleAddress = "19 Moylaragh Park Balbriggan Co Dublin"
    val formattedAddress = sampleAddress.replace(" ", "+")
    val expectedUrl = apiEndpoint + formattedAddress + apiKey
    

    "Calling the Get Latitude function with the sample Google GeoCoding response" should s"return the value $expectedLat" in {
        assert(GTRetrievalHelper.getLatitude(json) == expectedLat)
    }
    
    
    "Calling the Get Longitude function with the sample Google GeoCoding response" should s"return the value $expectedLong" in {
        assert(GTRetrievalHelper.getLongitude(json) == expectedLong)
    }
    
    s"Calling the URL Constructor function with the sample address: $sampleAddress" should s"return the teh valid url: $expectedUrl" in {
        assert(GTRetrievalHelper.urlConstructor(sampleAddress) == expectedUrl)
    }
    
}


















