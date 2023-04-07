package com.example.app.service;

import com.example.app.dto.BetResultDTO;
import com.example.app.entity.User;
import com.example.app.enums.BetStatus;
import com.example.app.mapper.BetResultMapper;
import com.example.app.repository.BetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BetRepository betRepository;
    private final BetResultMapper betResultMapper;

    public List<BetResultDTO> calcAllResultMoney(){
        List<User> users=betRepository.getBetUsersByStatus(BetStatus.CLOSED);
        return users.stream().map(betResultMapper::map).toList();
    }

}
