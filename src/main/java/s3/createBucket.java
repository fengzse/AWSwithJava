package s3;

import com.amazonaws.services.s3.AmazonS3;

public class createBucket {
    public static void bucketCreate(String newBucketName, AmazonS3 s3client){
        s3client.createBucket(newBucketName);
    }
}
