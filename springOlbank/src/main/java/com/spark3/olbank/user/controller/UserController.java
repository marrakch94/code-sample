package com.spark3.olbank.user.controller;

import com.spark3.olbank.user.model.RoleName;
import com.spark3.olbank.user.model.Userx;
import com.spark3.olbank.user.repository.RoleRepository;
import com.spark3.olbank.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.spark3.olbank.config.FileConstant.FORWARD_SLASH;
import static com.spark3.olbank.config.FileConstant.USER_FOLDER;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;


@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/AddUser")
    public Userx addUser(@RequestParam("roles") String roles,
                         @RequestParam("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("email") String email,
                         @RequestParam("adresse") String adresse,
                         @RequestParam("salary") String salary,
                         @RequestParam("userName") String userName,
                         @RequestParam("password") String password,
                         @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam("country") String country,
                         @RequestParam("city") String city,
                         @RequestParam("codepost") String codepost,
                         @RequestParam("enabled") boolean enabled,
                         @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws Exception {
        Userx user =new Userx();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder() ;
        user.setPassword(bCryptPasswordEncoder.encode(password));
        if (id.equals("null"))
            user.setId(null);
        else
        user.setId(Long.parseLong(id));
        user.setAdresse(adresse);
        user.setCity(city);
        user.setCodepost(codepost);
        user.setUserName(userName);
        user.setEmail(email);
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        user.setJoinDate(date);
        user.setCountry(country);
        user.setPhoneNumber(phoneNumber);
        user.setSalary(Float.parseFloat(salary));
        user.setName(name);
        user.setSurname(surname);
        user.setEnabled(enabled);
        user.setRoles(roleRepository.findByNameEquals(RoleName.valueOf(roles)));
        return userService.saveProfileImageAndUser(user,profileImage);
    }

    @PostMapping("/AddUsers")
    public List<Userx> addUsers(@RequestBody List<Userx> users) {
        return userService.saveUsers(users);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @GetMapping("/Users")
    public List<Userx> findAllUsers() {
        return userService.getUser();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/UserById/{id}")
    public Userx getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/UserByUsername/{username}")
    public Userx getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/UserStatEnabled")
    public int[] getUserStatEnabled() {
        return userService.UserStatEnabled();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/UserStatDate")
    public int[] getUserStatDate() throws ParseException {
        return userService.UserStatdate();
    }

    @PutMapping("/UpdateUser")
    public Userx updateUser(@RequestBody Userx user) {
        return userService.upadateUser(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping(path = "/image/{username}/{fileName}", produces = IMAGE_JPEG_VALUE)
    public byte[] getProfileImage(@PathVariable("username") String username,
                                  @PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(USER_FOLDER + username + FORWARD_SLASH + fileName));
    }

    @PostMapping("/signup")
    public Userx signUp(@RequestParam("roles") String roles,
                         @RequestParam("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("email") String email,
                         @RequestParam("adresse") String adresse,
                         @RequestParam("salary") String salary,
                         @RequestParam("userName") String userName,
                         @RequestParam("password") String password,
                         @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam("country") String country,
                         @RequestParam("city") String city,
                         @RequestParam("codepost") String codepost,
                         @RequestParam("enabled") boolean enabled,
                         @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws Exception {
        Userx user =new Userx();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder() ;
        user.setPassword(bCryptPasswordEncoder.encode(password));
        if (id.equals("null"))
            user.setId(null);
        else
            user.setId(Long.parseLong(id));
        user.setAdresse(adresse);
        user.setCity(city);
        user.setCodepost(codepost);
        user.setUserName(userName);
        user.setEmail(email);
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        user.setJoinDate(date);
        user.setCountry(country);
        user.setPhoneNumber(phoneNumber);
        user.setSalary(Float.parseFloat(salary));
        user.setName(name);
        user.setSurname(surname);
        user.setEnabled(true);
        user.setRoles(roleRepository.findByNameEquals(RoleName.valueOf("ROLE_USER")));
        return userService.saveProfileImageAndUser(user,profileImage);
    }


}
