package com.sample.service;

import com.sample.entity.UpdateEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SampleService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

  public SampleService() {
  }

  public SampleMapper getJSON(String Date, String time)
      throws Exception {
        
    return "{'Date': 07/08/2019, 'Time':12:00 }";
  }
}
