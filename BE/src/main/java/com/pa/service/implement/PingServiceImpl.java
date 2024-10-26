package com.pa.service.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Đảm bảo thêm import này

import com.pa.filters.Filters;
import com.pa.service.PingService;

@Service
public class PingServiceImpl implements PingService {
	@Autowired 
	private final Filters filters;

    public PingServiceImpl(Filters filters) {
        this.filters = filters; 
    }
    
    //https://www.stackhawk.com/blog/command-injection-java/
    @Override
    public String Ping(String ip) {
        try {
            // Thực hiện lệnh ping với địa chỉ IP được cung cấp
        	Process process = Runtime.getRuntime().exec("cmd.exe /c ping " + filters.CIFilter(ip));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString();
        } catch (Exception e) {
            return "Error executing ping command";
        }
    }
}
