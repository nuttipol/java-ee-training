package my.example.chapter01.model;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.FilesUploadEvent;
import org.primefaces.model.file.UploadedFile;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Attachment {

	private List<UploadedFile> datas = new ArrayList<>();
	
	public void handleFileUpload(FilesUploadEvent event) {
		log.info("handleFileUpload enter {}", event.getFiles());
		datas.addAll(event.getFiles().getFiles());
		log.info("handleFileUpload exit");
	}
}
