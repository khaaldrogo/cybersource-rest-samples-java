package samples.payments.coreServices;

import Api.ReversalApi;
import Invokers.ApiClient;
import Invokers.ApiException;

public class RetrieveAuthorizationReversal {
	private String getId="5335485520876949203528";
	private String responseCode=null;
	private String responseMsg=null;
	
	public static void main(String args[]) throws Exception {
		new RetrieveAuthorizationReversal();
	}

	public RetrieveAuthorizationReversal() throws Exception {
	
		process();
	}
    
	private void process() throws Exception {
	
	try {
		
		ReversalApi reversalApi=new ReversalApi();
		reversalApi.getAuthReversal(getId);
		
		responseCode=ApiClient.resp;
		responseMsg=ApiClient.respmsg;
		System.out.println("ResponseCode :" +responseCode);
		System.out.println("ResponseMessage :" +responseMsg);
		
	
	} catch (ApiException e) {
		
		e.printStackTrace();
	}
  }

}
