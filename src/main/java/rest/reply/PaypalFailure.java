package rest.reply;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FaultMessage", namespace = "http://svcs.paypal.com/types/ap")
public class PaypalFailure implements PaypalPayReply{
	private PaypalResponseEnvelope responseEnvelope;
	private PaypalFailureDetail error;
	public PaypalResponseEnvelope getResponseEnvelope() {
		return responseEnvelope;
	}
	public void setResponseEnvelope(PaypalResponseEnvelope responseEnvelope) {
		this.responseEnvelope = responseEnvelope;
	}
	public PaypalFailureDetail getError() {
		return error;
	}
	public void setError(PaypalFailureDetail error) {
		this.error = error;
	}
	public String getPayKey() {
		return "";
	}
	@Override
	public String toString() {
		return responseEnvelope.toString() + error.toString();
	}
}
