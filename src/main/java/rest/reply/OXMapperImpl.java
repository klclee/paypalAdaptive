package rest.reply;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * User: charlie
 * Date: Sep 25, 2010
 */
public class OXMapperImpl implements OXMapper{
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }


    public String marshall(Object objToUnMarshall) throws IOException {
        StringWriter result = new StringWriter();
        marshaller.marshal(objToUnMarshall, new StreamResult(result));
        return result.toString();
    }

    public Object unMarshall(InputStream content) throws IOException {
        return unmarshaller.unmarshal(new StreamSource(content));
    }
}
