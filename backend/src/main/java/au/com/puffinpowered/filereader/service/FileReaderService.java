package au.com.puffinpowered.filereader.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileReaderService {

    List<String> readVCFFile(MultipartFile file);

    List<String> readFile(String fileName);

    List<String> readFile(MultipartFile file);

}
