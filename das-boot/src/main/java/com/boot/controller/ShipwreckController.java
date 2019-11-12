package com.boot.controller;

import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck wreck) {
		return shipwreckRepository.saveAndFlush(wreck);
	}
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		return shipwreckRepository.findOne(id);
	}
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id,@RequestBody Shipwreck wreck) {
		Shipwreck existingShipWreck =shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(wreck, existingShipWreck);
		return shipwreckRepository.saveAndFlush(existingShipWreck);
	}
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.POST)
	public Shipwreck delete(@PathVariable Long id) {
		Shipwreck existingShipWreck =shipwreckRepository.findOne(id);
		 shipwreckRepository.delete(existingShipWreck);
		 return existingShipWreck;
	}
}
