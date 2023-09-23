package com.Sir.Module.Service.ServiceImpl;

import com.Sir.Module.Entity.UserRegistration;
import com.Sir.Module.PayloadDto.UserRegistrationDto;
import com.Sir.Module.Service.Service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendEmail(UserRegistrationDto user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Registration Successful");
        mailMessage.setText("Dear " + user.getFirstName() + ",\n\n"
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
                + "Thank you and welcome to our website!");
        javaMailSender.send(mailMessage);
    }
}
