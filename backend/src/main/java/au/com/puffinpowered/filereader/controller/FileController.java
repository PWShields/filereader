package au.com.puffinpowered.filereader.controller;


import au.com.puffinpowered.filereader.service.VcfServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/")
public class FileController {


	VcfServiceImpl vcfService;

	public FileController(VcfServiceImpl vcfService) {
		this.vcfService = vcfService;
	}

	@PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void fileUpload(@RequestParam("formData") MultipartFile file) {
		log.info("File received");
	}

	@PostMapping(value = "download/txt", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void downloadText(HttpServletResponse response, @RequestParam MultipartFile file) throws IOException {
		List<String> results = vcfService.transformData(file);
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment;filename=myFile.txt");
		ServletOutputStream out = response.getOutputStream();
		for (String line : results) {
			out.println(line);
		}
		out.flush();
		out.close();
	}


}
