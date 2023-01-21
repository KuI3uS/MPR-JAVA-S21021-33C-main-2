//package com.example.MPRJAVAS2102133C;
//
//
//import java.util.List;
//
//@RestController
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    ObjectMapper objectMapper;
//    public ResponseEntity getUsers() throws JsonProcessingException {
//        List<User> users = userRepository.findAll();
//        return ResponseEntity.ok(objectMapper.writeValueAsString(users));
//    }
//    public ResponseEntity addUser(@RequestBody User user){
//        User sevedUser = userRepository.save(user);
//        return ResponseEntity.ok(sevedUser);
//    }
//}
