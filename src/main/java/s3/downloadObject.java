package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class downloadObject {
    public static void main(String[] args) {
        try{
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(commonConstants.clientRegion)
                    .withCredentials(new AWSStaticCredentialsProvider(commonConstants.credentials))
                    .build();
            // here should be the file path in bucket
            String filePathDownload = "shuttle.mp4";

            S3Object objS3 = s3Client.getObject(commonConstants.bucketName,filePathDownload);
            S3ObjectInputStream inputStream = objS3.getObjectContent(); // read file content by inputStream
            FileUtils.copyInputStreamToFile(inputStream, new File((commonConstants.downloadPath+"shuttleNew.mp4")));
            System.out.println("File has been downloaded to the folder");

        }catch (AmazonServiceException | IOException e){
            e.printStackTrace();
        }
    }
}
