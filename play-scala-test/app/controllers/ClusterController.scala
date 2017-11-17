package controllers

import javax.inject.Inject

import models.Widget
import play.api.data._
import play.api.i18n._
import play.api.mvc._

import sys.process._
import scala.io.Source

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
class ClusterController @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
  import WidgetForm._
  

  private val widgets = scala.collection.mutable.ArrayBuffer[Widget]()
  private val res = scala.collection.mutable.ArrayBuffer[String]()
  
  private var msg = ""
  

  // The URL to the widget.  You can call this directly from the template, but it
  // can be more convenient to leave the template commpletely stateless i.e. all
  // of the "WidgetController" references are inside the .scala file.
  private val postUrl = routes.ApplicationController.createWidget()  
  

  //def index = Action {
  //  Ok(views.html.index())
  //}

  def listWidgets = Action { implicit request: MessagesRequest[AnyContent] =>
    // Pass an unpopulated form to the template
    
    
    Ok(views.html.application(widgets, form, postUrl, res, msg))
  }

  // This will be the action that handles our form post
  def createWidget = Action { implicit request: MessagesRequest[AnyContent] =>
    val errorFunction = { formWithErrors: Form[Data] =>
      // This is the bad case, where the form had validation errors.
      // Let's show the user the form again, with the errors highlighted.
      // Note how we pass the form with errors to the template.
      BadRequest(views.html.application(widgets, formWithErrors, postUrl, res, msg))
    }

    val successFunction = { data: Data =>
      // This is the good case, where the form was successfully parsed as a Data.
      
      val button_value = request.body.asFormUrlEncoded.get("action")(0)
      
      println(button_value)
      
      if ("run".equals(button_value)) {     
      
        val widget = Widget(input_dir = data.input, output_dir = data.output)     
        
        (data.input  + " " + data.output).!
        
        val filename = data.output
        val fileContents = Source.fromFile(filename).getLines.mkString
        // println(fileContents)
        res.append(fileContents)
        
        
        
        widgets.append(widget)
        Redirect(routes.ApplicationController.listWidgets()).flashing("info" -> "Result added!")
      } else if("clean".equals(button_value)) {
        widgets.clear
        res.clear
        msg = data.firstname
        Redirect(routes.ApplicationController.listWidgets()).flashing("info" -> "Result cleaned!")
      } else{
        BadRequest("This action is not allowed");
      }
    }

    val formValidationResult = form.bindFromRequest
    formValidationResult.fold(errorFunction, successFunction)
  }

}