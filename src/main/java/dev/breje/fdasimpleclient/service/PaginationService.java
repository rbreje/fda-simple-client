package dev.breje.fdasimpleclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class PaginationService {

    public String getNextPage(String localPath, String currentSkip, String total) {
        if (Integer.parseInt(total) < Integer.parseInt(currentSkip) + 10) {
            return null;
        }
        StringBuilder sb = new StringBuilder(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString());
        sb.append(localPath);
        sb.append("?skip=");
        sb.append(Integer.parseInt(currentSkip) + 10);
        return sb.toString();
    }

}
