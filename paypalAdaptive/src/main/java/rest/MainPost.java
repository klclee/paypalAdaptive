package rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;



import rest.reply.PaypalPayReply;
import rest.request.PaypalPayDso;
import rest.request.PaypalReciver;
import rest.request.PaypalRequestEnvelope;


public class MainPost {
	
	@Autowired
	private RestOperations restOperations;
	
	public void makeRequest(){
		PaypalPayDso payDso = generatePaypalDso();
		try{
			
			HttpEntity<PaypalPayDso> entity = new HttpEntity<PaypalPayDso>(payDso, generateHttpHeader());
			ResponseEntity<PaypalPayReply> responseEntity = restOperations.postForEntity("https://svcs.sandbox.paypal.com/AdaptivePayments/Pay", entity, PaypalPayReply.class);
			if (responseEntity.getStatusCode() != HttpStatus.OK){
				System.out.println("Do summfink");
			}else{
				System.out.println(responseEntity.getBody().getPayKey());
			}
		}catch (HttpStatusCodeException ex) {
			ex.printStackTrace();
		}
	}
	
	private MultiValueMap<String, String> generateHttpHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-PAYPAL-SECURITY-USERID", "your test user id");
		headers.add("X-PAYPAL-SECURITY-PASSWORD", "your test user password");
		headers.add("X-PAYPAL-SECURITY-SIGNATURE", "signiture from your test account");
		headers.add("X-PAYPAL-REQUEST-DATA-FORMAT", "XML");
		headers.add("X-PAYPAL-RESPONSE-DATA-FORMAT", "XML");
		headers.add("X-PAYPAL-APPLICATION-ID", "your app id from x.com");
		return headers;
		
	}

	private PaypalPayDso generatePaypalDso() {
		List<PaypalReciver> recivers = new ArrayList<PaypalReciver>();
		recivers.add(new PaypalReciver("1.20", "<your test sender email>", "<a invoice id like a basket id>"));
		
		PaypalPayDso payDso = new PaypalPayDso();
		payDso.setRequestEnvelope(new PaypalRequestEnvelope());
		payDso.setReciverList(recivers);
		payDso.setCurrencyCode("USD");
		//Not mandatory
		payDso.setIpnNotificationUrl("your IPN URL");
		payDso.setReturnUrl("customer return URL");
		payDso.setCancelUrl("customer cancel URL");
		
		return payDso;
	}
//
	public static void main(String[] arg) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-rest-template.xml");
		MainPost mainPost = (MainPost) ctx.getBean("rest");
		mainPost.makeRequest();
	}
}
