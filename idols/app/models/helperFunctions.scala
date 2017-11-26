package models

object helperFunctions {
  
    def arrayToHtml(description: String = "Reservation information", stringArray:Array[String], tag:String = "div"): String = {
      val start = "<" + tag + ">"
      val end = "</" + tag + ">"
      val desc_html = start + description + end
      stringArray.length match {
        case 1 => { desc_html + start + stringArray(0) + end}
        case _ => { desc_html + start + stringArray.mkString(start+end) + end}
      }
  }
    
    
    
}