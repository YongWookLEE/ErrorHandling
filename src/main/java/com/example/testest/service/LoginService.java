package com.example.testest.service;

import com.example.testest.dto.LoginDto;
import com.example.testest.dto.LoginResponseDto;
import com.example.testest.entity.TownEntity;
import com.example.testest.entity.UserEntity;
import com.example.testest.exception.InvalidRequestParameterException;
import com.example.testest.exception.UnknownException;
import com.example.testest.exception.WrongExecutionException;
import com.example.testest.repository.TownRepository;
import com.example.testest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final TownRepository townRepository;
    private final UserRepository userRepository;

    public LoginResponseDto authenticate(LoginDto loginDto){
        try {

            // 관리자 로그인
            if (loginDto.isManager()) {
                Optional<String> userId = Optional.ofNullable(loginDto.getId());
                Optional<String> password = Optional.ofNullable(loginDto.getPassword());

                if (userId.isEmpty() || password.isEmpty()) throw new InvalidRequestParameterException("NO PARAM");

                Optional<UserEntity> checkUser = Optional.ofNullable(userRepository.findById(userId.get()));

                if (checkUser.isEmpty()) throw new WrongExecutionException("WRONG EXECUTION");

                if (loginDto.getId().equals(checkUser.get().getId()) && loginDto.getPassword().equals(checkUser.get().getPassword())) {
                    return LoginResponseDto.builder()
                            .check(true)
                            .userName(checkUser.get().getUserName())
                            .build();
                } else {
                    throw new WrongExecutionException("WRONG EXECUTION");
                }
            }
            // 유저 로그인
            else {
                Optional<String> townName = Optional.ofNullable(loginDto.getTownName());
                Optional<String> manageCode = Optional.ofNullable(loginDto.getManageCode());

                if (townName.isEmpty() || manageCode.isEmpty()) throw new RuntimeException();

                Optional<TownEntity> checkTown = Optional.ofNullable(townRepository.findByTownName(townName.get()));

                if (checkTown.isEmpty()) throw new RuntimeException();

                if (loginDto.getTownName().equals(checkTown.get().getTownName()) && loginDto.getManageCode().equals(checkTown.get().getManageCode())) {
                    return LoginResponseDto.builder()
                            .check(true)
                            .townName(checkTown.get().getTownName())
                            .build();
                } else {
                    throw new RuntimeException();
                }
            }

        }catch (InvalidRequestParameterException e){
            log.info("LoginService.java Exception >>>>>> {}" , e.getMessage());
            throw e;
        }catch (WrongExecutionException e){
            log.info("LoginService.java Exception >>>>>> {}" , e.getMessage());
            throw e;
        }catch (RuntimeException e){
            log.info("LoginService.java Exception >>>>>> {}" , e.getMessage());
            throw e;
        }

    }
}
