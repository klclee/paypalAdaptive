package rest.reply;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: charlie
 * Date: Sep 25, 2010
 */
public interface OXMapper {
     public String marshall(Object objToUnMarshall) throws IOException;
    public Object unMarshall(InputStream content) throws IOException;
}
