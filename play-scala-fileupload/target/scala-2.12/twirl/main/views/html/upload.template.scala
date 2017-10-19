
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

object upload extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(treeString: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.22*/("""

"""),_display_(/*3.2*/main("File Upload")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
	"""),format.raw/*4.2*/("""<h1>File Upload</h1>
  	"""),_display_(/*5.5*/helper/*5.11*/.form(action = routes.ScalaFileUploadController.upload, 'enctype -> "multipart/form-data")/*5.101*/ {_display_(Seq[Any](format.raw/*5.103*/("""
    
    """),format.raw/*7.5*/("""<p>
    	<input type="file" name="picture" value="picture">
    </p>
    
    <p>
    	<button type="button" value="directory" onclick="openTree("""),_display_(/*12.65*/treeString),format.raw/*12.75*/(""")">Choose a directory</button>
    	<input name="dir" id="directory" type="text" value="Enter a directory">
    	<div id="container"></div>
    </p>
    
    <p>
    	<button type="submit">Upload</button>
    </p>
    
    <script>
    function openTree(jsonString) """),format.raw/*22.35*/("""{"""),format.raw/*22.36*/("""

    	"""),format.raw/*24.6*/("""$('#container').jstree("""),format.raw/*24.29*/("""{"""),format.raw/*24.30*/("""
	    	"""),format.raw/*25.7*/("""'core' : """),format.raw/*25.16*/("""{"""),format.raw/*25.17*/("""
	        	"""),format.raw/*26.11*/("""'data' : jsonString
	        """),format.raw/*27.10*/("""}"""),format.raw/*27.11*/("""
		"""),format.raw/*28.3*/("""}"""),format.raw/*28.4*/(""");
    
		$('#container')
	  		// listen for event
	  		.on('changed.jstree', function (e, data) """),format.raw/*32.47*/("""{"""),format.raw/*32.48*/("""
	    	"""),format.raw/*33.7*/("""var r = null;
	   		r = data.instance.get_node(data.selected[0]);

	    	// keep the absolute path of the directory selected
	    	$('#directory').val(r.data);
	  	"""),format.raw/*38.5*/("""}"""),format.raw/*38.6*/(""")
	  	// create the instance
	  	.jstree();
    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/("""
	"""),format.raw/*42.2*/("""</script>	
    """)))}),format.raw/*43.6*/("""
	
""")))}),format.raw/*45.2*/("""
"""))
      }
    }
  }

  def render(treeString:String): play.twirl.api.HtmlFormat.Appendable = apply(treeString)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (treeString) => apply(treeString)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Oct 12 11:06:10 CDT 2017
                  SOURCE: /Users/rhuang/Documents/Dropbox_1/TACC/PLAY/play-scala-fileupload/app/views/upload.scala.html
                  HASH: 9e2d83cf94970dd5a9ac05afc77025f66c61175a
                  MATRIX: 730->1|845->21|873->24|900->43|939->45|967->47|1017->72|1031->78|1130->168|1170->170|1206->180|1379->326|1410->336|1704->602|1733->603|1767->610|1818->633|1847->634|1881->641|1918->650|1947->651|1986->662|2043->691|2072->692|2102->695|2130->696|2255->793|2284->794|2318->801|2509->965|2537->966|2612->1014|2640->1015|2669->1017|2715->1033|2749->1037
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|30->5|30->5|30->5|30->5|32->7|37->12|37->12|47->22|47->22|49->24|49->24|49->24|50->25|50->25|50->25|51->26|52->27|52->27|53->28|53->28|57->32|57->32|58->33|63->38|63->38|66->41|66->41|67->42|68->43|70->45
                  -- GENERATED --
              */
          