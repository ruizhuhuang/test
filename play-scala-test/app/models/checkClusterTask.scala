package models

import play.api.mvc._


class checkClusterTask(name: String, tType: String) extends Task(name, tType){
   //name of this task, example: preprocessing, data analysis, postprocessing
  val taskName = name
  // type of this task, example: fileUpload
  val taskType = tType
  
//  var file : File 
//  var target : String 
//  
  def run(body: AnyContent) : Array[String]= {
    checkCluster(body)
  }
  
    /**
   * Upload file to selected directory
   */
  def checkCluster(body: AnyContent) : Array[String] = {
    val cluster  = new HadoopCluster(3,3,"Hadooop")
    cluster.getNodeList(body.asFormUrlEncoded.get("reservation")(0))
    
    
  }
    
  }