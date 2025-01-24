package org.nctry.server.services.User;

import org.nctry.server.DTO.UserResponse;
import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.user.dto.response.dtoUser_displayPublicData;
import org.nctry.server.user.model.User;
import org.nctry.server.user.model.UserFulldata;
import org.nctry.server.user.repository.IUserFullData;
import org.nctry.server.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;
    private final IUserFullData userFullData;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, IUserFullData userFullData) {
        this.userRepository = userRepository;
        this.userFullData = userFullData;
    }


    @Override
    public UserResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<User> users = userRepository.findAll(pageable);

        List<User> usersList = users.getContent();
        List<UserFulldata> usersFullDataList = usersList.stream().map(user ->
                userFullData.findById(user.getId()).orElseThrow(
                        () -> new ResourceNotFoundException("UserFullData", "id", user.getId().toString())
                )).toList();

        List<dtoUser_displayPublicData> content = new ArrayList<>();
        usersList.stream().map(
          user -> usersFullDataList.stream().map(
                  userFulldata -> content.add(new dtoUser_displayPublicData(user, userFulldata))
          )
        );
        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNumber(pageNumber);
        userResponse.setPageSize(pageSize);
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setLast(users.isLast());


        return userResponse;
    }

    @Override
    public dtoUser_displayPublicData findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                    new ResourceNotFoundException("User", "username", username)
                );

        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );

        return new dtoUser_displayPublicData(user, userFulldata);
    }

    @Override
    public dtoUser_displayPublicData findById(Long Id) {
        User user = userRepository.findById(Id).orElseThrow( () ->
                new ResourceNotFoundException("User", "id", Id.toString())
        );

        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );

        return new dtoUser_displayPublicData(user, userFulldata);
    }

    @Override
    public dtoUser_displayPublicData findByEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow( () ->
                new ResourceNotFoundException("User", "id", email)
        );

        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );

        return new dtoUser_displayPublicData(user, userFulldata);
    }
}
