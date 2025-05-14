package com.game4men.aigroove.admin.service;

import com.game4men.aigroove.admin.dto.LogResponseDto;

import com.game4men.aigroove.common.entity.Log;
import com.game4men.aigroove.common.repository.LogRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.game4men.aigroove.common.repository.LoginRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogSvc {
    private final LogRepository logRepository;

    // 모든 로그 조회
    public List<LogResponseDto> getAllLogs(String adminId) {
        List<Log> logs = logRepository.findAll();
        List<LogResponseDto> result = new ArrayList<>();

        for (Log log : logs) {
            LogResponseDto dto = new LogResponseDto();
            dto.setLog_id(log.getLogId());
            dto.setLog_time(log.getLogTime());
            dto.setLog_level(log.getLogLevel());
            dto.setMessage(log.getMessage());

            if (log.getAdmin() != null) {
                dto.set_admin(true);
                dto.setUsername(log.getAdmin().getUsername());
            } else if (log.getUser() != null) {
                dto.set_admin(false);
                dto.setUsername(log.getUser().getUsername());
            } else {
                dto.set_admin(false);
                dto.setUsername("알 수 없음");
            }

            result.add(dto);
        }
        return result;
    }

}
