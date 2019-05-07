package com.example.demo.controller;


import com.example.demo.entity.Clazz;
import com.example.demo.entity.User;
import com.example.demo.service.ClazzSerivce;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private ClazzSerivce clazzSerivce;
    @Autowired
    private UserService userService; // sẽ cần một thằng UserService
    // UserSerivce này vừa lấy được dữ liệu từ Repository

//    @RequestMapping("/")
//    public String indexClazz(Model model){
//        List<Clazz> clazzes = clazzSerivce.getAllClazz();
//        model.addAttribute("clazzes",clazzes);
//        return "indexClazz";
//    }

    // màn hình chính show ra danh sách các class
       @RequestMapping("/")
         public String indexClazz( Model model){
           List<Clazz> clazzes = clazzSerivce.getAllClazz();
             model.addAttribute("clazzes",clazzes);
             return "indexClazz";
            }



    @GetMapping("/{id}/list1")
    public String edit(@PathVariable("id") Long id, Model model) {
        System.out.println(id);
        model.addAttribute("users", userService.findByClassId(id));
        return "list1";
    }

    @RequestMapping("/list")
    public String  index(Model model) {

        List<User> users = userService.getAllUser();
        model.addAttribute("users",users);

//        // duyệt List sau đó check xem, phần tử nào có enable là  0 thì k show lên list
        for (int i = users.size()-1; i >= 0; i--){
            if(0 == ((User) users.get(i)).enable){
                users.remove (i);
            }
        }
        return "index";
    }
    @RequestMapping("/list2")
    public String index1( Model model){

           List<User> users = userService.findByEnable(1);

           model.addAttribute("users",users);
           return "index";
    }


    @RequestMapping(value = "/add")
    public String addUser(Model model) { // thêm người dùng, method này sẽ nhận input là người dùng muốn thêm user mới
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model) {
        Optional<User> userEdit = userService.findUserById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "editUser";
        // method này sẽ được gọi khi input của người dùng là muốn chỉnh sửa dữ liệu
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user) {
        userService.saveUser(user);
        return "redirect:/list"; // đưa đến trang list
        // tương tự
    }

    //@RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String deleteUser(@RequestParam("id") Long userId, Model model) {
//        userService.deleteUser(userId);
//        return "redirect:/list";
    // hàm trong đoạn cmt này sẽ xoá sạch dữ liệu trong db
//
//    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)

    public String deleteUser(@RequestParam("id") User user, Model model){
           // user.setEnable(0); // khi phần tử nào bị ấn nút del trên màn hình, thực chất là update dữ liệu
        // enable = 0 rồi đưa về database, tại db trường enable của id đó sẽ có giá trị là 0
            userService.deleted(user);
        return "redirect:/list"; // đứa đến trang list

    }




}
