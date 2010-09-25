package rest.reply;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement( name= "responseEnvelope")
public class PaypalResponseEnvelope {

	private XMLGregorianCalendar timestamp;
	private PaypalAckStatus ack;
	private String correlationId;
	private String build;
	
	@XmlJavaTypeAdapter(PaypalAckStatusAdapter.class)
	public PaypalAckStatus getAck() {
		return ack;
	}

	public void setAck(PaypalAckStatus ack) {
		this.ack = ack;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public XMLGregorianCalendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(XMLGregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "time:" + timestamp.toString() + "\\n" +
		"correlationId: " + correlationId + "\\n" + 
		"build: " + build + "\\n";
	}
	
}
