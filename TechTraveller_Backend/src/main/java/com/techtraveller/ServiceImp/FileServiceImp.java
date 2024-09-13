package com.techtraveller.ServiceImp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techtraveller.Exception.BadApiRequest;
import com.techtraveller.Service.FileService;

@Service
public class FileServiceImp implements FileService {
	@Override
	public String uploadImage(MultipartFile file, String path, String userOrAssignment) throws IOException {
		String originalFileName = file.getOriginalFilename();
		String imageName = UUID.randomUUID().toString();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String imageNameWithExtension = imageName + extension;
		String fullPathWithFileName = path + imageNameWithExtension;
		
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}
		if (userOrAssignment.equalsIgnoreCase("user")) {
			if (extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg")) {
				// upload img
				Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
				return imageNameWithExtension;
			} else {
				throw new BadApiRequest("File with this" + extension + "format not allowe.");
			}
		}
		else {
			Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
			return imageNameWithExtension;
		}

	}

	@Override
	public String uploadFile(MultipartFile file, String path) throws IOException {
		String orgFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString();
		String extension = orgFileName.substring(orgFileName.lastIndexOf("."));
		String fileNameWithExtension = fileName + extension;
		String fullPathWithFileName = path + fileNameWithExtension;

		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}

		// file upload
		Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));

		return fileNameWithExtension;
	}

	@Override
	public InputStream getResource(String path, String name) throws FileNotFoundException {
		String fullPath = path + name;
		InputStream inputStream = new FileInputStream(fullPath);
		return inputStream;
	}

	@Override
	public Boolean deleteFile(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + fileName;
		try {
			Path paths = Paths.get(fullPath);
			Files.delete(paths);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	

}