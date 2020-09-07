/*
 * package com.example.genericrestapi.test.controller;
 * 
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertTrue; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * 
 * public class DiagnosticControllerTest extends AbstractTest {
 * 
 * @Override
 * 
 * @Before public void setUp() { super.setUp(); }
 * 
 * @Test public void getProductsList() throws Exception { String uri =
 * "/orders/1?orderId=ATG000004"; MvcResult mvcResult =
 * mvc.perform(post("/forums/42/register") .contentType("application/json"))
 * .andExpect(status().isOk()); // MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.get(uri),1, //
 * .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
 * String content = mvcResult.getResponse().getContentAsString(); // Product[]
 * productlist = super.mapFromJson(content, Product[].class); //
 * assertTrue(productlist.length > 0); } // @Test // public void createProduct()
 * throws Exception { // String uri = "/products"; // Product product = new
 * Product(); // product.setId("3"); // product.setName("Ginger"); // String
 * inputJson = super.mapToJson(product); // MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.post(uri) //
 * .contentType(MediaType.APPLICATION_JSON_VALUE) //
 * .content(inputJson)).andReturn(); // // int status =
 * mvcResult.getResponse().getStatus(); // assertEquals(201, status); // String
 * content = mvcResult.getResponse().getContentAsString(); //
 * assertEquals(content, "Product is created successfully"); // } // @Test //
 * public void updateProduct() throws Exception { // String uri = "/products/2";
 * // Product product = new Product(); // product.setName("Lemon"); // String
 * inputJson = super.mapToJson(product); // MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.put(uri) //
 * .contentType(MediaType.APPLICATION_JSON_VALUE) //
 * .content(inputJson)).andReturn(); // // int status =
 * mvcResult.getResponse().getStatus(); // assertEquals(200, status); // String
 * content = mvcResult.getResponse().getContentAsString(); //
 * assertEquals(content, "Product is updated successsfully"); // } // @Test //
 * public void deleteProduct() throws Exception { // String uri = "/products/2";
 * // MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn(); // int status =
 * mvcResult.getResponse().getStatus(); // assertEquals(200, status); // String
 * content = mvcResult.getResponse().getContentAsString(); //
 * assertEquals(content, "Product is deleted successsfully"); // } }
 */