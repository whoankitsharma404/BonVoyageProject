package com.BonVoyage.UserService.services.impl;

import com.BonVoyage.UserService.external.FeignClientUserPackage;
import com.BonVoyage.UserService.models.User;
import com.BonVoyage.UserService.models.UsersWishList;
import com.BonVoyage.UserService.payloads.*;
import com.BonVoyage.UserService.repositories.UserRepository;
import com.BonVoyage.UserService.repositories.UsersWishListRepository;
import com.BonVoyage.UserService.services.UserService;
import com.BonVoyage.UserService.utils.EncryptionUtils;
import com.BonVoyage.UserService.utils.IdGeneration;
import com.BonVoyage.UserService.utils.Mapper;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final FeignClientUserPackage feignClientUserPackage;

    private final UsersWishListRepository usersWishListRepository;
    private static String SESSION_ID=  null;

    @Override
    public UserDTO registerNewAccount(UserDTO userDTO) throws Exception {
        String email = userDTO.getUserEmail();

        User user =userRepository.findByUserEmail(email).orElse(null);
        if (user!=null) {
            throw new RuntimeException("User already exists");
        }

        User newUser = new User();
        String lastUser = userRepository.findMaxUserId();

        newUser.setUserID(IdGeneration.generateNextUserId(lastUser));
        newUser.setUserName(userDTO.getUserName());
        newUser.setUserEmail(userDTO.getUserEmail());
        newUser.setUserPhone(userDTO.getUserPhone());
        newUser.setUserPassword(EncryptionUtils.encrypt(userDTO.getUserPassword()));
        newUser.setUserAddress(userDTO.getUserAddress());
        newUser.setUserRole(userDTO.getUserRole());
        newUser.setCreatedAt(String.valueOf(new Date()));
        newUser.setUpdatedAt(String.valueOf(new Date()));
        newUser.setVersion(0);

        User muser =userRepository.save(newUser);

//        BookingsDTO bookingsDTOS = userDTO.getUserBooking().get(0);
//
//        Object obj =feignClientConfig.doPostCall(null,null,bookingsDTOS);


        mapTpUserDtoResponse(muser);

        return Mapper.mapToUserDto(muser);
    }

    private void mapTpUserDtoResponse(User muser) {



    }


    @Override
    public LoginResponse loginUser(LoginRequest userDTO, HttpServletRequest request) throws Exception {
        if(StringUtils.isBlank(userDTO.getUserEmail()) || StringUtils.isBlank(userDTO.getUserPassword())){
            throw new Exception("Enter valid email and password!!");
        }
        User fetchedUser = userRepository.findByUserEmail(userDTO.getUserEmail()).orElse(null);
        assert fetchedUser != null;
        if(Boolean.TRUE.equals(validatingUserNameAndPassword(fetchedUser,userDTO.getUserPassword()))){

             LoginResponse response = new LoginResponse();
             response.setUserID(fetchedUser.getUserID());
             response.setUserRole(fetchedUser.getUserRole());
             response.setUserAddress(fetchedUser.getUserAddress());
             response.setUserPhone(fetchedUser.getUserPhone());
             response.setUserName(fetchedUser.getUserName());
             response.setUserEmail(fetchedUser.getUserEmail());
             return response;
        }
        throw new Exception("Enter valid email and password!!");
    }

    private Boolean validatingUserNameAndPassword(User fetchedUser, String userPassword) throws Exception {
        String fetchedPassword = EncryptionUtils.decrypt(fetchedUser.getUserPassword());
        return userPassword.equals(fetchedPassword);
    }


    @Override
    public UserDTO getUserByUserName(String userName) {
        User user =userRepository.findByUserName(userName).orElse(null);
        return Mapper.mapToUserDto(user);
    }

    @Override
    public UserDTO updateWishList(String userId, String packageId) {
        return null;
    }

    @Override
    public UserDTO deletePackageFromWishList(String userId, String packageId) {
        return null;
    }

    @Override
    public UserDTO getAdminDetails() {
        return userRepository.findByUserRole("ADMIN");
    }

    @Override
    public Object createPackage(PackageDTO packageDTO) {
        return feignClientUserPackage.doPostSavePackage(null,null,packageDTO);
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    @Override
    public UsersWishList addingWishList(String userID, String packageID) {

        String lastUser = usersWishListRepository.findMaxUserWishListId();

        UsersWishList usersWishList =UsersWishList.builder()
                .wishlistID(IdGeneration.generateNextUsersWishListId(lastUser))
                .packageID(packageID)
                .userID(userID)
                .build();
        UsersWishList usersWishList2 =usersWishListRepository.save(usersWishList);
         return usersWishList2;
    }
}
