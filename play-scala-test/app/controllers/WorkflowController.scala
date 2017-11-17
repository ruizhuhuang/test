package controllers
import javax.inject._
import play.api._
import play.api.mvc._

import models.Task
//import models.UploadTask
//import models.DirectoryStructure
import models._
import play.api.libs.json._

import java.util.ArrayList


@Singleton
class WorkflowController @Inject() (configuration: play.api.Configuration) (cc: ControllerComponents) extends AbstractController(cc) {
  import ClusterForm._
 
  var tasks = scala.collection.mutable.ArrayBuffer[Task]()
 //var tasks = new ArrayList[Task]()
//  var directories : Map[String, JsValue]
  
  var res : AnyRef = _
  
  
  def showWorkflow() = Action { implicit request: Request[AnyContent] =>
    // can change root directory to start the directory tree
//    val root = configuration.underlying.getString("fileUpload.default.dir")
    
    
    
    
    // eliminate duplicate of tasks when page is refreshed
    //var taskArray: Array[Task] = new Array[Task](tasks.size())
    
    if (tasks.size == 0) 
      buildTasks()    
      //taskArray = tasks.toArray(taskArray)      
    

    // request root path & conf
    Ok(views.html.clusterStatus(res, tasks(0) , 0))
  }
  
  
  def buildTasks() {
    val task1 = new checkClusterTask("preprecessing","checkHadoop")
    //task1.creat()
    
    
//    val task2 = new UploadTask("Data Analysis", "fileUpload")
//    val task3 = new UploadTask("Postprocessing", "fileUpload")
    tasks.append(task1)
//    tasks.add(task2)
//    tasks.add(task3)
  }
  
  
//  var dirTree: DirectoryStructure = null
//  def generateTree(rootPath: String) = Action {
//    if (dirTree == null || !rootPath.equals(dirTree.root.name))
//      dirTree = new DirectoryStructure(rootPath)
//    Ok(dirTree.getJsonString())
//  }
//  
  
  def runTask  = Action { implicit request: Request[AnyContent] =>
    val index = 0
    val body = request.body
    
    println(request.body.asFormUrlEncoded)
    
    
    //val task = tasks.get(index)
    val task = tasks(index)
    if (task.taskType.equals("checkHadoop"))
      res = task.run(body)
      //tasks.get(index).run(body)

    Redirect(routes.WorkflowController.showWorkflow);
  }
  
  
//  def runAllTask() = {
//    tasks.foreach(t => t.run())
//  }
  
  
//  def configureTask(t : Task, map : Map[String, Any]) ={
//    t.configure(map)
//  }
  
  
  //def buildTasksFromConfiguraiton(configfilename: String)={}

}