package rest.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "PayRequest")
public class PaypalPayDso {

	private PaypalRequestEnvelope requestEnvelope;
	private String actionType = "PAY";
	private String cancelUrl;
	private String returnUrl;
	private String ipnNotificationUrl;
	private String currencyCode;
	private String feesPayer = "EACHRECEIVER";
	private List<PaypalReciver> reciverList;
	
	@XmlElement(name = "requestEnvelope")
	public PaypalRequestEnvelope getRequestEnvelope() {
		return requestEnvelope;
	}

	public void setRequestEnvelope(PaypalRequestEnvelope requestEnvelope) {
		this.requestEnvelope = requestEnvelope;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getIpnNotificationUrl() {
		return ipnNotificationUrl;
	}

	public void setIpnNotificationUrl(String ipnNotificationUrl) {
		this.ipnNotificationUrl = ipnNotificationUrl;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getFeesPayer() {
		return feesPayer;
	}

	public void setFeesPayer(String feesPayer) {
		this.feesPayer = feesPayer;
	}

	@XmlElementWrapper(name = "receiverList")
	@XmlElements({
		@XmlElement(name="receiver", type=PaypalReciver.class)
	})
	public List<PaypalReciver> getReciverList() {
		return reciverList;
	}

	public void setReciverList(List<PaypalReciver> reciverList) {
		this.reciverList = reciverList;
	}

}
