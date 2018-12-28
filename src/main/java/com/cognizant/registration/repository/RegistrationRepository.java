package com.cognizant.registration.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cognizant.registration.domain.User;
import com.cognizant.registration.util.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Repository
public class RegistrationRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationRepository.class);

    @Autowired
    private DynamoDBMapper mapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUser(String email) {
        return mapper.load(User.class, email);
    }

    public List<User> getAllUsers() {
        return mapper.scan(User.class, new DynamoDBScanExpression());
    }

    public void deleteUser(User user) {
        mapper.delete(user);
    }

    public String register(final User user) {
        String result = "";

        try {
            DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
            Map expected = new HashMap();

            expected.put("email", new ExpectedAttributeValue().withExists(false));
            saveExpression.setExpected(expected);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            mapper.save(user, saveExpression);

            result = ErrorCodeEnum.SUCCESS.getValue();

            // If the email already exists
        } catch (ConditionalCheckFailedException e) {
            result = ErrorCodeEnum.USER_ALREADY_EXISTS.getValue();

        }
        return result;
    }

}