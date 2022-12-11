package application;

import java.util.ArrayList;
import java.util.List;

import application.Model.Entity;
import application.Model.Roboter;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MapOfRobot {
	
	@FXML
    private GridPane squares;
	
    private int width, height;
    private List<Entity> entities;
    private Roboter roboter;
    

    public MapOfRobot(int width, int height) {
        this.width = width;
        this.height = height;         
        this.roboter = null;
        this.entities = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Roboter getRoboter() {
        return roboter;
    }

    public void setPlayer(Roboter roboter) {
        this.roboter = roboter;
    }

    public void addEntity(Entity entity) {    	
        entities.add(entity);       
    }
    
    public void removeEntity(Entity entity) {    	
        this.entities.remove(entity);
    }
    
    public void removeEntityPicture(Entity entity) {
    	entity.x().setValue(width + 10); 
    }
        
    public void backEntityPicture(Entity entity,int x,int y) {
    	entity.x().set(x); 
    	entity.y().set(y);
    }
    
    
    public List<Entity> getEntities() {
		return entities;
	}
    
    public Entity getEntityByName(String name) {
        for(Entity entity : this.entities) {
        	if(entity.getName().compareTo(name)==0) {        		
        		return entity;
        	}
        }
        return null;
    }    
    
    
	public Entity getEntity(int x ,int y) {
        for(Entity entity : this.entities) {
        	if(entity.getX() == x && entity.getY() == y) {        		
        		return entity;
        	}
        }
        return null;
    } 
	
	 
}
