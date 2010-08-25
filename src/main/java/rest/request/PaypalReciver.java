package rest.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "receiver")
public class PaypalReciver{
	private String amount;
	private String email;
	private String invoiceId;
	
	public PaypalReciver(String amount, String email, String invoiceId) {
		super();
		this.amount = amount;
		this.email = email;
		this.invoiceId = invoiceId;
	}
	public PaypalReciver() {
		super();
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
}
