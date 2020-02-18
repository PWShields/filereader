package au.com.puffinpowered.filereader.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VcfService {

	List<String> transformData(MultipartFile input);

}
