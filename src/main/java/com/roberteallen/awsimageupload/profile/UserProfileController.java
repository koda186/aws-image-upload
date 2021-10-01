package com.roberteallen.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfile(){
        return userProfileService.getUserProfiles();
    }

    //take profileid and consume/produces media value
    @PostMapping(
            path = "{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    //use userProfileService to upload images
    public void uploadUserProfileImage(@PathVariable("userProfileId")UUID userProfileId,
                                       @RequestParam("file")MultipartFile file){
        userProfileService.uploadUserProfileImage(userProfileId, file);
    }
}
