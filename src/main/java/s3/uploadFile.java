/*
这是uploadObject对象化写法
 */
package s3;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
public class uploadFile {
    public void fileUpload(String bucketName, String fileKeyName,
                                  File fileUploadPath, AmazonS3 s3Client, String contentType){
        /*
            1. 使用PutObjectRequest类上传文件，构造函数参数为 bucket名， 上传文件的keyName，以及上传的文件
            2. 上传的文件需要创建new File()实例，fileUploadPath的实参应该是一个 new File(uploadPath)),
               uploadPath是待上传文件的完整路径含文件名即扩展名
            3. 可以编辑一些request的meta元数据
            4. 最后使用s3Client.putObject(request)上传文件
         */
        try{
            PutObjectRequest request = new PutObjectRequest(bucketName, fileKeyName, fileUploadPath);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            metadata.addUserMetadata("uploader", "hc");
            request.setMetadata(metadata);

            /*
             s3Client.putObject(request).withCannedAcl(CannedAccessControlList.PublicRead)
             可以直接打开上传文件的公共访问权限
             */
            s3Client.putObject(request);
            System.out.println("File has been uploaded");
        }catch (AmazonServiceException e){
            e.printStackTrace();
        }

    }
}
