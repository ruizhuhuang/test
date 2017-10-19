
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rhuang/Documents/Dropbox_1/TACC/PLAY/play-scala-fileupload/conf/routes
// @DATE:Mon Oct 16 18:18:47 CDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_1: controllers.HomeController,
  // @LINE:10
  Assets_2: controllers.Assets,
  // @LINE:12
  ScalaFileUploadController_0: controllers.ScalaFileUploadController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_1: controllers.HomeController,
    // @LINE:10
    Assets_2: controllers.Assets,
    // @LINE:12
    ScalaFileUploadController_0: controllers.ScalaFileUploadController
  ) = this(errorHandler, HomeController_1, Assets_2, ScalaFileUploadController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_2, ScalaFileUploadController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ScalaFileUploadController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ScalaFileUploadController.upload()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_ScalaFileUploadController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ScalaFileUploadController_index2_invoker = createInvoker(
    ScalaFileUploadController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScalaFileUploadController",
      "index",
      Nil,
      "GET",
      this.prefix + """upload""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ScalaFileUploadController_upload3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ScalaFileUploadController_upload3_invoker = createInvoker(
    ScalaFileUploadController_0.upload(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScalaFileUploadController",
      "upload",
      Nil,
      "POST",
      this.prefix + """upload""",
      """""",
      Seq("""nocsrf""")
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_ScalaFileUploadController_index2_route(params) =>
      call { 
        controllers_ScalaFileUploadController_index2_invoker.call(ScalaFileUploadController_0.index)
      }
  
    // @LINE:15
    case controllers_ScalaFileUploadController_upload3_route(params) =>
      call { 
        controllers_ScalaFileUploadController_upload3_invoker.call(ScalaFileUploadController_0.upload())
      }
  }
}
