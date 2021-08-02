package s3;

import com.amazonaws.services.s3.AmazonS3;

public class createAndDeleteBucket {
    // create new bucket
    public void bucketCreate(String newBucketName, AmazonS3 s3client){
        s3client.createBucket(newBucketName);
    }

    public void bucketDelete(String bucketName, AmazonS3 s3Client){
        s3Client.deleteBucket(bucketName);
    }
}
