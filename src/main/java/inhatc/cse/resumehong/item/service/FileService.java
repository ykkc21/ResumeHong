package inhatc.cse.resumehong.item.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {      //File Upload Service with UUID name transformation

    public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws IOException {

        UUID uuid = UUID.randomUUID();
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());
        String savedFileName = uuid.toString() + ext;
        String fileUploadFullURL = uploadPath + "/" + savedFileName;

        FileOutputStream fos = new FileOutputStream(fileUploadFullURL);

        fos.write(fileData);
        fos.close();

        return savedFileName;
    }

    public void deleteFile(String filePath) {
        File deleteFile = new File(filePath);

        if(deleteFile.exists()){
            deleteFile.delete();
            log.info("File Deleted");
        }

        else
            log.info("File Not Found");

    }
}
