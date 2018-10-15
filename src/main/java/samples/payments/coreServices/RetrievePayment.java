package samples.payments.coreServices;

import Api.PaymentApi;
import Invokers.ApiClient;
import Invokers.ApiException;

public class RetrievePayment {
	
	
	private String getId="5391637959586712204001";
	private String responseCode=null;
	private String responseMsg=null;
	
	public static void main(String args[]) throws Exception {
		new RetrievePayment();
	}

	public RetrievePayment() throws Exception {
	
		process();
	}
    
	private void process() throws Exception {
	
	try {
		
		PaymentApi paymentApi=new PaymentApi();
		paymentApi.getPayment(getId);
		
		responseCode=ApiClient.resp;
		responseMsg=ApiClient.respmsg;
		System.out.println("ResponseCode :" +responseCode);
		System.out.println("ResponseMessage :" +responseMsg);
		
	
	} catch (ApiException e) {
		
		e.printStackTrace();
	}
  }

}
