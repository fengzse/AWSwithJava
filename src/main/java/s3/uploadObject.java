package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;


public class uploadObject {

    public static void main(String[] args)throws IOException {

        try {
            //This code expects that you have AWS credentials set up per:
            // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(commonConstants.clientRegion)
                    .withCredentials(new AWSStaticCredentialsProvider(commonConstants.credentials))
                    .build();

            // Upload a text string as a new object.
            s3Client.putObject(commonConstants.bucketName, commonConstants.stringObjKeyName,
                    "Uploaded String Object for Testing");
            System.out.println("String has been created as a file into the bucket");

            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(commonConstants.bucketName, commonConstants.fileObjKeyName,
                    new File(commonConstants.uploadPath));  // Create a file object
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(commonConstants.contentTypeVideo);
            metadata.addUserMetadata("uploader", "hc");
            request.setMetadata(metadata);
            s3Client.putObject(request);
            System.out.println("File has been uploaded");

        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
}

