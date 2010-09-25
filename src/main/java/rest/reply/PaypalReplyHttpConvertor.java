package rest.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * User: charlie
 * Date: Sep 25, 2010
 */
public class PaypalReplyHttpConvertor implements HttpMessageConverter<PaypalPayReply> {

    @Autowired
	private OXMapper oxMapper;

    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<MediaType> getSupportedMediaTypes() {
		return Collections.singletonList(new MediaType("text", "xml"));
	}

	public PaypalPayReply read(Class<? extends PaypalPayReply> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {

		return (PaypalPayReply) oxMapper.unMarshall(inputMessage.getBody());
	}

	public void write(PaypalPayReply t, MediaType contentType, HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		throw new UnsupportedOperationException("not support");
	}
}
