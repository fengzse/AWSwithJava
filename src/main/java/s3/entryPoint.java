package s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

public class entryPoint {
    public static void main(String[] args) {
        createAndDeleteFolder folder = new createAndDeleteFolder();
        uploadFile upload = new uploadFile();
        downloadFile download = new downloadFile();

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(commonConstants.clientRegion)
                .withCredentials(new AWSStaticCredentialsProvider(commonConstants.credentials))
                .build();

        /*
        // create a new folder
        folder.createFolder(commonConstants.bucketName,commonConstants.bucketNameToBeCreated,
                s3Client, commonConstants.SUFFIX);
         */

        /*
        // upload file into the folder created in the bucket
        String fileInFolderPath = commonConstants.bucketNameToBeCreated+commonConstants.SUFFIX+commonConstants.fileObjKeyName;
        upload.fileUpload(commonConstants.bucketName, fileInFolderPath,
                new File(commonConstants.uploadPath),s3Client,commonConstants.contentTypeVideo);
         */

        /*
        // download file from folder in becket
        String filePathBucket = commonConstants.bucketNameToBeCreated+commonConstants.SUFFIX+commonConstants.fileObjKeyName;
        download.fileDownload(s3Client,filePathBucket,commonConstants.bucketName,
                commonConstants.downloadPath,"newShuttle.mp4");
         */

        /*
        // delete folder and files
        folder.deleteFolder(commonConstants.bucketName,commonConstants.bucketNameToBeCreated,s3Client);
         */

    }
}
