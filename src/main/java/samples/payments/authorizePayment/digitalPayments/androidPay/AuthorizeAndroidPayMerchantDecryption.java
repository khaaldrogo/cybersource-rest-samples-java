package samples.payments.authorizePayment.digitalPayments.androidPay;

import Api.PaymentApi;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.CreatePaymentRequest;
import Model.V2paymentsClientReferenceInformation;
import Model.V2paymentsOrderInformation;
import Model.V2paymentsOrderInformationAmountDetails;
import Model.V2paymentsOrderInformationBillTo;
import Model.V2paymentsPaymentInformation;
import Model.V2paymentsPaymentInformationTokenizedCard;
import Model.V2paymentsProcessingInformation;

public class AuthorizeAndroidPayMerchantDecryption {
	private String responseCode = null;
	private String responseMsg = null;

	CreatePaymentRequest request;

	private CreatePaymentRequest getRequest() {
		request = new CreatePaymentRequest();

		V2paymentsClientReferenceInformation client = new V2paymentsClientReferenceInformation();
		client.code("TC_MPOS_Paymentech_1");
		request.clientReferenceInformation(client);
		
		V2paymentsProcessingInformation processingInformation = new V2paymentsProcessingInformation();
		processingInformation.paymentSolution("006");
		request.processingInformation(processingInformation);

		V2paymentsOrderInformationBillTo billTo = new V2paymentsOrderInformationBillTo();
		billTo.country("US");
		billTo.firstName("John");
		billTo.lastName("Deo");
		billTo.phoneNumber("6504327113");
		billTo.address2("Desk M3-5573");
		billTo.address1("901 Metro Center Blvd");
		billTo.postalCode("94404");
		billTo.locality("Foster City");
		billTo.company("Visa");
		billTo.administrativeArea("CA");
		billTo.email("test@cybs.com");
		
		V2paymentsOrderInformationAmountDetails amountDetails = new V2paymentsOrderInformationAmountDetails();
		amountDetails.totalAmount("2012");
		amountDetails.currency("USD");

		V2paymentsOrderInformation orderInformation = new V2paymentsOrderInformation();
		orderInformation.billTo(billTo);
		orderInformation.amountDetails(amountDetails);
		request.setOrderInformation(orderInformation);
		

		V2paymentsPaymentInformationTokenizedCard tokenizedCard = new V2paymentsPaymentInformationTokenizedCard();
		tokenizedCard.expirationYear("2031");
		tokenizedCard.number("4111111111111111");
		tokenizedCard.expirationMonth("12");
		tokenizedCard.transactionType("1");
		tokenizedCard.cryptogram("AceY+igABPs3jdwNaDg3MAACAAA=");

		V2paymentsPaymentInformation paymentInformation = new V2paymentsPaymentInformation();
		paymentInformation.tokenizedCard(tokenizedCard);
		request.setPaymentInformation(paymentInformation);

		return request;

	}

	public static void main(String args[]) throws Exception {
		new AuthorizeAndroidPayMerchantDecryption();
	}

	public AuthorizeAndroidPayMerchantDecryption() throws Exception {
		process();
	}

	private void process() throws Exception {

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
