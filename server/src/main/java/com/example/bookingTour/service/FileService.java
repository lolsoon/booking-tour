package com.example.bookingTour.service;

import com.example.bookingTour.utils.FileManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class FileService implements IFileService {

	private FileManager fileManager = new FileManager();
	
// ubuntu
	private String linkFolder = "/home/ubuntu/TourDuLichTeam2-v2/image";
	@Override
	public String uploadImage(MultipartFile image) throws IOException {
		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());
		String path = linkFolder + "/" + nameImage;
		fileManager.createNewMultiPartFile(path, image);
		return nameImage;
	}
	@Override
	public byte[] getImage(String fileName) throws IOException {
		String filePath = linkFolder + "/" + fileName;
		// Đọc dữ liệu của file ảnh thành mảng byte[]
		Path imagePath = Paths.get(filePath);
		return Files.readAllBytes(imagePath);
	}

// localhost
	// private String linkFolder = "D:\\Documents\\Mook\\TourDuLichTeam2-v2\\image";
	// @Override
	// public String uploadImage(MultipartFile image) throws IOException {

	// 	String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

	// 	String path = linkFolder + "\\" + nameImage;

	// 	fileManager.createNewMultiPartFile(path, image);

	// 	return nameImage;
	// }

	// @Override
	// public byte[] getImage(String fileName) throws IOException {
	// 	String filePath = linkFolder + "\\" + fileName;
	// 	// Đọc dữ liệu của file ảnh thành mảng byte[]
	// 	Path imagePath = Paths.get(filePath);
	// 	return Files.readAllBytes(imagePath);
	// }
}
