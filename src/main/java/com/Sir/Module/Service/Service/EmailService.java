package com.Sir.Module.Service.Service;

import com.Sir.Module.Entity.UserRegistration;
import com.Sir.Module.PayloadDto.UserRegistrationDto;

public interface EmailService {

    public void sendEmail(UserRegistrationDto user);

}
