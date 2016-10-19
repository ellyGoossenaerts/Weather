package db;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class RelationalDatabase {
    
    private final  EntityManagerFactory factory;
    private  EntityManager manager;
   
    public RelationalDatabase(String name){
        factory = Persistence.createEntityManagerFactory(name);
    }
    
    protected void openConnection(){
        try {
            System.out.println("open");
            manager = factory.createEntityManager();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(), e);
        }
        
    }
   
    protected void closeConnection(){
        try {
            System.out.println("close");
            manager.close();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    public void close(){
        try {
            factory.close();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    protected EntityManager getManager(){
        return this.manager;
    }
    
}
