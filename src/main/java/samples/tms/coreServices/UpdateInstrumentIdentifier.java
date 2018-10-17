package samples.tms.coreServices;

import Api.InstrumentIdentifierApi;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.Body1;
import Model.InlineResponse2007;
import Model.InstrumentidentifiersProcessingInformation;
import Model.InstrumentidentifiersProcessingInformationAuthorizationOptions;
import Model.InstrumentidentifiersProcessingInformationAuthorizationOptionsInitiator;
import Model.InstrumentidentifiersProcessingInformationAuthorizationOptionsInitiatorMerchantInitiatedTransaction;

public class UpdateInstrumentIdentifier {
	private String responseCode = null;
	private String status=null;
	static InlineResponse2007 response;
	private String profileId="93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private String tokenId="76C16E5FCB608FEAE05340588D0ADAB1";

	Body1 body;

	private Body1 getRequest() {
		body = new Body1();
		
		InstrumentidentifiersProcessingInformationAuthorizationOptionsInitiatorMerchantInitiatedTransaction merchantInitiatedTransaction=new InstrumentidentifiersProcessingInformationAuthorizationOptionsInitiatorMerchantInitiatedTransaction();
		merchantInitiatedTransaction.previousTransactionId("123456789012345");
		
		InstrumentidentifiersProcessingInformationAuthorizationOptionsInitiator initiator=new InstrumentidentifiersProcessingInformationAuthorizationOptionsInitiator();
		initiator.merchantInitiatedTransaction(merchantInitiatedTransaction);
		
		InstrumentidentifiersProcessingInformationAuthorizationOptions authorizationOptions=new InstrumentidentifiersProcessingInformationAuthorizationOptions();
		authorizationOptions.initiator(initiator);
		
		InstrumentidentifiersProcessingInformation processingInformation=new InstrumentidentifiersProcessingInformation();
		processingInformation.authorizationOptions(authorizationOptions);
		body.processingInformation(processingInformation);
		
		return body;

	}

	public static void main(String args[]) throws Exception {
		new UpdateInstrumentIdentifier();
	}

	public UpdateInstrumentIdentifier() throws Exception {
		process();
	}

	public  InlineResponse2007 process() throws Exception {

		try {
			body = getRequest();

			InstrumentIdentifierApi instrumentIdentifierApi = new InstrumentIdentifierApi();
			response=instrumentIdentifierApi.instrumentidentifiersTokenIdPatch(profileId, tokenId, body);

			responseCode=ApiClient.responseCode;
			status=ApiClient.status;
			
			System.out.println("ResponseCode :" +responseCode);
			System.out.println("Status :" +status);
			System.out.println(response.getId());
			System.out.println(response.toString());

		} catch (ApiException e) {

			e.printStackTrace();
		}
		return response;
	}


}
