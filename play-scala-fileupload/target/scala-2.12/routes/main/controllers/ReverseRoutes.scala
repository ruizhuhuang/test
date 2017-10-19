
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rhuang/Documents/Dropbox_1/TACC/PLAY/play-scala-fileupload/conf/routes
// @DATE:Mon Oct 16 18:18:47 CDT 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:12
  class ReverseScalaFileUploadController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def upload(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "upload")
    }
  
    // @LINE:12
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "upload")
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
