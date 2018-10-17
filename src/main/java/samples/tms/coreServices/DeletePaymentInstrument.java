package samples.tms.coreServices;

import Api.PaymentInstrumentApi;
import Invokers.ApiClient;
import Invokers.ApiException;

public class DeletePaymentInstrument {
	private String profileId = "93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private String tokenId="76C16E5FCB608FEAE05340588D0ADAB1";
	private String responseCode = null;
	private String status = null;
	

	public static void main(String args[]) throws Exception {
		new DeletePaymentInstrument();
	}

	public DeletePaymentInstrument() throws Exception {

		process();
	}

	private void process() throws Exception {

		try {

			PaymentInstrumentApi paymentInstrumentApi = new PaymentInstrumentApi();
			paymentInstrumentApi.paymentinstrumentsTokenIdDelete(profileId, tokenId);

			responseCode = ApiClient.responseCode;
			status = ApiClient.status;

			System.out.println("ResponseCode :" + responseCode);
			System.out.println("Status :" + status);

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
