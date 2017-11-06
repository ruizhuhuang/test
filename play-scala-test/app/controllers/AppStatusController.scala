package controllers

import javax.inject.Inject

import models.Widget
import play.api.data._
import play.api.i18n._
import play.api.mvc._

import sys.process._
import scala.io.Source
import java.util.Date
import java.text.SimpleDateFormat

import org.htmlcleaner.HtmlCleaner
import java.net.URL
import java.net.URLDecoder




//@Singleton
class AppStatusController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  private val res = scala.collection.mutable.TreeMap[String,String]()(implicitly[Ordering[String]].reverse)
  
  
  
  def index() = Action { implicit request: Request[AnyContent] =>
    val apps = listApp()
    //val apps = Array("application_1509916447369_0003","application_1509916447369_0002","application_1509916447369_0001")
    for (app <- apps) {
      val url = getAppURL(getFirstNode(), app)
      //val url = getAppURL("wrangler.tacc.utexas.edu", app)
      println(app)
      println(url)
      res(app)=getTbody(url) 
    }
    Ok(views.html.appStatus(res))
  }
  
  // get first node name e.g c252-101 in the reservation
  def getFirstNode(resName:String="hadoop-test"):String = {
    val command = "tmp=`sinfo -T|grep "+ resName + " |awk '{print $6}'` && scontrol show hostname $tmp | head -n 1"
    Process(Seq("bash","-c", command)).!!.split("\n")(0)
  }
  
  // list jobs, return array of apps
  def listApp(status:String = "ALL") = {
    val command = "yarn application -list -appStates " + status + " | grep $USER | awk '{print $1}'"
    Process(Seq("bash","-c", command)).!!.split("\n")    
  }
  
  // get job status URL
  def getAppURL(firstNode:String = "c251-101", app:String = "application_1509916447369_0003"):String = {
    "http://" + firstNode + ":8088/cluster/app/" + app
       
  }
  
  // get job status table body
  def getTbody(url:String = "http://c251-101:8088/cluster/app/application_1509916447369_0003")= {
      val cleaner = new HtmlCleaner
      val props = cleaner.getProperties
      val rootNode = cleaner.clean(new URL(url))
      val test = rootNode.findElementByAttValue("class", "info", true, true)      
      cleaner.getInnerHtml(test)
  }
  
  
  
}


/**
 * The classic WidgetController using MessagesAbstractController.
 *
 * Instead of MessagesAbstractController, you can use the I18nSupport trait,
 * which provides implicits that create a Messages instances from
 * a request using implicit conversion.
 *
 * See https://www.playframework.com/documentation/2.6.x/ScalaForms#passing-messagesprovider-to-form-helpers
 * for details.
 */
//class AppStatusController @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
//  import WidgetForm._
//    
//
//  def index = Action {implicit request: Request[AnyContent] =>
//    
//    
//    Ok(views.html.appStatus())
//  }
//  
//  
//  def refresh = Action {implicit request: Request[AnyContent] =>
//    
//    Ok(views.html.appStatus())
//  }
//  
//  def getStatus(apps:Array[String]){
//    
//  }
//  def listApp(status:String = "ALL") = {
//    val command = "yarn application -list -appStates " + status + " | grep $USER | awk '{print $1}'"
//    Process(Seq("bash","-c", command)).!!.split("\n")    
//  }
//  
//  def TS2Date(ts:String)={val df = new SimpleDateFormat("yyyy-MM-dd H:m:s");df.format(ts.toLong)}
//
//  
//}