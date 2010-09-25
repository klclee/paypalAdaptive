package rest.reply;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PayResponse", namespace = "http://svcs.paypal.com/types/ap")
public class PayResponse implements PaypalPayReply{

	private PaypalResponseEnvelope responseEnvelope;
	private String payKey;
	private String paymentExecStatus;
	
	public PaypalResponseEnvelope getResponseEnvelope() {
		return responseEnvelope;
	}
	public void setResponseEnvelope(PaypalResponseEnvelope responseEnvelope) {
		this.responseEnvelope = responseEnvelope;
	}
	public String getPayKey() {
		return payKey;
	}
	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}
	public String getPaymentExecStatus() {
		return paymentExecStatus;
	}
	public void setPaymentExecStatus(String paymentExecStatus) {
		this.paymentExecStatus = paymentExecStatus;
	}
	
	
}
