package samples.tms.coreServices;

import Api.InstrumentIdentifierApi;
import Invokers.ApiClient;
import Invokers.ApiException;

public class DeleteInstrumentIdentifier {
	private String profileId="93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private String tokenId="7020000000000137654";
	private String responseCode=null;
	private String status=null;
	
	public static void main(String args[]) throws Exception {
		new DeleteInstrumentIdentifier();
	}

	public DeleteInstrumentIdentifier() throws Exception {
	
		process();
	}
    
	private void process() throws Exception {
	
	try {
		
		InstrumentIdentifierApi instrumentIdentifierApi = new InstrumentIdentifierApi();
		instrumentIdentifierApi.instrumentidentifiersTokenIdDelete(profileId,tokenId );
		
		responseCode=ApiClient.responseCode;
		status=ApiClient.status;
		
		System.out.println("ResponseCode :" +responseCode);
		System.out.println("Status :" +status);
		
		
	
	} catch (ApiException e) {
		
		e.printStackTrace();
	}
  }

}
