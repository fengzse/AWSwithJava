/*
    这是downloadObject对象化写法
 */
package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class downloadFile {
    /*
     filePathDownload需要bucket内完整的文件路径和keyName
     如果有子目录且key有指明类型(也就是扩展名)，则需要明确指定如 file/path/keyName.extension
     downloadPath是本地要接收下载文件目录，在new File的参数里需要加上下载文件的文件名(可以直接创建新的文件名，但文件类型必须一致)
    */
    public void fileDownload(AmazonS3 s3Client, String filePathDownload,
                                    String bucketName, String downloadPath,
                                    String newFileName) {
        /*
            getObject参数为bucket名和文件路径(含文件名及其扩展名)
            下载文件通常都要使用流inputStream将文件以流的形式读取到内存，并使用File类创建新的文件实例 new File()
        */
        try{
            S3Object objS3 = s3Client.getObject(bucketName,filePathDownload);
            S3ObjectInputStream inputStream = objS3.getObjectContent(); // read file content by inputStream
            FileUtils.copyInputStreamToFile(inputStream, new File((downloadPath+newFileName)));
            System.out.println("File has been downloaded to the folder");
        }catch (AmazonServiceException |IOException e){
            e.printStackTrace();
        }

    }
}
