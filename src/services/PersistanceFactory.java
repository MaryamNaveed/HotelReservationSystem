package services;

public class PersistanceFactory {
	private static PersistanceFactory pf=null;
	PersistanceHandler service=null;
	
	private PersistanceFactory() {
		
	}
	
	public static synchronized PersistanceFactory getInstance() {
		if(pf==null) {
			pf=new PersistanceFactory();
		}
		
		return pf;
	}
	
	public PersistanceHandler createPersistanceHandler(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(service==null) {
			if(className.equalsIgnoreCase("mysqldbhandler")) {
				//service= (PersistanceHandler) Class.forName(className).newInstance();
				service= new MySqlDBHandler();
			}
			else if(className.equalsIgnoreCase("filehandler")) {
				//service= (PersistanceHandler) Class.forName(className).newInstance();
				service= new FileHandler();
			}
			
		}
		return service;
		
	}

	
}
