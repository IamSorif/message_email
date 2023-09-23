package com.Sir.Module.Service.ServiceImpl;

import com.Sir.Module.Entity.UserRegistration;
import com.Sir.Module.PayloadDto.UserRegistrationDto;
import com.Sir.Module.Repository.UserRegistrationRepository;
import com.Sir.Module.Service.Service.UserRegistrationService;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {


    private final UserRegistrationRepository userRegistrationRepo;

    public UserRegistrationServiceImpl(UserRegistrationRepository userRegistrationRepo) {
        this.userRegistrationRepo = userRegistrationRepo;
    }

    @Override
    public UserRegistrationDto CreateRegistration(UserRegistrationDto userRegistrationDto) {

        UserRegistration uRegistration = mapToEntity(userRegistrationDto);

        UserRegistration saveRegistration = userRegistrationRepo.save(uRegistration);

        UserRegistrationDto convertedRegistration = mapToDto(saveRegistration);

        return convertedRegistration;
    }

    private UserRegistration mapToEntity (UserRegistrationDto userRegistrationDto){

        UserRegistration ur = new UserRegistration();

        ur.setId(userRegistrationDto.getId());
        ur.setFirstName(userRegistrationDto.getFirstName());
        ur.setLastName(userRegistrationDto.getLastName());
        ur.setEmail(userRegistrationDto.getEmail());
        ur.setMobile(userRegistrationDto.getMobile());
        ur.setCity(userRegistrationDto.getCity());
        ur.setCountry(userRegistrationDto.getCountry());
        ur.setState(userRegistrationDto.getState());
        ur.setPincode(userRegistrationDto.getPincode());
        ur.setPassword(userRegistrationDto.getPassword());

        return ur;
    }

    private UserRegistrationDto mapToDto(UserRegistration userRegistration){

        UserRegistrationDto urd =new UserRegistrationDto();

        urd.setId(userRegistration.getId());
        urd.setFirstName(userRegistration.getFirstName());
        urd.setLastName(userRegistration.getLastName());
        urd.setEmail(userRegistration.getEmail());
        urd.setMobile(userRegistration.getMobile());
        urd.setCity(userRegistration.getCity());
        urd.setCountry(userRegistration.getCountry());
        urd.setState(userRegistration.getState());
        urd.setPincode(userRegistration.getPincode());
        urd.setPassword(userRegistration.getPassword());

        return urd;

    }
}
