package samples.payments.authorizePayment;

import Api.PaymentApi;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.CreatePaymentRequest;
import Model.V2paymentsClientReferenceInformation;
import Model.V2paymentsOrderInformation;
import Model.V2paymentsOrderInformationAmountDetails;
import Model.V2paymentsOrderInformationBillTo;
import Model.V2paymentsPaymentInformation;
import Model.V2paymentsPaymentInformationCard;
import Model.V2paymentsPointOfSaleInformation;

public class CurrenciesSupported {
	private static String responseCode = null;
	private static String responseMsg = null;

	static CreatePaymentRequest request;

	private static CreatePaymentRequest getRequest() {
		request = new CreatePaymentRequest();

		V2paymentsClientReferenceInformation client = new V2paymentsClientReferenceInformation();
		client.code("1234567890");
		request.clientReferenceInformation(client);

		V2paymentsPointOfSaleInformation pointOfSaleInformation = new V2paymentsPointOfSaleInformation();
		pointOfSaleInformation.cardPresent(false);
		pointOfSaleInformation.catLevel(6);
		pointOfSaleInformation.terminalCapability(4);
		request.pointOfSaleInformation(pointOfSaleInformation);

		V2paymentsOrderInformationBillTo billTo = new V2paymentsOrderInformationBillTo();
		billTo.country("US");
		billTo.firstName("John");
		billTo.lastName("Deo");
		billTo.address1("901 Metro Center Blvd");
		billTo.postalCode("40500");
		billTo.locality("Foster City");
		billTo.administrativeArea("CA");
		billTo.email("test@cybs.com");

		V2paymentsOrderInformationAmountDetails amountDetails = new V2paymentsOrderInformationAmountDetails();
		amountDetails.totalAmount("100.00");
		amountDetails.currency("INR");

		V2paymentsOrderInformation orderInformation = new V2paymentsOrderInformation();
		orderInformation.billTo(billTo);
		orderInformation.amountDetails(amountDetails);
		request.setOrderInformation(orderInformation);

		V2paymentsPaymentInformationCard card = new V2paymentsPaymentInformationCard();
		card.expirationYear("2031");
		card.number("4111111111111111");
		card.securityCode("123");
		card.expirationMonth("12");

		V2paymentsPaymentInformation paymentInformation = new V2paymentsPaymentInformation();
		paymentInformation.card(card);
		request.setPaymentInformation(paymentInformation);

		return request;

	}

	public static void main(String args[]) throws Exception {
		new CurrenciesSupported();
	}

	public CurrenciesSupported() throws Exception {
		process();
	}
	

	public static void process() throws Exception {

		try {
			request = getRequest();

			PaymentApi paymentApi = new PaymentApi();
			paymentApi.createPayment(request);

			responseCode = ApiClient.resp;
			responseMsg = ApiClient.respmsg;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + responseMsg);

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
