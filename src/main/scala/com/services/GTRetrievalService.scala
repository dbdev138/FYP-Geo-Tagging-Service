package com.services

import com.support.LoggingSupport
import com.support.GTRetrievalHelper

import java.io.{IOException}
import scala.io.{Source}
import java.net.{URL, HttpURLConnection, SocketTimeoutException}

import net.liftweb.json._
import net.liftweb.json.Serialization.write
import java.util.Calendar
import net.liftweb.json.JsonDSL._

object GTRetrievalService {
    
    implicit val formats = DefaultFormats
    
    case class GeoCords(lat: String, lng: String)
    case class GeoLats(lat: String)
    case class GeoLngs(lng: String)
    
    
        def getGeoTags_single(address: String, connectTimeout: Int = 4000, readTimeout: Int = 4000, requestMethod: String = "GET") : String = {
            LoggingSupport.serviceRequestlog1("Geo Tagging Service", address)
            
            val url = GTRetrievalHelper.urlConstructor(address)
            
            val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
            println(connection)
            connection.setConnectTimeout(connectTimeout)
            connection.setReadTimeout(readTimeout)
            connection.setRequestMethod(requestMethod)
            
            
            val inputStream = connection.getInputStream
            //here parse the connction.InputStream to JSON
            val content = io.Source.fromInputStream(inputStream).mkString

            if (inputStream != null) inputStream.close
            
            val json = parse(content)
            
            //Parse out latude
            val lat = GTRetrievalHelper.getLatitude(json)
            //Parse out long
            val lng = GTRetrievalHelper.getLongitude(json)
            //Convert to a GeoCords Object
            val geoCords = List[GeoCords](GeoCords(s"$lat",s"$lng"))
            //Convert back to json before return
            val jsonString = write(geoCords)
            
            return jsonString
        }
        
        def getGeoLats_single(address: String, connectTimeout: Int = 4000, readTimeout: Int = 4000, requestMethod: String = "GET") : String = {
            LoggingSupport.serviceRequestlog1("Geo Tagging Service", address)
            
            val url = GTRetrievalHelper.urlConstructor(address)
            
            val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
            println(connection)
            connection.setConnectTimeout(connectTimeout)
            connection.setReadTimeout(readTimeout)
            connection.setRequestMethod(requestMethod)
            
            
            val inputStream = connection.getInputStream
            //here parse the connction.InputStream to JSON
            val content = io.Source.fromInputStream(inputStream).mkString

            if (inputStream != null) inputStream.close
            
            val json = parse(content)
            
            // //Parse out latude
            // val lat = GTRetrievalHelper.getLatitude(json)
            // val geoLats = GeoLats(lat)
            // //Convert back to json before return
            // val jsonString = write(geoLats)
            
            //Parse out lngitude
            val lat = GTRetrievalHelper.getLatitude(json)
            //Convert back to json before return
            val jsonString = write(lat)
            
            return jsonString
        }
        
        def getGeoLngs_single(address: String, connectTimeout: Int = 4000, readTimeout: Int = 4000, requestMethod: String = "GET") : String = {
            LoggingSupport.serviceRequestlog1("Geo Tagging Service", address)
            
            val url = GTRetrievalHelper.urlConstructor(address)
            
            val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
            println(connection)
            connection.setConnectTimeout(connectTimeout)
            connection.setReadTimeout(readTimeout)
            connection.setRequestMethod(requestMethod)
            
            
            val inputStream = connection.getInputStream
            //here parse the connction.InputStream to JSON
            val content = io.Source.fromInputStream(inputStream).mkString

            if (inputStream != null) inputStream.close
            
            val json = parse(content)
            
            // //Parse out lngitude
            // val lng = GTRetrievalHelper.getLongitude(json)
            // val geoLngs = GeoLngs(lng)
            // //Convert back to json before return
            // val jsonString = write(geoLngs)
            
            //Parse out lngitude
            val lng = GTRetrievalHelper.getLongitude(json)
            //Convert back to json before return
            val jsonString = write(lng)
            
            return jsonString
        }
        
    
}