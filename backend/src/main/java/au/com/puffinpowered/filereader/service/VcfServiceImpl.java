package au.com.puffinpowered.filereader.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static au.com.puffinpowered.filereader.domain.VCFFieldNames.*;

@Slf4j
@Service
public class VcfServiceImpl implements VcfService {

	FileReaderService fileReaderService;

	public VcfServiceImpl(FileReaderService fileReaderService) {
		this.fileReaderService = fileReaderService;
	}

	public List<String> transformData(MultipartFile input) {
		List<String> fileRows = fileReaderService.readVCFFile(input);
		return parseVcf(fileRows);
	}

	private List<String> parseVcf(List<String> inputRows) {
		List<String> modifiedRows = new ArrayList<>();
		for (String row : inputRows) {
			modifiedRows.add(modifyRow(row));
		}
		return modifiedRows;
	}

	private String modifyRow(String row) {
		String[] data = row.split("\t", -1);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("chr");
		stringBuilder.append(data[CHROM.getPostion()]);
		stringBuilder.append(":");
		stringBuilder.append(data[POS.getPostion()]);
		stringBuilder.append(data[REF.getPostion()]);
		stringBuilder.append(">");
		stringBuilder.append(data[ALT.getPostion()]);
		return stringBuilder.toString();
	}
}
