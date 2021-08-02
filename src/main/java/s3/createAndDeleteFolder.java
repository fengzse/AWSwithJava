package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class createAndDeleteFolder {
    public void createFolder(String bucketName, String folderName, AmazonS3 s3Client, String SUFFIX){
        try{
            // create meta-data for new folder and set content-length to 0
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(0);

            // create empty content by InputStream
            InputStream emptyContentFolder = new ByteArrayInputStream(new byte[0]);

            // create a PutObjectRequest passing the folder name suffixed by /
            PutObjectRequest request = new PutObjectRequest(bucketName, folderName+SUFFIX,
                    emptyContentFolder,metadata);

            // send request to S3 to create folder
            s3Client.putObject(request);
            System.out.println("Folder has been created");
        }catch (AmazonServiceException e){
            e.printStackTrace();
        }
    }

    /*
     * This method first deletes all the files in given folder and then the folder itself
     */
    public void deleteFolder(String bucketName, String folderName, AmazonS3 s3Client){
        try{
            // get list of S3ObjectSummary objects from folder
            List<S3ObjectSummary> fileList = s3Client.listObjects(bucketName,folderName).getObjectSummaries();
            for(S3ObjectSummary file:fileList){
                // delete files by key( key is the name.extension of the file in bucket)
                 s3Client.deleteObject(bucketName,file.getKey());
            }
            // delete folder
            s3Client.deleteObject(bucketName,folderName);
            System.out.println("Folder has been deleted");
        }catch (AmazonServiceException e){
            e.printStackTrace();
        }
    }
}
