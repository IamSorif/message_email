package com.Sir.Module.Service.ServiceImpl;

import com.Sir.Module.PayloadDto.UserRegistrationDto;
import com.Sir.Module.Service.Service.MessageService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Value("${twilio.account.sid}")
    private String twilioAccountSid;
    @Value("${twilio.auth.token}")
    private String twilioAuthToken;
    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;
    public void sendRegistrationMessage(UserRegistrationDto user) {
            Twilio.init(twilioAccountSid, twilioAuthToken);

            String messageBody = "Dear " + user.getFirstName() + ",\n\n"
                    + "Thank you for registering on our website!\n\n"
                    + "Your registration details:\n"
                    + "First Name: " + user.getFirstName() + "\n"
                    + "Last Name: " + user.getLastName() + "\n"
                    + "Email: " + user.getEmail() + "\n"
                    + "Mobile: " + user.getMobile() + "\n"
                    + "City: " + user.getCity() + "\n"
                    + "State: " + user.getState() + "\n"
                    + "Country: " + user.getCountry() + "\n"
                    + "Pincode: " + user.getPincode() + "\n\n"
                    + "Thank you and welcome to our website!";
            Message message = Message.creator(
                    new PhoneNumber(user.getMobile()),
                    new PhoneNumber(twilioPhoneNumber),
                    messageBody
            ).create();
            System.out.println("Message SID: " + message.getSid());
        }
    }


