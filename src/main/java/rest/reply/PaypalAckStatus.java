package rest.reply;

public enum PaypalAckStatus {
	SUCCESS("Success"),
	FAILURE("Failure");

	private String value;
	
	private PaypalAckStatus(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
}
