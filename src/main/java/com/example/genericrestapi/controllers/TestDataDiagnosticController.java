package com.example.genericrestapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.genericrestapi.response.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

@RestController

@RequestMapping("/diagnosticTest")
public class TestDataDiagnosticController {

	@ApiOperation(value = "get the specific order status", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/order/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getOrderStatus() {
		Response response = new Response();

		response.setData("ACCEPTED");
		response.setMsg("Query Successful");
		response.setCode(HttpStatus.valueOf(100).toString());

		return new ResponseEntity<>((response), HttpStatus.OK);
		// TODO: handle exception
	}

	@ApiOperation(value = "Create Order", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/order/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createOrder() {
		Response response = new Response();

		response.setData("ATG000004");
		response.setMsg("Query Successful");
		response.setCode(HttpStatus.valueOf(100).toString());
		return new ResponseEntity<>((response), HttpStatus.OK);
	}

	@ApiOperation(value = "get the specific order report", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/report/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getResultReport() {

		Response response = new Response();

		response.setData(
				"https://www.mysrl.in/srl_web_reports/GenerateReports.aspx?acc=gw0FCsNbeZeRhhwhfSRDpw==&lid=225&ctyp=W&session=SRLCCINV");
		response.setMsg("Query Successful");
		response.setCode(HttpStatus.valueOf(100).toString());
		return new ResponseEntity<>((response), HttpStatus.OK);

	}

//	
//	@ApiOperation(value = "View a list of available products", response = Iterable.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	
//    @RequestMapping(value = "/orderS/{orderId}", method= RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<?> getOrderStatuse(@RequestParam Integer dId,@PathVariable String orderId){
//		OrderStatusResponse response = null;
//		String orderrId="ATG000002";
//		try {
//			String a = MD5Util.class.gen
//	        System.out.println(""+hashtext);
//			//orderStatusRequest.setStrVldTk("e8afef69e6cf470144f9f324d4bd5ae0");
//			//ResponseEntity<?> response = (ResponseEntity<?>) diagnosticService.getOrderStatus(orderStatusRequest);
//	        response.setData("ACCEPTED");
//			response.setMsg("Query Successful");
//			response.setStatus(HttpStatus.valueOf(100));
//			return new ResponseEntity<>((response),HttpStatus.OK);
//	 } catch (Exception e) {
//			return new ResponseEntity<>((response),HttpStatus.INTERNAL_SERVER_ERROR);
//
//		// TODO: handle exception
//	}
//
//
//	}

//    @RequestMapping(value = "/list", method= RequestMethod.GET)
//    public Iterable list(Model model){
//        Iterable productList = diagnosticService.listAllProducts();
//        return productList;
//    }

}
