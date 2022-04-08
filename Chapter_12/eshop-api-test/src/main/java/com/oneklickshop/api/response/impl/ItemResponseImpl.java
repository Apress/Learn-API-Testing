package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.ItemResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ItemResponseImpl implements ItemResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the Item Model.
 *
 * @author Jagdeep Jain
 */
public class ItemResponseImpl extends ItemResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public Item getItem() {
    ObjectMapper objectMapper = new ObjectMapper();
    Item item;
    try {
      item = objectMapper.readValue(getResponse().asString(), Item.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return item;
  }
}
