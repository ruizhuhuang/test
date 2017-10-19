
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" href=""""),_display_(/*14.39*/routes/*14.45*/.Assets.versioned("stylesheets/style.css")),format.raw/*14.87*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.versioned("images/favicon.png")),format.raw/*15.104*/("""">
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.versioned("javascripts/main.js")),format.raw/*16.69*/("""" type="text/javascript"></script>
	    	<script src=""""),_display_(/*17.21*/routes/*17.27*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*17.75*/(""""></script>
	    <script src=""""),_display_(/*18.20*/routes/*18.26*/.Assets.versioned("javascripts/jstree.js")),format.raw/*18.68*/(""""></script>

	
    </head>
    <body>
        """),format.raw/*24.32*/("""
        """),_display_(/*25.10*/content),format.raw/*25.17*/("""


    """),format.raw/*28.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Oct 12 11:06:10 CDT 2017
                  SOURCE: /Users/rhuang/Documents/Dropbox_1/TACC/PLAY/play-scala-fileupload/app/views/main.scala.html
                  HASH: 235f1b7cc3d6e81a99db43249d10ca02ddb9f220
                  MATRIX: 987->260|1112->290|1140->292|1220->397|1256->406|1291->414|1317->419|1391->466|1406->472|1469->514|1557->575|1572->581|1633->620|1685->645|1700->651|1761->691|1843->746|1858->752|1927->800|1985->831|2000->837|2063->879|2137->1015|2174->1025|2202->1032|2236->1039
                  LINES: 26->7|31->7|33->9|36->12|37->13|37->13|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|42->18|47->24|48->25|48->25|51->28
                  -- GENERATED --
              */
          