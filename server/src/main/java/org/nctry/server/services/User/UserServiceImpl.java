package org.nctry.server.services.User;

import org.nctry.server.DTO.UserDTO;
import org.nctry.server.DTO.UserFullDataDTO;
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

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;
    private final IUserFullData userFullData;
    private Page<User> cachedData = Page.empty();
    private Pageable cachedPageable = Pageable.unpaged();

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, IUserFullData userFullData) {
        this.userRepository = userRepository;
        this.userFullData = userFullData;
    }


    @Override
    public UserResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        if (!cachedData.isEmpty() && cachedPageable.equals(pageable)) {
            System.out.println("Cargo la data existente");
            return mapPageToUserResponse(cachedData, pageNumber, pageSize);
        }

        Page<User> users = userRepository.findAll(pageable);
        cachedData = users;
        System.out.println("Cargo la data nueva");

        return mapPageToUserResponse(users, pageNumber, pageSize);
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
        /*User user = userRepository.findByEmail(email).orElseThrow( () ->
                new ResourceNotFoundException("User", "id", email)
        );



        UserFulldata userFulldata = userFullData.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId().toString())
        );*/

        return null;//new dtoUser_displayPublicData(user, userFulldata);
    }

    private UserResponse mapPageToUserResponse(Page<User> users, int pageNumber, int pageSize) {
        List<User> usersList = users.getContent();
        List<UserDTO> content = usersList.stream().map(this::mapToUserDTO).toList();

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNumber(pageNumber);
        userResponse.setPageSize(pageSize);
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setLast(users.isLast());

        return userResponse;
    }

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
