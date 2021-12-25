package buisnessLayer;

public class paymentFactory {
	
	Payment service=null;
	
	public paymentFactory() {
		
	}
	
	
	
	public Payment createPaymentHandler(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(service==null) {
			if(className.equalsIgnoreCase("CashPayment")) {
				//service= (PersistanceHandler) Class.forName(className).newInstance();
				service= new paymentByCash();
			}
			else if(className.equalsIgnoreCase("CardPayment")) {
				//service= (PersistanceHandler) Class.forName(className).newInstance();
				service= new paymentByCreditCard();
			}
			
		}
		return service;
		
	}

	
}
