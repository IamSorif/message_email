package com.Sir.Module.Service.Service;

import com.Sir.Module.PayloadDto.UserRegistrationDto;

public interface MessageService {

    public void sendRegistrationMessage(UserRegistrationDto user);
}
