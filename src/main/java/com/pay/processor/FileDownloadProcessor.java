package com.pay.processor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.bstek.dorado.uploader.DownloadFile;
import com.bstek.dorado.uploader.annotation.FileProvider;
import com.bstek.dorado.uploader.util.ParameterUtils;

@Component("fileDownloadProcessor")
public class FileDownloadProcessor {

	private DownloadFile getDownloadFile(String fileName) throws IOException {
		String name = fileName;
		ParameterUtils.validateParameterCharacters(name);
		URL url = this.getClass().getResource(name);
		InputStream stream = url.openConnection().getInputStream();
		DownloadFile file = new DownloadFile(name, stream);
		return file;
	}

	@FileProvider
	public DownloadFile downloadTemplate(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("file");
		DownloadFile file = getDownloadFile(fileName);
		return file;
	}
}
