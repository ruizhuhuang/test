package controllers

import javax.inject._
import play.api._
import play.api.mvc._


import sys.process._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ZeppelinController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   * 
   */
  
  //private val test=scala.collection.mutable.ArrayBuffer("")
  
  def index() = Action { implicit request: Request[AnyContent] =>
    //val name:String =  "ruizhu"
    //println(test)
    Ok(views.html.zeppelin())
  }
  
  def startZeppelin = Action { implicit  request =>
    "/Users/rhuang/Documents/Dropbox_1/TACC/PLAY/start-zeppelin.sh".!    
    //Ok("http://localhost:8080/")
    //Ok("hello")
    Thread.sleep(8000) 
    println("Zeppelin is ready")
    //Ok("Got request [" + request + "]")
    Redirect("http://localhost:8080/");

    
   // "/Users/rhuang/Documents/Dropbox_1/TACC/PLAY/run_pi.sh".!
    //test.append("kkk")
    //Redirect(routes.HomeController.index()).flashing("info" -> "Widget added!")
    //Ok("ok")
    
  }
}
