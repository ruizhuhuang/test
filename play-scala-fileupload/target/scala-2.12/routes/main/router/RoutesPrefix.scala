
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rhuang/Documents/Dropbox_1/TACC/PLAY/play-scala-fileupload/conf/routes
// @DATE:Mon Oct 16 18:18:47 CDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
