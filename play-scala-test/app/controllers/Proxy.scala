package controllers

import javax.inject.Inject
import play.api.mvc._
import play.api.libs.ws._
import play.api.libs.concurrent.Execution.Implicits._

import org.htmlcleaner.HtmlCleaner
import java.net.URL

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class Proxy @Inject() (ws: WSClient) extends Controller {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   * 
   */
  
    def index(url: String) = Action.async {
      
      
      val cleaner = new HtmlCleaner
      val props = cleaner.getProperties
      val rootNode = cleaner.clean(new URL(url))
//      val test = (rootNode.findElementByAttValue("id", "apps", true, true).
//                  findElementByAttValue("type", "text/javascript", true, true))
//                  
      val test = rootNode.findElementByAttValue("class", "info", true, true)      
      
      //val elements = rootNode.getElementsByName("a", true)
      println(cleaner.getInnerHtml(test))
      
      ws.url(url).get().map(resp => Ok(resp.body).as("text/html"))
      
      
      
      

      
    }
  
  
  

}
