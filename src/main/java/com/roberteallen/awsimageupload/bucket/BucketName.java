package com.roberteallen.awsimageupload.bucket;

public enum BucketName {

    PROFILE_IMAGE("myawsbucket-image-upload-roberteallen");

    //Use Terraform in future
    private final String bucketName;

    BucketName(String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
