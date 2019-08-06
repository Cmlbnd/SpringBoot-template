package com.sample.controller;

import com.sample.service.OptimizationInputService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@Api(value = "/api/v1/sample", description = "Sample Controller")
@RestController
public class SampleController {
  private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

  @Autowired SampleService sampleService;

  @ApiOperation(value = "sampleValue", notes = "description of value",
      response = SampleService.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful retrieval of some resources")})
  @RequestMapping(value = "/api/v1/sample/endpoint1", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody
  ResponseEntity doGetJSON(
      @RequestParam(value = "Date") String param1,
      @RequestParam(value = "Time") String parm2,
      throws Exception {


    String output = sampleManager.getJSON(param1, param2);
    
    return new ResponseEntity<>(output, HttpStatus.OK);
  }

  @ExceptionHandler({Exception.class})
  protected ResponseEntity<String> exceptionHandler(Exception e) {
    LOGGER.error(e.getMessage());
    return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  protected ResponseEntity<String> handleMissingParams(MissingServletRequestParameterException e) {
    LOGGER.error(e.getMessage());
    return new ResponseEntity<>("Missing required parameter: " + e.getParameterName(),
        HttpStatus.UNPROCESSABLE_ENTITY);
  }
}