package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

	/**
	 * Test when the edge case when the both supported and enabled protocols are null.
	 */
	@Test
	public void preparedSocket_NullProtocols()  {
		TLSSocketFactory f = mock(TLSSocketFactory.class);

		SSLSocket s = mock(SSLSocket.class);

		when(s.getSupportedProtocols()).thenReturn(null);
		when(s.getEnabledProtocols()).thenReturn(null);

		f.prepareSocket(new SSLSocket() {

			public String[] getSupportedProtocols() {
				return null;
			}

			public String[] getEnabledProtocols() {
				return null;
			}

			public void setEnabledProtocols(String[] protocols) {
				fail();
			}
		});
	}

	@Test
	public void typical()  {
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(new SSLSocket() {
			@Override
			public String[] getSupportedProtocols() {
				return shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
			}
			@Override
			public String[] getEnabledProtocols() {
				return shuffle(new String[]{"SSLv3", "TLSv1"});
			}
			@Override
			public void setEnabledProtocols(String[] protocols) {
				assertTrue(Arrays.equals(protocols, new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
			}
		});
	}


	private String[] shuffle(String[] in) {
		List<String> list = new ArrayList<String>(Arrays.asList(in));
		Collections.shuffle(list);
		return list.toArray(new String[0]);
	}
}