package samples.flex.coreServices;

import Api.KeyGenerationApi;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.GeneratePublicKeyRequest;
import Model.InlineResponse200;

public class GenerateKey {
	private String responseCode = null;
	private String responseMsg = null;
	
	public static InlineResponse200 response=null;

	GeneratePublicKeyRequest request;

	private GeneratePublicKeyRequest getRequest() {
		request = new GeneratePublicKeyRequest();
		request.encryptionType("RsaOaep256");
		return request;

	}

	public static void main(String args[]) throws Exception {
		new GenerateKey();
	}

	public GenerateKey() throws Exception {
		process();
	}

	public InlineResponse200 process() throws Exception {

		try {
			request = getRequest();

			KeyGenerationApi keyGenerationApi = new KeyGenerationApi();
			response=keyGenerationApi.generatePublicKey(request);

			responseCode = ApiClient.resp;
			responseMsg = ApiClient.respmsg;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + responseMsg);

		} catch (ApiException e) {

			e.printStackTrace();
		}
		return response;
	}


}
