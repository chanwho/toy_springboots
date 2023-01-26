package com.toy.toy_springboots.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class AddUUID {
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Map UploadProcess(MultipartHttpServletRequest multipartHttpServletRequest, Map<String, Object> params)
            throws IllegalStateException, IOException {
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        // 이거 왜 상대경로 이렇게 된건지 질문
        String relativePath = "C:\\Develops\\toy_springboots\\src\\main\\resources\\static\\files\\";

        String physicalFileName = getUniqueSequence();
        // file.separator가 왜 OS마다 다르게 적용되어야 하는지 질문. VS의 기능?
        String savePath = relativePath + physicalFileName + File.separator;
        File newPath = new File(savePath);
        newPath.mkdir();

        Map attachFile = null;
        List attachFiles = new ArrayList<>();
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName); // file을 받아옴
            String originalFileName = multipartFile.getOriginalFilename(); // 그 file의 이름 추출

            String savePathFileName = savePath + originalFileName;
            multipartFile.transferTo(new File(savePathFileName));

            attachFile = new HashMap<>();

            attachFile.put("USER_UID", getUniqueSequence());
            attachFile.put("NAME", params.get("NAME"));
            attachFile.put("ID", params.get("ID"));
            attachFile.put("PASSWORD", params.get("PASSWORD"));
            attachFile.put("PHONE_NUMBER", params.get("PHONE_NUMBER"));
            attachFile.put("BIRTHDAY", params.get("BIRTHDAY"));
            attachFile.put("EMAIL", params.get("EMAIL"));
            attachFile.put("SMS_AD", params.get("SMS_AD"));
            attachFile.put("EMAIL_AD", params.get("EMAIL_AD"));

            attachFiles.add(attachFile);
        }

        params.put("attachFiles", attachFiles);

        // service를 2개 만든 이유 질문
        return params;
    }

}
