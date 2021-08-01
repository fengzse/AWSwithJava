package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Regions;

public class commonConstants {

    public static String accessKey = "****";
    public static String secretKey = "****";
    public static Regions clientRegion = Regions.EU_NORTH_1;
    public static String bucketName = "mydrivestest";
    public static String bucketNameToBeCreated = "mys3test";
    /*
    1. 下面的两个KeyName在赋值字符串的时候要加上扩展名，扩展名在S3的bucket里会记录在类型中
    2. KeyName是作为bucket中文件的键名设置的，例如在下载的时候，需要提供文件的key就是这个KeyName。
       如果KeyName有扩展名在设置下载路径的也要编写完整的文件名.扩展名。如果文件在子文件夹里，则需要 子目录/文件名.扩展名
     */
    public static String stringObjKeyName = "aTextString";    // name of a string to be uploaded as a file, used as key in bucket
    public static String fileObjKeyName = "shuttle.mp4";   // name of the file to be uploaded，used as key in bucket

    public static String fileName = "shuttle.mp4";
    public static String uploadPath =
            "files\\upload\\"+fileName; //Path to file to upload including file name
    public static String downloadPath = "files\\download\\";
    public static String contentTypeJpg = "image/jpg";
    public static String contentTypeVideo = "video/mp4";
    public static String contentTypeText = "text/plain";
    public static final String SUFFIX = "/";

   public static AWSCredentials credentials = new AWSCredentials() {
        @Override
        public String getAWSAccessKeyId() {
            return commonConstants.accessKey;
        }

        @Override
        public String getAWSSecretKey() {
            return commonConstants.secretKey;
        }
    };

}
