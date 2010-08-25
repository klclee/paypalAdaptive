package rest.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="requestEnvelope")
public class PaypalRequestEnvelope{
	
	private String errorLanguage = "en_US";

	public String getErrorLanguage() {
		return errorLanguage;
	}

	public void setErrorLanguage(String errorLanguage) {
		this.errorLanguage = errorLanguage;
	}
}
