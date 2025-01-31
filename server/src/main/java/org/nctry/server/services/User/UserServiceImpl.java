package org.nctry.server.services.User;

import org.nctry.server.DTO.UserDTO;
import org.nctry.server.DTO.UserFullDataDTO;
import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.Utilities.Pages.SortUtils;
import org.nctry.server.Utilities.Pages.mappers.ResponseMapper;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
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

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;
    private final IUserFullData userFullData;

    //Mapper
    private ResponseMapper responseMapper;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, IUserFullData userFullData) {
        this.userRepository = userRepository;
        this.userFullData = userFullData;
    }


    @Override
    public GeneralResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        responseMapper = ResponseMapper.INSTANCE;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "User"));

        Page<User> users = userRepository.findAll(pageable);

        return responseMapper.mapToResponse(
                users.getContent().stream().map(this::mapToUserDTO).toList(),
                users.getNumber(),
                users.getSize(),
                users.getTotalElements(),
                users.isLast());
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                    new ResourceNotFoundException("User", "username", username)
                );

        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );

        return mapToUserDTO(user);
    }

    @Override
    public UserDTO findById(Long Id) {
        User user = userRepository.findById(Id).orElseThrow( () ->
                new ResourceNotFoundException("User", "id", Id.toString())
        );

        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );

        return mapToUserDTO(user);
    }

    /*@Override
    public dtoUser_displayPublicData findByEmail(String email) {
        *//*User user = userRepository.findByEmail(email).orElseThrow( () ->
                new ResourceNotFoundException("User", "id", email)
        );

        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );*//*

        return null;//new dtoUser_displayPublicData(user, userFulldata);
    }*/

    private UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullData(mapToUserFullDataDTO(user.getUserFullData()));
        userDTO.setUsername(user.getUsername());
        userDTO.setLastOnlineAt(user.getLastOnlineAt());

        return userDTO;
    }

    private UserFullDataDTO mapToUserFullDataDTO(UserFulldata userFullData) {
        UserFullDataDTO userFullDataDTO = new UserFullDataDTO();
        userFullDataDTO.setBirthday(userFullData.getBirthday());
        userFullDataDTO.setName(userFullData.getName());
        userFullDataDTO.setCity(userFullData.getCity());
        userFullDataDTO.setCountry(userFullData.getCountry());
        userFullDataDTO.setLastName(userFullData.getLastName());
        userFullDataDTO.setCreatedAt(userFullData.getCreatedAt());

        return userFullDataDTO;
    }

}
