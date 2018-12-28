//package com.cognizant.registration;
//
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
//import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
//import com.cognizant.registration.domain.User;
//import com.cognizant.registration.repository.IRegistrationRepository;
//import com.cognizant.registration.repository.RegistrationRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//
//import static org.springframework.test.util.AssertionErrors.assertTrue;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = RegistrationApplication.class)
//@WebAppConfiguration
//@ActiveProfiles("local")
//@TestPropertySource(properties = {
//		"amazon.dynamodb.endpoint=http://localhost:8000/",
//		"amazon.aws.accesskey=yourAccessKey",
//		"amazon.aws.secretkey=yourSecretKey" })
//public class RegistrationApplicationTests {
//
//	private DynamoDBMapper dynamoDBMapper;
//
//	@Autowired
//	private AmazonDynamoDB amazonDynamoDB;
//
//	@Autowired
//    IRegistrationRepository repository;
//
//	private static final String EMAIL = "test@gmail.com";
//	private static final String PASSWORD = "testing";
//
//	@Before
//	public void setup() throws Exception {
//		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//
//		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(User.class);
//		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//		amazonDynamoDB.createTable(tableRequest);
//
//		// your code here...
//
//		dynamoDBMapper.batchDelete((List<User>)repository.findAll());
//	}
//
//	@Test
//	public void dynamoDBTestCase() {
//		User testUser = new User(EMAIL,PASSWORD);
//		repository.save(testUser);
//
//		List<User> theUser = (List<User>) repository.findAll();
//
//		assertTrue("Book found.", theUser.size() > 0);
//		assertTrue("The book name is correct.", theUser.get(0).getEmail().equals(EMAIL));
//	}
//}