package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

	/**
	 * Test when the edge case when the both supported and enabled protocols are null.
	 */
	@Test
	public void preparedSocket_NullProtocols()  {
		TLSSocketFactory f = mock(TLSSocketFactory.class);

		SSLSocket socket = mock(SSLSocket.class);

		when(socket.getSupportedProtocols()).thenReturn(null);
		when(socket.getEnabledProtocols()).thenReturn(null);
		doAnswer((string) -> {
			fail();
			// check that the method is not called
			verify(socket,never()).setEnabledProtocols(string.getArgument(0));
			return null;
		}).when(socket).setEnabledProtocols(any(String[].class));

		f.prepareSocket(socket);
	}

	@Test
	public void typical()  {
		TLSSocketFactory f = new TLSSocketFactory();
		SSLSocket socket = mock(SSLSocket.class);
		when(socket.getSupportedProtocols()).thenReturn(shuffle(new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1",
				"TLSv1.2" }));
		when(socket.getEnabledProtocols()).thenReturn(shuffle(new String[] { "SSLv3", "TLSv1" }));
		doAnswer((string) -> {
			assertTrue(Arrays.equals(string.getArgument(0), new String[] { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
			// check that the method is called once
			verify(socket, times(1)).setEnabledProtocols(string.getArgument(0));
			return null;

		}).when(socket).setEnabledProtocols(any(String[].class));

		f.prepareSocket(socket);
	}


	private String[] shuffle(String[] in) {
		List<String> list = new ArrayList<String>(Arrays.asList(in));
		Collections.shuffle(list);
		return list.toArray(new String[0]);
	}
}