package de.pm.menue;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import de.pm.awk.model.Benutzer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;


    
    
public class ScreensController extends StackPane {
    
    private HashMap<String, Node> screens = new HashMap<>();
	private HashMap<String, ControlledSceneController> controllers = new HashMap<>();  
	public static String sourcePath = "";
	private Benutzer currentUser;
	//private AuftragTO currentAuftrag;
	// private IKundenVerwaltung kundenManager;
	// private IAuftragsverwaltung auftragManager;
    // private IRessourcenVerwaltung ressourcenVerwaltung;
	// private Auftrag currentAuftrag;
	// private BearbeitungAuftragTO currentBAuftrag;
	
	public ScreensController(){
		super();
	}


	
	
	// public BearbetungAuftrag getCurrentBAuftrag() {
	// 	return currentBAuftrag;
	// }




	// public void setCurrentBAuftrag(BearbetungAuftrag currentBAuftrag) {
	// 	this.currentBAuftrag = currentBAuftrag;
	// }




	// public Auftrag getCurrentAuftrag() {
	// 	return currentAuftrag;
	// }




	// public void setCurrentAuftrag(Auftrag currentAuftrag) {
	// 	this.currentAuftrag = currentAuftrag;
	// }




	// public BearbeitungAuftragTO getCurrentBAuftrag() {
	// 	return currentBAuftrag;
	// }




	// public void setCurrentBAuftrag(BearbeitungAuftragTO currentBAuftrag) {
	// 	this.currentBAuftrag = currentBAuftrag;
	// }




	// public AuftragTO getCurrentAuftrag() {
	// 	return currentAuftrag;
	// }




	// public void setCurrentAuftrag(AuftragTO currentAuftrag) {
	// 	this.currentAuftrag = currentAuftrag;
	// }




	public Benutzer getCurrentUser() {
		return currentUser;
	}




	public void setCurrentUser(Benutzer currentUser) {
		this.currentUser = currentUser;
	}




	public void addScreen(String name, Node screen) { 
	       screens.put(name, screen); 
	   } 
	
	public boolean loadScreen(String name, String resource) { 
		// System.out.println("Name: "+name);
		// System.out.println("Resource: "+resource);

		//   String file = System.getProperty("user.dir")+"/target/classes/"+resource;
		//   System.out.println(file);
		
	    // try { 

		// 	 URL url = getClass().getClassLoader().getResource(resource); -> weg

        // if (url == null) {  -> weg
        //     System.out.println("FXML nicht gefunden: " + resource); -> weg
        //     return false; -> weg 
        // }

	    //    FXMLLoader myLoader = new FXMLLoader();
	    //    File f = new File(file);
	    //    URL url = f.toURI().toURL();
	    //    myLoader.setLocation(url);
//	       System.out.println("Location: "+myLoader.getLocation()); -> weg
	       
	    //    Parent loadScreen = (Parent) myLoader.load(); 
	    //    ControlledSceneController myScreenControler = 
	    //           ((ControlledSceneController) myLoader.getController());
	    //    this.controllers.put(name, myScreenControler);
	    //    myScreenControler.setScreenParent(this); 
	    //    addScreen(name, loadScreen); 
	    //    System.out.println("Anzahl Screens: "+screens.size());
	    //    return true; 
	    //  }catch(Exception e) { 
	    // 	 System.out.println("Fehler beim laden von "+file);
	    // 	 System.out.println(e.getMessage()); 
	    // 	 return false; 
	    //  }


    System.out.println("Name: " + name);
    System.out.println("Resource: " + resource);

    try {
        // FXML aus dem Classpath laden (wichtig für JAR + Maven)
        URL url = getClass().getClassLoader().getResource(resource);

        if (url == null) {
            System.out.println("FXML nicht gefunden: " + resource);
            return false;
        }

        FXMLLoader loader = new FXMLLoader(url);
        Parent loadScreen = loader.load();

        ControlledSceneController controller =
                loader.getController();

        this.controllers.put(name, controller);
        controller.setScreenParent(this);

        addScreen(name, loadScreen);

        System.out.println("Anzahl Screens: " + screens.size());
        return true;

    } catch (Exception e) {
        System.out.println("Fehler beim Laden von: " + resource);
        e.printStackTrace();
        return false;
    }
	     
	} 

	
	public boolean setScreen(final String name) { 
	     
		Node screenToRemove;
        if(screens.get(name) != null){   //screen loaded
        	 if(!getChildren().isEmpty()){    //if there is more than one screen
        		 	getChildren().add(0, screens.get(name));     //add the screen
        		 	screenToRemove = getChildren().get(1);
        		 	getChildren().remove(1);                    //remove the displayed screen
        	 }else{
        		 getChildren().add(screens.get(name));       //no one else been displayed, then just show
        	}
        	this.controllers.get(name).initData();  // Aufruf der InitData in jedem Controller beim Szenewechsel (z.B. zum Aktualisieren der TableView)
        	return true;
         }else {
        	 System.out.println("screen hasn't been loaded!!! \n");
        	 return false;
         }     
	}
	
	public boolean unloadScreen(String name) { 
	
		if(screens.remove(name) == null) { 
			System.out.println("Screen didn't exist"); 
	        return false; 
	      } else { 
	           return true; 
	     } 
	}

	public void print() {
		Set<String> keys = screens.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){
			System.out.println("key: "+it.next());
		} 
		
	}



   public ControlledSceneController getController(String name){
		return this.controllers.get(name);
	}




    
}


