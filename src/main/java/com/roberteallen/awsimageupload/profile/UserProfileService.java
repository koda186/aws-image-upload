package com.roberteallen.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

//where the business logic happens, UserProfileController
@Service
public class UserProfileService {
    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService){
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfiles();
    }

    void uploadUserProfileImage(UUID userProfileId, MultipartFile file){
        //TODO
        //1. Check if image is not empty
        //2. If file is an image
        //3. The user exists in our database
        //4. Grab some metadata from file if any
        //5. Store the image in s3 and update database
    }

}
