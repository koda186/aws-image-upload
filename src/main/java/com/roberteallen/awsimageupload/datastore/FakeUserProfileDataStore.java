package com.roberteallen.awsimageupload.datastore;

import com.roberteallen.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        String userProfileImageLink;
        String username = "";
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), username = "JohnJones", userProfileImageLink = null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), username = "BridgetEdwards", userProfileImageLink = null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
