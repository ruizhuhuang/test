
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rhuang/Documents/Dropbox_1/TACC/PLAY/play-scala-fileupload/conf/routes
// @DATE:Mon Oct 16 18:18:47 CDT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseScalaFileUploadController ScalaFileUploadController = new controllers.ReverseScalaFileUploadController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseScalaFileUploadController ScalaFileUploadController = new controllers.javascript.ReverseScalaFileUploadController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
