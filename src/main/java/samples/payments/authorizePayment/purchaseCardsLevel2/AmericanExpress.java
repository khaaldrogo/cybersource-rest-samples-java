package samples.payments.authorizePayment.purchaseCardsLevel2;

import java.util.ArrayList;
import java.util.List;

import Api.PaymentApi;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.CreatePaymentRequest;
import Model.V2paymentsAggregatorInformation;
import Model.V2paymentsAggregatorInformationSubMerchant;
import Model.V2paymentsClientReferenceInformation;
import Model.V2paymentsOrderInformation;
import Model.V2paymentsOrderInformationAmountDetails;
import Model.V2paymentsOrderInformationBillTo;
import Model.V2paymentsOrderInformationInvoiceDetails;
import Model.V2paymentsOrderInformationInvoiceDetailsTransactionAdviceAddendum;
import Model.V2paymentsPaymentInformation;
import Model.V2paymentsPaymentInformationCard;
import Model.V2paymentsProcessingInformation;

public class AmericanExpress {
	private String responseCode = null;
	private String responseMsg = null;

	CreatePaymentRequest request;

	private CreatePaymentRequest getRequest() {
		request = new CreatePaymentRequest();

		V2paymentsClientReferenceInformation client = new V2paymentsClientReferenceInformation();
		client.code("TC50171_13");
		request.clientReferenceInformation(client);

		V2paymentsProcessingInformation processingInformation = new V2paymentsProcessingInformation();
		processingInformation.commerceIndicator("internet");
		request.setProcessingInformation(processingInformation);
		
		V2paymentsAggregatorInformationSubMerchant subMerchant = new V2paymentsAggregatorInformationSubMerchant();
		subMerchant.cardAcceptorId("1234567890");
		subMerchant.country("US");
		subMerchant.phoneNumber("650-432-0000");
		subMerchant.address1("900 Metro Center");
		subMerchant.postalCode("94404-2775");
		subMerchant.locality("Foster City");
		subMerchant.name("Visa Inc");
		subMerchant.administrativeArea("CA");
		subMerchant.region("PEN");
		subMerchant.email("test@cybs.com");

		V2paymentsAggregatorInformation aggregatorInformation = new V2paymentsAggregatorInformation();
		aggregatorInformation.subMerchant(subMerchant);
		aggregatorInformation.name("V-Internatio");
		aggregatorInformation.aggregatorId("123456789");
		request.setAggregatorInformation(aggregatorInformation);
		
		V2paymentsOrderInformationBillTo billTo = new V2paymentsOrderInformationBillTo();
		billTo.country("US");
		billTo.lastName("Deo");
		billTo.address2("Address 2");
		billTo.address1("201 S. Division St.");
		billTo.postalCode("48104-2201");
		billTo.locality("Ann Arbor");
		billTo.administrativeArea("MI");
		billTo.firstName("John");
		billTo.phoneNumber("999999999");
		billTo.district("MI");
		billTo.buildingNumber("123");
		billTo.company("Visa");
		billTo.email("test@cybs.com");
		
		List<V2paymentsOrderInformationInvoiceDetailsTransactionAdviceAddendum> transactionAdviceAddendum= new ArrayList<V2paymentsOrderInformationInvoiceDetailsTransactionAdviceAddendum>();
		//transactionAdviceAddendum.add("data"," data");
		
		V2paymentsOrderInformationInvoiceDetails invoiceDetails=new V2paymentsOrderInformationInvoiceDetails();
		invoiceDetails.purchaseOrderNumber("LevelII Auth Po");
		invoiceDetails.transactionAdviceAddendum(transactionAdviceAddendum);

		V2paymentsOrderInformationAmountDetails amountDetails = new V2paymentsOrderInformationAmountDetails();
		amountDetails.totalAmount("113.00");
		amountDetails.currency("USD");
		
		V2paymentsOrderInformation orderInformation = new V2paymentsOrderInformation();
		orderInformation.billTo(billTo);
		orderInformation.invoiceDetails(invoiceDetails);
		orderInformation.amountDetails(amountDetails);
		request.setOrderInformation(orderInformation);

		V2paymentsPaymentInformationCard card = new V2paymentsPaymentInformationCard();
		card.expirationYear("2031");
		card.number("378282246310005");
		card.securityCode("123");
		card.expirationMonth("12");
		card.type("003");
		
		V2paymentsPaymentInformation paymentInformation = new V2paymentsPaymentInformation();
		paymentInformation.card(card);
		request.setPaymentInformation(paymentInformation);

		return request;

	}

	public static void main(String args[]) throws Exception {
		new AmericanExpress();
	}

	public AmericanExpress() throws Exception {
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
