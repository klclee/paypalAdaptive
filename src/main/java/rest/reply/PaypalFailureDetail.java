package rest.reply;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class PaypalFailureDetail {
	private String errorId;
	private String domain;
	private String severity;
	private String category;
	private String message;
	private List<String> parameter;
	
	
	
	@Override
	public String toString() {
		return "errorId" + errorId + "\\n" +
		"domain: " + domain + "\\n" +
		"severity: " + severity + "\\n" +
		"category: " + category + "\\n" +
		"message: " + message + "\\n" + paramStrings();
	}
	private String paramStrings() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String param : parameter){
			stringBuilder.append(param).append("\\n");
		}
		return stringBuilder.toString();
	}
	@XmlElements({
		@XmlElement(name = "parameter", type = String.class)
	})
	public List<String> getParameter() {
		return parameter;
	}
	public void setParameter(List<String> parameter) {
		this.parameter = parameter;
	}
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
