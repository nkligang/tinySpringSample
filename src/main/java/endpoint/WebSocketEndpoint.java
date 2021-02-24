package endpoint;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fenglinga.tinyspring.framework.annotation.Component;
import com.fenglinga.tinyspring.framework.annotation.websocket.OnClose;
import com.fenglinga.tinyspring.framework.annotation.websocket.OnError;
import com.fenglinga.tinyspring.framework.annotation.websocket.OnMessage;
import com.fenglinga.tinyspring.framework.annotation.websocket.OnOpen;
import com.fenglinga.tinyspring.framework.annotation.websocket.ServerEndpoint;
import com.fenglinga.tinyspring.framework.websocket.WebSocketCodecPacket;

@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketEndpoint {
	private static final Logger LOG = LoggerFactory.getLogger(WebSocketEndpoint.class);
    
    @OnOpen
    public void onOpen(IoSession session) {
        LOG.info("OPENED:" + session);
    }

    @OnClose
    public void onClose(IoSession session) {
    	LOG.info("CLOSED:" + session);
    }
    
    @OnMessage
    public void onMessage(String message, IoSession session) {
    	LOG.info("onMessage:" + message);
    	WebSocketCodecPacket result = WebSocketCodecPacket.buildPacket("Hello from server:" + message);
    	session.write(result);
    }
    
    @OnMessage
    public void onMessage(byte[] message, IoSession session) {
    }

    @OnError
    public void onError(IoSession session, Throwable error) {
        error.printStackTrace();
    }
}
