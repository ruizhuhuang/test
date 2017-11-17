package models

/**
 * Presentation object used for displaying data in a template.
 *
 * Note that it's a good practice to keep the presentation DTO,
 * which are used for reads, distinct from the form processing DTO,
 * which are used for writes.
 */
import play.api.libs.Files
import play.api.mvc._
import scala.sys.process._


 class HadoopCluster(numNode: Int, numDays:Int, cType: String) extends Cluster(numNode,numDays,cType){
  //number of node for the cluster
  val numberNode = numNode
  
  // number of days for the cluster
  val numberDays = numDays
  
  // type of this task, example: fileUpload
  val clusterType = cType
  
//  val id: Int
  
  /**
   * Run this task
   * @param body: message requested from user
   * @return feedback to user
   */
  def create() = {    
    createHadoopCluster()
  }
  
  def createHadoopCluster() = {
    // run bash script to create hadoop reservation
  }



  override def configure(parameters: Map[String, Any]) = {
      configureHadoopCluster(parameters)
    //parameters.foreach { case (k, v) => this.setByName(k, v) }
  }
  
  def configureHadoopCluster(parameters: Map[String, Any]){
    // configure 
    
  }
  
  def getNodeList(reservationName: String) : Array[String]= {
    getHadoopNodeList(reservationName)    
  }
  
  def getHadoopNodeList(reservationName:String = "hadoop+Idols+2428") : Array[String] = {
    //get node list
    val resName = reservationName
    //val command = "tmp=`sinfo -T|grep "+ resName + " |awk '{print $6}'` && scontrol show hostname $tmp"
    val command = "echo $HOME"
    Process(Seq("bash","-c", command)).!!.split("\n")     
  }

}