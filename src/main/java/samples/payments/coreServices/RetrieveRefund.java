package samples.payments.coreServices;

import Api.RefundApi;
import Invokers.ApiClient;
import Invokers.ApiException;

public class RetrieveRefund {

	private String getId="5335504389516958903526";
	private String responseCode=null;
	private String responseMsg=null;
	
	public static void main(String args[]) throws Exception {
		new RetrieveRefund();
	}

	public RetrieveRefund() throws Exception {
	
		process();
	}
    
	private void process() throws Exception {
	
	try {
		
		RefundApi refundApi=new RefundApi();
		refundApi.getRefund(getId);
		
		responseCode=ApiClient.resp;
		responseMsg=ApiClient.respmsg;
		System.out.println("ResponseCode :" +responseCode);
		System.out.println("ResponseMessage :" +responseMsg);
		
	
	} catch (ApiException e) {
		
		e.printStackTrace();
	}
  }

}
