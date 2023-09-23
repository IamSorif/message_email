package com.Sir.Module.Controller;

import com.Sir.Module.PayloadDto.UserRegistrationDto;
import com.Sir.Module.Service.Service.EmailService;
import com.Sir.Module.Service.Service.MessageService;
import com.Sir.Module.Service.Service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/registrations")
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    private final EmailService emailService;
    private final MessageService messageService;

    public UserRegistrationController(UserRegistrationService userRegistrationService, EmailService emailService, MessageService messageService) {
        this.userRegistrationService = userRegistrationService;
        this.emailService = emailService;
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<?> createRegistration(
            @Valid @RequestBody UserRegistrationDto userRegistrationDto, BindingResult result
            // when you have two return type you can not use ResponseEntity<UserRegistrationDto>
            // you have to use ResponseEntity<?>
            // when you will write ResponseEntity<?> return type can be anything
    ) {

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }

            //[result.getFieldError().getDefaultMessage()] this will automatically get the message
            // that either mobileNo is invalid or email is every invalid message it will get.

            UserRegistrationDto createdRegistration = userRegistrationService.CreateRegistration(userRegistrationDto);

            emailService.sendEmail(createdRegistration);
            messageService.sendRegistrationMessage(createdRegistration);

            return new ResponseEntity<>(createdRegistration, HttpStatus.CREATED);

        }
    }


