package samples.payments.coreServices;

import Api.CreditApi;
import Invokers.ApiClient;
import Invokers.ApiException;

public class RetrieveCredit {
	private String getId="5332036920866055004101";
	private String responseCode=null;
	private String responseMsg=null;
	
	public static void main(String args[]) throws Exception {
		new RetrieveCredit();
	}

	public RetrieveCredit() throws Exception {
	
		process();
	}
    
	private void process() throws Exception {
	
	try {
		
		CreditApi creditApi=new CreditApi();
		creditApi.getCredit(getId);
		
		responseCode=ApiClient.resp;
		responseMsg=ApiClient.respmsg;
		System.out.println("ResponseCode :" +responseCode);
		System.out.println("ResponseMessage :" +responseMsg);
		
	
	} catch (ApiException e) {
		
		e.printStackTrace();
	}
  }

}
