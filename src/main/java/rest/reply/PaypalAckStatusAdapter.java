package rest.reply;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PaypalAckStatusAdapter extends XmlAdapter<String, PaypalAckStatus>{

	@Override
	public PaypalAckStatus unmarshal(String v) throws Exception {
		return PaypalAckStatus.valueOf(v.toUpperCase());
	}

	@Override
	public String marshal(PaypalAckStatus v) throws Exception {
		return v.value();
	}

}
