package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	ShipwreckController sc;

	@Mock
	ShipwreckRepository shipwreckRepository;

	@org.junit.Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		
		when(shipwreckRepository.findOne(1l)).thenReturn(sw);
		Shipwreck result = sc.get(1l);
		assertEquals(1l, result.getId().longValue());

	}

}
