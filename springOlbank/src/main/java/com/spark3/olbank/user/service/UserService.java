package com.spark3.olbank.user.service;


import com.spark3.olbank.user.exception.NotAnImageFileException;
import com.spark3.olbank.user.model.Userx;
import com.spark3.olbank.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static com.spark3.olbank.config.FileConstant.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.MediaType.*;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Userx findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    public Userx findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(Userx user, MultipartFile profileImage) throws IOException, NotAnImageFileException {
        user.setProfileImageUrl(getTemporaryProfileImageUrl(user.getUserName()));
        saveProfileImageAndUser(user, profileImage);
    }

    public Userx saveProfileImageAndUser(Userx user, MultipartFile profileImage) throws IOException, NotAnImageFileException {
        if (profileImage != null) {
            if(!Arrays.asList(IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE, IMAGE_GIF_VALUE).contains(profileImage.getContentType())) {
                throw new NotAnImageFileException(profileImage.getOriginalFilename());
            }
            Path userFolder = Paths.get(USER_FOLDER + user.getUserName()).toAbsolutePath().normalize();
            if(!Files.exists(userFolder)) {
                Files.createDirectories(userFolder);
            }
            Files.deleteIfExists(Paths.get(userFolder + user.getUserName() + DOT + JPG_EXTENSION));
            Files.copy(profileImage.getInputStream(), userFolder.resolve(user.getUserName() + DOT + JPG_EXTENSION), REPLACE_EXISTING);
            user.setProfileImageUrl(setProfileImageUrl(user.getUserName()));
        }
        userRepository.save(user);
        return user;
    }

    private String setProfileImageUrl(String username) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(USER_IMAGE_PATH + username + FORWARD_SLASH
                + username + DOT + JPG_EXTENSION).toUriString();
    }

    private String getTemporaryProfileImageUrl(String username) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(DEFAULT_USER_IMAGE_PATH + username).toUriString();
    }


    public boolean userExists(String email) {
        return userRepository.existsUsersByEmail(email);
    }

    public Userx saveUser(Userx user) {
        return userRepository.save(user);
    }

    public List<Userx> saveUsers(List<Userx> users) {
        return userRepository.saveAll(users);
    }

    public List<Userx> getUser() {
        return userRepository.findAll();
    }

    public Userx getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Userx getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User supprimé !" + id;
    }

    public Userx upadateUser(Userx user) {
        Userx existingUser = userRepository.findById(user.getId()).orElse(null);
        // existingUser.setFirstname(user.getFirstname());
        // existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setAdresse(user.getAdresse());
        //existingUser.setAdresse2(user.getAdresse2());
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        // existingUser.setTel(user.getTel());
        existingUser.setCountry(user.getCountry());
        existingUser.setCity(user.getCity());
        existingUser.setCodepost(user.getCodepost());
        return userRepository.save(existingUser);
    }

    public int[] UserStatEnabled() {
        int[] count = new int[2];
        count[0] = userRepository.countByEnabledEquals(true);
        count[1] = userRepository.countByEnabledEquals(false);
        return count;
    }

    public int[] UserStatdate() throws ParseException {
        int[] count = new int[12];
        String input = "01-01-2021 00:00:00";
        String input1 = "01-02-2021 00:00:00";
        String input2 = "01-03-2021 00:00:00";
        String input3 = "01-04-2021 00:00:00";
        String input4 = "01-05-2021 00:00:00";
        String input5 = "01-06-2021 00:00:00";
        String input6 = "01-07-2021 00:00:00";
        String input7 = "01-08-2021 00:00:00";
        String input8 = "01-09-2021 00:00:00";
        String input9 = "01-10-2021 00:00:00";
        String input10 = "01-11-2021 00:00:00";
        String input11 = "01-12-2021 00:00:00";
        String input12 = "01-01-2022 00:00:00";

        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        count[0] = userRepository.countByJoinDateBetween(parser.parse(input),parser.parse(input1));
        count[1] = userRepository.countByJoinDateBetween(parser.parse(input1),parser.parse(input2));
        count[2] = userRepository.countByJoinDateBetween(parser.parse(input2),parser.parse(input3));
        count[3] = userRepository.countByJoinDateBetween(parser.parse(input3),parser.parse(input4));
        count[4] = userRepository.countByJoinDateBetween(parser.parse(input4),parser.parse(input5));
        count[5] = userRepository.countByJoinDateBetween(parser.parse(input5),parser.parse(input6));
        count[6] = userRepository.countByJoinDateBetween(parser.parse(input6),parser.parse(input7));
        count[7] = userRepository.countByJoinDateBetween(parser.parse(input7),parser.parse(input8));
        count[8] = userRepository.countByJoinDateBetween(parser.parse(input8),parser.parse(input9));
        count[9] = userRepository.countByJoinDateBetween(parser.parse(input9),parser.parse(input10));
        count[10] = userRepository.countByJoinDateBetween(parser.parse(input10),parser.parse(input11));
        count[11] = userRepository.countByJoinDateBetween(parser.parse(input11),parser.parse(input12));
        return count;
    }
}